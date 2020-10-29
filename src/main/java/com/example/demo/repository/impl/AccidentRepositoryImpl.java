package com.example.demo.repository.impl;

import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.NumericMetricsAggregation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchHitsIterator;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import java.util.*;
import com.example.demo.model.Accident;
import com.example.demo.model.WConditions;
import com.example.demo.repository.AccidentRepository;
import com.example.demo.repository.AccidentRepositoryMod;


public class AccidentRepositoryImpl implements AccidentRepositoryMod {

    private ElasticsearchOperations elasticsearchOperations;
    @Autowired
    AccidentRepository accidentRepository;

    @Autowired
    public AccidentRepositoryImpl(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @Override
    public Collection<WConditions> findWConditions() {
        List<WConditions> ConditionsList = new ArrayList<>();
        final TermsAggregationBuilder condition = AggregationBuilders.terms("condition").field("Weather_Condition.keyword").size(10);
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .addAggregation(condition)
                .build();

        SearchHits<Accident> searchTop = elasticsearchOperations.search(searchQuery, Accident.class, IndexCoordinates.of("accidentes"));
        final ParsedStringTerms bucketTop = (ParsedStringTerms) searchTop.getAggregations().asMap().get("condition");
        bucketTop.getBuckets().forEach(item -> {
            ConditionsList.add(new WConditions(item.getKeyAsString(), (int) item.getDocCount()));
        });
        return ConditionsList;
    }

    @Override
    public Float findPromDistance() {
        Float PromDistance = null;

        AvgAggregationBuilder avgAggregationBuilder = AggregationBuilders.avg("promedio_distance").field("Distance(mi)");
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .addAggregation(avgAggregationBuilder)
                .build();

        SearchHitsIterator<Accident> stream = elasticsearchOperations.searchForStream(searchQuery, Accident.class, IndexCoordinates.of("accidentes"));
        Aggregation aggregation = stream.getAggregations().iterator().next();

        if (aggregation instanceof NumericMetricsAggregation.SingleValue) {
            final NumericMetricsAggregation.SingleValue numericProperty = (NumericMetricsAggregation
                    .SingleValue) aggregation;
            PromDistance = (float) numericProperty.value();
        }
        return PromDistance;
    }

}

package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.demo.model.Accident;

@Repository
public interface AccidentRepository extends ElasticsearchRepository<Accident, String>, AccidentRepositoryMod {

    List<Accident> findByStartTimeBetween(String dateFrom, String dateTo, Pageable pageable);

    Page<Accident> findByStartLocationWithin(Point punto, Distance distance, Pageable pageable);

}

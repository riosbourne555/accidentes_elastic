package com.example.demo.services.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.inject.Inject;
import com.example.demo.dto.AccidentDTO;
import com.example.demo.dto.WConditionsDTO;
import com.example.demo.model.Accident;
import com.example.demo.repository.AccidentRepository;
import com.example.demo.services.IAccidentService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;


@Service
@Transactional
public class AccidentService implements IAccidentService {

    @Inject
    public AccidentRepository accidentRepository;


    @Override
    public Collection<AccidentDTO> getAccidentsByDates(String dateFrom, String dateTo) {
        Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();

        this.getAccidentRepository().findByStartTimeBetween(dateFrom, dateTo, PageRequest.of(0, 10000))
                .stream().map(a -> new AccidentDTO(a))
                .collect(Collectors.toCollection(() -> result));
        return result;
    }

    @Override
    public Collection<AccidentDTO> getAccidentsByRadius(Point point, Distance distancia) {
        Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();

        return this.getAccidentRepository().findByStartLocationWithin(point, distancia, PageRequest.of(0, 10000))
                .stream().map(a -> new AccidentDTO(a))
                .collect(Collectors.toCollection(() -> result));
    }

    @Override
    public Collection<AccidentDTO> getAccidentsSeverityByRadius(Point point, Distance distancia) {
        Collection<AccidentDTO> result = new ArrayList<AccidentDTO>();

        return this.getAccidentRepository().findByStartLocationWithin(point, distancia, PageRequest.of(0, 5, Sort.by("Severity.keyword").descending()))
                .stream().map(a -> new AccidentDTO(a))
                .collect(Collectors.toCollection(() -> result));
    }

    @Override
    public Collection<WConditionsDTO> getWeatherCondition() {
        Collection<WConditionsDTO> result = new ArrayList<WConditionsDTO>();

        return this.getAccidentRepository().findWConditions()
                .stream().map(a -> new WConditionsDTO(a))
                .collect(Collectors.toCollection(()-> result));
    }

    @Override
    public Float getPromDistance() {
        Float PromDistance = 0f;
        PromDistance = this.getAccidentRepository().findPromDistance();
        return PromDistance;
    }

    @Override
    public void saveAccident(String aDescription) {
        Accident newAccident = new Accident(aDescription);
        this.getAccidentRepository().save(newAccident);

    }

    public AccidentRepository getAccidentRepository() {
        return this.accidentRepository;
    }

    public void setAccidentRepository(AccidentRepository aRepository) {
        this.accidentRepository = aRepository;
    }

}

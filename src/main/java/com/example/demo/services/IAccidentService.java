package com.example.demo.services;

import java.util.Collection;
import com.example.demo.dto.AccidentDTO;
import com.example.demo.dto.WConditionsDTO;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

public interface IAccidentService {

    public Collection<AccidentDTO> getAccidentsByDates(String dateFrom, String dateTo);

    public Collection<WConditionsDTO> getWeatherCondition();

    public Collection<AccidentDTO> getAccidentsByRadius(Point point, Distance distancia);

    public Collection<AccidentDTO> getAccidentsSeverityByRadius(Point point, Distance distancia);

    public Float getPromDistance();

    public void saveAccident(String description);

}

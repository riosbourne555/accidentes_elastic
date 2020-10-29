package com.example.demo.controller;
import java.util.Collection;

import javax.inject.Inject;

import com.example.demo.dto.AccidentDTO;
import com.example.demo.dto.WConditionsDTO;
import com.example.demo.services.IAccidentService;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccidentController {

    @Inject
    private IAccidentService accidentsService;

    @GetMapping(value = "api/from/{date1}/to/{date2}")
    public ResponseEntity<?> getAccidentsByDates(@PathVariable("date1") String date1, @PathVariable("date2") String date2) {
        ResponseEntity<?> response = null;
        Collection<AccidentDTO> result = this.getAccidentsService().getAccidentsByDates(date1, date2);
        response = ResponseEntity.ok(result);
        return response;
    }

    @GetMapping(value = "api/WeatherCondition")
    public ResponseEntity<?> getWeatherCondition() {
        ResponseEntity<?> response = null;
        Collection<WConditionsDTO> result = this.getAccidentsService().getWeatherCondition();
        response = ResponseEntity.ok(result);
        return response;
    }

    @GetMapping(value = "/api/{latitud}/{longitud}/{distancia}")
    public ResponseEntity<?> getAccidentsByRadius(@PathVariable("latitud") float latitud, @PathVariable("longitud") float longitud, @PathVariable("distancia") int distancia) {
        ResponseEntity<?> response = null;
        Collection<AccidentDTO> result = this.getAccidentsService().getAccidentsByRadius(new Point(latitud, longitud), new Distance(distancia,  Metrics.KILOMETERS));
        response = ResponseEntity.ok(result);
        return response;
    }

    @GetMapping(value = "/api/severity/{latitud}/{longitud}/{distancia}")
    public ResponseEntity<?> getAccidentsSeverityByRadius(@PathVariable("latitud") float latitud, @PathVariable("longitud") float longitud, @PathVariable("distancia") int distancia) {
        ResponseEntity<?> response = null;
        Collection<AccidentDTO> result = this.getAccidentsService().getAccidentsSeverityByRadius(new Point(latitud, longitud), new Distance(distancia,  Metrics.KILOMETERS));
        response = ResponseEntity.ok(result);
        return response;
    }

    @GetMapping(value = "/api/DistanciaPromedio")
    public ResponseEntity<?> getPromDistance() {
        ResponseEntity<?> response = null;
        Float result = this.getAccidentsService().getPromDistance();
        response = ResponseEntity.ok(result);
        return response;
    }

    public IAccidentService getAccidentsService() {
        return this.accidentsService;
    }

}

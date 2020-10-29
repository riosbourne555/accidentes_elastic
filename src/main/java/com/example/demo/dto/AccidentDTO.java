package com.example.demo.dto;

import com.example.demo.model.Accident;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.geo.GeoResult;

public class AccidentDTO {

    public String id;
    public String startTime;
    public String endTime;
    public String city;
	public String state;
	public String country;
    public String description;
    public String severity;
    public GeoPoint start_location;
    public GeoPoint end_location;

    public AccidentDTO(Accident anAccident) {
        this.setId(anAccident.getId());
        this.setStartTime(anAccident.getStartTime());
        this.setEndTime(anAccident.getEndTime());
        this.setCity(anAccident.getCity());
        this.setState(anAccident.getState());
        this.setCountry(anAccident.getCountry());
        this.setDescription(anAccident.getDescription());
        this.setSeverity(anAccident.getSeverity());
        this.setStart_location(anAccident.getStart_location());
        this.setEnd_location(anAccident.getEnd_location());
    }

    public AccidentDTO(String id, String startTime, String endTime, String city, String state, String country, String severity, String description, GeoPoint startLocatio, GeoPoint endLocation) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.city = city;
        this.state = state;
        this.country = country;
        this.description = description;
        this.severity = severity;
        this.start_location = startLocatio;
        this.end_location = endLocation;
    }

    public AccidentDTO(GeoResult<Accident> a) {
	}

	public static AccidentDTO factory(String id, String startTime, String endTime, String city, String state, String country, String severity, String description, GeoPoint startLocatio, GeoPoint endLocation) {
        return new AccidentDTO(id, startTime, endTime, city, state, country, severity, description, startLocatio, endLocation);
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String anId) {
        this.id = anId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public GeoPoint getEnd_location() {
        return end_location;
    }
    public void setEnd_location(GeoPoint end_location) {
        this.end_location = end_location;
    }
    public GeoPoint getStart_location() {
        return start_location;
    }
    public void setStart_location(GeoPoint start_location) {
        this.start_location = start_location;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}

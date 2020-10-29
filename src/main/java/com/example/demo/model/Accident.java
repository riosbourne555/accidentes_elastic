package com.example.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Document(indexName = "accidentes")
public class Accident {

    @Id
    private String id;
    @Field("Start_Time")
    private String startTime;
    @Field(name="End_Time")
	private String endTime;
    @Field("Description")
    private String description;
    @Field("City")
    private String city;
    @Field("State")
    private String state;
    @Field("Country")
	private String country;

    @GeoPointField
    @Field("start_location")
	private GeoPoint startLocation;
	
    @GeoPointField
    @Field("end_location")
	private GeoPoint endLocation;

    @Field("Distance(mi)")
    private Float distance;

    @Field("Severity")
    private String severity;

    public Accident() {
    }

    public Accident(@Value("description") String aDescription) {
        this.setDescription(aDescription);
    }

    public Accident(@Value("startTime") String aStartTime,
                    @Value("endTime") String aEndTime,
                    @Value("city") String aCity,
                    @Value("state") String aState,
                    @Value("country") String aCountry,
                    @Value("description") String aDescription,
                    @Value("severity") String aSeverity,
                    @Value("startLocation") GeoPoint aStart_location,
                    @Value("endtLocation") GeoPoint aEnd_location) {
        this.setStartTime(aStartTime);
        this.setEndTime(aEndTime);
        this.setCity(aCity);
        this.setState(aState);
        this.setCountry(aCountry);
        this.setDescription(aDescription);
        this.setSeverity(aSeverity);
        this.setStart_location(aStart_location);
        this.setEnd_location(aEnd_location);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String anId) {
        this.id = anId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
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

    public GeoPoint getStart_location() {
        return startLocation;
    }
    public void setStart_location(GeoPoint start_location) {
        this.startLocation = start_location;
    }

    public GeoPoint getEnd_location() {
        return endLocation;
    }

    public void setEnd_location(GeoPoint end_location) {
        this.endLocation = end_location;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}

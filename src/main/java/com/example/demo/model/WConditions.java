package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;

public class WConditions {

    @Id
    @Field("Weather_Condition")
    private String condition;
    private Integer cantidad;

    public WConditions(String acondition, Integer acantidad) {
        condition = acondition;
        this.cantidad = acantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
}

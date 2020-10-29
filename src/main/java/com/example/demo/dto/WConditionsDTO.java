package com.example.demo.dto;

import com.example.demo.model.WConditions;

public class WConditionsDTO {

    public String condicion_climatica;
    public Integer cantidad;

    public WConditionsDTO(String acondition, Integer acantidad) {
        this.condicion_climatica = acondition;
        this.cantidad = acantidad;
    }

    public WConditionsDTO(WConditions a) {
        this.condicion_climatica = a.getCondition();
        this.cantidad = a.getCantidad();
	}

	public static WConditionsDTO factory(String acondition, Integer acantidad) {
        return new WConditionsDTO(acondition, acantidad);
    }


}

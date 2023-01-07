package com.example.zakladmechanicznyspringboot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private int id;
    private String mark;
    private String description;
    private Integer repairCost;
    private String status;

    public Vehicle() {
    }

    public Vehicle(int id, String m, String d, int c, String s) {
        this.id = id;
        this.mark = m;
        this.description = d;
        this.repairCost = c;
        this.status = s;
    }
}

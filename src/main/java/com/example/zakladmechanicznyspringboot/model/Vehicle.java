package com.example.zakladmechanicznyspringboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Vehicle {
    private String mark;
    private String description;
    private int repairCost;
    private String status;
    public Vehicle(Vehicle vehicle) {
        this.mark = vehicle.getMark();
        this.description = vehicle.getDescription();
        this.repairCost = vehicle.getRepairCost();
        this.status = vehicle.getStatus();
    }
}

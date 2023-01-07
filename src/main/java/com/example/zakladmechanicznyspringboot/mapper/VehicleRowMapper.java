package com.example.zakladmechanicznyspringboot.mapper;

import com.example.zakladmechanicznyspringboot.model.Vehicle;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleRowMapper implements RowMapper<Vehicle> {

    /**
     * Umożliwia wyświetlanie poszczególnych obiektów klasy Vehicle w wierszach. Bez tego nagłówki w tabeli w HTML
     * musiałyby być takie same jak w tabeli w bazie danych.
     * @param rs - służy do pobierania odpowiednich składowych
     * @param rowNum - liczba rzędów (pobierana automatycznie)
     * @return - kolejne obiekty klasy Vehicle
     * @throws SQLException - bez tego nie działa
     */
    public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(rs.getInt("id"));
        vehicle.setMark(rs.getString("mark"));
        vehicle.setDescription(rs.getString("description"));
        vehicle.setRepairCost(rs.getInt("cost"));
        vehicle.setStatus(rs.getString("status"));
        return vehicle;
    }

}

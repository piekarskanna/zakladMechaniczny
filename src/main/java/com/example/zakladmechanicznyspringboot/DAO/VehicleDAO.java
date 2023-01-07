package com.example.zakladmechanicznyspringboot.DAO;

import com.example.zakladmechanicznyspringboot.mapper.VehicleRowMapper;
import com.example.zakladmechanicznyspringboot.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class VehicleDAO {

    //instancja klasy JdbcTemplate używana do operacji na bazie danych
    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * Metoda zwraca wszystkie pojazdy znajdujące się w tabeli 'pojazdy', a składowe układa w wiersze dzięki RowMapperowi
     * @return - lista obiektów klasy Vehicle
     */
    public List<Vehicle> list() {
        return jdbcTemplate.query("SELECT * FROM pojazdy", new VehicleRowMapper());
    }

    /**
     * Metoda zapisuje pojazd do bazy danych
     * @param vehicle - obiekt tworzony w HTML
     */
    public void saveVehicle(Vehicle vehicle) {
        jdbcTemplate.update("INSERT INTO pojazdy (mark, description, cost) values(?, ?, ?)",
                vehicle.getMark(), vehicle.getDescription(), vehicle.getRepairCost());
    }

    /**
     * Metoda zwraca pojazd, na który kliknęliśmy, poprzez jego id
     * @param id - id pojazdu, którego chcemy edytować
     * @return - wybrany pojazd
     */
    public Vehicle get(int id) {
        String sql = "SELECT * FROM pojazdy WHERE id = ?";
        Object[] args = {id};
        return jdbcTemplate.queryForObject(sql, args, new VehicleRowMapper());
    }

    /**
     * Metoda zapisuje do bazy zaktualizowany pojazd
     * @param vehicle - pojazd, któremu zmieniliśmy status
     */
    public void updateStatus(Vehicle vehicle) {
        String sql = "UPDATE pojazdy SET status=? WHERE id=?";
        jdbcTemplate.update(sql, vehicle.getStatus(), vehicle.getId());
    }

//    public void delete(int id) {
//    }
}


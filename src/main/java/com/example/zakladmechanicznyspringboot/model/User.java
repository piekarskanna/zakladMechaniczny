package com.example.zakladmechanicznyspringboot.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


//trzeba ogaranc tabele
@Component
public class User {
    private int id;
    private String role;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;


    @Autowired
    public User(User user) {
        this.id = user.getId();
        this.role = user.getRole();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.gender = user.getGender();
    }

}
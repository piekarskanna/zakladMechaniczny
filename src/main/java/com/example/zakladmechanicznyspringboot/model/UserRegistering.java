package com.example.zakladmechanicznyspringboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class UserRegistering extends User {

    public UserRegistering(int id, String role, String firstName, String lastName, String email, String password, String gender) {
        super(id, role, firstName, lastName, email, password, gender);
    }


//    @Override
//    public String toString() {
//        return super.toString() + " oraz userRegistering{" +
//                "type='" + this.type + '\'' +
//                '}';
//    }
}
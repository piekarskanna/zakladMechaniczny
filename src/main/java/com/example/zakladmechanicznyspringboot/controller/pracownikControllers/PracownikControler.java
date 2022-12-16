package com.example.zakladmechanicznyspringboot.controller.pracownikControllers;


import com.example.zakladmechanicznyspringboot.controller.UserRepository;
import com.example.zakladmechanicznyspringboot.model.Pracownik;
import com.example.zakladmechanicznyspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PracownikControler {

    //trzeba bedzie podmienic aby wszedzie byl pracownik a nie user


    @Autowired
    UserRepository userRepository;

    @Autowired
    Pracownik pracownik;

    @Autowired
    User user;

    @PostMapping("/widokHomePracownika")
    public String menuPracownika(@RequestBody String input) {
        System.out.println(input);

        switch (input) {
            case "upvote=wybor1":
                return "wprowadzanieGodzinPracy";
            case "upvote=wybor4":
                return "redirect:/";
        }
        return "";
    }



    @PostMapping("/wprowadzGodziny")
    public boolean wprowadzanieGodzin(@RequestBody String input){

        String czesciInputu[] = input.split("&");
        System.out.println("----");
        String split1[] = czesciInputu[0].split("=");
        String date = split1[1];
        System.out.println(date);

        String split2[] = czesciInputu[1].split("=");
        String hours = split2[1];
        System.out.println(hours);
        System.out.println("dzien" + date);
        System.out.println("godziny" + Integer.valueOf(hours));


        System.out.println("id pracownika: " + user.getId());
//        userRepository.addWorkingHours(date, Integer.valueOf(hours), idPracownika);



        return false;
    }

}

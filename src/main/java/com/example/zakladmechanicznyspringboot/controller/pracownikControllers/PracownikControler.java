package com.example.zakladmechanicznyspringboot.controller.pracownikControllers;


import com.example.zakladmechanicznyspringboot.controller.UserRepository;
import com.example.zakladmechanicznyspringboot.model.Pracownik;
import com.example.zakladmechanicznyspringboot.model.User;
import com.example.zakladmechanicznyspringboot.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;


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

        return switch (input) {
            case "upvote=wybor1" -> "wprowadzanieGodzinPracy";
            case "upvote=wybor2" -> "dodajPojazd";
            case "upvote=wybor3" -> "zwrocPojazdy";
            case "upvote=wybor4" -> "redirect:/";
            default -> "";
        };
    }

    /**Metoda dodająca pojazd po poprawnym wprowadzeniu danych na stronie
     * @param vehicle - nowy obiekt typu vehicle tworzony interaktywnie przy pomocy HTMLa
     * @param model - do wypisania podstawowych informacji o pojeździe
     * @return - zwraca kolejną stronę
     */
    @PostMapping("/dodajPojazd")
    public String dodajPojazd(@ModelAttribute Vehicle vehicle, Model model) {
        userRepository.addVehicleToDb(vehicle);
        System.out.println("Hey");
        model.addAttribute("mark", vehicle.getMark());
        return "welcomePojazd";
    }

    /**
     * Metoda dodaje nowy widok. Dzięki mav.addObject(...) możemy dostać się do zawartości tabeli "pojazdy", zwracanej
     * przez userRepository.getVehicles(), z poziomu HTML. Tam iterujemy po zawartości tabeli i wypisujemy wartości.
     * @return - nowy widok
     */
    @GetMapping("/zwrocPojazdy")
    public ModelAndView zwrocPojazdy() {
        ModelAndView mav = new ModelAndView("zwrocPojazdy");
        mav.addObject("vehicles", userRepository.getVehicles());
        return mav;
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

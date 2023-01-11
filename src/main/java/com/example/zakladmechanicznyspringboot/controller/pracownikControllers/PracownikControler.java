package com.example.zakladmechanicznyspringboot.controller.pracownikControllers;


import com.example.zakladmechanicznyspringboot.DAO.VehicleDAO;
import com.example.zakladmechanicznyspringboot.model.Pracownik;
import com.example.zakladmechanicznyspringboot.model.User;
import com.example.zakladmechanicznyspringboot.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PracownikControler {

    //trzeba bedzie podmienic aby wszedzie byl pracownik a nie user



    @Autowired
    Pracownik pracownik;

    @Autowired
    private VehicleDAO vdao;

    @Autowired
    User user;


    @PostMapping("/widokHomePracownika")
    public String menuPracownika(@RequestBody String input) {
        System.out.println(input);

        return switch (input) {
            case "upvote=wybor1" -> "wprowadzanieGodzinPracy";
            case "upvote=wybor2" -> "redirect:/list";
            case "upvote=wybor4" -> "redirect:/";
            default -> "";
        };
    }

    //********************************** POJAZDY ***************************************
    /**
     * Metoda dodaje nowy widok. Dzięki mav.addObject(...) możemy dostać się do zawartości tabeli "pojazdy", zwracanej
     * przez userRepository.getVehicles(), z poziomu HTML. Tam iterujemy po zawartości tabeli i wypisujemy pojazdy.
     * @return - nowy widok
     */
    @RequestMapping("/list")
    public ModelAndView zwrocPojazdy() {
        ModelAndView mav = new ModelAndView("listVehicles");
        mav.addObject("vehicles", vdao.list());
        return mav;
    }

    /**
     * Metoda odpowiada za dodanie widoku, z którego poziomu dodajemy nowy pojazd do bazy danych. Wywołuje ją kliknięcie
     * na opcję "dodaj pojazd".
     * @return - widok ze stworzonym pojazdem
     */
    @RequestMapping("/addVehicleForm")
    public ModelAndView dodajPojazd() {
        ModelAndView mav = new ModelAndView("addVehicleForm");
        Vehicle newVehicle = new Vehicle();
        mav.addObject("vehicles",newVehicle);
        return mav;
    }

    /**
     * Metoda zapisuje stworzony pojazd do bazy danych
     * @param vehicle - pojazd stworzony w ramach akcji /addVehicleForm
     * @return - przekierowanie do listy pojazdów
     */
    @PostMapping("/saveVehicle")
    public String save(@ModelAttribute Vehicle vehicle) {
        vdao.saveVehicle(vehicle);
        return "redirect:/list";
    }

    /**
     * Metoda dodaje widok umożliwiający edycję obiektu
     * @param id - id obiektu, który modyfikujemy
     * @return - widok z edytowanym pojazdem
     */
    @RequestMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("updateForm");
        Vehicle vehicle = vdao.get(id);
        mav.addObject("vehicle", vehicle);
        return mav;
    }

    /**
     * Metoda zapisuje zmodyfikowany pojazd do bazy
     * @param vehicle - edytowany pojazd
     * @return - przekierowanie do listy pojazdów po naciśnięciu przycisku
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("vehicle") Vehicle vehicle) {
        vdao.updateStatus(vehicle);
        return "redirect:/list";
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

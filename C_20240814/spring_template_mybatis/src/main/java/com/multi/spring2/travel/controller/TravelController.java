package com.multi.spring2.travel.controller;


import com.multi.spring2.travel.domain.Booking;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/travel")
public class TravelController {

    @GetMapping
    public String travel(Model model) {
        return "travel/travel";
    }

    @GetMapping("/city")
    public String getCity() {
        return "travel/city";
    }

    @PostMapping("/plan")
    public ModelAndView planTrip(String plan, int price) {
        System.out.println("controller data>> " + plan + " " + (price + 1));
        ModelAndView modelAndView = new ModelAndView("travel/planTrip");
        modelAndView.addObject("plan", plan);
        modelAndView.addObject("price", price + 1000);
        return modelAndView;
    }

    @GetMapping(value = "/search")
    public String searchDestination(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("keyword", keyword);
        return "travel/searchResult";
    }

    @GetMapping("/country/{countryName}/{population}")
    public String getCountry(@PathVariable("countryName") String countryName,
                             @PathVariable("population") String population,
                             Model model) {
        model.addAttribute("countryName", countryName);
        model.addAttribute("population", population);
        return "travel/countryInfo";
    }

    @GetMapping("/booking")
    public String bookingForm(Model model) {
        model.addAttribute("booking", new Booking());
        return "travel/bookingForm";
    }

    @PostMapping("/booking")
    public String submitBooking(@ModelAttribute Booking booking) {
        //Model model
        //model.addAttribute("booking", booking);
        return "travel/bookingConfirmation";
    }
}



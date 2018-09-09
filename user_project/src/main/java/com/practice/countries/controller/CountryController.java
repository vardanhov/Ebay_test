package com.practice.countries.controller;

import com.practice.countries.service.CountryService;
import com.practice.countries.view.CountryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController {
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countriesService) {
        this.countryService = countriesService;
    }


    @RequestMapping(value = "/countries", method = {POST})
    public  List<CountryView> countries() {
        return countryService.country();
    }
}

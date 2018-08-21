package ru.bellintegrator.practice.countries.service;

import ru.bellintegrator.practice.countries.view.CountryView;
import java.util.List;

public interface CountryService {


    /**
     * List of Countries
     *
     *
     */

    List<CountryView> country();



    /**
     * save country
     *
     *
     */
    void save(CountryView countries);


}

package ru.bellintegrator.practice.countries.dao;


import ru.bellintegrator.practice.countries.model.Country;
import java.util.List;

public interface CountryDao  {


    /**
     * Get Country by code
     *
     *
     */

    Country getCountryByCode(String code);


    /**
     * Get list country
     *
     *
     */
    List<Country> all();


    /**
     * save country
     *
     *
     */
    void save(Country country);
}

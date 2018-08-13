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
     * Get Country by name
     *
     *
     */
    Country getCountryByName(String name);


    List<Country> all();

    void save(Country country);
}

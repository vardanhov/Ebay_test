package com.practice.countries.dao;


import com.practice.countries.model.Country;
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


}

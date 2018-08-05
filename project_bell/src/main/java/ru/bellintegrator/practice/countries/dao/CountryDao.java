package ru.bellintegrator.practice.countries.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.practice.countries.model.Country;

public interface CountryDao extends JpaRepository<Country, Long> {


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

}

package ru.bellintegrator.practice.countries.service;

import ru.bellintegrator.practice.countries.view.CountryView;

import java.util.List;
import java.util.Map;

public interface CountryService {


    /**
     * List of Countries
     *
     *
     */

    List<CountryView> country();


    void save(CountryView countries);
}
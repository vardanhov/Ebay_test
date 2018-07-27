package ru.bellintegrator.practice.countries.service;

import ru.bellintegrator.practice.countries.view.CountryView;

import java.util.List;
import java.util.Map;

public interface CountryService {

    Map<String, List<CountryView>> countries();
}

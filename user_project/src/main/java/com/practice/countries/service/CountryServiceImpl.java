package com.practice.countries.service;

import com.practice.countries.dao.CountryDao;
import com.practice.countries.model.Country;
import com.practice.countries.view.CountryView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {



    private final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

    private final CountryDao dao;

    @Autowired
    public CountryServiceImpl(CountryDao dao) {
        this.dao = dao;
    }


    /**
     * List of Countries
     *
     *
     */
    @Override
    @Transactional(readOnly = true)
    public List<CountryView> country() {
        List<Country> all = dao.all();

        Function<Country, CountryView> mapContries = p -> {
            CountryView view = new CountryView();
            view.code = p.getCode();
            view.name = p.getName();
            return view;
        };

        return all.stream()
                .map(mapContries)
                .collect(Collectors.toList());
    }

}
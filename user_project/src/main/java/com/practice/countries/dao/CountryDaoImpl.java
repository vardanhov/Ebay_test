package com.practice.countries.dao;

import com.practice.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class CountryDaoImpl implements CountryDao {


    private final EntityManager em;

    @Autowired
    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }


    /**
     * Get Country by code
     *
     *
     */
    @Override
    public Country getCountryByCode(String code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Country> criteria = builder.createQuery(Country.class);
        Root<Country> countryRoot = criteria.from(Country.class);
        criteria.where(builder.equal(countryRoot.get("code"), code));
        TypedQuery<Country> query = em.createQuery(criteria);
        return query.getSingleResult();

    }
    /**
     * Get list country
     *
     *
     */

    @Override
    public List<Country> all() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Country> criteria = criteriaBuilder.createQuery(Country.class);
        Root<Country> countryRoot = criteria.from(Country.class);
        criteria.select(countryRoot);
        List<Country> countryList = em.createQuery(criteria).getResultList();
        return countryList;
    }

}
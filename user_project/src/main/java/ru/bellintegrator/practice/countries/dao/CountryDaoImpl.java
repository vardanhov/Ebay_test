package ru.bellintegrator.practice.countries.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.countries.model.Country;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @Override
    public Country getCountryByCode(String code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Country> criteria = builder.createQuery(Country.class);

        Root<Country> countryRoot = criteria.from(Country.class);
        criteria.where(builder.equal(countryRoot.get("code"), code));

        TypedQuery<Country> query = em.createQuery(criteria);

            return query.getSingleResult();

    }


    @Override
    public Country getCountryByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Country> criteria = builder.createQuery(Country.class);

        Root<Country> countryRoot = criteria.from(Country.class);
        criteria.where(builder.equal(countryRoot.get("name"), name));

        TypedQuery<Country> query = em.createQuery(criteria);

            return query.getSingleResult();


}

    @Override
    public List<Country> all() {
        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
        return query.getResultList();
    }


    @Override
    public void save(Country country) {
        em.persist(country);
    }
}
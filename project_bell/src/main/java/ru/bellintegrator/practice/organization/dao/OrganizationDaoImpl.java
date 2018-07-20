package ru.bellintegrator.practice.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OrganizationDaoImpl implements OrganizationDao {
    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl( EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Organization> all() {
        TypedQuery<Organization> query = em.createQuery("SELECT p FROM Organization p", Organization.class);
        return query.getResultList();

    }

    @Override
    public Organization loadById(Long id) {
        return null;
    }

    @Override
    public Organization updateOrganization(Organization organization) {
        return null;
    }

    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }
    private CriteriaQuery<Organization> buildCriteria(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);

        Root<Organization> organization = criteria.from(Organization.class);
        criteria.where(builder.equal(organization.get("name"), name));

        return criteria;
    }
}

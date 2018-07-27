package ru.bellintegrator.practice.organization.dao;


import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationUpdateView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

public class OrganizationDaoImpl implements OrganizationDao {
    private final EntityManager em;

    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }



    @Override
    public List<Organization> allOrganization() {
        TypedQuery<Organization> query = em.createQuery("SELECT o FROM Organization o", Organization.class);
        return query.getResultList();
    }


    @Override
    public Organization findOrganizationById(Long id) {

        return em.find(Organization.class, id);
    }


    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }


    @Override
    public void updateOrganization(OrganizationUpdateView update) {
        Organization organization = em.find(Organization.class, update.getId());

        organization.update(update);
        em.merge(organization);
    }
}

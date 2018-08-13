package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;


public interface OrganizationDao {


    /**
     * Organizatin list
     *
     *
     */
    List<Organization> filter(String name, String inn, Boolean isActive);


    /**
     * Get Organization by id
     *
     *
     */
    OrganizationView getById(Long id);


    /**
     * Save Organization
     *
     *
     */
    void save(OrganizationView view);


    /**
     * Update Organization
     *
     *
     */
    void update(OrganizationView update);


    /**
     * Delete Organization
     *
     *
     */
    void delete(Long id);

}

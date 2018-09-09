package com.practice.organization.service;

import com.practice.organization.view.OrganizationView;

import java.util.List;


public interface OrganizationService {


    /**
     * Organizatin list
     *
     *
     */
    List<OrganizationView> list(OrganizationView organizationView);


    /**
     * Get Organization by id
     *
     *
     */
    OrganizationView getById(Long id);

    /**
     * Update Organization
     *
     *
     */
    void update(OrganizationView update);


    /**
     * Save Organization
     *
     *
     */
    void save(OrganizationView view);

    void delete(Long id);
}

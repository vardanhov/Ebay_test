package ru.bellintegrator.practice.organization.dao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationUpdateView;

import java.util.List;


public interface OrganizationDao {


    List<Organization> allOrganization();


    Organization findOrganizationById(Long id);


    void save(Organization organization);

    void updateOrganization(OrganizationUpdateView update);

}

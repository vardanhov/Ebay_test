package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationSaveView;
import ru.bellintegrator.practice.organization.view.OrganizationUpdateView;


public interface OrganizationService {



    void saveOrganization(OrganizationSaveView organizationSaveView);



    OrganizationUpdateView getOrganizationById(Long id);

}

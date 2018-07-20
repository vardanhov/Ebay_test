package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationView;
import java.util.List;

public interface OrganizationService {


    void add(OrganizationView organization);

    List<OrganizationView> organizations();

}

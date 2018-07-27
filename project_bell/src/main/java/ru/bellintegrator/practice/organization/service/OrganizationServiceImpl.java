package ru.bellintegrator.practice.organization.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationSaveView;
import ru.bellintegrator.practice.organization.view.OrganizationUpdateView;


@Service
   public class OrganizationServiceImpl implements OrganizationService{

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OrganizationDao dao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao) {

        this.dao = dao;
    }

    @Override
    public OrganizationUpdateView getOrganizationById(Long id) {
        Organization organization = dao.findOrganizationById(id);
        return new OrganizationUpdateView(organization.getId(),
                organization.getName(),
                organization.getFullName(),
                organization.getInn(),
                organization.getKpp(),
                organization.getAddress(),
                organization.getPhone(),
                organization.getActive());
    }


    @Override
    public void saveOrganization(OrganizationSaveView view) {
        Organization organization = new Organization(view.name,
                view.fullName,
                view.inn,
                view.kpp,
                view.address,
                view.phone,
                view.isActive);
        dao.save(organization);

    }


}
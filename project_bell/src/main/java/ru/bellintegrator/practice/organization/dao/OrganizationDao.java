package ru.bellintegrator.practice.organization.dao;
import ru.bellintegrator.practice.organization.model.Organization;
import java.util.List;


public interface OrganizationDao {


    List<Organization> all();
    Organization loadById(Long id);
    Organization updateOrganization(Organization organization);
    void save(Organization organization);


}

package ru.bellintegrator.practice.organization.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
   public class OrganizationServiceImpl implements OrganizationService{

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OrganizationDao orgdao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao dao) {

        this.orgdao = dao;
    }


    /**
     * Save Organization
     *
     *
     */
    @Override
    @Transactional
    public void save(OrganizationView view) {
        orgdao.save(view);
    }


    /**
     * Get Organization by id
     *
     *
     */
    @Override
    @Transactional(readOnly = true)
    public OrganizationView getById(Long id) {

        return orgdao.getById(id);
    }


    /**
     * Update Organization
     *
     *
     */
    @Override
    @Transactional
    public void update(OrganizationView update) {
        orgdao.update(update);

    }


    /**
     * Delete Organization
     *
     *
     */
    @Override
    @Transactional
    public void delete(Long id) {
        orgdao.delete(id);
    }



    /**
     * Organizatin list
     *
     *
     */
    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> list(OrganizationView organizationView) {


        List<Organization> all = orgdao.filter(organizationView.getName(),organizationView.getInn(),organizationView.isActive());
        Function<Organization, OrganizationView> mapOrganization = o -> {
            OrganizationView view = new OrganizationView();
            view.setId(o.getId()) ;
            view.setName(o.getName());
            view.setActive(o.getActive());
            log.info(view.toString());

            return view;
        };

        return all.stream()
                .map(mapOrganization)
                .collect(Collectors.toList());
    }

}
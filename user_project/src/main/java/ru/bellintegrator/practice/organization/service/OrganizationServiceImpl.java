package ru.bellintegrator.practice.organization.service;

import org.hibernate.service.spi.ServiceException;
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
        if (view.getName() == null) {
            throw new ServiceException("Введите называние компании");
        }
        if (view.getFullName() == null) {
            throw new ServiceException("Введите полное называние компании");
        }
        if (view.getInn() == null) {
            throw new ServiceException("Введите inn");
        }
        if(view.getKpp() == null) {
            throw new IllegalArgumentException("Введите kpp");
        }
        if (view.getAddress() == null) {
            throw new ServiceException("Введите адрес компании");
        }

        Organization organization = new Organization();
        organization.setName(view.getName());
        organization.setFullName(view.getFullName());
        organization.setInn(view.getInn());
        organization.setKpp(view.getKpp());
        organization.setAddress(view.getAddress());
        organization.setPhone(view.getPhone());
        organization.setActive(view.isActive());
        orgdao.save(organization);
    }


    /**
     * Get Organization by id
     *
     *
     */
    @Override
    @Transactional(readOnly = true)
    public OrganizationView getById(Long id) {
        Organization organization =orgdao.getById(id);
        OrganizationView view = new OrganizationView();
        view.setId(organization.getId()) ;
        view.setName(organization.getName());
        view.setFullName(organization.getFullName());
        view.setInn(organization.getInn());
        view.setKpp(organization.getKpp());
        view.setAddress(organization.getAddress());
        view.setPhone(organization.getPhone());
        view.setActive(organization.getActive());
        return view;

    }


    /**
     * Update Organization
     *
     *
     */
    @Override
    @Transactional
    public void update(OrganizationView update) {

        if (update.getId() == null) {
            throw new ServiceException("Введите id");
        }
        if (update.getName() == null) {
            throw new ServiceException("Введите называние компании");
        }
        if (update.getFullName() == null) {
            throw new ServiceException("Введите полное называние компании");
        }
        if (update.getInn() == null) {
            throw new ServiceException("Введите inn");
        }
        if(update.getKpp() == null) {
            throw new IllegalArgumentException("Введите kpp");
        }
        if (update.getAddress() == null) {
            throw new ServiceException("Введите адрес компании");
        }
        Organization org = orgdao.getById(update.getId());
        org.setName(update.getName());
        org.setFullName(update.getFullName());
        org.setInn(update.getInn());
        org.setKpp(update.getKpp());
        org.setAddress(update.getAddress());
        org.setPhone(update.getPhone());
        org.setActive(update.isActive());
        orgdao.update(org);

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
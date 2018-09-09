package com.practice.office.service;

import com.practice.office.dao.OfficeDao;
import com.practice.office.view.OfficeView;
import com.practice.organization.dao.OrganizationDao;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.practice.office.model.Office;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class OfficeServiceImpl implements OfficeService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OfficeDao officeDao;
    private final OrganizationDao orgdao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, OrganizationDao orgdao) {
        this.officeDao = officeDao;
        this.orgdao = orgdao;
    }

    /**
     * Save Office
     *
     *
     */
    @Override
    @Transactional
    public void save(OfficeView view) {


        Office office = new Office();
        office.setName(view.getName());
        office.setAddress(view.getAddress());
        office.setPhone(view.getPhone());
        office.setActive(view.getActive());
        orgdao.getById(view.getOrgId()).addOffice(office);
        officeDao.save(office);
    }


    /**
     * Get Office by id
     *
     *
     */
    @Override
    @Transactional(readOnly = true)
    public OfficeView getById(Long id) {
        Office office = officeDao.getById(id);
        OfficeView view = new OfficeView();
        view.setId(office.getId()) ;
        view.setName(office.getName());
        view.setAddress(office.getAddress());
        view.setPhone(office.getPhone());
        view.setActive(office.getActive());
        return view;

    }

    /**
     * Update Office
     *
     *
     */
    @Override
    @Transactional
    public void update(OfficeView view) {

        if (view.getId() == null) {
            throw new ServiceException("Введите id");
        }
        if (view.getName() == null) {
            throw new ServiceException("Введите называние");
        }
        if (view.getAddress() == null) {
            throw new ServiceException("Введите адрес");
        }
        Office office = officeDao.getById(view.getId());
        office.setName(view.getName());
        office.setAddress(view.getAddress());
        office.setPhone(view.getPhone());
        office.setActive(view.getActive());
        officeDao.update(office);

    }

    @Override
    @Transactional
    public void delete(Long id) {

        officeDao.delete(id);
    }


    /**
     * Offoce list
     *
     *
     */
    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> list(OfficeView office) {


        List<Office> all = officeDao.filter(office.getOrgId(), office.getName(), office.getPhone(),office.getActive());
        Function<Office, OfficeView> mapOffice = p -> {
            OfficeView view = new OfficeView();
            view.setId(p.getId());
            view.setName(p.getName());
            view.setActive(p.getActive());
            log.info(view.toString());
            return view;
        };

        return all.stream()
                .map(mapOffice)
                .collect(Collectors.toList());
    }
}

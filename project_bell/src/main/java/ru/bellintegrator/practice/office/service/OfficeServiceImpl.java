package ru.bellintegrator.practice.office.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeSaveView;
import ru.bellintegrator.practice.office.view.OfficeView;



@Service
public class OfficeServiceImpl implements OfficeService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OfficeDao dao;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao) {

        this.dao = dao;
    }

    @Override
    public OfficeView getOfficeById(Long id) {
        Office office = dao.findOfficeById(id);
        OfficeView officeView = new OfficeView();
        officeView.id = office.getId();
        officeView.name = office.getName();
        officeView.address = office.getAddress();
        officeView.phone = office.getPhone();
        officeView.isActive = office.getActive();
        return officeView;
    }


    @Override
    public void saveOffice(OfficeSaveView officeSaveView) {
        Office office = new Office();
        office.setName(officeSaveView.name);
        office.setAddress(officeSaveView.address);
        office.setPhone(officeSaveView.phone);
        office.setActive(officeSaveView.isActive);
        dao.save(office);

    }


}

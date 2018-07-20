package ru.bellintegrator.practice.office.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final OfficeDao dao;

    @Autowired
    public OfficeServiceImpl(OfficeDao dao) {

        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional

    public void add(OfficeView view) {
        Office office = new Office(view.name, view.address, view.phone);
        dao.save(office);
    }

    @Override
    public List<OfficeView> offices() {
        List<Office> all = dao.all();

        return all.stream()
                .map(mapOffice())
                .collect(Collectors.toList());
    }


    private Function<Office, OfficeView> mapOffice() {
        return p -> {
            OfficeView view = new OfficeView();
            view.id = String.valueOf(p.getId());
            view.name = p.getName();
            view.address = p.getAddress();
            view.phone = p.getPhone();


            log.debug(view.toString());

            return view;
        };
    }
}

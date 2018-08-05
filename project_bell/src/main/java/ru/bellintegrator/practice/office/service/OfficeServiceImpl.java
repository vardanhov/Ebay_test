package ru.bellintegrator.practice.office.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
     * Save Office
     *
     *
     */
    @Override
    public void save(OfficeView view) {
        dao.save(view);
    }


    /**
     * Get Office by id
     *
     *
     */
    @Override
    public OfficeView getById(Long id) {

        return dao.getById(id);
    }

    /**
     * Update Office
     *
     *
     */
    @Override
    public void update(OfficeView update) {
        dao.update(update);

    }

    /**
     * Delete Office
     *
     *
     */
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }


    /**
     * Offoce list
     *
     *
     */
    @Override
    public List<OfficeView> list(OfficeView office) {


        List<Office> all = dao.filter(office.getId(), office.getName(), office.getPhone(),office.getActive());

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

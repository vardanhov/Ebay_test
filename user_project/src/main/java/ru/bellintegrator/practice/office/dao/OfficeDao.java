package ru.bellintegrator.practice.office.dao;


import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.List;


public interface OfficeDao {


    /**
     * Offoce list
     *
     *
     */
    List<Office> filter(Long orgId, String name, String phone, Boolean isActive);

    /**
     * Get Office by id
     *
     *
     */
    OfficeView getById(Long id);


    /**
     * Save Office
     *
     *
     */
    void save(OfficeView view);

    /**
     * Update Office
     *
     *
     */
    void update(OfficeView update);

    /**
     * Delete Office
     *
     *
     */
    void delete(Long id);
}
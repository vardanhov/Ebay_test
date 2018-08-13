package ru.bellintegrator.practice.office.service;


import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.List;


public interface OfficeService {

    /**
     * Offoce list
     *
     *
     */
    List<OfficeView> list(OfficeView officeView);

    /**
     * Get Office by id
     *
     *
     */
    OfficeView getById(Long id);

    /**
     * Update Office
     *
     *
     */
    void update(OfficeView update);

    /**
     * Save Office
     *
     *
     */
    void save(OfficeView view);

    /**
     * Delete Office
     *
     *
     */
    void delete(Long id);
}
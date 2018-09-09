package com.practice.office.service;


import com.practice.office.view.OfficeView;
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

    void delete(Long id);

}
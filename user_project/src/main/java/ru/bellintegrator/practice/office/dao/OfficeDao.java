package ru.bellintegrator.practice.office.dao;


import ru.bellintegrator.practice.office.model.Office;
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
    Office getById(Long id);


    /**
     * Save Office
     *
     *
     */
    void save(Office office);

    /**
     * Update Office
     *
     *
     */
    void update(Office update);



}
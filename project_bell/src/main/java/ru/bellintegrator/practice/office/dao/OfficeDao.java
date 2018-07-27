package ru.bellintegrator.practice.office.dao;


import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeUpdateView;
import java.util.List;


public interface OfficeDao {

    List<Office> allOffice();


    Office findOfficeById(Long id);


    void save(Office office);

    void updateOffice(OfficeUpdateView update);
    }

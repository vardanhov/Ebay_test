package ru.bellintegrator.practice.office.service;


import ru.bellintegrator.practice.office.view.OfficeSaveView;
import ru.bellintegrator.practice.office.view.OfficeView;



public interface OfficeService {




    void saveOffice(OfficeSaveView officeSaveView);



    OfficeView getOfficeById(Long id);
}
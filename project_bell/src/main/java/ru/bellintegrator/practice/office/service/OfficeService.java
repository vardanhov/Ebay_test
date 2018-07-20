package ru.bellintegrator.practice.office.service;


import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.List;

public interface OfficeService {


    void add(OfficeView office);


    List<OfficeView> offices();
}
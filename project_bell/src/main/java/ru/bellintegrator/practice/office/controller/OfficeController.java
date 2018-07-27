package ru.bellintegrator.practice.office.controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeSaveView;
import ru.bellintegrator.practice.office.view.OfficeView;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    private final OfficeService officeService;


    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;

    }


    @ApiOperation(value = "findOfficeById", nickname = "findOfficeById", httpMethod = "GET")
    @PostMapping("/{id}")
    public OfficeView office(@PathVariable("id") Long id) {
        OfficeView response = new OfficeView();
        response.isActive = true;
        return response;
    }

    @ApiOperation(value = "saveOffice", nickname = "saveOffice", httpMethod = "POST")
    @PostMapping("/save")
    public void save(@RequestBody OfficeSaveView saveData) {
        officeService.saveOffice(saveData);
    }
}
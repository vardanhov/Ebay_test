package ru.bellintegrator.practice.organization.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.PathVariable;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationSaveView;
import ru.bellintegrator.practice.organization.view.OrganizationUpdateView;



@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    private final OrganizationService organizationService;


    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;

    }


    @ApiOperation(value = "findOrganizationById", nickname = "findOrganizationById", httpMethod = "GET")
    @PostMapping("/{id}")
    public OrganizationUpdateView organization(@PathVariable("id") Long id) {
        return organizationService.getOrganizationById(id);
    }

    @ApiOperation(value = "saveOrganization", nickname = "saveOrganization", httpMethod = "POST")
    @PostMapping("/save")
    public void save(OrganizationSaveView saveData) {
        organizationService.saveOrganization(saveData);
    }
}
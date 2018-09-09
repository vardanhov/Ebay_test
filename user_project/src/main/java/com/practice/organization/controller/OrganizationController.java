package com.practice.organization.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.practice.organization.service.OrganizationService;
import com.practice.organization.view.OrganizationView;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {
    private final OrganizationService organizationService;


    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;

    }


    @ApiOperation(value = "getOrgById", nickname = "getOrgById", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/{id}")
    public OrganizationView getOrgById(@PathVariable Long id) {
        return organizationService.getById(id);
    }



    @ApiOperation(value = "saveOrganization", nickname = "saveOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    ResponseEntity<OrganizationView> save( @Valid @RequestBody OrganizationView saveData) {
        organizationService.save(saveData);
        return new ResponseEntity<OrganizationView>(saveData, HttpStatus.CREATED);
    }





    @ApiOperation(value = "updateOrganization", nickname = "updateOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    ResponseEntity<OrganizationView> update(@Valid @RequestBody OrganizationView updateData) {
        organizationService.update(updateData);
        return new ResponseEntity<OrganizationView>(updateData, HttpStatus.OK);
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OrganizationView> delete(@PathVariable Long id) {
        organizationService.delete(id);
        return new ResponseEntity<OrganizationView>(HttpStatus.GONE);
    }



    @ApiOperation(value = "getList", nickname = "getList", httpMethod = "POST")
    @PostMapping("/list")
    public List<OrganizationView> list(@RequestBody OrganizationView orgView) {
        return organizationService.list(orgView);
    }

}
package ru.bellintegrator.practice.organization.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationView;
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


    @ApiOperation(value = "getById", nickname = "getById", httpMethod = "GET")
    @ApiResponses(value = {

            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/{id}")
    public OrganizationView organization(@PathVariable Long id) {
        return organizationService.getById(id);
    }



    @ApiOperation(value = "saveOrganization", nickname = "saveOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})

    @PostMapping("/save")
    public void save(@RequestBody OrganizationView saveData) {
        organizationService.save(saveData);
    }




    @ApiOperation(value = "updateOrganization", nickname = "updateOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})

    @PostMapping("/update")
    public void update(@RequestBody OrganizationView updateData) {
        organizationService.update(updateData);
    }





    @ApiOperation(value = "getList", nickname = "getList", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})

    @PostMapping("/list")
    public List<OrganizationView> list(@RequestBody OrganizationView View) {
        return organizationService.list(View);
    }

}
package com.practice.office.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.practice.office.service.OfficeService;
import com.practice.office.view.OfficeView;

import javax.validation.Valid;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }


    /**
     * Get Office by id
     *
     *
     */
    @ApiOperation(value = "getOfficeById", nickname = "getOfficeById", httpMethod = "GET")
    @GetMapping("/{id}")
    public OfficeView getOfficeById(@PathVariable Long id) {
        return officeService.getById(id);
    }

    /**
     * Save Office
     *
     *
     */
    @ApiOperation(value = "saveOffice", nickname = "saveOffice", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    ResponseEntity<OfficeView> save(@Valid @RequestBody OfficeView saveData) {
        officeService.save(saveData);
        return new ResponseEntity<OfficeView>(saveData, HttpStatus.CREATED);
    }


    /**
     * Update Office
     *
     *
     */
    @ApiOperation(value = "updateOffice", nickname = "updateOffice", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    ResponseEntity<OfficeView> update(@Valid @RequestBody OfficeView updateData) {
        officeService.update(updateData);
        return new ResponseEntity<OfficeView>(updateData, HttpStatus.OK);
    }

    /**
     * Offoce Delete
     *
     *
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OfficeView> deleteEmployee(@PathVariable Long id) {
        officeService.delete(id);
        return new ResponseEntity<OfficeView>(HttpStatus.GONE);
    }


    /**
     * Office list
     *
     *
     */
    @ApiOperation(value = "getList", nickname = "getList", httpMethod = "POST")
    @PostMapping("/list")
    public List<OfficeView> list(@RequestBody OfficeView officeView) {
        return officeService.list(officeView);
    }

}
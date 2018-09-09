package com.practice.user.controller;


import com.practice.user.service.UserService;
import com.practice.user.view.UserView;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get User by id
     *
     *
     */
    @ApiOperation(value = "getUserById", nickname = "getUserById", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @GetMapping("/{id}")
    public UserView getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }


    /**
     * Save User
     *
     *
     */
    @ApiOperation(value = "saveUser", nickname = "saveUser", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    ResponseEntity<UserView> save( @Valid @RequestBody UserView saveData) {
        userService.save(saveData);
        return new ResponseEntity<UserView>(saveData, HttpStatus.CREATED);
    }

    /**
     * Update User
     *
     *
     */
    @ApiOperation(value = "updateUser", nickname = "updateUser", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/update")
    ResponseEntity<UserView> update( @Valid @RequestBody UserView updateData) {
        userService.update(updateData);
        return new ResponseEntity<UserView>(updateData, HttpStatus.OK);
    }

    /**
     * Delete User
     *
     *
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserView> deleteEmployee( @PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<UserView>(HttpStatus.GONE);
    }

    /**
     * User list
     *
     *
     */
    @ApiOperation(value = "getList", nickname = "getList", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/list")
    public List<UserView> list(@RequestBody UserView userView) {
        return userService.list(userView);
    }

}
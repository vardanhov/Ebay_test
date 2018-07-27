package ru.bellintegrator.practice.user.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.user.service.UserService;
import ru.bellintegrator.practice.user.view.UserSaveView;
import ru.bellintegrator.practice.user.view.UserView;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }


    @ApiOperation(value = "finduserById", nickname = "finduserById", httpMethod = "GET")
    @PostMapping("/{id}")
    public UserView user(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @ApiOperation(value = "saveUser", nickname = "saveUser", httpMethod = "POST")
    @PostMapping("/save")
    public void save(UserSaveView saveData) {
        userService.save(saveData);
    }
}
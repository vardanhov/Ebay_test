package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.view.UserSaveView;

import ru.bellintegrator.practice.user.view.UserView;


public interface UserService {

    UserView getUserById(Long id);


    void save(UserSaveView userSaveView);
}
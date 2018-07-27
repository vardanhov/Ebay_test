package ru.bellintegrator.practice.user.dao;

import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserUpdateView;

import java.util.List;


public interface UserDao {
    List<User> allUser();


    User findUserById(Long id);


    void save(User user);

    void update(UserUpdateView update);

}

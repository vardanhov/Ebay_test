package ru.bellintegrator.practice.user.dao;

import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserView;
import java.util.List;


public interface UserDao {

    /**
     * User list
     *
     *
     */
    List<User> filter(UserView userView);


    /**
     * Get User by id
     *
     *
     */
    UserView getById(Long id);


    /**
     * Save User
     *
     *
     */
    void save(UserView view);


    /**
     * Update User
     *
     *
     */
    void update(UserView update);



    /**
     * Delete User
     *
     *
     */
    void delete(Long id);

}
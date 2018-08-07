package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.view.UserView;
import java.util.List;


public interface UserService {



    /**
     * User list
     *
     *
     */

    List<UserView> list();


    /**
     * Get User by id
     *
     *
     */
    UserView getById(Long id);


    /**
     * Update User
     *
     *
     */
    void update(UserView update);


    /**
     * Save User
     *
     *
     */
    void save(UserView view);


    /**
     * Delete User
     *
     *
     */
    void delete(Long id);
}
package ru.bellintegrator.practice.user.dao;

import ru.bellintegrator.practice.user.model.User;
import java.util.List;


public interface UserDao {

    /**
     * User list
     *
     *
     */
    List<User> filter(Long officeId, String firstName, String secondName, String middleName, String position, String docCode, String citizenshipCode);


    /**
     * Get User by id
     *
     *
     */
    User getById(Long id);


    /**
     * Save User
     *
     *
     */
    void save(User user);


    /**
     * Update User
     *
     *
     */
    void update(User update);



    /**
     * Delete User
     *
     *
     */
    void delete(Long id);



}
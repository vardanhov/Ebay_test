package ru.bellintegrator.practice.user.dao;

import ru.bellintegrator.practice.user.model.User;

import java.util.List;

/**
 * DAO для работы с Person
 */
public interface UserDao {
    /**
     * Получить все объекты Person
     *
     * @return
     */
    List<User> all();

    /**
     * Получить Person по идентификатору
     *
     * @param id
     * @return
     */
    User loadById(Long id);

    /**
     * Получить Person по имени
     *
     * @param name
     * @return
     */
    User loadByName(String name);

    /**
     * Сохранить Person
     *
     * @param user
     */
    void save(User user);
}

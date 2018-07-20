package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;

/**
 * Сервис
 */
public interface UserService {

    /**
     * Добавить нового человека в БД
     *
     * @param user
     */
    void add(UserView user);

    /**
     * Получить список людей
     *
     * @return {@User}
     */
    List<UserView> users();
}
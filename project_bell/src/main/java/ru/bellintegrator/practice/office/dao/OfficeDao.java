package ru.bellintegrator.practice.office.dao;



import ru.bellintegrator.practice.office.model.Office;

import java.util.List;

/**
 * DAO для работы с Person
 */
public interface OfficeDao {
    /**
     * Получить все объекты Person
     *
     * @return
     */
    List<Office> all();

    /**
     * Получить Person по идентификатору
     *
     * @param id
     * @return
     */
    Office loadById(Long id);

    /**
     * Получить Person по имени
     *
     * @param name
     * @return
     */
    Office loadByName(String name);

    /**
     * Сохранить Person
     *
     * @param office
     */
    void save(Office office);
}

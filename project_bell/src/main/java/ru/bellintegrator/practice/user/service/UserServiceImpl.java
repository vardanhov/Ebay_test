package ru.bellintegrator.practice.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.bellintegrator.practice.countries.dao.CountryDao;
import ru.bellintegrator.practice.countries.model.Country;

import ru.bellintegrator.practice.docs.dao.DocumentTypeDao;
import ru.bellintegrator.practice.docs.model.Document;
import ru.bellintegrator.practice.docs.model.DocumentType;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.dao.UserDaoImpl;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final UserDao dao;
    private final UserDaoImpl daoImpl;
    private final DocumentTypeDao documentTypeDao=null;
    private final CountryDao countryDao=null;

    @Autowired
    public UserServiceImpl(UserDao dao, UserDaoImpl daoImpl) {

        this.dao = dao;
        this.daoImpl = daoImpl;
    }

    /**
     * Save User
     *
     *
     */
    @Override
    public void save(UserView view) {
        dao.save(view);
    }


    /**
     * Get User by id
     *
     *
     */
    @Override
    public UserView getById(Long id) {

        return dao.getById(id);
    }


    /**
     * Update User
     *
     *
     */
    @Override
    public void update(UserView update) {
        dao.update(update);

    }


    /**
     * Delete User
     *
     *
     */
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }




    /**
     * User list
     *
     *
     */
    @Override
    public List<UserView> list() {
        List<User> all = daoImpl.all();

        Function<User, UserView> mapUser = p -> {
            UserView view = new UserView();
            view.setId(p.getId());
            view.setFirstName(p.getFirstName());
            view.setSecondName(p.getSecondName());
            view.setMiddleName(p.getMiddleName());
            view.setPosition(p.getPosition());

            log.info(view.toString());
            return view;
        };

        return all.stream()
                .map(mapUser)
                .collect(Collectors.toList());
    }



}

package ru.bellintegrator.practice.user.dao;



import ru.bellintegrator.practice.countries.model.Country;
import ru.bellintegrator.practice.docs.model.DocumentType;
import ru.bellintegrator.practice.user.model.User;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.user.view.UserUpdateView;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    private final EntityManager em;

    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }
Country country;


    @Override
    public List<User> allUser() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }


    @Override
    public User findUserById(Long id) {

        return em.find(User.class, id);
    }


    @Override
    public void save(User user) {
        em.persist(user);
    }


    @Override
    public void update(UserUpdateView update) {
        User user = em.find(User.class, update.getId());

        user.update(update,  country);
        em.merge(user);
    }
}
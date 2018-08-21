package ru.bellintegrator.practice.user.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.document.model.Document;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final EntityManager em;

    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }


    /**
     * Update User
     *
     *
     */
    @Override
    public void update(User user) {
        em.merge(user);
    }

    /**
     * Save User
     *
     *
     */


    @Override
    public void save(User user) {
        em.persist(user);
    }

    /**
     * Get User by id
     *
     *
     */
    @Override
    public User getById(Long id) {
        User user =em.find(User.class, id);
        if (user==null)
            throw new IllegalArgumentException("User не найден");
        return user;


    }


    /**
     * Delete User
     *
     *
     */
    @Override
    public void delete(Long id) {
        Document document = em.find(Document.class, id);
        em.remove(document);

    }

    /**
     * User list
     *
     *
     */
    @Override
    public List<User> filter(Long officeId, String firstName, String secondName, String middleName, String position, String docCode, String citizenshipCode) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> user = criteria.from(User.class);
        Predicate predicate = builder.conjunction();


        if (firstName != null) {
            Predicate p = builder.equal(user.get("firstName"), firstName);
            predicate = builder.and(predicate, p);
        }

        if (secondName != null) {
            Predicate p = builder.equal(user.get("secondName"), secondName);
            predicate = builder.and(predicate, p);
        }

        if (middleName != null) {
            Predicate p = builder.equal(user.get("middleName"), middleName);
            predicate = builder.and(predicate, p);
        }

        if (position != null) {
            Predicate p = builder.equal(user.get("position"), position);
            predicate = builder.and(predicate, p);
        }

        if (docCode != null) {
            Predicate p = builder.equal(user.get("document").get("documentType").get("code"), docCode);
            predicate = builder.and(predicate, p);
        }

        if (citizenshipCode != null) {
            Predicate p = builder.equal(user.get("country").get("code"), citizenshipCode);
            predicate = builder.and(predicate, p);
        }

        if (officeId != null) {
            Predicate p = builder.equal(user.get("office").get("id"), officeId);
            predicate = builder.and(predicate, p);
        }

        criteria.where(predicate);
        TypedQuery<User> query = em.createQuery(criteria);


        return query.getResultList();
    }



    public User getByOfficeId(UserView view) {
        User user =em.find(User.class, view.getOfficeId());
        if (user==null)
            throw new IllegalArgumentException("User не найден");
        return user;


    }
}
package ru.bellintegrator.practice.user.dao;



import ru.bellintegrator.practice.countries.dao.CountryDao;
import ru.bellintegrator.practice.countries.model.Country;
import ru.bellintegrator.practice.docs.dao.DocumentTypeDao;
import ru.bellintegrator.practice.docs.model.Document;
import ru.bellintegrator.practice.docs.model.DocumentType;
import ru.bellintegrator.practice.user.model.User;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.user.view.UserView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final DocumentTypeDao documentTypeDao;
    private final CountryDao countryDao;

    public UserDaoImpl(EntityManager em, DocumentTypeDao documentTypeDao, CountryDao countryDao) {
        this.em = em;
        this.documentTypeDao = documentTypeDao;
        this.countryDao = countryDao;

    }

    /**
     * Update User
     *
     *
     */
    @Override
    public void update(UserView userView) {
        User user = em.find(User.class, userView.getId());
        DocumentType documentType = documentTypeDao.getDocumentTypeByName(userView.getDocName());
        user.setFirstName(userView.getFirstName());
        user.setSecondName(userView.getSecondName());
        user.setMiddleName(userView.getMiddleName());
        user.setDocument(new Document(documentType, userView.getDocNumber(), userView.getDocDate()));
        user.setPhone(userView.getPhone());
        user.setPosition(userView.getPosition());
        user.setCountry(new Country(userView.getCitizenshipName(), userView.getCitizenshipCode()));
        user.setIdentified(true);
        em.persist(user);
    }

    /**
     * Save User
     *
     *
     */
    @Override
    public void save(UserView userView) {
        User user = new User();
        DocumentType documentType;
        if (userView.getDocName() != null) {
            documentType = documentTypeDao.getDocumentTypeByName(userView.getDocName());
        } else {
            documentType = documentTypeDao.getDocumentTypeByCode(userView.getDocCode());
        }
        Country country;
        if (userView.getCitizenshipName() != null) {
            country = countryDao.getCountryByName(userView.getCitizenshipName());
        } else {
            country = countryDao.getCountryByCode(userView.getCitizenshipCode());
        }
        user.setFirstName(userView.getFirstName());
        user.setSecondName(userView.getSecondName());
        user.setMiddleName(userView.getMiddleName());
        user.setPosition(userView.getPosition());
        user.setPhone(userView.getPhone());
        user.setDocument(new Document(documentType, userView.getDocNumber(), userView.getDocDate()));
        user.setCountry(country);
        user.setIdentified(true);
        em.persist(user);
    }

    /**
     * Get User by id
     *
     *
     */
    @Override
    public UserView getById(Long id) {
        User user = em.find(User.class, id);
        UserView userView = new UserView();
        userView.setId(user.getId());
        userView.setFirstName(user.getFirstName());
        userView.setSecondName(user.getSecondName());
        userView.setMiddleName(user.getMiddleName());
        userView.setPosition(user.getPosition());
        userView.setPhone(user.getPhone());
        userView.setDocName(user.getDocument().getDocumentType().getName());
        userView.setDocNumber(user.getDocument().getNumber());
        userView.setDocDate(user.getDocument().getDate());
        userView.setCitizenshipName(user.getCountry().getName());
        userView.setCitizenshipCode(user.getCountry().getCode());
        userView.setIdentified(user.getIdentified());
        return userView;
    }

    /**
     * Delete User
     *
     *
     */
    @Override
    public void delete(Long id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    /**
     * User list
     *
     *
     */
    @Override
    public List<User> filter(UserView userView) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);

        Root<User> user = criteria.from(User.class);

        Predicate predicate = builder.conjunction();
        if (userView.getFirstName() != null) {
            Predicate p = builder.equal(user.get("firstname"), userView.getFirstName());
            predicate = builder.and(predicate, p);
        }

        if (userView.getSecondName() != null) {
            Predicate p = builder.equal(user.get("secondname"), userView.getSecondName());
            predicate = builder.and(predicate, p);
        }

        if (userView.getMiddleName() != null) {
            Predicate p = builder.equal(user.get("middlename"), userView.getMiddleName());
            predicate = builder.and(predicate, p);
        }

        if (userView.getPosition() != null) {
            Predicate p = builder.equal(user.get("position"), userView.getPosition());
            predicate = builder.and(predicate, p);
        }

        if (userView.getDocCode() != null) {
            Predicate p = builder.equal(user.get("document").get("documentType").get("code"), userView.getDocCode());
            predicate = builder.and(predicate, p);
        }

        if (userView.getCitizenshipCode() != null) {
            Predicate p = builder.equal(user.get("country").get("code"), userView.getCitizenshipCode());
            predicate = builder.and(predicate, p);
        }

        if (userView.getOfficeId() != null) {
            Predicate p = builder.equal(user.get("office").get("id"), userView.getOfficeId());
            predicate = builder.and(predicate, p);
        }

        criteria.where(predicate);
        TypedQuery<User> query = em.createQuery(criteria);


        return query.getResultList();
    }

    public List<User> all() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    public DocumentType findDocumentTypeId(String code) {
        return documentTypeDao.getDocumentTypeByCode(code);
    }



    public Country findCountryId(String code) {
        return countryDao.getCountryByCode(code);
    }
}
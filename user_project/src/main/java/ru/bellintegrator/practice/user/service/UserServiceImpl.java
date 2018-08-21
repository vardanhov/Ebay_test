package ru.bellintegrator.practice.user.service;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.countries.dao.CountryDao;
import ru.bellintegrator.practice.countries.model.Country;
import ru.bellintegrator.practice.docs.dao.DocumentTypeDao;
import ru.bellintegrator.practice.docs.model.DocumentType;
import ru.bellintegrator.practice.document.dao.DocumentDao;
import ru.bellintegrator.practice.document.model.Document;
import ru.bellintegrator.practice.office.dao.OfficeDao;
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
    private final CountryDao countryDao;
    private final DocumentTypeDao documentTypeDao;
    private final OfficeDao officeDao;
    private final DocumentDao documentDao;

    @Autowired
    public UserServiceImpl(UserDao dao, UserDaoImpl daoImpl, CountryDao countryDao, DocumentTypeDao documentTypeDao, OfficeDao officeDao, DocumentDao documentDao) {

        this.dao = dao;
        this.daoImpl = daoImpl;
        this.countryDao = countryDao;
        this.documentTypeDao = documentTypeDao;
        this.officeDao = officeDao;
        this.documentDao = documentDao;
    }

    /**
     * Save User
     *
     *
     */
    @Override
    @Transactional
    public void save(UserView userView) {
        if (userView.getFirstName() == null) {
            throw new ServiceException("Введите firstname");
        }
        if (userView.getPosition() == null) {
            throw new ServiceException("Введите position");
        }
        if(userView.getOfficeId() == null) {
            throw new IllegalArgumentException("Введите officeId");
        }
        User user = new User();
        DocumentType documentType = documentTypeDao.getDocumentTypeByName(userView.getDocName());
        Country country = countryDao.getCountryByCode( userView.getCitizenshipCode());
        Document document = new Document();
        document.setNumber(userView.getDocNumber());
        document.setDate(userView.getDocDate());
        documentDao.save(document);
        user.setFirstName(userView.getFirstName());
        user.setSecondName(userView.getSecondName());
        user.setMiddleName(userView.getMiddleName());
        user.setPosition(userView.getPosition());
        user.setPhone(userView.getPhone());
        user.setDocument(document);
        document.setDocumentType(documentType);
        user.setCountry(country);
        user.setIdentified(true);
        officeDao.getById(userView.getOfficeId()).addUser(user);
        dao.save(user);
        log.info("User add as " + user);
    }


    /**
     * Get User by id
     *
     *
     */
    @Override
    @Transactional(readOnly = true)
    public UserView getById(Long id) {
            User user = dao.getById(id);
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
     * Update User
     *
     *
     */
    @Override
    @Transactional

        public void update(UserView userView) {
        if (userView.getId() == null) {
            throw new ServiceException("Введите id");
        }
        if (userView.getFirstName() == null) {
            throw new ServiceException("Введите firstname");
        }
        if (userView.getPosition() == null) {
            throw new ServiceException("Введите position");
        }

            User user  = dao.getById(userView.getId());


            DocumentType documentType = documentTypeDao.getDocumentTypeByName(userView.getDocName());
            Country country = countryDao.getCountryByCode( userView.getCitizenshipCode());
            Document document = documentDao.loadById(userView.getId());
            document.setNumber(userView.getDocNumber());
            document.setDate(userView.getDocDate());
            documentDao.update(document);
            user.setFirstName(userView.getFirstName());
            user.setSecondName(userView.getSecondName());
            user.setMiddleName(userView.getMiddleName());
            user.setPhone(userView.getPhone());
            user.setPosition(userView.getPosition());
            document.setDocumentType(documentType);
            user.setDocument(document);
            user.setCountry(country);
            user.setIdentified(true);
            dao.update(user);

    }


    /**
     * Delete User
     *
     *
     */
    @Override
    @Transactional
    public void delete(Long id) {

        dao.delete(id);
    }


    /**
     * User list
     *
     *
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserView> list(UserView user) {
        List<User> all = daoImpl.filter(user.getOfficeId(),user.getFirstName(), user.getSecondName(), user.getMiddleName(), user.getPosition(),user.getDocCode(), user.getCitizenshipCode() );
        Function<User, UserView> mapUser = p -> {
            UserView view = new UserView();
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

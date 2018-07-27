package ru.bellintegrator.practice.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.bellintegrator.practice.countries.dao.CountryDao;
import ru.bellintegrator.practice.countries.model.Country;

import ru.bellintegrator.practice.docs.dao.DocumentTypeDao;
import ru.bellintegrator.practice.docs.model.Document;
import ru.bellintegrator.practice.docs.model.DocumentType;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserSaveView;
import ru.bellintegrator.practice.user.view.UserView;

@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final UserDao dao;
    private final DocumentTypeDao documentTypeDao=null;
    private final CountryDao countryDao=null;

    @Autowired
    public UserServiceImpl(UserDao dao) {

        this.dao = dao;
    }

    @Override
    public void save(UserSaveView userSaveView) {
        User user = new User();

        DocumentType documentType;
        if (userSaveView.docName != null) {
            documentType = documentTypeDao.findByName(userSaveView.docName);
        } else {
            documentType = documentTypeDao.findByCode(userSaveView.docCode);
        }
        Country country;
        if (userSaveView.citizenshipName != null) {
            country = countryDao.getCountryByName(userSaveView.citizenshipName);
        } else {
            country = countryDao.getCountryByCode(userSaveView.citizenshipCode);
        }

        user.setFirstName(userSaveView.firstName);
        user.setSecondName(userSaveView.secondName);
        user.setMiddleName(userSaveView.middleName);
        user.setPosition(userSaveView.position);
        user.setPhone(userSaveView.phone);
        user.setDocument(new Document(documentType, userSaveView.docNumber, userSaveView.docDate));
        user.setCountry(country);
        user.setIdentified(true);
        dao.save(user);

    }


    @Override
    public UserView getUserById(Long id) {
        User user = dao.findUserById(id);
        UserView view = new UserView();
        view.id = user.getId();
        view.firstName = user.getFirstName();
        view.secondName = user.getSecondName();
        view.middleName = user.getMiddleName();
        view.position = user.getPosition();
        view.phone = user.getPhone();
        view.docName = user.getDocument().getDocumentType().getName();
        view.docNumber = user.getDocument().getNumber();
        view.docDate = user.getDocument().getDate();
        view.citizenshipName = user.getCountry().getName();
        view.citizenshipCode = user.getCountry().getCode();
        view.isIdentified = user.getIdentified();
        return view;

    }
}

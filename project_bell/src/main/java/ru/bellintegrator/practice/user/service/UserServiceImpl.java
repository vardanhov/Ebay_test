package ru.bellintegrator.practice.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserView;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(UserView view) {
        User user = new User(view.firstName, view.secondName, view.middleName, view.position,view.phone, view.docCode, view.docName, view.docNumber, view.docDate, view.citizenshipName, view.citizenshipCode);
        dao.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<UserView> users() {
        List<User> all = dao.all();

        return all.stream()
                .map(mapUser())
                .collect(Collectors.toList());
    }

    private Function<User, UserView> mapUser() {
        return p -> {
            UserView view = new UserView();
            view.id = String.valueOf(p.getId());
            view.firstName = p.getFirstName();
            view.secondName = p.getSecondName();
            view.middleName = p.getMiddleName();
            view.position=p.getPosition();
            view.phone= p.getPhone();
            view.docCode=p.getDocCode();
            view.docName=p.getDocName();
            view.docNumber=p.getDocNumber();
            view.docDate=p.getDocDate();
            view.citizenshipCode=p.getCitizenshipCode();
            view.citizenshipName=p.getCitizenshipName();

            log.debug(view.toString());

            return view;
        };
    }
}

package ru.bellintegrator.practice.person.service.user;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bellintegrator.practice.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.countries.dao.CountryDao;
import ru.bellintegrator.practice.countries.model.Country;
import ru.bellintegrator.practice.docs.dao.DocumentTypeDao;
import ru.bellintegrator.practice.docs.model.Document;
import ru.bellintegrator.practice.docs.model.DocumentType;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.view.UserView;
import org.junit.Before;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class UserDaoImplTest {


    @Autowired
    private OfficeDao officeDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DocumentTypeDao documentTypeDao;

    @Autowired
    private CountryDao countryDao;


    private OfficeView officeview;
    private Document document;
    private DocumentType documentType;
    private Country country;
    private User user;
    private UserView userview;

    @Before
    public void setUp() {
        userview = new UserView();
        userview.setId(5L);
        userview.setFirstName("Anton");
        userview.setSecondName("Atamanov");
        userview.setMiddleName("Konstantinovich");
        userview.setPosition("Engineer");
        userview.setPhone("+76461616166");
        userview.setDocNumber("09an987656");
        userview.setDocDate("12.12.2008");
        userview.setDocCode("10");
        userview.setDocName("Passport");
        userview.setCitizenshipCode("007");
        userview.setCitizenshipName("Russia");

    }


    @Test
    public void testSave() {
        userDao.save(userview);
        assertNotNull(userview.getId());

    }

//@Test
//public void saveUser() {
//    UserView userview = new UserView();
//
//
//
//   userview.setFirstName("Andrey");
//    userview.setSecondName("Kovalchuk");
//    userview.setMiddleName("Borisovich");
//}

@Test
public void updateUser(){
    Long id = 2L;
    UserView userview = userDao.getById(id);
    userview.setFirstName("Igor");
    userview.setSecondName("Kovalchuk");
    userview.setMiddleName("Borisovich");

    userDao.update(userview);

    UserView newUser = userDao.getById(id);
    Assert.assertEquals(userview, newUser);

}




}

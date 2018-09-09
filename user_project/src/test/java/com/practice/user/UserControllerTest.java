package com.practice.user;


import org.bitbucket.radistao.test.annotation.AfterAllMethods;
import org.bitbucket.radistao.test.annotation.BeforeAllMethods;
import org.bitbucket.radistao.test.runner.BeforeAfterSpringTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import com.practice.Application;
import com.practice.office.service.OfficeService;
import com.practice.office.view.OfficeView;
import com.practice.organization.service.OrganizationService;
import com.practice.organization.view.OrganizationView;
import com.practice.user.service.UserService;
import com.practice.user.view.UserView;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(BeforeAfterSpringTestRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class UserControllerTest {

    private static final String URL = "http://localhost:8888/api/";
    private static HttpHeaders headers = new HttpHeaders();
    private static Long id=7L;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private OrganizationService orgService;
    @Autowired
    private OfficeService officeService;
    @Autowired
    private UserService userService;



    @BeforeAllMethods
    public  void  setUp() {
        OrganizationView view = new OrganizationView();
        view.setName("Яндекс");
        view.setFullName("Яндекс");
        view.setInn("54156161");
        view.setKpp("6156156");
        view.setAddress("Москва, Каширское ш. 14");
        view.setPhone("+7(968)4571245");
        view.setActive(true);
        orgService.save(view);

        OfficeView saveoffice = new OfficeView();
        saveoffice.setName("Яндекс  офис № 3");
        saveoffice.setAddress("Москва, Мосфильмовская 15");
        saveoffice.setPhone("+7(926)6466878");
        saveoffice.setActive(true);
        saveoffice.setOrgId(5L);
        officeService.save(saveoffice);


    }

    @Before
    public void setupUser() {
        UserView userView = new UserView();
        userView.setFirstName("Мария");
        userView.setSecondName("Козлова");
        userView.setMiddleName("Игоревна");
        userView.setPosition("Специалист");
        userView.setPhone("+7(987)6548445");
        userView.setDocCode("10");
        userView.setDocName("Паспорт иностранного гражданина");
        userView.setDocNumber("64684646");
        userView.setDocDate("02.02.2006");
        userView.setCitizenshipCode("007");
        userView.setCitizenshipName("Российская Федерация");
        userView.setIdentified(true);
        userView.setOfficeId(5L);
        userService.save(userView);
        UserView getUser =userService.getById(id);
    }


    @Test
    public void testSave() {
        UserView save = new UserView();
        save.setFirstName("Денис");
        save.setSecondName("Шевченко");
        save.setMiddleName("Борисович");
        save.setPosition("курьер");
        save.setPhone("+7(987)6454665");
        save.setDocCode("10");
        save.setDocName("Паспорт иностранного гражданина");
        save.setDocNumber("64646466");
        save.setDocDate("02.11.1999");
        save.setCitizenshipCode("007");
        save.setCitizenshipName("Российская Федерация");
        save.setIdentified(true);
        save.setOfficeId(5L);
        HttpEntity<UserView> entitystatus = new HttpEntity(save, headers);
        ResponseEntity<UserView> responseEntity = restTemplate.postForEntity(
                URL+"user/save", entitystatus, UserView.class);
        int status = responseEntity.getStatusCodeValue();
        UserView resultUser = responseEntity.getBody();
        UserView getUser =userService.getById(10L);
        // verify

        assertEquals("Incorrect Response Status", HttpStatus.CREATED.value(), status);
        assertNotNull(resultUser);
        assertEquals(resultUser.getFirstName(), getUser.getFirstName());
        userService.delete(id++);
    }

    @Test
    public void testUpdate() {
        UserView update = new UserView();
        update.setId(13L);
        update.setFirstName("Дмитрий");
        update.setSecondName("Орлов");
        update.setMiddleName("Антонович");
        update.setPosition("Водитель");
        update.setPhone("+7(925)6464589");
        update.setDocName("Паспорт иностранного гражданина");
        update.setDocNumber("64516165161");
        update.setDocDate("07.09.2008");
        update.setCitizenshipCode("007");
        update.setIdentified(true);
        HttpEntity<UserView> entitystatus = new HttpEntity(update, headers);
       ResponseEntity<UserView> responseEntity = restTemplate.postForEntity(
               URL+"user/update", entitystatus, UserView.class);
        int status = responseEntity.getStatusCodeValue();
        UserView getUser =userService.getById(id);
// verify
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
        assertNotEquals("Мария",getUser.getFirstName());
        assertThat(getUser.getSecondName(), is("Орлов"));
    }


    @Test
    public void testList() {
        UserView filter = new UserView();
        filter.setFirstName("Мария");
        filter.setSecondName("Козлова");
        filter.setMiddleName("Игоревна");
        filter.setPosition("Специалист");
        filter.setDocCode("10");
        filter.setCitizenshipCode("007");
        HttpEntity<UserView> entitystatus = new HttpEntity(filter, headers);
        ResponseEntity<UserView[]> responseEntity = restTemplate.exchange(
                URL+"user/list", HttpMethod.POST, entitystatus,
                UserView[].class);
        int status = responseEntity.getStatusCodeValue();
        UserView[] users = responseEntity.getBody();
        UserView newuser = new UserView();
        for (UserView user : users) {
            newuser.setFirstName(user.getFirstName());
        }
// verify
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
        assertThat(newuser, notNullValue());
        assertThat(newuser.getFirstName(), is("Мария"));
        assertNotNull("User not found", users);
    }

    @Test
    public void testLoadById() {
        HttpEntity<UserView> entitystatus = new HttpEntity( headers);
        ResponseEntity<UserView> responseEntity = restTemplate.getForEntity(URL+"user/" + "{id}", UserView.class, id);
        int status = responseEntity.getStatusCodeValue();
        UserView resultUser = responseEntity.getBody();
        //   verify
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
        assertThat(resultUser, notNullValue());
        assertThat(resultUser.getFirstName(), is("Мария"));
    }

    @Test
    public void testDelete() {
        UserView user = new UserView();
        user.setFirstName("Денис");
        user.setSecondName("Шевченко");
        user.setMiddleName("Борисович");
        user.setPosition("курьер");
        user.setPhone("+7(987)6454665");
        user.setDocCode("10");
        user.setDocName("Паспорт иностранного гражданина");
        user.setDocNumber("64646466");
        user.setDocDate("02.11.1999");
        user.setCitizenshipCode("007");
        user.setCitizenshipName("Российская Федерация");
        user.setIdentified(true);
        user.setOfficeId(5L);
        userService.save(user);
        // Delete user
        HttpEntity<UserView> entitystatus = new HttpEntity( headers);
        ResponseEntity<UserView> responseEntitydel = restTemplate.exchange(URL+"user/delete/{id}", HttpMethod.DELETE, entitystatus, UserView.class,
                id++);
        int status = responseEntitydel.getStatusCodeValue();
        // verify
        assertEquals("Incorrect Response Status", HttpStatus.GONE.value(), status);


    }

    @After
    public void deleteUser() {
        userService.delete(id++);

    }
    @AfterAllMethods
    public void deleteOrgOff(){
        officeService.delete(5L);
        orgService.delete(5L);

    }
}

package com.practice.office;

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

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;


@RunWith(BeforeAfterSpringTestRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OfficeControllerTest {

    private static final String URL = "http://localhost:8888/api/";
    private static HttpHeaders headers = new HttpHeaders();
    private static Long id = 5L;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private OrganizationService orgService;
    @Autowired
    private OfficeService officeService;


    @BeforeAllMethods
    public void setUp() {
        OrganizationView view = new OrganizationView();
        view.setName("Яндекс");
        view.setFullName("Яндекс");
        view.setInn("54156160");
        view.setKpp("6156156");
        view.setAddress("Москва, Каширское ш. 14");
        view.setPhone("+7(968)4571245");
        view.setActive(true);
        orgService.save(view);


    }

    @Before
    public void officeSave() {
        OfficeView saveoffice = new OfficeView();
        saveoffice.setName("Яндекс  офис № 3");
        saveoffice.setAddress("Москва, Мосфильмовская 15");
        saveoffice.setPhone("+7(926)6466878");
        saveoffice.setActive(true);
        saveoffice.setOrgId(5L);
        officeService.save(saveoffice);
        OfficeView getOffice1 = officeService.getById(id);
    }

    @Test
    public void testSave() {
        OfficeView save = new OfficeView();
        save.setName("Яндекс  офис № 4");
        save.setAddress("Москва, Ленинский пр. 15");
        save.setPhone("+7(926)6466878");
        save.setOrgId(5L);
        save.setActive(true);
        HttpEntity<OfficeView> entitystatus = new HttpEntity(save, headers);
        ResponseEntity<OfficeView> responseEntity = restTemplate.postForEntity(
                URL + "office/save", entitystatus, OfficeView.class);
        int status = responseEntity.getStatusCodeValue();
        OfficeView resultOffice = responseEntity.getBody();
        OfficeView getOffice = officeService.getById(8L);
        // verify
        assertEquals("Incorrect Response Status", HttpStatus.CREATED.value(), status);
        assertNotNull(resultOffice);
        assertEquals(getOffice.getName(), resultOffice.getName());
        officeService.delete(id++);
    }

    @Test
    public void testUpdate() {
        OfficeView update = new OfficeView();
        update.setId(id);
        update.setName("Яндекс  офис № 5");
        update.setAddress("Москва, Молодежная 46");
        update.setPhone("+7(925)6484679");
        update.setActive(true);
        HttpEntity<OfficeView> entitystatus = new HttpEntity(update, headers);
        ResponseEntity<OfficeView> responseEntity = restTemplate.postForEntity(
                URL + "office/update", entitystatus, OfficeView.class);
        int status = responseEntity.getStatusCodeValue();
        OfficeView getOffice = officeService.getById(id);
// verify
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
        assertNotEquals("Яндекс  офис № 3", getOffice.getName());
        assertThat(getOffice.getAddress(), is("Москва, Молодежная 46"));
    }


    @Test
    public void testList() {
        OfficeView filter = new OfficeView();
        filter.setOrgId(5L);
        filter.setName("Яндекс  офис № 3");
        filter.setPhone("+7(926)6466878");
        filter.setActive(true);
        HttpEntity<OfficeView> entitystatus = new HttpEntity(filter, headers);
        ResponseEntity<OfficeView[]> responseEntity = restTemplate.exchange(
                URL + "office/list", HttpMethod.POST, entitystatus,
                OfficeView[].class);
        int status = responseEntity.getStatusCodeValue();
        OfficeView[] offices = responseEntity.getBody();
        OfficeView newoffice = new OfficeView();
        for (OfficeView office : offices) {
            newoffice.setName(office.getName());
        }
// verify
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
        assertThat(newoffice, notNullValue());
        assertThat(newoffice.getName(), is("Яндекс  офис № 3"));
        assertNotNull("Office not found", offices);
    }


    @Test
    public void testLoadById() {
        HttpEntity<OfficeView> entitystatus = new HttpEntity(headers);
        ResponseEntity<OfficeView> responseEntity = restTemplate.getForEntity(URL + "office/" + "{id}", OfficeView.class, id);
        int status = responseEntity.getStatusCodeValue();
        OfficeView resultOffice = responseEntity.getBody();
        //   verify
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
        assertThat(resultOffice, notNullValue());
        assertThat(resultOffice.getName(), is("Яндекс  офис № 3"));
    }


    @Test
    public void testDelete() {
        OfficeView save = new OfficeView();
        save.setName("Яндекс  офис № 4");
        save.setAddress("Москва, Ленинский пр. 15");
        save.setPhone("+7(926)6466878");
        save.setOrgId(5L);
        save.setActive(true);
        officeService.save(save);
        HttpEntity<OfficeView> entitystatus = new HttpEntity(headers);
        ResponseEntity<OfficeView> responseEntitydel = restTemplate.exchange(URL + "office/delete/{id}", HttpMethod.DELETE, entitystatus, OfficeView.class,
                id++);
        int status = responseEntitydel.getStatusCodeValue();
        // verify
        assertEquals("Incorrect Response Status", HttpStatus.GONE.value(), status);

    }
    @After
    public void deleteOffice() {
        officeService.delete(id++);

    }
    @AfterAllMethods
    public void deleteOrg(){
        orgService.delete(5L);
    }

}




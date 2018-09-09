package com.practice.organization;

import com.practice.Application;
import com.practice.organization.service.OrganizationService;
import com.practice.organization.view.OrganizationView;
import org.bitbucket.radistao.test.runner.BeforeAfterSpringTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;


@RunWith(BeforeAfterSpringTestRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OrganizationControllerTest {


    private static final String URL = "http://localhost:8888/api/";
    private static HttpHeaders headers = new HttpHeaders();
    private static Long id = 5L;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private OrganizationService orgService;


    @Before
    public void setup() {
        OrganizationView view = new OrganizationView();
        view.setName("Яндекс");
        view.setFullName("Яндекс");
        view.setInn("5415616");
        view.setKpp("6156156");
        view.setAddress("Москва, Каширское ш. 14");
        view.setPhone("+7(968)4571245");
        view.setActive(true);
        orgService.save(view);

    }

    @Test
    public void testSave() {
        OrganizationView save = new OrganizationView();
        save.setName("Рамблер");
        save.setFullName("Рамблер");
        save.setInn("645566");
        save.setKpp("646512");
        save.setAddress("Москва, Кутузовский пр. 24");
        save.setPhone("+7(925)4783456");
        save.setActive(true);
        HttpEntity<OrganizationView> entitystatus = new HttpEntity(save, headers);
        ResponseEntity<OrganizationView> responseEntity = restTemplate.postForEntity(
                URL + "organization/save", entitystatus, OrganizationView.class);
        int status = responseEntity.getStatusCodeValue();
        OrganizationView result = responseEntity.getBody();
        // Delete organization
        orgService.delete(id++);
        OrganizationView getorgan = orgService.getById(id);
        // verify
        assertEquals("Incorrect Response Status", HttpStatus.CREATED.value(), status);
        assertNotNull(result);
        assertEquals(getorgan.getName(), result.getName());

    }

    @Test
    public void testUpdate() {
        OrganizationView update = new OrganizationView();
        update.setId(id);
        update.setName("Связной");
        update.setFullName("Связной");
        update.setInn("645636516");
        update.setKpp("654615455");
        update.setAddress("Москва, Тверская 24");
        update.setPhone("+7(926)2652894");
        update.setActive(true);
        HttpEntity<OrganizationView> entitystatus = new HttpEntity(update, headers);
        ResponseEntity<OrganizationView> responseEntity = restTemplate.postForEntity(
                URL + "organization/update", entitystatus, OrganizationView.class);
        int status = responseEntity.getStatusCodeValue();
        OrganizationView getorgan = orgService.getById(id);
// verify
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
        assertNotEquals("Яндекс", getorgan.getName());
        assertThat(getorgan.getInn(), is("645636516"));

    }



    @Test
    public void testList() {
        OrganizationView filter = new OrganizationView();
        filter.setName("Яндекс");
        filter.setInn("5415616");
        filter.setActive(true);
        HttpEntity<OrganizationView> entitystatus = new HttpEntity(filter, headers);
        ResponseEntity<OrganizationView[]> responseEntity = restTemplate.exchange(
                URL + "organization/list", HttpMethod.POST, entitystatus,
                OrganizationView[].class);
        int status = responseEntity.getStatusCodeValue();
        OrganizationView[] orgs = responseEntity.getBody();
        OrganizationView newOrg = new OrganizationView();
        for (OrganizationView organization : orgs) {
            newOrg.setName(organization.getName());
        }
         // verify
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
        assertThat(newOrg, notNullValue());
        assertThat(newOrg.getName(), is("Яндекс"));
        assertNotNull("Organization not found", orgs);
    }



    @Test
    public void testLoadById() {
        HttpEntity<OrganizationView> entitystatus = new HttpEntity(headers);
        ResponseEntity<OrganizationView> responseEntity = restTemplate.getForEntity(URL + "organization/" + "{id}", OrganizationView.class, id);
        int status = responseEntity.getStatusCodeValue();
        OrganizationView resultOrg = responseEntity.getBody();
        //   verify
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
        assertThat(resultOrg, notNullValue());
        assertThat(resultOrg.getName(), is("Яндекс"));
    }

    @Test
    public void testDelete() {
        OrganizationView save = new OrganizationView();
        save.setName("Рамблер");
        save.setFullName("Рамблер");
        save.setInn("645566");
        save.setKpp("646512");
        save.setAddress("Москва, Кутузовский пр. 24");
        save.setPhone("+7(925)4783456");
        save.setActive(true);
        orgService.save(save);
        // Delete organization
        HttpEntity<OrganizationView> entitystatus = new HttpEntity(headers);
        ResponseEntity<OrganizationView> responseEntitydel = restTemplate.exchange(URL + "organization/delete/{id}", HttpMethod.DELETE, entitystatus, OrganizationView.class,
                id++);
        int status = responseEntitydel.getStatusCodeValue();
        // verify
        assertEquals("Incorrect Response Status", HttpStatus.GONE.value(), status);

    }
    @After
    public void deleteOrg() {
        orgService.delete(id++);
    }
}









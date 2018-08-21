package ru.bellintegrator.practice.person.service.user.organization;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import java.io.IOException;

public class OrganizationControllerTest {

    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders headers = new HttpHeaders();
    private ResponseEntity<Object> responseEntity;

    {
        headers.setContentType(MediaType.APPLICATION_JSON);
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {

            }
        });
    }


    @Test
    public void save() {
        OrganizationView save = new OrganizationView();
        save.setName("Яндекс");
        save.setFullName("Яндекс");
        save.setInn("54156161");
        save.setKpp("6156156");
        save.setAddress("Москва, Каширское ш. 14");
        save.setPhone("+7(968)4571245");
        save.setActive(true);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/organization/save",
                new HttpEntity<>(save, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void update() {
        OrganizationView update = new OrganizationView();
        update.setId(4L);
        update.setName("Сбербанк России");
        update.setFullName("Сбербанк России");
        update.setInn("648929828");
        update.setKpp("641615616");
        update.setAddress("Москва, Молодежная 48");
        update.setPhone("+7(925)5873215");
        update.setActive(true);
        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/organization/update",
                new HttpEntity<>(update, headers), Object.class);
        System.out.println(responseEntity);

    }


    @Test
    public void list() {
        OrganizationView filter = new OrganizationView();


        responseEntity = restTemplate.postForEntity("http://localhost:8888/api/organization/list",
                new HttpEntity<>(filter, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void loadById() {
        responseEntity = restTemplate.getForEntity("http://localhost:8888/api/organization/2", Object.class);
        System.out.println(responseEntity);
    }

}









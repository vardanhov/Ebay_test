package ru.bellintegrator.practice.person.service.user.user;


import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.practice.user.view.UserView;

import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.assertEquals;


public class UserControllerTest {

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
    public void update() {
        UserView update = new UserView();
        update.setId(1L);
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



        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/user/update",
                new HttpEntity<>(update, headers), Object.class);
        System.out.println(responseEntity);

    }

    @Test
    public void save() {
        UserView save = new UserView();
        save.setFirstName("Мария");
        save.setSecondName("Козлова");
        save.setMiddleName("Игоревна");
        save.setPosition("Специалист");
        save.setPhone("+7(987)6548445");
        save.setDocCode("10");
        save.setDocName("Паспорт иностранного гражданина");
        save.setDocNumber("64684646");
        save.setDocDate("02.02.2006");
        save.setCitizenshipCode("007");
        save.setCitizenshipName("Российская Федерация");
        save.setIdentified(true);
        save.setOfficeId(3L);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/user/save",
                new HttpEntity<>(save, headers), Object.class);
        System.out.println(responseEntity);
    }


    @Test
    public void delete() {
        UserView delete = new UserView();
          delete.setId(3L);
        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/user/delete",
                new HttpEntity<>(delete, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void list() {
        UserView filter = new UserView();
        filter.setOfficeId(1L);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/user/list",
                new HttpEntity<>(filter, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void loadById() {
        responseEntity = restTemplate.getForEntity("http://localhost:8888/api/user/2", Object.class);
        System.out.println(responseEntity);
    }

}

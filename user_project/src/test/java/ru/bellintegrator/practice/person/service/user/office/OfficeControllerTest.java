package ru.bellintegrator.practice.person.service.user.office;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.practice.office.view.OfficeView;
import java.io.IOException;

public class OfficeControllerTest {

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
        OfficeView save = new OfficeView();
        save.setName("Мегафон  офис № 3");
        save.setAddress("Москва, Мосфильмовская 15");
        save.setPhone("+7(926)6466878");
        save.setActive(true);
        save.setOrgId(2L);

        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/office/save",
                new HttpEntity<>(save, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void update() {
        OfficeView update = new OfficeView();
        update.setId(4L);
        update.setName("Новый офис МТС");
        update.setAddress("Москва, Довженко 12");
        update.setPhone("+7(925)3574865");
        update.setActive(true);
        responseEntity = restTemplate.postForEntity(
                "http://localhost:8888/api/office/update",
                new HttpEntity<>(update, headers), Object.class);
        System.out.println(responseEntity);

    }


    @Test
    public void list() {
        OfficeView filter = new OfficeView();
        filter.setOrgId(1L);

        responseEntity = restTemplate.postForEntity("http://localhost:8888/api/office/list",
                new HttpEntity<>(filter, headers), Object.class);
        System.out.println(responseEntity);
    }

    @Test
    public void loadById() {
        responseEntity = restTemplate.getForEntity("http://localhost:8888/api/office/2", Object.class);
        System.out.println(responseEntity);
    }

}








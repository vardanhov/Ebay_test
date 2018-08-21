package ru.bellintegrator.practice.person.service.user.country;



import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import ru.bellintegrator.practice.countries.view.CountryView;
import java.io.IOException;



public class CountryControllerTest {


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
    public void list() {
        CountryView view = new CountryView();


        responseEntity = restTemplate.postForEntity("http://localhost:8888/api/countries",
                new HttpEntity<>(view, headers), Object.class);
        System.out.println(responseEntity);
    }

}

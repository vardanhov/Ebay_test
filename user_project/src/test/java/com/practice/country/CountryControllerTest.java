package com.practice.country;

import com.practice.Application;
import com.practice.countries.view.CountryView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Application.class)
public class CountryControllerTest {

    private static HttpHeaders headers = new HttpHeaders();

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testLoadAll() {
        HttpEntity<CountryView> entitystatus = new HttpEntity(headers);
        ResponseEntity<CountryView[]> responseEntity = restTemplate.exchange(
                "http://localhost:8888/api/countries", HttpMethod.POST, null,
                CountryView[].class);
        int status = responseEntity.getStatusCodeValue();
        CountryView[] countries = responseEntity.getBody();
        CountryView country =countries[3];
        // verify
        assertThat(countries.length, is(5));
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
        assertThat(country.code, is("804"));
        assertNotNull("DocumentType not found", country);
    }

}

package com.practice.documenttype;

import com.practice.Application;
import com.practice.docs.view.DocumentTypeView;
import com.practice.user.view.UserView;
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
public class DocumentTypeControllerTest {

    private static HttpHeaders headers = new HttpHeaders();

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testLoadAll() {
        HttpEntity<UserView> entitystatus = new HttpEntity(headers);
        ResponseEntity<DocumentTypeView[]> responseEntity = restTemplate.exchange(
               "http://localhost:8888/api/docs", HttpMethod.POST, null,
               DocumentTypeView[].class);
        int status = responseEntity.getStatusCodeValue();
        DocumentTypeView[] doctypes = responseEntity.getBody();
        DocumentTypeView doctype =doctypes[3];
        // verify
        assertThat(doctypes.length, is(5));
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
        assertThat(doctype.code, is("07"));
        assertNotNull("DocumentType not found", doctype);
    }
}

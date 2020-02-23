package ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @WebMvcTest(BasicSecurityController.class)
class BasicSecurityControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Test Basic Login")
    void basicLogin() {
        ResponseEntity<Object> result = testRestTemplate.withBasicAuth("user", "pass")
                .getForEntity("/security/basic/login", Object.class);
        System.out.println(result.getBody().toString());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}

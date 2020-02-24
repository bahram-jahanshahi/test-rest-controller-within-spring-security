package ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicSecurityControllerTest3 {

    private String baseUrl = "http://localhost:9003";

    @Test
    void basicLogin() {
        String url = baseUrl + "/security/basic/login";
        RestTemplate restTemplate = new RestTemplateBuilder()
                .basicAuthentication("user", "pass")
                .build();

        // create request
        HttpEntity request = new HttpEntity(null);

        // send request
        ResponseEntity<Boolean> responseEntity
                = restTemplate.exchange(url, HttpMethod.GET, request, Boolean.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(true, responseEntity.getBody());
        assertEquals(2, 2);
    }
}

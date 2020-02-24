package ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

public class BasicSecurityControllerTest2 {

    private String baseUrl = "http://localhost:9003";

    @Test
    void basicLogin() {
        String url = baseUrl + "/security/basic/login";

        // create auth credentials
        String authStr = "user:pass";
        String base64Credentials = Base64.getEncoder().encodeToString(authStr.getBytes());

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);

        // create request
        HttpEntity request = new HttpEntity(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Boolean> responseEntity
                = restTemplate.exchange(url, HttpMethod.GET, request, Boolean.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(true, responseEntity.getBody());
        assertEquals(2, 2);
    }


}

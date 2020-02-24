package ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.controllers;

import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.entities.Student;
import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.usecases.commands.ListStudentCommand;
import ir.afarinesh.mctab.testrestcontrollerwhitinspringsecurity.usecases.outcomes.ListStudentOutcome;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

    private String baseUrl = "http://localhost:9003";

    @Test
    void listStudent() {
        String url = baseUrl + "/student/all";
        // create Rest Template
        RestTemplate restTemplate = new RestTemplateBuilder()
                .basicAuthentication("user", "pass")
                .build();

        // create request
        HttpEntity request = new HttpEntity(new ListStudentCommand(""));

        // send request
        ResponseEntity<ListStudentOutcome> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                ListStudentOutcome.class
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertNotNull(responseEntity.getBody().getStudents());
        assertEquals(0, responseEntity.getBody().getStudents().size());
    }
}

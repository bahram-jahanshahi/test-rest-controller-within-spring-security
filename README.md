# Test Rest Controller and Spring Security
This sample project is supposed to show how it is possible to test particular `rest service` 
meanwhile spring security is activated in project.
## How to run project
1. Run `spring boot` application.
2. Run `StudentControllerTest` in test package.
## How does it work?
In order to understand how this project works you only need to consider two files:
`StudentControllerTest.java` and `StudentController.java`.  
First of all notice `StudentController.java` in this bellow code:  
```java
@RestController
@RequestMapping("/student")
public class StudentController {

    final ListStudentUseCase listStudentUseCase;

    public StudentController(ListStudentUseCase listStudentUseCase) {
        this.listStudentUseCase = listStudentUseCase;
    }

    @PostMapping("/all")
    public ListStudentOutcome listStudent(@RequestBody ListStudentCommand command) throws Exception {
        return listStudentUseCase.listStudent(command);
    }
}
``` 
> notice `listStudent` method which provide rest service by url `/student/all`. 
> this method calls `ListStudentUseCase.listStudent` method 
> which receive a particular command and produce an specific outcome.
> In order to use this rest service we have to send a command to url `/student/all`. 
> so let's see how we are able to call this rest service in `StudentControllerTest.java` java test class.
  
If you open the `StudentControllerTest.java` class you see this bellow code: 
```java
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
```
For testing we use `RestTemplate.java` class in `org.springframework.web.client` package.  
The first step is create RestTemplate by `RestTemplateBuilder`. 
```java
RestTemplate restTemplate = new RestTemplateBuilder()
                .basicAuthentication("user", "pass")
                .build();
```
notice we put  `user` as username and `pass` as password in `basicAuthentication(...)` method.  
The second step is create `command` and the third one is sending request to rest web service.


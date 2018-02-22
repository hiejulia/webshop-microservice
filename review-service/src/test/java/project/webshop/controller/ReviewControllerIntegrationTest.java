package project.webshop.controller;


import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment =
        SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReviewControllerIntegrationTest {
    @LocalServerPort
    private int port;

    private TestRestTemplate template = new TestRestTemplate();

    @Test
    public void retrieveTodos() throws Exception {
        String expected = "["
                + "{id:1,user:Jack,desc:\"Learn Spring MVC\",done:false}" + ","
                + "{id:2,user:Jack,desc:\"Learn Struts\",done:false}" + "]";

        String uri = "/users/Jack/todos";

        ResponseEntity<String> response =
                template.getForEntity(createUrl(uri), String.class);

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createUrl(String uri) {
        return "http://localhost:" + port + uri;
    }
}

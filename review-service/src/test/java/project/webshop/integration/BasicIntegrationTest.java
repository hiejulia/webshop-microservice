package project.webshop.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BasicIntegrationTest.class)
//        webEnvironment = BasicIntegrationTest.WebEnvironment.RANDOM_PORT)
public class BasicIntegrationTest {

    private static final String LOCAL_HOST =
            "http://localhost:";

    @LocalServerPort
    private int port;

    private TestRestTemplate template = new TestRestTemplate();

    @Test
    public void welcome() throws Exception {
        ResponseEntity<String> response = template
                .getForEntity(createURL("/welcome"), String.class);
//        assertThat(response.getBody(), equalTo("Hello World"));
    }

    private String createURL(String uri) {
        return LOCAL_HOST + port + uri;
    }
}
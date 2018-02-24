package project.webshop.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.Charset;
import java.util.Base64;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSecurityRestTest {

    private TestRestTemplate template = new TestRestTemplate();

    // header with basic auth
    HttpHeaders headers = createHeaders("user-name", "user-password");

    HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.getEncoder().encode
                        (auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
    }

    @Test
    public void retrieveUsers() throws Exception {
        // mock expected json returned
        String expected = "["
                + "{id:1,user:Julia}" + ","
                + "{id:2,user:Hien}" + "]";

        ResponseEntity<String> response = template.exchange(
                createUrl("/users/Jack/todos"), HttpMethod.GET,
                new HttpEntity<String>(null, headers),
                String.class);
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

}

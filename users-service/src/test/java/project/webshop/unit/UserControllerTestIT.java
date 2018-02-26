package project.webshop.unit;

import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import project.webshop.controller.UserController;

@ActiveProfiles("integration-test") // integration test run with embedded database
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserController.class, webEnvironment =
        SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTestIT {

    @LocalServerPort
    private int port;

    private TestRestTemplate template = new TestRestTemplate();

}
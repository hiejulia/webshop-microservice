package project.webshop.config;


import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class AppConfig {

    // jersey config
    @Named
    static class JerseyConfig extends ResourceConfig {

        public JerseyConfig() {
            this.packages("project.webshop");
        }

    }

}
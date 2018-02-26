package project.webshop.config.session;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRedisHttpSession
public class AppSessionConfig {
    //
    @Bean
    public LettuceConnectionFactory connectionFactory(){
        return new LettuceConnectionFactory();
    }

}

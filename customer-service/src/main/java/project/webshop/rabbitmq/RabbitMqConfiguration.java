package project.webshop.rabbitmq;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// RabbitMQ configuration class
@Configuration
public class RabbitMqConfiguration {
    // ConnectionFactory
    @Bean
    public ConnectionFactory connectionFactory()
    {
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("172.17.0.9");
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");

        //connectionFactory.setUsername("user");
        //connectionFactory.setPassword("password");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin()
    {
        return new RabbitAdmin(connectionFactory());
    }


    @Bean
    public MessageConverter jsonMessageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

}

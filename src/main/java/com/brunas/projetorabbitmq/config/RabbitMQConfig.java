package com.brunas.projetorabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    //Nas exchanges do tipo fanout, todas as filas receberão as mensagens enviadas, não tem routingKey

    //FILAS
    @Value("${spring.rabbitmq.fila1}")
    private String fila1;

    @Value("${spring.rabbitmq.fila2}")
    private String fila2;

    @Value("${spring.rabbitmq.fila3}")
    private String fila3;

    @Bean
    public Queue fila1() { return new Queue(fila1, true); }

    @Bean
    public Queue fila2() { return new Queue(fila2, true); }

    @Bean
    public Queue fila3() { return new Queue(fila3, true); }

    //EXCHANGE DO TIPO FANOUT
    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange("fanout-exchange");
    }

    //BINDINGS
    @Bean
    Binding binding(Queue fila1, FanoutExchange exchange) {
        return BindingBuilder.bind(fila1).to(exchange);
    }

    @Bean
    Binding binding2(Queue fila2, FanoutExchange exchange) {
        return BindingBuilder.bind(fila2).to(exchange);
    }

    @Bean
    Binding binding3(Queue fila3, FanoutExchange exchange) {
        return BindingBuilder.bind(fila3).to(exchange);
    }
}

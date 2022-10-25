package com.brunas.projetorabbitmq.teste;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProdutorService {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProdutorService(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarFanout(String mensagem) {
        rabbitTemplate.convertAndSend("fanout-exchange", null, mensagem);
        System.out.println("Enviando mensagem: " + mensagem);
    }

}

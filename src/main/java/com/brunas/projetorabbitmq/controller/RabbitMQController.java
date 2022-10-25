package com.brunas.projetorabbitmq.controller;

import com.brunas.projetorabbitmq.teste.RabbitMQProdutorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fanout")
public class RabbitMQController {

    private final RabbitMQProdutorService produtorService;

    public RabbitMQController(RabbitMQProdutorService produtorConfig) {
        this.produtorService = produtorConfig;
    }

    @GetMapping("/fila")
    public void enviarFila(@RequestBody String mensagem) {
        produtorService.enviarFanout(mensagem);
    }

}

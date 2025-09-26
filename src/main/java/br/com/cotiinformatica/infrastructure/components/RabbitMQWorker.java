package br.com.cotiinformatica.infrastructure.components;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RabbitMQWorker {

    /*
        Método para ler e processar as mensagens contidas na fila.
     */
    @RabbitListener(queues = "financas")
    public void receive(@Payload String mensagem) {

        //Log simples
        System.out.println("\n*** MENSAGEM LIDA DA FILA COM SUCESSO!");
        System.out.println("TEXTO: " + mensagem);
        System.out.println("DATA E HORA: " + LocalDateTime.now());
        System.out.println("***\n");
    }
}

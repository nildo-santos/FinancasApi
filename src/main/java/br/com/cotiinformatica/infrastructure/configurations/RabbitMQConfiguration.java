package br.com.cotiinformatica.infrastructure.configurations;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    /*
        Método para configurar a fila que iremos acessar no RabbitMQ
     */
    @Bean
    Queue getQueue() {
        /*
            Nome da fila: financas
            Durable: true (fila que não será apagada)
         */
        return new Queue("financas", true);
    }
}

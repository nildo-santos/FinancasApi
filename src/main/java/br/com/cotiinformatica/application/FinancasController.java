package br.com.cotiinformatica.application;

import br.com.cotiinformatica.domain.dtos.AnaliseRequestDto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/financas")
public class FinancasController {

    @Autowired //Injeção de dependência
    private RabbitTemplate rabbitTemplate;

    @Autowired //Injeção de dependência
    private Queue queue;

    /*
        Método para processar a análise financeira
     */
    @PostMapping("analise")
    public ResponseEntity<?> processarAnalise(@RequestBody AnaliseRequestDto request) {

        //Criando uma mensagem que será enviada para a fila
        var mensagem = """
                    Solicitação de análise financeira.
                """;

        //Enviando para a fila
        rabbitTemplate.convertAndSend(queue.getName(), mensagem);

        //Log simples
        System.out.println("\n*** NOVA MENSAGEM ENVIADA PARA A FILA COM SUCESSO EM: " + LocalDateTime.now() + "*** \n");

        return ResponseEntity.ok().body("Solicitação de análise financeira realizada com sucesso.");
    }

}

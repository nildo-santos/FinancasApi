package br.com.cotiinformatica.application;

import br.com.cotiinformatica.domain.dtos.requests.AlterarMovimentacaoRequest;
import br.com.cotiinformatica.domain.dtos.requests.CriarMovimentacaoRequest;
import br.com.cotiinformatica.domain.dtos.responses.ConsultarMovimentacaoResponse;
import br.com.cotiinformatica.domain.interfaces.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/movimentacoes")
public class MovimentacoesController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<ConsultarMovimentacaoResponse> post(@RequestBody CriarMovimentacaoRequest request) {

        //enviando a movimentação para cadastro
        var response = movimentacaoService.criar(request);

        //retornar a resposta
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<ConsultarMovimentacaoResponse> put(@RequestBody AlterarMovimentacaoRequest request) {

        //enviando a movimentação para alteração
        var response = movimentacaoService.alterar(request);

        //retornar a resposta
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ConsultarMovimentacaoResponse> delete(@PathVariable UUID id) {

        //enviando para exclusão
        var response = movimentacaoService.excluir(id);

        //retornar a resposta
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("{dataMin}/{dataMax}/{page}")
    public ResponseEntity<Page<ConsultarMovimentacaoResponse>> get
            (@PathVariable String dataMin, @PathVariable String dataMax, @PathVariable int page) {

        //realizando a consulta na camada de serviço
        var resultado = movimentacaoService.consultar(LocalDate.parse(dataMin), LocalDate.parse(dataMax), page);

        //retornando o resultado
        return ResponseEntity.ok().body(resultado);
    }

    @GetMapping("{id}")
    public ResponseEntity<ConsultarMovimentacaoResponse> get(@PathVariable UUID id) {

        //realizando a consulta na camada de serviço
        var response = movimentacaoService.obterPorId(id);

        //retornando a resposta
        return ResponseEntity.ok().body(response);
    }
}

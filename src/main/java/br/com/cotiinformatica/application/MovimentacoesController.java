package br.com.cotiinformatica.application;

import br.com.cotiinformatica.domain.dtos.requests.AlterarMovimentacaoRequest;
import br.com.cotiinformatica.domain.dtos.requests.CriarMovimentacaoRequest;
import br.com.cotiinformatica.domain.interfaces.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/movimentacoes")
public class MovimentacoesController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody CriarMovimentacaoRequest request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> put(@PathVariable UUID id, @RequestBody AlterarMovimentacaoRequest request) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("{dataMin}/{dataMax}")
    public ResponseEntity<?> get(@PathVariable String dataMin, @PathVariable String dataMax) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable UUID id) {
        return ResponseEntity.ok().build();
    }
}

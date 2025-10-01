package br.com.cotiinformatica.application;

import br.com.cotiinformatica.domain.dtos.responses.ConsultarTipoResponse;
import br.com.cotiinformatica.domain.interfaces.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipos")
public class TiposController {

    @Autowired
    private TipoService tipoService;

    @GetMapping
    public ResponseEntity<List<ConsultarTipoResponse>> getAll() {
        //executando a consulta na camada de serviço
        var resultado = tipoService.consultar();
        //retornado a lista obtida
        return ResponseEntity.ok().body(resultado);
    }
}

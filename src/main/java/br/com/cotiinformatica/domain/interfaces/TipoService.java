package br.com.cotiinformatica.domain.interfaces;

import br.com.cotiinformatica.domain.dtos.responses.ConsultarTipoResponse;

import java.util.List;

public interface TipoService {

    List<ConsultarTipoResponse> consultar();
}

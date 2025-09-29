package br.com.cotiinformatica.domain.dtos.responses;

import java.util.UUID;

public record ConsultarTipoResponse(
        UUID id, //id do tipo
        String nome //nome do tipo
) {
}
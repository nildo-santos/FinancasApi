package br.com.cotiinformatica.domain.dtos.responses;

import java.util.UUID;

public record ConsultarMovimentacaoResponse(
        UUID id, //id da movimentação
        String nome, //nome da movimentação
        String data, //data da movimentação
        Double valor, //valor da movimentação
        ConsultarTipoResponse tipo //tipo da Movimentação
) {
}
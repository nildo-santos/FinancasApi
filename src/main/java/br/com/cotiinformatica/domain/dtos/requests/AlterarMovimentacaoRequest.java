package br.com.cotiinformatica.domain.dtos.requests;

import java.util.UUID;

public record AlterarMovimentacaoRequest(
        UUID id, //id da movimentação
        String nome, //nome da movimentação
        String data, //data da movimentação
        Double valor, //valor da movimentação
        UUID tipoId //id do tipo da moimentação
) {
}

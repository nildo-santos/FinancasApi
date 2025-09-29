package br.com.cotiinformatica.domain.interfaces;

import br.com.cotiinformatica.domain.dtos.requests.AlterarMovimentacaoRequest;
import br.com.cotiinformatica.domain.dtos.requests.CriarMovimentacaoRequest;
import br.com.cotiinformatica.domain.dtos.responses.ConsultarMovimentacaoResponse;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.UUID;

public interface MovimentacaoService {

    ConsultarMovimentacaoResponse criar (CriarMovimentacaoRequest request);

    ConsultarMovimentacaoResponse alterar(AlterarMovimentacaoRequest request);

    ConsultarMovimentacaoResponse excluir(UUID id);

    Page<ConsultarMovimentacaoResponse> consultar (LocalDate dataMin, LocalDate datamax, int page);

    ConsultarMovimentacaoResponse obterPorId(UUID id);
}

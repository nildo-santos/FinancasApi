package br.com.cotiinformatica.domain.services;

import br.com.cotiinformatica.domain.dtos.requests.AlterarMovimentacaoRequest;
import br.com.cotiinformatica.domain.dtos.requests.CriarMovimentacaoRequest;
import br.com.cotiinformatica.domain.dtos.responses.ConsultarMovimentacaoResponse;
import br.com.cotiinformatica.domain.interfaces.MovimentacaoService;
import br.com.cotiinformatica.infrastructure.repositories.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Override
    public ConsultarMovimentacaoResponse criar(CriarMovimentacaoRequest request) {
        return null;
    }

    @Override
    public ConsultarMovimentacaoResponse alterar(AlterarMovimentacaoRequest request) {
        return null;
    }

    @Override
    public ConsultarMovimentacaoResponse excluir(UUID id) {
        return null;
    }

    @Override
    public Page<ConsultarMovimentacaoResponse> consultar(LocalDate dataMin, LocalDate dataMax, int page) {
        return null;
    }

    @Override
    public ConsultarMovimentacaoResponse obterPorId(UUID id) {
        return null;
    }
}

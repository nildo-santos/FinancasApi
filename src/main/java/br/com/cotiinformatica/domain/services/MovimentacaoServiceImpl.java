package br.com.cotiinformatica.domain.services;

import br.com.cotiinformatica.domain.dtos.requests.AlterarMovimentacaoRequest;
import br.com.cotiinformatica.domain.dtos.requests.CriarMovimentacaoRequest;
import br.com.cotiinformatica.domain.dtos.responses.ConsultarMovimentacaoResponse;
import br.com.cotiinformatica.domain.dtos.responses.ConsultarTipoResponse;
import br.com.cotiinformatica.domain.entities.Movimentacao;
import br.com.cotiinformatica.domain.entities.Tipo;
import br.com.cotiinformatica.domain.interfaces.MovimentacaoService;
import br.com.cotiinformatica.infrastructure.repositories.MovimentacaoRepository;
import br.com.cotiinformatica.infrastructure.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    public ConsultarMovimentacaoResponse criar(CriarMovimentacaoRequest request) {

        //capturar os dados do DTO (request)
        var movimentacao = new Movimentacao(); //entidade do banco de dados
        movimentacao.setNome(request.nome());
        movimentacao.setData(LocalDate.parse(request.data()));
        movimentacao.setValor(BigDecimal.valueOf(request.valor()));

        //buscar o registro do tipo no banco de dados através do id
        var tipo = tipoRepository.findById(request.tipoId()).get();
        movimentacao.setTipo(tipo); //preenchendo o tipo da movimentação

        //salvar no banco de dados
        movimentacaoRepository.save(movimentacao);

        //Copiar os dados para o DTO de resposta
        var response = new ConsultarMovimentacaoResponse(
                movimentacao.getId(),
                movimentacao.getNome(),
                movimentacao.getData().toString(),
                movimentacao.getValor().doubleValue(),
                new ConsultarTipoResponse(tipo.getId(), tipo.getNome())
        );

        return response; //retornando o DTO de resposta
    }

    @Override
    public ConsultarMovimentacaoResponse alterar(AlterarMovimentacaoRequest request) {

        //buscando a movimentação no banco de dados através do ID
        var movimentacao = movimentacaoRepository.findById(request.id()).get();

        movimentacao.setNome(request.nome());
        movimentacao.setData(LocalDate.parse(request.data()));
        movimentacao.setValor(BigDecimal.valueOf(request.valor()));
        movimentacao.getTipo().setId(request.tipoId());

        //salvar no banco de dados
        movimentacaoRepository.save(movimentacao);

        //Copiar os dados para o DTO de resposta
        var response = new ConsultarMovimentacaoResponse(
                movimentacao.getId(),
                movimentacao.getNome(),
                movimentacao.getData().toString(),
                movimentacao.getValor().doubleValue(),
                new ConsultarTipoResponse(movimentacao.getTipo().getId(), movimentacao.getTipo().getNome())
        );

        return response; //retornando o DTO de resposta
    }

    @Override
    public ConsultarMovimentacaoResponse excluir(UUID id) {

        //buscando a movimentação no banco de dados através do ID
        var movimentacao = movimentacaoRepository.findById(id).get();

        //excluir no banco de dados
        movimentacaoRepository.delete(movimentacao);

        //Copiar os dados para o DTO de resposta
        var response = new ConsultarMovimentacaoResponse(
                movimentacao.getId(),
                movimentacao.getNome(),
                movimentacao.getData().toString(),
                movimentacao.getValor().doubleValue(),
                new ConsultarTipoResponse(movimentacao.getTipo().getId(), movimentacao.getTipo().getNome())
        );

        return response; //retornando o DTO de resposta

    }

    @Override
    public Page<ConsultarMovimentacaoResponse> consultar(LocalDate dataMin, LocalDate dataMax, int page) {

        //Criando a regra de paginação
        var pageable = PageRequest.of(page, 25); //máximo 25 registros por página

        //Executando a consulta no banco de dados e capturar o resultado
        var lista = movimentacaoRepository.findByDatas(dataMin, dataMax, pageable);

        //Copiando os dados da consulta da entidade para uma lista do DTO
        var resultado = lista.map(m -> new ConsultarMovimentacaoResponse(
                m.getId(),
                m.getNome(),
                m.getData().toString(),
                m.getValor().doubleValue(),
                new ConsultarTipoResponse(m.getTipo().getId(), m.getTipo().getNome())
        ));

        return resultado;
    }

    @Override
    public ConsultarMovimentacaoResponse obterPorId(UUID id) {

        //buscando a movimentação no banco de dados através do ID
        var movimentacao = movimentacaoRepository.findById(id).get();

        //Copiar os dados para o DTO de resposta
        var response = new ConsultarMovimentacaoResponse(
                movimentacao.getId(),
                movimentacao.getNome(),
                movimentacao.getData().toString(),
                movimentacao.getValor().doubleValue(),
                new ConsultarTipoResponse(movimentacao.getTipo().getId(), movimentacao.getTipo().getNome())
        );

        return response; //retornando o DTO de resposta
    }
}

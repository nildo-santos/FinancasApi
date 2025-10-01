package br.com.cotiinformatica.domain.services;

import br.com.cotiinformatica.domain.dtos.responses.ConsultarTipoResponse;
import br.com.cotiinformatica.domain.interfaces.TipoService;
import br.com.cotiinformatica.infrastructure.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoServiceImpl implements TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    public List<ConsultarTipoResponse> consultar() {

        var lista = tipoRepository.findAll(); //consultando os tipos no banco de dados

        var resultado = new ArrayList<ConsultarTipoResponse>();
        for(var tipo : lista) {
            var dto = new ConsultarTipoResponse(tipo.getId(), tipo.getNome());
            resultado.add(dto);
        }

        return resultado;
    }
}

package br.com.cotiinformatica.domain.services;

import br.com.cotiinformatica.domain.dtos.responses.ConsultarTipoResponse;
import br.com.cotiinformatica.domain.interfaces.TipoService;
import br.com.cotiinformatica.infrastructure.repositories.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServiceImpl implements TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    public List<ConsultarTipoResponse> consultar() {
        return List.of();
    }
}

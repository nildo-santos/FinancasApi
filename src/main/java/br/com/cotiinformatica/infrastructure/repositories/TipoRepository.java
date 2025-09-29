package br.com.cotiinformatica.infrastructure.repositories;

import br.com.cotiinformatica.domain.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, UUID> {
}

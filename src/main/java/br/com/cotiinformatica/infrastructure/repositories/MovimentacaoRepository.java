package br.com.cotiinformatica.infrastructure.repositories;

import br.com.cotiinformatica.domain.entities.Movimentacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, UUID> {

    /*
        Método para consultar as movimentações dentro de um periodo de datas
        e retornar os dados de forma paginada
        JPQL - Java Persistence Query Language
     */
    @Query("""
            SELECT m FROM Movimentacao m 
            JOIN m.tipo t
            WHERE m.data BETWEEN :pDataMin AND :pDataMax
            ORDER BY m.data ASC
            """)
    Page<Movimentacao> findByDatas(
            @Param("pDataMin") LocalDate dataMin,
            @Param("pDataMax") LocalDate dataMax,
            Pageable pageable);
}

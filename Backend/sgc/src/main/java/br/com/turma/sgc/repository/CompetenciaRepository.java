package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.service.dto.CompetenciaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {

    //Query para pegar as competências de determinada categoria.(Layla) OK
    @Query(value = "select c from Competencia c join Categoria ca on ca.id = :idCategoria")
    List<Competencia> buscarCompetenciaPorIdCategoria(@Param("idCategoria") Integer idCategoria);

    @Query(value = "select c from Competencia c where lower(c.nome) LIKE lower(:#{#competencia.nome})")
    Optional<Competencia> buscarPorNome(@Param("competencia") CompetenciaDTO competencia);

}

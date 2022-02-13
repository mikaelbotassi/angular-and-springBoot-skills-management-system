package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {
/*
    //Query para pegar as competências de determinada categoria.(Layla)
    @Query(value = "select c.competencia from Competencia c where c.categoria.id = :idCategoria")
    List<Competencia> buscarCompetenciaPorIdCategoria(@Param("idCategoria") Integer idCategoria);
 */
}

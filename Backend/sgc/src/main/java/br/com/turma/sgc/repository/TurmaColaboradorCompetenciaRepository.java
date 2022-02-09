package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.TurmaColaboradorCompetenciaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TurmaColaboradorCompetenciaRepository extends JpaRepository<TurmaColaboradorCompetencia, TurmaColaboradorCompetenciaPK> {

    @Query(value = "select tcc from TurmaColaboradorCompetencia tcc where tcc.id.idTurmaFormacao = :idTurma")
    List<TurmaColaboradorCompetencia> procurarTodosPorIdTurma(@Param("idTurma") Integer idTurma);

    @Query(value = "select tcc from TurmaColaboradorCompetencia tcc where tcc.id.idColaborador = :idColaborador")
    List<TurmaColaboradorCompetencia> procurarTodosPorIdColaborador(@Param("idColaborador") Integer idColaborador);

    @Query(value = "select tcc from TurmaColaboradorCompetencia tcc where tcc.id.idCompetencia = :idCompetencia")
    List<TurmaColaboradorCompetencia> procurarTodosPorIdCompetencia(@Param("idCompetencia") Integer idCompetencia);

}

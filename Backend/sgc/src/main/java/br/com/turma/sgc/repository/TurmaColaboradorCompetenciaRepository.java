package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.TurmaColaboradorCompetenciaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaColaboradorCompetenciaRepository extends JpaRepository<TurmaColaboradorCompetencia, TurmaColaboradorCompetenciaPK> {

    @Query(value = "select t from TurmaColaboradorCompetencia t where t.turma.id  = :idTurma")
    List<TurmaColaboradorCompetencia> procurarTodasTurmasPorIdTurma(@Param("idTurma") Integer id);


    @Query ("select tcc from TurmaColaboradorCompetencia tcc inner join ColaboradorCompetencia cc" +
            " on cc.nivel < 3 and cc.colaborador.id = tcc.colaborador.id where tcc.turma.id = :idTurma")
    List<TurmaColaboradorCompetencia> procurarTodosAlunosPorIdTurma (@Param("idTurma") Integer id);

    @Query ("select tcc from TurmaColaboradorCompetencia tcc inner join ColaboradorCompetencia cc" +
            " on cc.nivel = 3 and cc.colaborador.id = tcc.colaborador.id where tcc.turma.id = :idTurma")
    List<TurmaColaboradorCompetencia> procurarTodosInstrutoresPorIdTurma (@Param("idTurma") Integer id);


}

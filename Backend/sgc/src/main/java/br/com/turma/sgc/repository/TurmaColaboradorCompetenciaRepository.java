package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.TurmaColaboradorCompetenciaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TurmaColaboradorCompetenciaRepository extends JpaRepository<TurmaColaboradorCompetencia, TurmaColaboradorCompetenciaPK> {
    @Query("select t from TurmaColaboradorCompetencia t where t.colaborador.id = :idColaborador")
    List<TurmaColaboradorCompetencia> queryTurmaColaboradorCompetenciaByColaborador(Integer idColaborador);
}

package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.TurmaColaboradorCompetenciaPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaColaboradorCompetenciaRepository extends JpaRepository<TurmaColaboradorCompetencia, TurmaColaboradorCompetenciaPK> {
}

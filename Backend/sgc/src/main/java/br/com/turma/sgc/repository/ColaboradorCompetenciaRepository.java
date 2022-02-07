package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.pk.ColaboradorCompetenciaPK;
import br.com.turma.sgc.service.ColaboradorCompetenciaService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorCompetenciaRepository extends JpaRepository<ColaboradorCompetenciaService, ColaboradorCompetenciaPK> {
}

package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.domain.pk.Colaborador_CompetenciaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Colaborador_Competencia_Repository extends JpaRepository<Colaborador, Colaborador_CompetenciaPK> {
}

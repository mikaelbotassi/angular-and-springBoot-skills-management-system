package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Colaborador_Competencia_Repository extends JpaRepository<Colaborador, Integer> {
}

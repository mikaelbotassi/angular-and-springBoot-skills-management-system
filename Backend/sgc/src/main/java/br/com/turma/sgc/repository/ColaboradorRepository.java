package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.domain.TurmaFormacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

}

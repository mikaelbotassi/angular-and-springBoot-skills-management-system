package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {
    @Query("select c from Colaborador c where c.senioridade.id = :idSenioridade")
    List<Colaborador> queryColaboradorBySenioridade(Integer idSenioridade);
}

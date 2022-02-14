package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {
    //15 - Query para retornar todos os colaboradores de determinada senioridade.(Gustavo)
    @Query("select c from Colaborador c where c.senioridade.id = :idSenioridade")
    List<Colaborador> procurarPorSenioridadeId(@Param("idSenioridade") Integer idSenioridade);
}

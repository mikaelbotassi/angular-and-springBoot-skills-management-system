package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.TurmaFormacao;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaFormacaoRepository extends JpaRepository<TurmaFormacao, Integer> {

    @Query(value = "select t from TurmaFormacao t where t.status.id = :idStatus")
    List<TurmaFormacao> procurarTodosPorIdStatus(@Param("idStatus") Integer idStatus);
}

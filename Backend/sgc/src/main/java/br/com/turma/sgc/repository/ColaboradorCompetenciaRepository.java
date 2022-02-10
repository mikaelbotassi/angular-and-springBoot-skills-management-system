package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.ColaboradorCompetenciaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorCompetenciaRepository extends JpaRepository<ColaboradorCompetencia, ColaboradorCompetenciaPK> {

//    @Query(value = "select cc from ColaboradorCompetencia cc where  (select tcc from TurmaColaboradorCompetencia tcc where tcc.idTurma = :idTurma).colaborador.id = cc.colaborador.id and cc.nivel.id = :nivelColaborador")
//    List<ColaboradorCompetencia> procurarTodosInstrutoresPorIdTurma (@Param("idTurma") Integer id, @Param("nivelColaborador") Integer nivel);
}

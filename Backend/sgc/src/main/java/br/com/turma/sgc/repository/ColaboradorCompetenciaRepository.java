package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.domain.enums.NivelEnum;
import br.com.turma.sgc.domain.pk.ColaboradorCompetenciaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorCompetenciaRepository extends JpaRepository<ColaboradorCompetencia, ColaboradorCompetenciaPK> {

//    @Query(value = "select cc from ColaboradorCompetencia cc where  (select tcc from TurmaColaboradorCompetencia tcc where tcc.idTurma = :idTurma).colaborador.id = cc.colaborador.id and cc.nivel.id = :nivelColaborador")
//    List<ColaboradorCompetencia> procurarTodosInstrutoresPorIdTurma (@Param("idTurma") Integer id, @Param("nivelColaborador") Integer nivel);
}

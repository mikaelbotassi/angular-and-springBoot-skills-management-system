package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.domain.pk.ColaboradorCompetenciaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorCompetenciaRepository extends JpaRepository<ColaboradorCompetencia, ColaboradorCompetenciaPK> {
    @Query(value = "select cc.competencia from ColaboradorCompetencia cc where cc.colaborador.id = :idColaborador and cc.nivel = :idNivel")
    List<Competencia> buscarCompetenciasPorNivelEPorIdColaborador(@Param("idColaborador") Integer idColaborador, @Param("idNivel") Integer idNivel);

}

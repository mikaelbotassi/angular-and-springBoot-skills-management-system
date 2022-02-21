package br.com.turma.sgc.repository;
import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.domain.pk.ColaboradorCompetenciaPK;
import br.com.turma.sgc.service.dto.CompetenciaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorCompetenciaRepository extends JpaRepository<ColaboradorCompetencia, ColaboradorCompetenciaPK> {

    @Query(value = "select cc.competencia from ColaboradorCompetencia cc where cc.colaborador.id = :idColaborador and cc.nivel = :idNivel")
    List<Competencia> buscarCompetenciasPorNivelEPorIdColaborador(@Param("idColaborador") Integer idColaborador, @Param("idNivel") Integer idNivel);

    @Query("select cc.colaborador from ColaboradorCompetencia cc where cc.competencia.id = :idCompetencia")
    List<Colaborador> buscarColaboradoresPorCompetencia(@Param("idCompetencia") Integer idCompetencia);

//    @Query("select cc.colaborador from ColaboradorCompetencia cc where cc.nivel = :nivelMax")
//    List<ColaboradorBuscaDTO> buscaColaboradorInstrutor(@Param("nivelMax") Integer nivelMax);

    @Query("select cc from ColaboradorCompetencia cc where cc.colaborador.id = :idColaborador")
    List<CompetenciaDTO> buscaCompetenciaNivel (@Param("idColaborador") Integer idColaborador);
    //Query para retornar todos os colaboradores que podem dar uma determinada competência.(Layla) OK
    @Query(value = "select cc.colaborador from ColaboradorCompetencia cc " +
            "where cc.competencia.id = :idCompetencia and cc.nivel = 3")
    List<Colaborador> buscarColaboradorPraAplicarCompeteciaPorId(@Param("idCompetencia") Integer idCompetencia);


}

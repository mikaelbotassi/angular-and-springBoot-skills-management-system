package br.com.turma.sgc.repository;
import br.com.turma.sgc.domain.Colaborador;
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

    @Query(value = "select cc.competencia from ColaboradorCompetencia cc join Colaborador c on c.id = :idColaborador")
    List<Competencia> listarTodasCompetenciasDeUmColaborador(@Param("idColaborador") Integer idColaborador);

    @Query(value = "select cc.competencia from ColaboradorCompetencia cc where cc.colaborador.id = :idColaborador and cc.nivel = :idNivel")
    List<Competencia> buscarCompetenciasPorNivelEPorIdColaborador(@Param("idColaborador") Integer idColaborador, @Param("idNivel") Integer idNivel);

    //Query para retornar todos os colaboradores que podem dar uma determinada competência.(Layla)
    @Query(value = "select cc.colaborador from ColaboradorCompetencia cc where cc.competencia.id = :idCompetencia and cc.nivel = 3")
    List<Colaborador> buscarColaboradorPraAplicarCompetecia(@Param("idCompetencia") Integer idCompetencia);
//
//    //Query para retornar todos os colaboradores que podem dar uma determinada competência.(Layla)
//    @Query(value = "select cc.colaborador from ColaboradorCompetencia cc where cc.colaborador.id = :idColaborador and cc.nivel = 3")
//    List<Integer> buscarColaboradorAplicarCompeteciaID(@Param("competência") Integer competenciaId);
}

package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.domain.pk.ColaboradorCompetenciaPK;
import br.com.turma.sgc.service.dto.ColaboradorBuscaDTO;
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

    @Query("select new br.com.turma.sgc.service.dto.ColaboradorBuscaDTO(cc.colaborador.nomeColaborador, cc.colaborador.sobrenomeColaborador," +
            "cc.colaborador.dataNascimento, cc.colaborador.dataAdmissao, cc.colaborador.senioridade.nome)  " +
            " from ColaboradorCompetencia cc where cc.competencia.id = :idCompetencia")
    List<ColaboradorBuscaDTO> buscarColaboradoresPorCompetencia(@Param("idCompetencia") Integer idCompetencia);

    @Query("select new br.com.turma.sgc.service.dto.ColaboradorBuscaDTO(cc.colaborador.nomeColaborador, cc.colaborador.sobrenomeColaborador, " +
            "cc.colaborador.dataNascimento, cc.colaborador.dataAdmissao, cc.colaborador.senioridade.nome)  " +
            "from ColaboradorCompetencia cc where cc.nivel = :nivelMax")
    List<ColaboradorBuscaDTO> buscaColaboradorInstrutor(@Param("nivelMax") Integer nivelMax);

    @Query("select new br.com.turma.sgc.service.dto.CompetenciaDTO(cc.competencia.id, cc.competencia.nome," +
            "cc.competencia.descricao, cc.competencia.categoria.id, cc.nivel) " +
            "from ColaboradorCompetencia cc where cc.colaborador = :idColaborador")
    List<CompetenciaDTO> buscaCompetenciaNivel (@Param("idColaborador") Integer idColaborador);
}

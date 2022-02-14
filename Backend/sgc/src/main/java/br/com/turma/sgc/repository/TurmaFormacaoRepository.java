package br.com.turma.sgc.repository;

import br.com.turma.sgc.domain.TurmaFormacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurmaFormacaoRepository extends JpaRepository<TurmaFormacao, Integer> {
    //10 - Query para pegar as turmas iniciadas.(Gustavo)
    @Query(value = "select t from TurmaFormacao t where t.status.id = 2")
    List<TurmaFormacao> queryTurmaFormacaoIniciada();

    //5 - Query para verificar se um colaborador está ligado à uma disciplina(Se ele estiver ligado à uma turma_colaborador_competência não pode ser excluido).(Gustavo)
    @Query("select tf from TurmaColaboradorCompetencia tcc, TurmaFormacao tf where tcc.colaborador.id = :idColaborador and tcc.turma = tf.id")
    List<TurmaFormacao> buscarContemColaborador(@Param("idColaborador") Integer idColaborador);

    //Query para pegar as turmas em andamento.(Mikael)
    @Query(value = "select t from TurmaFormacao t where t.status.id = 2")
    List<TurmaFormacao> buscaTurmaAndamento();

    //Query para pegar as turmas de determinado intervalo de tempo.
    @Query(value = "select t from TurmaFormacao t where :inicio <= t.inicio and :fim <= t.termino")
    List<TurmaFormacao> buscarTodasTurmasPorIntervalo(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);

}

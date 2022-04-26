package br.com.turma.sgc.resource;

import br.com.turma.sgc.SgcApplication;
import br.com.turma.sgc.builder.ColaboradorBuilder;
import br.com.turma.sgc.builder.CompetenciaBuilder;
import br.com.turma.sgc.builder.TurmaColaboradorCompetenciaBuilder;
import br.com.turma.sgc.builder.TurmaFormacaoBuilder;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorDTO;
import br.com.turma.sgc.service.dto.Competencia.CompetenciaDTO;
import br.com.turma.sgc.service.dto.Turma.TurmaColaboradorCompetenciaDTO;
import br.com.turma.sgc.service.dto.Turma.TurmaFormacaoDTO;
import br.com.turma.sgc.util.IntTestComum;
import br.com.turma.sgc.util.TestUtil;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SgcApplication.class)
@Transactional
public class TurmaFormacaoResourceTest extends IntTestComum {

    private static final String URL = "/api/turmaFormacao";

    @Autowired
    private TurmaFormacaoBuilder turmaFormacaoBuilder;

    @Autowired
    private TurmaColaboradorCompetenciaBuilder turmaColaboradorCompetenciaBuilder;

    @Autowired
    private ColaboradorBuilder colaboradorBuilder;

    @Autowired
    private CompetenciaBuilder competenciaBuilder;

    @Before
    public void inicializaTeste(){
        turmaFormacaoBuilder.setCustomizacao(null);
    }

    @Test
    @SneakyThrows
    public void pegarTodosTest(){
        turmaFormacaoBuilder.persistir(turmaFormacaoBuilder.construirEntidade());

        getMockMvc()
                .perform(get(URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    @SneakyThrows
    public void salvarTest() {


        TurmaFormacaoDTO dto = turmaFormacaoBuilder.construirEntidade();

        getMockMvc().perform(post(URL)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(dto))).andExpect(status().isCreated());
    }


    @Test
    @SneakyThrows
    public void atualizarTest(){

        TurmaFormacaoDTO dto = turmaFormacaoBuilder.persistir(turmaFormacaoBuilder.construirEntidade());

        getMockMvc().perform(put(URL)
                        .contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(dto)))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void deletarTest() {

        TurmaFormacaoDTO dto = turmaFormacaoBuilder.persistir(turmaFormacaoBuilder.construirEntidade());

        getMockMvc().perform(delete(URL + "/" + dto.getId())).andExpect(status().isNoContent());
    }


    @Test
    @SneakyThrows
    public void procurarPorIdTest() {

        TurmaFormacaoDTO dto = turmaFormacaoBuilder.persistir(turmaFormacaoBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/" + dto.getId())).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void procurarPorIdStatusTest() {

        TurmaFormacaoDTO dto = turmaFormacaoBuilder.persistir(turmaFormacaoBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/procurarTodosPorIdStatus/" + dto.getId())).andExpect(status().isOk());
    }


    @Test
    @SneakyThrows
    public void procurarAlunosPorIdTurmaTest() {

        TurmaFormacaoDTO dto = turmaFormacaoBuilder.persistir(turmaFormacaoBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/procurarTodosAlunosPorIdTurma/" + dto.getId())).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void procurarInstrutorPorIdTurmaTest() {

        TurmaFormacaoDTO dto = turmaFormacaoBuilder.persistir(turmaFormacaoBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/procurarTodosInstrutoresPorIdTurma/" + dto.getId())).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void procurarInstrutorCompetenciaPorIdTurmaTest() {

        TurmaFormacaoDTO dto = turmaFormacaoBuilder.persistir(turmaFormacaoBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/procurarTodosInstrutoresCompetenciaPorIdTurma/" + dto.getId())).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void inserirColaboradorTurma() {
        TurmaColaboradorCompetenciaDTO dto = turmaColaboradorCompetenciaBuilder.persistir(turmaColaboradorCompetenciaBuilder.construirEntidade());

        getMockMvc().perform(post(URL + "/inserirColaborador").contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(dto))).andExpect(status().isCreated());

    }

    @Test
    @SneakyThrows
    public void pegarTodosAndamentoTest(){
        turmaFormacaoBuilder.persistir(turmaFormacaoBuilder.construirEntidade());

        getMockMvc()
                .perform(get(URL + "/turmasEmAndamento"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    @SneakyThrows
    public void pegarTodosFinalizadosTest(){
        turmaFormacaoBuilder.persistir(turmaFormacaoBuilder.construirEntidade());

        getMockMvc()
                .perform(get(URL + "/turmasFinalizadas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    @SneakyThrows
    public void procurarTodosColaboradorCompetenciaTest() {

        TurmaFormacaoDTO dto = turmaFormacaoBuilder.persistir(turmaFormacaoBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/todosColaboradorCompetenciaTurma/" + dto.getId())).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void procurarTodosColaboradorTest() {

        getMockMvc().perform(get(URL + "/Colaboradores")).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void procurarTodosColaboradorNivelTest() {

        CompetenciaDTO dto = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());

        ColaboradorDTO colabDto = colaboradorBuilder.persistir(colaboradorBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/ColaboradorCompetencia/" + colabDto.getId() + '/' + dto.getId() )).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void procurarTumaColaboradorCompetenciaNivelTest() {

        TurmaColaboradorCompetenciaDTO turma = turmaColaboradorCompetenciaBuilder.persistir(turmaColaboradorCompetenciaBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/procurarTurmaColaboradorCompetenciaPorId/" + turma.getTurmaId() + '/' + turma.getColaboradorId() + '/' + turma.getCompetenciaId() )).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void cadastrarZeroTest() {
        CompetenciaDTO dto = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());

        ColaboradorDTO colabDto = colaboradorBuilder.persistir(colaboradorBuilder.construirEntidade());

        getMockMvc().perform(post(URL + "/cadastrarColaboradorCompetenciaZero/" + colabDto.getId() + '/' + dto.getId()))
                .andExpect(status().isCreated());
    }

    @Test
    @SneakyThrows
    public void subirCompetencia() {
        CompetenciaDTO dto = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());

        ColaboradorDTO colabDto = colaboradorBuilder.persistir(colaboradorBuilder.construirEntidade());

        getMockMvc().perform(post(URL + "/cadastrarColaboradorCompetenciaZero/" + colabDto.getId() + '/' + dto.getId()));

        getMockMvc().perform(put(URL + "/colaboradorCompetencia/subirNivel/" + colabDto.getId() + '/' + dto.getId()))
                .andExpect(status().isAccepted());
    }

    @Test
    @SneakyThrows
    public void deletarTurmaColaboradorCompetencia() {

        TurmaColaboradorCompetenciaDTO turma = turmaColaboradorCompetenciaBuilder.persistir(turmaColaboradorCompetenciaBuilder.construirEntidade());

        getMockMvc().perform(delete(URL + "/turmaColaboradorCompetenciaDeletar/" + turma.getTurmaId() + '/' + turma.getColaboradorId() + '/' + turma.getCompetenciaId() )).andExpect(status().isNoContent());
    }



}

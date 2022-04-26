package br.com.turma.sgc.resource;

import br.com.turma.sgc.SgcApplication;
import br.com.turma.sgc.builder.ColaboradorBuilder;
import br.com.turma.sgc.builder.CompetenciaBuilder;
import br.com.turma.sgc.builder.TurmaColaboradorCompetenciaBuilder;
import br.com.turma.sgc.builder.TurmaFormacaoBuilder;
import br.com.turma.sgc.service.dto.Competencia.CompetenciaDTO;
import br.com.turma.sgc.service.dto.Turma.TurmaColaboradorCompetenciaDTO;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SgcApplication.class)
@Transactional
public class CompetenciaResourceTest extends IntTestComum {

    private static final String URL = "/api/competencia";

    @Autowired
    private CompetenciaBuilder competenciaBuilder;

    @Autowired
    private ColaboradorBuilder colaboradorBuilder;

    @Autowired
    private TurmaFormacaoBuilder turmaFormacaoBuilder;

    @Autowired
    private TurmaColaboradorCompetenciaBuilder turmaColaboradorCompetenciaBuilder;


    @Before
    public void inicializaTeste(){
        competenciaBuilder.setCustomizacao(null);
    }

    @Test
    @SneakyThrows
    public void pegarTodosTest(){
        competenciaBuilder.persistir(competenciaBuilder.construirEntidade());

        getMockMvc()
                .perform(get(URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    @SneakyThrows
    public void salvarTest() {
        CompetenciaDTO dto = competenciaBuilder.construirEntidade();

        getMockMvc().perform(post(URL)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(dto))).andExpect(status().isCreated());
    }


    @Test
    @SneakyThrows
    public void atualizarTest() {

        CompetenciaDTO dto = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());

        getMockMvc().perform(put(URL)
                        .contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(dto)))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void procurarPorIdTest(){
        CompetenciaDTO dto = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/" + dto.getId())).andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void deletarTest() {

        CompetenciaDTO dto = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());

        getMockMvc().perform(delete(URL + "/" + dto.getId())).andExpect(status().isNoContent());
    }

    @Test
    @SneakyThrows
    public void procurarCompetenciaNivelColaboradorTest() {
        CompetenciaDTO dto = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/colaborador/" + 1 +"/nivel/" + 3)).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void buscarCompetenciaPorIdCategoria() {
        CompetenciaDTO dto = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());
        getMockMvc().perform(get(URL + "/categoria/" + dto.getCategoria().getId())).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void procurarCompetenciaColaboradorTest() {
        getMockMvc().perform(get(URL + "/colaboradores/" + 1)).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void procurarCompetenciaColaboradorTurma() {
        TurmaColaboradorCompetenciaDTO dto = turmaColaboradorCompetenciaBuilder.persistir(turmaColaboradorCompetenciaBuilder.construirEntidade());
        getMockMvc().perform(get(URL + "/turma/" + dto.getTurmaId() + "/colaborador/" + dto.getColaboradorId())).andExpect(status().isOk());
    }



    @Test
    @SneakyThrows
    public void procurarCompetenciadropdown() {

        getMockMvc().perform(get(URL + "/dropdown")).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void existeCompetencia () {
        CompetenciaDTO dto = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());
        getMockMvc().perform(get(URL + "/presente")
                        .contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(dto)))
                .andExpect(status().isOk());    }
}

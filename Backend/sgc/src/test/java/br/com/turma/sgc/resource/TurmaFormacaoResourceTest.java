package br.com.turma.sgc.resource;

import br.com.turma.sgc.SgcApplication;
import br.com.turma.sgc.builder.ColaboradorBuilder;
import br.com.turma.sgc.builder.CompetenciaBuilder;
import br.com.turma.sgc.builder.TurmaColaboradorCompetenciaBuilder;
import br.com.turma.sgc.builder.TurmaFormacaoBuilder;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
import br.com.turma.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import br.com.turma.sgc.service.dto.TurmaFormacaoDTO;
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

        //Como customizar o builder
//        CompetenciaDTO dto = competenciaBuilder.customizar(competencia -> competencia.setNome("Java")).construir();

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

        colaboradorBuilder.persistir(colaboradorBuilder.construirEntidade());
        competenciaBuilder.persistir(competenciaBuilder.construirEntidade());
        turmaFormacaoBuilder.persistir(turmaFormacaoBuilder.construirEntidade());
        TurmaColaboradorCompetenciaDTO dto = turmaColaboradorCompetenciaBuilder.persistir(turmaColaboradorCompetenciaBuilder.construirEntidade());

        getMockMvc().perform(post(URL + "/inserirColaborador").contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(dto))).andExpect(status().isCreated());

    }

    /*
    @Test
    @SneakyThrows
    public void buscaTurmaFinalizada() {

        TurmaFormacaoDTO dto = turmaFormacaoBuilder.persistir(turmaFormacaoBuilder.construirEntidade());
        //.andExpect(status().isNoContent());
        getMockMvc().perform(get(URL + "/buscaTurmaFinalizada/" + dto.getId())).andExpect(status().isNoContent());
    }
 */

}

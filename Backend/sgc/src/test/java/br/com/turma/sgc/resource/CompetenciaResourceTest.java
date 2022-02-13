package br.com.turma.sgc.resource;

import br.com.turma.sgc.SgcApplication;
import br.com.turma.sgc.builder.CompetenciaBuilder;
import br.com.turma.sgc.service.dto.CompetenciaDTO;
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
public class CompetenciaResourceTest extends IntTestComum {

    private static final String URL = "/api/competencia";

    @Autowired
    private CompetenciaBuilder competenciaBuilder;

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

        //Como customizar o builder
//        CompetenciaDTO dto = competenciaBuilder.customizar(competencia -> competencia.setNome("Java")).construir();

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
//"/colaborador/{idColaborador}/nivel/{idNivel}"
        CompetenciaDTO dto = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/colaborador/" + 1 +"/nivel/" + 3)).andExpect(status().isOk());
    }



}

package br.com.turma.sgc.resource;

import br.com.turma.sgc.SgcApplication;
import br.com.turma.sgc.builder.ColaborarBuilder;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
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
public class ColaboradorResourceTest extends IntTestComum {

    private static final String URL = "/api/colaborador";

    @Autowired
    private ColaborarBuilder colaborarBuilder;

    @Before
    public void inicializaTeste(){
        colaborarBuilder.setCustomizacao(null);
    }

    @Test
    @SneakyThrows
    public void pegarTodosTest(){
        colaborarBuilder.persistir(colaborarBuilder.construirEntidade());

        getMockMvc()
                .perform(get(URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    @SneakyThrows
    public void salvarTest() {
        ColaboradorDTO dto = colaborarBuilder.construirEntidade();

        getMockMvc().perform(post(URL)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(dto))).andExpect(status().isCreated());
    }


    @Test
    @SneakyThrows
    public void atualizarTest() {

        ColaboradorDTO dto = colaborarBuilder.persistir(colaborarBuilder.construirEntidade());

        getMockMvc().perform(put(URL)
                        .contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(dto)))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void procurarTodosTest(){
        ColaboradorDTO dto = colaborarBuilder.persistir(colaborarBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/" + dto.getId())).andExpect(status().isOk());

    }

    @Test
    @SneakyThrows
    public void procurarPorIdTest() {

        ColaboradorDTO dto = colaborarBuilder.persistir(colaborarBuilder.construirEntidade());

        getMockMvc().perform(delete(URL + "/" + dto.getId())).andExpect(status().isNoContent());
    }

    @Test
    @SneakyThrows
    public void inserirTest() {

        ColaboradorDTO dto = colaborarBuilder.persistir(colaborarBuilder.construirEntidade());

        getMockMvc().perform(delete(URL + "/" + dto.getId())).andExpect(status().isNoContent());
    }

    @Test
    @SneakyThrows
    public void deletarTest() {

        ColaboradorDTO dto = colaborarBuilder.persistir(colaborarBuilder.construirEntidade());

        getMockMvc().perform(delete(URL + "/" + dto.getId())).andExpect(status().isNoContent());
    }

    @Test
    @SneakyThrows
    public void buscarColaboradorPraAplicarCompeteciaPorIdTest() {

        ColaboradorDTO dto = colaborarBuilder.persistir(colaborarBuilder.construirEntidade());

        getMockMvc().perform(delete(URL + "/" + dto.getId())).andExpect(status().isNoContent());
    }
}

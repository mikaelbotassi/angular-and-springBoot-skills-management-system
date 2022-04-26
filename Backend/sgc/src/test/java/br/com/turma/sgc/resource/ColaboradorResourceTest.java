package br.com.turma.sgc.resource;

import br.com.turma.sgc.SgcApplication;
import br.com.turma.sgc.builder.ColaboradorBuilder;
import br.com.turma.sgc.builder.CompetenciaBuilder;
import br.com.turma.sgc.service.dto.Competencia.CadastrarCompetenciaDTO;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorDTO;
import br.com.turma.sgc.service.dto.Competencia.CompetenciaDTO;
import br.com.turma.sgc.service.mapper.ColaboradorMapper;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SgcApplication.class)
@Transactional
public class ColaboradorResourceTest extends IntTestComum {

    private static final String URL = "/api/colaborador";

    @Autowired
    private ColaboradorBuilder colaboradorBuilder;

    @Autowired
    private ColaboradorMapper colaboradorMapper;

    @Autowired
    private CompetenciaBuilder competenciaBuilder;

    @Before
    public void inicializaTeste(){
        colaboradorBuilder.setCustomizacao(null);
    }

    @Test
    @SneakyThrows
    public void pegarTodosTest(){
        colaboradorBuilder.persistir(colaboradorBuilder.construirEntidade());

        getMockMvc()
                .perform(get(URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)));
    }

    @Test
    @SneakyThrows
    public void salvarTest() {

        ColaboradorDTO dto = colaboradorBuilder.construirEntidade();
        ColaboradorDTO cadastrarColaboradorDTO = colaboradorMapper
                .toDto(colaboradorMapper.toEntity(dto));
        getMockMvc().perform(post(URL)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(cadastrarColaboradorDTO))).andExpect(status().isCreated());
    }

    @Test
    @SneakyThrows
    public void salvarComCompetenciaTest() {
        competenciaBuilder.persistir(competenciaBuilder.construirEntidade());

        ColaboradorDTO dto = colaboradorBuilder.construirEntidade();
        List<CadastrarCompetenciaDTO> lista = new ArrayList<>();
        CadastrarCompetenciaDTO cadastrarCompetenciaDTO = new CadastrarCompetenciaDTO();
        cadastrarCompetenciaDTO.setId(1);
        cadastrarCompetenciaDTO.setNivel(1);
        lista.add(cadastrarCompetenciaDTO);
        dto.setCompetencia(lista);
        getMockMvc().perform(post(URL)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(dto))).andExpect(status().isCreated());
    }

    @Test
    @SneakyThrows
    public void atualizarTest(){

        ColaboradorDTO dto = colaboradorBuilder.persistir(colaboradorBuilder.construirEntidade());

        getMockMvc().perform(put(URL)
                        .contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(dto)))
                .andExpect(status().isOk());
    }


    @Test
    @SneakyThrows
    public void deletarTest() {

        ColaboradorDTO dto = colaboradorBuilder.persistir(colaboradorBuilder.construirEntidade());

        getMockMvc().perform(delete(URL + "/" + dto.getId())).andExpect(status().isNoContent());
    }

    @Test
    @SneakyThrows
    public void procurarPorIdTest() {

        ColaboradorDTO dto = colaboradorBuilder.persistir(colaboradorBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/" + dto.getId())).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void procurarPorIdcompetenciaTest() {

        ColaboradorDTO dto = colaboradorBuilder.persistir(colaboradorBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/" + dto.getId())).andExpect(status().isOk());
    }


    @Test
    @SneakyThrows
    public void procurarColaboradorPorCompetencia() {

        CompetenciaDTO dto = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/competencias/" + dto.getId())).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void procurarColaboradorPorId() {

        ColaboradorDTO dto = colaboradorBuilder.persistir(colaboradorBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/colaborador/" + dto.getId())).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void procurarColaboradorAplicarCompetencia() {

        CompetenciaDTO dto = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/aplicarCompetencia/" + dto.getId())).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    public void procurarCompetenciasEnsinadasColaboradorId() {

        ColaboradorDTO dto = colaboradorBuilder.persistir(colaboradorBuilder.construirEntidade());

        getMockMvc().perform(get(URL + "/competenciasColaborador/" + dto.getId())).andExpect(status().isOk());
    }

}

package br.com.turma.sgc.resource;

import br.com.turma.sgc.SgcApplication;
import br.com.turma.sgc.builder.ColaboradorBuilder;
import br.com.turma.sgc.builder.CompetenciaBuilder;
import br.com.turma.sgc.service.dto.CadastrarColaboradorDTO;
import br.com.turma.sgc.service.dto.CadastrarCompetenciaDTO;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
import br.com.turma.sgc.service.dto.TurmaFormacaoDTO;
import br.com.turma.sgc.service.mapper.CadastrarColaboradorMapper;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    private CadastrarColaboradorMapper cadastrarColaboradorMapper;

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
        CadastrarColaboradorDTO cadastrarColaboradorDTO = cadastrarColaboradorMapper
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
        CadastrarColaboradorDTO cadastrarColaboradorDTO = cadastrarColaboradorMapper
                .toDto(colaboradorMapper.toEntity(dto));
        List<CadastrarCompetenciaDTO> lista = new ArrayList<>();
        CadastrarCompetenciaDTO cadastrarCompetenciaDTO = new CadastrarCompetenciaDTO();
        cadastrarCompetenciaDTO.setId(1);
        cadastrarCompetenciaDTO.setNivel(1);
        lista.add(cadastrarCompetenciaDTO);
        cadastrarColaboradorDTO.setCompetencia(lista);
        getMockMvc().perform(post(URL)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(cadastrarColaboradorDTO))).andExpect(status().isCreated());
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

}

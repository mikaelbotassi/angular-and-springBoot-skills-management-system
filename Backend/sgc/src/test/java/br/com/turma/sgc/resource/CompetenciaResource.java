package br.com.turma.sgc.resource;

import br.com.turma.sgc.SgcApplication;
import br.com.turma.sgc.builder.CompetenciaBuilder;
import br.com.turma.sgc.service.CompetenciaService;
import br.com.turma.sgc.service.mapper.CompetenciaMapper;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SgcApplication.class)
@Transactional
public class CompetenciaResource {

    private static String URL = "/api/competencia";

    private MockMvc mockMvc;

    @Autowired
    private CompetenciaMapper mapper;

    @Autowired
    private CompetenciaService competenciaService;

    @Autowired
    private CompetenciaBuilder competenciaBuilder;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void inicializaTeste(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        competenciaBuilder.setCustomizacao(null);
    }

    @Test
    @SneakyThrows
     public void pegarTodosTeste(){
        mockMvc.perform(get(URL)).andExpect(status().isOk());
    }

}

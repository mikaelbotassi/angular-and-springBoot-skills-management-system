package br.com.turma.sgc.resource;

import br.com.turma.sgc.SgcApplication;
import br.com.turma.sgc.builder.CompetenciaBuilder;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest(classes = SgcApplication.class)
@RunWith(SpringRunner.class)
public class CompetenciaResource {

    private final String URL = "/api/Competencia";


    private MockMvc mockMvc;

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
    public void listarTest(){
        mockMvc.perform(get(URL)).andExpect(status().isOk());
    }

}

package br.com.turma.sgc.resource;

import br.com.turma.sgc.SgcApplication;
import br.com.turma.sgc.builder.CompetenciaBuilder;
import br.com.turma.sgc.service.CompetenciaService;
import br.com.turma.sgc.service.mapper.CompetenciaMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

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

    @Before
    public void inicializaTeste(){
        competenciaBuilder.setCustomizacao(null);
    }

    @Test public void pegarTodosTeste(){
        mockMvc.perform()
    }

}

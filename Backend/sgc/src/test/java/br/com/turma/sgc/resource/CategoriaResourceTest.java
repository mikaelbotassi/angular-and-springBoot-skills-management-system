package br.com.turma.sgc.resource;

import br.com.turma.sgc.SgcApplication;
import br.com.turma.sgc.util.IntTestComum;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SgcApplication.class)
@Transactional
public class CategoriaResourceTest extends IntTestComum {

    private static final String URL = "/api/categoria";


    @Test
    @SneakyThrows
    public void pegarTodosTest(){
        getMockMvc()
                .perform(get(URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.not(0)));
    }


    @Test
    @SneakyThrows
    public void procurarPorIdTest() {

        getMockMvc().perform(get(URL + "/" + 1)).andExpect(status().isOk());
    }



}

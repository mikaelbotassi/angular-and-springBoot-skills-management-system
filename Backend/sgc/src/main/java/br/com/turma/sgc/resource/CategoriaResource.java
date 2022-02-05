package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Categoria;
import br.com.turma.sgc.services.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
@Controller representa uma classe com endpoints (URIs que serão expostas pela API
a classe indica que o valor retornado pelos métodos devem ser vinculados ao corpo da resposta (response body).
*/

@SpringBootApplication

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaServices categoriaServices;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Categoria> listCategoria() {
        return categoriaServices.listCategoria();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Categoria searchById(@PathVariable("id") Long id) {
        return categoriaServices.findId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria nao encontrada"));
    }
}



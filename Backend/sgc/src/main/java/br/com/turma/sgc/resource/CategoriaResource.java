package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Categoria;
import br.com.turma.sgc.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private CategoriaRepository categoriaRepository;

    CategoriaResource(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public List findAll() {
        return categoriaRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Integer id) {
        return categoriaRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse((ResponseEntity<Categoria>) ResponseEntity.notFound());
    }
}



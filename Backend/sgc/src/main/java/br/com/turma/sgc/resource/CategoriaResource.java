package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Categoria;
import br.com.turma.sgc.enums.CategoriaEnum;
import br.com.turma.sgc.services.CategoriaServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
@Controller representa uma classe com endpoints (URIs que serão expostas pela API
a classe indica que o valor retornado pelos métodos devem ser vinculados ao corpo da resposta (response body).
*/

@SpringBootApplication
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categoria")
public class CategoriaResource {

    @Autowired
    private final CategoriaServices categoriaServices;

    @GetMapping
    public ResponseEntity<CategoriaEnum[]> findAll(){
        return ResponseEntity.ok().body(categoriaServices.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaEnum> findById(@PathVariable int id){
        return ResponseEntity.ok().body(categoriaServices.findById(id));
    }
}



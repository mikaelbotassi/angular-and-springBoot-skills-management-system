package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Categoria;
import br.com.turma.sgc.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/categoria")
@RestController
@RequiredArgsConstructor
public class CategoriaResource {

    private final CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> procurarTodos(){
        return ResponseEntity.ok().body(service.procurarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> procurarPorId(@PathVariable int id){
        return ResponseEntity.ok().body(service.procurarPorId(id));
    }
}

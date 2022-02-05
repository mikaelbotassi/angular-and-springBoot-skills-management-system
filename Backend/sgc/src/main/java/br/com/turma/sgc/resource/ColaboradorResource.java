package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.service.ColaboradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colaborador")
@RequiredArgsConstructor
public class ColaboradorResource {

    private final ColaboradorService service;

    @GetMapping
    public ResponseEntity<List<Colaborador>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Colaborador> findById(@PathVariable int id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Colaborador> insert(@RequestBody Colaborador colab){
        return ResponseEntity.ok().body(service.insert(colab));
    }

}

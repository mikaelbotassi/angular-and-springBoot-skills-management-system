package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.service.TurmaFormacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/turma-formacao")
@RequiredArgsConstructor
public class TurmaFormacaoResource {

    private final TurmaFormacaoService service;

    @GetMapping
    public ResponseEntity<List<TurmaFormacao>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TurmaFormacao> findById(@PathVariable int id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TurmaFormacao> insert(@RequestBody TurmaFormacao turma){
        return ResponseEntity.ok().body(service.insert(turma));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<TurmaFormacao> update(@RequestBody TurmaFormacao turma){
        return ResponseEntity.ok().body(service.update(turma));
    }

}

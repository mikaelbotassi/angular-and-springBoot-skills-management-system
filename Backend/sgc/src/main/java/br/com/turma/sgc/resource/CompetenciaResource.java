package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.service.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencia")
public class CompetenciaResource {
    @Autowired
    CompetenciaService competenciaService;

    @GetMapping()
    public ResponseEntity<List<Competencia>> procurarTodos(){
        return ResponseEntity.ok().body(competenciaService.procurarTodos());
    }

    @PostMapping
    public ResponseEntity<Competencia> inserir(@RequestBody Competencia competencia) {
        return ResponseEntity.ok().body(competenciaService.inserir(competencia));
    }

    @PutMapping
    public ResponseEntity<Competencia> atualizar(@RequestBody Competencia competencia) {
        return ResponseEntity.ok().body(competenciaService.atualizar(competencia));
    }

    @GetMapping("{id}")
    public ResponseEntity<Competencia> procurarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(competenciaService.procurarPorId(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        return ResponseEntity.noContent().build();
    }
}

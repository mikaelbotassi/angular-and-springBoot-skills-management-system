package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.service.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/competencia")
public class CompetenciaResource {
    @Autowired
    CompetenciaService competenciaService;

    @GetMapping()
    public ResponseEntity<List<Competencia>> findAll(){
        return competenciaService.findAll();
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Competencia competencia) {
        return competenciaService.save(competencia);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Competencia competencia) {
        return competenciaService.update(competencia);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Competencia>> findById(@PathVariable Integer id){
        return competenciaService.findById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id){
        return competenciaService.delete(id);
    }
}

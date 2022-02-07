package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.service.TurmaColaboradorCompetenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/disciplinas")
public class TurmaColaboradorCompetenciaResource {

    private final TurmaColaboradorCompetenciaService service;

    @GetMapping
    public ResponseEntity<List<TurmaColaboradorCompetencia>> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/turma/{idTurma}/colaborador/{idColaborador}/competencia/{idCompetencia}")
    public ResponseEntity<TurmaColaboradorCompetencia> findById(@PathVariable int idTurma, @PathVariable int idColaborador, @PathVariable int idCompetencia){
        return ResponseEntity.ok().body(service.findById(idTurma, idColaborador, idCompetencia));
    }

    @PostMapping
    public TurmaColaboradorCompetencia save(@RequestBody TurmaColaboradorCompetencia turmaColaboradorCompetencia){
        return service.save(turmaColaboradorCompetencia);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody TurmaColaboradorCompetencia turmaColaboradorCompetencia){
        return service.update(turmaColaboradorCompetencia);
    }

    @DeleteMapping(value = "/turma/{idTurma}/colaborador/{idColaborador}/competencia/{idCompetencia}")
    public ResponseEntity<Void> delete(@PathVariable int idTurma, @PathVariable int idColaborador, @PathVariable int idCompetencia){
        service.delete(idTurma, idColaborador, idCompetencia);
        return ResponseEntity.noContent().build();
    }

}

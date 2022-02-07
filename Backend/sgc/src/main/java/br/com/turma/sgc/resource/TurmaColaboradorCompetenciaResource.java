package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.service.TurmaColaboradorCompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turma-colaborador-competencia")
public class TurmaColaboradorCompetenciaResource {

    @Autowired
    TurmaColaboradorCompetenciaService turmaColaboradorCompetenciaService;

    @GetMapping
    public ResponseEntity<List<TurmaColaboradorCompetencia>> findAll(){
        return turmaColaboradorCompetenciaService.findAll();
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody TurmaColaboradorCompetencia turmaColaboradorCompetencia){
        return turmaColaboradorCompetenciaService.save(turmaColaboradorCompetencia);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody TurmaColaboradorCompetencia turmaColaboradorCompetencia){
        return turmaColaboradorCompetenciaService.update(turmaColaboradorCompetencia);
    }

    /*@DeleteMapping("{id_turma}/{id_competencia}/{id_colaborador}")
    public ResponseEntity<String> delete(@PathVariable("id_turma") Integer idTurma,
                                         @PathVariable("id_competencia") Integer idCompetencia,
                                         @PathVariable("id_colaborador") Integer idColaborador) {


    }*/
}

package br.com.turma.sgc.resource;

import br.com.turma.sgc.service.TurmaColaboradorCompetenciaService;
import br.com.turma.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/turmaColaboradorCompetencia")
public class TurmaColaboradorCompetenciaResource {

    private final TurmaColaboradorCompetenciaService service;


    @GetMapping
    public ResponseEntity<List<TurmaColaboradorCompetenciaDTO>> procurarTodos(){
        return ResponseEntity.ok().body(service.procurarTodos());
    }

    @GetMapping(value = "/turma-{idTurma}/colaborador-{idColaborador}/competencia-{idCompetencia}")
    public ResponseEntity<TurmaColaboradorCompetenciaDTO> procurarPorId(@PathVariable int idTurma,
                                                                     @PathVariable int idColaborador, @PathVariable int idCompetencia){
        return ResponseEntity.ok().body(service.procurarPorId(idTurma, idColaborador, idCompetencia));
    }

    @GetMapping("turma/{idTurma}")
    public ResponseEntity<List<TurmaColaboradorCompetenciaDTO>> procurarTodosPorIdTurma(@PathVariable Integer idTurma){
        return ResponseEntity.ok(service.procurarTodosPorIdTurma(idTurma));
    }

    @GetMapping("colaborador/{idColaborador}")
    public ResponseEntity<List<TurmaColaboradorCompetenciaDTO>> procurarTodosPorIdColaborador(@PathVariable Integer idColaborador){
        return ResponseEntity.ok(service.procurarTodosPorIdColaborador(idColaborador));
    }

    @GetMapping("competencia/{idCompetencia}")
    public ResponseEntity<List<TurmaColaboradorCompetenciaDTO>> procurarTodosPorIdCompetencia(@PathVariable Integer idCompetencia){
        return ResponseEntity.ok(service.procurarTodosPorIdCompetencia(idCompetencia));
    }

    /*
    @PostMapping
    public TurmaColaboradorCompetencia inserir(@RequestBody TurmaColaboradorCompetenciaPK turmaColaboradorCompetenciaPK){
        return service.inserir(turmaColaboradorCompetenciaPK);
    }
    */
    @DeleteMapping(value = "/turma/{idTurma}/colaborador/{idColaborador}/competencia/{idCompetencia}")
    public ResponseEntity<Void> deletar(@PathVariable int idTurma, @PathVariable int idColaborador, @PathVariable int idCompetencia){
        service.deletar(idTurma, idColaborador, idCompetencia);
        return ResponseEntity.noContent().build();
    }

}

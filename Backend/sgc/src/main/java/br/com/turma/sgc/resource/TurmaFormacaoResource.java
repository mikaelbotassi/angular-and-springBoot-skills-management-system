package br.com.turma.sgc.resource;

import br.com.turma.sgc.service.TurmaFormacaoService;
import br.com.turma.sgc.service.dto.ColaboradorFuncaoTurmaDTO;
import br.com.turma.sgc.service.dto.InstrutorCompetenciaTurmaDTO;
import br.com.turma.sgc.service.dto.TurmaFormacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/turmaFormacao")
@RequiredArgsConstructor
public class TurmaFormacaoResource {

    private final TurmaFormacaoService turmaFormacaoService;


    @GetMapping
    public ResponseEntity<List<TurmaFormacaoDTO>> procurarTodos(){
        return ResponseEntity.ok().body(turmaFormacaoService.procurarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TurmaFormacaoDTO> procurarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(turmaFormacaoService.procurarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TurmaFormacaoDTO> inserir(@RequestBody TurmaFormacaoDTO turma){
        return ResponseEntity.created(URI.create("./api/turmaFormacao")).body(turmaFormacaoService.inserir(turma));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        turmaFormacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<TurmaFormacaoDTO> atualizar(@RequestBody TurmaFormacaoDTO turma){
        return ResponseEntity.ok().body(turmaFormacaoService.atualizar(turma));
    }

    @GetMapping(value = "/procurarTodosPorIdStatus/{id}")
    public ResponseEntity<List<TurmaFormacaoDTO>> procurarTodosPorIdStatus (@PathVariable Integer id){
        return ResponseEntity.ok().body(turmaFormacaoService.procurarTodosPorIdStatus(id));
    }

    @GetMapping(value = "/procurarTodosAlunosPorIdTurma/{id}")
    public ResponseEntity<List<ColaboradorFuncaoTurmaDTO>> procurarTodosAlunosPorIdTurma (@PathVariable Integer id){
        return ResponseEntity.ok().body(turmaFormacaoService.procurarTodosAlunosPorIdTurma(id));
    }

    @GetMapping(value = "/procurarTodosInstrutoresPorIdTurma/{id}")
    public ResponseEntity<List<ColaboradorFuncaoTurmaDTO>> procurarTodosInstrutoresPorIdTurma (@PathVariable Integer id){
        return ResponseEntity.ok().body(turmaFormacaoService.procurarTodosInstrutoresPorIdTurma(id));
    }

    @GetMapping(value = "/procurarTodosInstrutoresCompetenciaPorIdTurma/{id}")
    public ResponseEntity<List<InstrutorCompetenciaTurmaDTO>> procurarTodosInstrutoresCompetenciaPorIdTurma (@PathVariable Integer id){
     return ResponseEntity.ok().body(turmaFormacaoService.procurarTodosInstrutoresCompetenciaPorIdTurma(id));
    }

    @GetMapping(value = "/turmasFinalizadas")
    public ResponseEntity<List<TurmaFormacaoDTO>> buscaTurmaFinalizada(){
        return ResponseEntity.ok().body(turmaFormacaoService.buscaTurmaFinalizada());
    }

    @GetMapping(value = "/turmasEmAndamento")
    public ResponseEntity<List<TurmaFormacaoDTO>> buscaTurmaAndamento(){
        return ResponseEntity.ok().body(turmaFormacaoService.buscarTurmaAndamento());
    }

    @GetMapping(value = "/inicio/{inicio}/fim/{fim}")
    public ResponseEntity<List<TurmaFormacaoDTO>> buscarTodasTurmasPorIntervalo(@PathVariable String inicio,@PathVariable String fim){
        return ResponseEntity.ok().body(turmaFormacaoService.buscarTodasTurmasPorIntervalo(inicio, fim));
    }

}

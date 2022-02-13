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
}

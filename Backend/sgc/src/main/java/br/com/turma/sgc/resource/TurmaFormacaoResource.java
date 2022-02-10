package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.service.TurmaFormacaoService;
import br.com.turma.sgc.service.dto.TurmaFormacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/turmaFormacao")
@RequiredArgsConstructor
public class TurmaFormacaoResource {

    private final TurmaFormacaoService service;


    @GetMapping
    public ResponseEntity<List<TurmaFormacaoDTO>> procurarTodos(){
        return ResponseEntity.ok().body(service.procurarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TurmaFormacaoDTO> procurarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.procurarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TurmaFormacaoDTO> inserir(@RequestBody TurmaFormacaoDTO turma){
        return ResponseEntity.ok().body(service.inserir(turma));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<TurmaFormacaoDTO> atualizar(@RequestBody TurmaFormacaoDTO turma){
        return ResponseEntity.ok().body(service.atualizar(turma));
    }

    @GetMapping(value = "/procurarTodosPorIdStatus/{id}")
    public ResponseEntity<List<TurmaFormacaoDTO>> procurarTodosPorIdStatus (@PathVariable Integer id){
        return ResponseEntity.ok().body(service.procurarTodosPorIdStatus(id));
    }

}

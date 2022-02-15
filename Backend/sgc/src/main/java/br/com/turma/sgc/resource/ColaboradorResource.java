package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.service.ColaboradorService;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/colaborador")
@RequiredArgsConstructor
public class ColaboradorResource {

    private final ColaboradorService service;

    @GetMapping
    public ResponseEntity<List<Colaborador>> procurarTodos() {
        return ResponseEntity.ok().body(service.procurarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Colaborador> procurarPorId(@PathVariable int id) {
        return ResponseEntity.ok().body(service.procurarPorId(id));
    }

    @GetMapping(value = "/senioridade/{idSenioridade}")
    public ResponseEntity<List<ColaboradorDTO>> procurarPorSenioridadeId(@PathVariable Integer idSenioridade) {
        return ResponseEntity.ok().body(service.procurarPorSenioridadeId(idSenioridade));
    }

    @PostMapping
    public ResponseEntity<Colaborador> inserir(@RequestBody Colaborador colab) {
        return ResponseEntity.ok().body(service.inserir(colab));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Colaborador> atualizar(@RequestBody Colaborador c) {
        return ResponseEntity.ok().body(service.atualizar(c));
    }

}

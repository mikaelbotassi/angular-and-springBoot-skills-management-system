package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Senioridade;
import br.com.turma.sgc.service.SenioridadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/senioridade")
@RestController
@RequiredArgsConstructor
public class SenioridadeResource {

    private final SenioridadeService service;

    @GetMapping
    public ResponseEntity<List<Senioridade>> procurarTodos(){
        return ResponseEntity.ok().body(service.procurarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Senioridade> procurarPorId(@PathVariable int id){
        return ResponseEntity.ok().body(service.procurarPorId(id));
    }

}
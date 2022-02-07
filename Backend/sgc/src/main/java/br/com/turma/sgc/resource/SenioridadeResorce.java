package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Senioridade;
import br.com.turma.sgc.service.SenioridadeService;
import com.sun.tools.javac.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/senioridade")
@RequiredArgsConstructor
public class SenioridadeResorce {
    private final SenioridadeService service;

    @GetMapping
    public ResponseEntity<List<Senioridade>> findAll(){
        return ResponseEntity.ok().body(service.procurarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Senioridade> findById(@PathVariable int id){
        return ResponseEntity.ok().body(service.procurarPorId(id));
    }
}

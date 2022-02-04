package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Senioridade;
import br.com.turma.sgc.service.SenioridadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/senioridade")
public class SenioridadeResource {

    @Autowired
    private SenioridadeService service;

    @GetMapping
    public ResponseEntity<List<Senioridade>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Senioridade> findById(@PathVariable int id){
        return ResponseEntity.ok().body(service.findById(id));
    }

}

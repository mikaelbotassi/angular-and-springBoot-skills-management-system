package br.com.turma.sgc.resource;

import br.com.turma.sgc.enums.SenioridadeEnum;
import br.com.turma.sgc.service.SenioridadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/senioridade")
@RestController
@RequiredArgsConstructor
public class SenioridadeResource {

    private final SenioridadeService service;

    @GetMapping
    public ResponseEntity<SenioridadeEnum[]> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SenioridadeEnum> findById(@PathVariable int id){
        return ResponseEntity.ok().body(service.findById(id));
    }

}
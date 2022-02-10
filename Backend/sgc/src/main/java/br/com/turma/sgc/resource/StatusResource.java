package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Status;
import br.com.turma.sgc.service.StatusService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/status")
@RestController
@RequiredArgsConstructor
public class StatusResource {

    private final StatusService service;

    @GetMapping
    public ResponseEntity<List<Status>> procurarTodos(){
        return ResponseEntity.ok().body(service.procurarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Status> procurarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.procurarPorId(id));
    }



}

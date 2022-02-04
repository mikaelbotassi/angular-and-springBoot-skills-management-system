package br.com.turma.sgc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/senioridade")
public class SenioridadeController {


    @GetMapping
    public ResponseEntity<String> findAll(){
        return ResponseEntity.ok().body("GET");
    }

}

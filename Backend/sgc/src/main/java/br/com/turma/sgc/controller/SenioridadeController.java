package br.com.turma.sgc.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RequestMapping("/Senioridade")
@RestController
public class SenioridadeController {


    @GetMapping
    public ResponseEntity<String> findAll(){
        return ResponseEntity.ok().body("GET");
    }

}

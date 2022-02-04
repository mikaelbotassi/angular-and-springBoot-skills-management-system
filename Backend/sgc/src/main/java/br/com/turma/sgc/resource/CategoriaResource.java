package br.com.turma.sgc.resource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RequestMapping("/Categoria")
@RestController

public class CategoriaResource {

    @GetMapping
    public ResponseEntity<String> findAll() {return ResponseEntity.ok().body("GET");}
}

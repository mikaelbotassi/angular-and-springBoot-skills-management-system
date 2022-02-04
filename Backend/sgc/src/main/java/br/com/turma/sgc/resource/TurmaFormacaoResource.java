package br.com.turma.sgc.resource;

import br.com.turma.sgc.services.TurmaFormacaoService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RequestMapping("/TurmaFormacao")
@RestController
public class TurmaFormacaoResource {

    @PostMapping
    public ResponseEntity<String> add(){
        return ResponseEntity.ok().body("POST");
    }
    @GetMapping
    public ResponseEntity<String> findAll(){
        return ResponseEntity.ok().body("GET");
    }
    @PutMapping
    public ResponseEntity<String> update(){
        return ResponseEntity.ok().body("PUT");
    }
    @DeleteMapping
    public ResponseEntity<String> delete(){
        return ResponseEntity.ok().body("DELETE");
    }
}

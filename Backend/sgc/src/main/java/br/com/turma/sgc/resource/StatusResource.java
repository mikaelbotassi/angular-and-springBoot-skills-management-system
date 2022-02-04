package br.com.turma.sgc.resource;

import org.hibernate.annotations.Fetch;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RequestMapping("/Status")
@RestController
public class StatusResource {


    @GetMapping
    public ResponseEntity<String> findAll(){
        return ResponseEntity.ok().body("GET");
    }





}

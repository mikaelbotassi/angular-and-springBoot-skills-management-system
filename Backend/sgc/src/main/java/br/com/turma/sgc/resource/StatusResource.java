package br.com.turma.sgc.resource;
import br.com.turma.sgc.enums.StatusEnum;
import br.com.turma.sgc.service.StatusService;
import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/status")
@RestController
@RequiredArgsConstructor
public class StatusResource {

    private final StatusService service;

    @GetMapping
    public ResponseEntity<StatusEnum[]> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StatusEnum> findById(@PathVariable int id){
        return ResponseEntity.ok().body(service.findById(id));
    }

}

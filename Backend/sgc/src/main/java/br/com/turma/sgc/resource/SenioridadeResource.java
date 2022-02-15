package br.com.turma.sgc.resource;

import br.com.turma.sgc.service.SenioridadeService;
import br.com.turma.sgc.service.dto.SenioridadeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/senioridade")
@RestController
@RequiredArgsConstructor
public class SenioridadeResource {

    private final SenioridadeService service;

    @GetMapping
    public ResponseEntity<List<SenioridadeDTO>> procurarTodos(){
        return ResponseEntity.ok().body(service.listarTodasSenioridades());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SenioridadeDTO> procurarPorId(@PathVariable int id){
        return ResponseEntity.ok().body(service.buscarSenioridadePorId(id));
    }

}
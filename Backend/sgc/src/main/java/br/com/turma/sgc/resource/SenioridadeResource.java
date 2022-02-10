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

    @GetMapping(value = "/{id}")
    public ResponseEntity<SenioridadeDTO> buscarSenioridadePorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.buscarSenioridadePorId(id));
    }

    @GetMapping
    public ResponseEntity<List<SenioridadeDTO>> listarTodasSenioridades(){
        return ResponseEntity.ok().body(service.listarTodasSenioridades());
    }

    @PostMapping
    public ResponseEntity<SenioridadeDTO> inserirSenioridade(@RequestBody SenioridadeDTO dto) {
        return ResponseEntity.ok().body(service.inserirSenioridade(dto));
    }

    @PutMapping
    public ResponseEntity<SenioridadeDTO> atualizarSenioridade(@RequestBody SenioridadeDTO dto) {
        return ResponseEntity.ok().body(service.atualizarSenioridade(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirSenioridade(@PathVariable Integer id) {
        service.excluirSenioridade(id);
        return ResponseEntity.noContent().build();
    }

}
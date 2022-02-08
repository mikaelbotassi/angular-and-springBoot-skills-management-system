package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.service.CompetenciaService;
import br.com.turma.sgc.service.dto.CompetenciaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/competencia")
public class CompetenciaResource {

    private final CompetenciaService competenciaService;

    @GetMapping()
    public ResponseEntity<List<CompetenciaDTO>> procurarTodos(){
        return ResponseEntity.ok().body(competenciaService.procurarTodos());
    }



    @PutMapping
    public ResponseEntity<Competencia> atualizar(@RequestBody Competencia competencia) {
        return ResponseEntity.ok().body(competenciaService.atualizar(competencia));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competencia> procurarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(competenciaService.procurarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        return ResponseEntity.noContent().build();
    }
}

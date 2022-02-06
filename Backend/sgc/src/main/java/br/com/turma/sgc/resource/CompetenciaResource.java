package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.services.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencia")
public class CompetenciaResource {
    @Autowired
    CompetenciaService competenciaService;

    @GetMapping()
    public ResponseEntity<List<Competencia>> findAll(){
        return competenciaService.findAll();
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Competencia competencia) {
        return competenciaService.save(competencia);
    }
}

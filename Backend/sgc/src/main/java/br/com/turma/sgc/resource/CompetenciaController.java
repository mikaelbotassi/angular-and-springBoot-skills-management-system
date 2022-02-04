package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.services.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/competencia")
public class CompetenciaController {
    @Autowired
    CompetenciaService competenciaService;

    @GetMapping()
    public ResponseEntity<List<Competencia>> findAll(){
        return competenciaService.findAll();
    }
}

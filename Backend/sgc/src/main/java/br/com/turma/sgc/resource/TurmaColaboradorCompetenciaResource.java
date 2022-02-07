package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.service.TurmaColaboradorCompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/turma-colaborador-competencia")
public class TurmaColaboradorCompetenciaResource {

    @Autowired
    TurmaColaboradorCompetenciaService turmaColaboradorCompetencia;

    @GetMapping
    public ResponseEntity<List<TurmaColaboradorCompetencia>> findAll(){
        return turmaColaboradorCompetencia.findAll();
    }
}

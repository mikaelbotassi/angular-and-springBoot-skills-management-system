package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.service.ColaboradorCompetenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ColaboradoresCompetencias")
public class ColaboradorCompetenciaResource {

    private final ColaboradorCompetenciaService service;


    @GetMapping
    public ResponseEntity<List<ColaboradorCompetencia>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/colaborador-{idColaborador}/competencia-{idCompetencia}")
    public ResponseEntity<ColaboradorCompetencia> findById(@PathVariable int idColaborador, @PathVariable int idCompetencia){
        return ResponseEntity.ok().body(service.findById(idColaborador, idCompetencia));
    }

    @PostMapping
    public ColaboradorCompetencia insert(ColaboradorCompetencia ColaboradorCompetencia){
        return service.insert(ColaboradorCompetencia);
    }

    @DeleteMapping(value = "/colaborador-{idColaborador}/competencia-{idCompetencia}")
    public ResponseEntity<Void> delete(@PathVariable int idColaborador, @PathVariable int idCompetencia){
        service.delete(idColaborador, idCompetencia);
        return ResponseEntity.noContent().build();
    }

}

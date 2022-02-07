package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.domain.Colaborador_Competecia;
import br.com.turma.sgc.domain.pk.Colaborador_CompetenciaPK;
import br.com.turma.sgc.service.Colaborador_Competencia_Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Resource
@RequestMapping("/api/colaborador_competencia")
public class Colaborador_Competencia_Resource {

    private final Colaborador_Competencia_Service service;

    @GetMapping
    public ResponseEntity<List<Colaborador>> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/colaborador-{idColaborador}-competencia/{idCompetencia}")
    public ResponseEntity<Colaborador_Competecia> findById(@PathVariable int idColaborador, @PathVariable int idCompetencia){
        return ResponseEntity.ok().body(service.findById(idColaborador, idCompetencia));
    }

    @PostMapping
    public Colaborador_Competecia save(@RequestBody Colaborador_CompetenciaPK colaboradorCompetenciaPK){
        return service.save(colaboradorCompetenciaPK);
    }

    @DeleteMapping(value = "/colaborador/{idColaborador}/competencia/{idCompetencia}")
    public ResponseEntity<Void> delete(@PathVariable int idColaborador, @PathVariable int idCompetencia){
        service.delete(idColaborador, idCompetencia);
        return ResponseEntity.noContent().build();
    }
}

package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.Colaborador;
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
    public ResponseEntity<List<ColaboradorCompetencia>> procurarTodos(){
        return ResponseEntity.ok().body(service.procurarTodos());
    }

    @GetMapping(value = "/colaborador-{idColaborador}/competencia-{idCompetencia}")
    public ResponseEntity<ColaboradorCompetencia> procurarPorId(@PathVariable int idColaborador, @PathVariable int idCompetencia){
        return ResponseEntity.ok().body(service.procurarPorId(idColaborador, idCompetencia));
    }

    @PostMapping
    public ColaboradorCompetencia inserir(ColaboradorCompetencia ColaboradorCompetencia){
        return service.inserir(ColaboradorCompetencia);
    }

    @DeleteMapping(value = "/colaborador-{idColaborador}/competencia-{idCompetencia}")
    public ResponseEntity<Void> deletar(@PathVariable int idColaborador, @PathVariable int idCompetencia){
        service.deletar(idColaborador, idCompetencia);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<ColaboradorCompetencia> atualizar(@RequestBody ColaboradorCompetencia c){
        return ResponseEntity.ok().body(service.atualizar(c));
    }

}

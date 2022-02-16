package br.com.turma.sgc.resource;
import br.com.turma.sgc.service.ColaboradorService;
import br.com.turma.sgc.service.dto.CadastrarColaboradorDTO;
import br.com.turma.sgc.service.dto.ColaboradorBuscaDTO;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
import br.com.turma.sgc.service.dto.CompetenciaColaboradorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/colaborador")
@RequiredArgsConstructor
public class ColaboradorResource {

    private final ColaboradorService service;

    @GetMapping
    public ResponseEntity<List<ColaboradorBuscaDTO>> procurarTodos(){
        return ResponseEntity.ok().body(service.procurarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ColaboradorDTO> procurarPorId(@PathVariable int id){
        return ResponseEntity.ok().body(service.procurarPorId(id));
    }

    @GetMapping("instrutores")
    public ResponseEntity<List<ColaboradorBuscaDTO>> buscaColaboradorInstrutor(){
        return ResponseEntity.ok().body(service.buscaColaboradorInstrutor());
    }

    @GetMapping("competencias/{idCompetencia}")
    public ResponseEntity<List<ColaboradorBuscaDTO>> buscarColaboradoresPorCompetencia(@PathVariable    ("idCompetencia") Integer idCompetencia){

        return ResponseEntity.ok().body(service.buscarColaboradoresPorCompetencia(idCompetencia));

    }

    @GetMapping("colaborador/{idColaborador}")
    public ResponseEntity<CompetenciaColaboradorDTO> buscarColaborador(@PathVariable("idColaborador") Integer idColaborador){

        return ResponseEntity.ok().body(service.buscarColaborador(idColaborador));

    }

    @PostMapping
    public ResponseEntity<ColaboradorDTO> inserir(@RequestBody CadastrarColaboradorDTO colab){
        return ResponseEntity.created(URI.create("./api/colaborador")) .body(service.inserir(colab));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<ColaboradorDTO> atualizar(@RequestBody ColaboradorDTO c){
        return ResponseEntity.ok().body(service.atualizar(c));
    }

    @GetMapping(value = "/aplicarCompetencia/{idCompetencia}") //OK
    public ResponseEntity<List<ColaboradorDTO>> buscarColaboradorPraAplicarCompeteciaPorId(@PathVariable Integer idCompetencia) {
        return ResponseEntity.ok().body(service.buscarColaboradorPraAplicarCompeteciaPorId(idCompetencia));
    }

}

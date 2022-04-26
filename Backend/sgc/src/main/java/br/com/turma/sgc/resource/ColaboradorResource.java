package br.com.turma.sgc.resource;

import br.com.turma.sgc.service.ColaboradorService;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorBuscaDTO;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorDTO;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorListDTO;
import br.com.turma.sgc.service.dto.Competencia.CompetenciaColaboradorDTO;
import br.com.turma.sgc.service.dto.Turma.TurmaColaboradorCompetenciaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<ColaboradorListDTO>> procurarTodos(){
        return ResponseEntity.ok().body(service.procurarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ColaboradorDTO> procurarPorId(@PathVariable int id){
        return ResponseEntity.ok().body(service.procurarPorId(id));
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
    public ResponseEntity<ColaboradorDTO> inserir(@RequestBody @Valid ColaboradorDTO colab){
        return ResponseEntity.created(URI.create("./api/colaborador")) .body(service.inserir(colab));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<ColaboradorDTO> atualizar(@RequestBody @Valid ColaboradorDTO c){
        return ResponseEntity.ok().body(service.atualizar(c));
    }

    @GetMapping(value = "/aplicarCompetencia/{idCompetencia}") //OK
    public ResponseEntity<List<ColaboradorDTO>> buscarColaboradorPraAplicarCompeteciaPorId(@PathVariable Integer idCompetencia) {
        return ResponseEntity.ok().body(service.buscarColaboradorPraAplicarCompeteciaPorId(idCompetencia));
    }

    @GetMapping(value = "/competenciasColaborador/{idColaborador}") //OK
    public ResponseEntity<List<TurmaColaboradorCompetenciaDTO>> procurarCompetenciasEnsinadaPorColaborador(@PathVariable Integer idColaborador) {
        return ResponseEntity.ok().body(service.procurarCompetenciasEnsinadaPorColaborador(idColaborador));
    }

}

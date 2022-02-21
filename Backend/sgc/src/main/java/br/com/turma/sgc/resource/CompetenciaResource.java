package br.com.turma.sgc.resource;

import br.com.turma.sgc.service.dto.CompetenciaDTO;
import br.com.turma.sgc.service.CompetenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/competencia")
public class CompetenciaResource {

    private final CompetenciaService competenciaService;

    @GetMapping()
    public ResponseEntity<List<CompetenciaDTO>> procurarTodos(){
        return ResponseEntity.ok().body(competenciaService.procurarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetenciaDTO> procurarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(competenciaService.procurarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CompetenciaDTO> inserir(@RequestBody CompetenciaDTO competenciaDTO) {
        return ResponseEntity.created(URI.create("/api/competencia")).body(competenciaService.inserir(competenciaDTO));
    }

    @PutMapping
    public ResponseEntity<CompetenciaDTO> atualizar(@RequestBody CompetenciaDTO competenciaDTO) {
        return ResponseEntity.ok().body(competenciaService.atualizar(competenciaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        competenciaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/colaborador/{idColaborador}/nivel/{idNivel}")
    public ResponseEntity<List<CompetenciaDTO>> buscarCompetenciasMaximasPorIdColaborador(@PathVariable Integer idColaborador, @PathVariable Integer idNivel){
        List<CompetenciaDTO> dto = competenciaService.buscarCompetenciasPorNivelEPorIdColaborador(idColaborador, idNivel);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("colaboradores/{idColaborador}")
    public ResponseEntity<List<CompetenciaDTO>> buscaCompetenciaNivel(@PathVariable Integer idColaborador){

        return ResponseEntity.ok(competenciaService.buscaCompetenciaNivel(idColaborador));

    }

    @GetMapping("/turma/{idTurma}/colaborador/{idColaborador}")
    public ResponseEntity<List<CompetenciaDTO>> pegarTodasCompetenciasDoColaboradorNaTurma(@PathVariable Integer idTurma, @PathVariable Integer idColaborador){
        List<CompetenciaDTO> dto = competenciaService.pegarTodasCompetenciasDoColaboradorNaTurma(idTurma, idColaborador);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/categoria/{idCategoria}") //ok
    public ResponseEntity<List<CompetenciaDTO>> buscarCompetenciaPorIdCategoria(@PathVariable Integer idCategoria) {
        return ResponseEntity.ok().body(competenciaService.buscarCompetenciaPorIdCategoria(idCategoria));
    }

}

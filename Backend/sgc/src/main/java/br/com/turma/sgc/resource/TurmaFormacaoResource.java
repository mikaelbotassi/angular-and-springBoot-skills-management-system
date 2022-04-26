package br.com.turma.sgc.resource;

import br.com.turma.sgc.service.TurmaFormacaoService;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorCompetenciaDTO;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorFuncaoTurmaDTO;
import br.com.turma.sgc.service.dto.Colaborador.InstrutorCompetenciaTurmaDTO;
import br.com.turma.sgc.service.dto.Turma.TurmaColaboradorCompetenciaDTO;
import br.com.turma.sgc.service.dto.Turma.TurmaColaboradorCompetenciaNivelDTO;
import br.com.turma.sgc.service.dto.Turma.TurmaFormacaoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/turmaFormacao")
@RequiredArgsConstructor
public class TurmaFormacaoResource {

    private final TurmaFormacaoService turmaFormacaoService;


    @GetMapping
    public ResponseEntity<List<TurmaFormacaoDTO>> procurarTodos(){
        return ResponseEntity.ok().body(turmaFormacaoService.procurarTodos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TurmaFormacaoDTO> procurarPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(turmaFormacaoService.procurarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TurmaFormacaoDTO> inserir(@RequestBody @Valid TurmaFormacaoDTO turma){
        return ResponseEntity.created(URI.create("./api/turmaFormacao")).body(turmaFormacaoService.inserir(turma));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        turmaFormacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<TurmaFormacaoDTO> atualizar(@RequestBody @Valid TurmaFormacaoDTO turma){
        return ResponseEntity.ok().body(turmaFormacaoService.atualizar(turma));
    }

    @GetMapping(value = "/procurarTodosPorIdStatus/{id}")
    public ResponseEntity<List<TurmaFormacaoDTO>> procurarTodosPorIdStatus (@PathVariable Integer id){
        return ResponseEntity.ok().body(turmaFormacaoService.procurarTodosPorIdStatus(id));
    }

    @GetMapping(value = "/procurarTodosAlunosPorIdTurma/{id}")
    public ResponseEntity<List<ColaboradorFuncaoTurmaDTO>> procurarTodosAlunosPorIdTurma (@PathVariable Integer id){
        return ResponseEntity.ok().body(turmaFormacaoService.procurarTodosAlunosPorIdTurma(id));
    }

    @GetMapping(value = "/procurarTodosInstrutoresPorIdTurma/{id}")
    public ResponseEntity<List<ColaboradorFuncaoTurmaDTO>> procurarTodosInstrutoresPorIdTurma (@PathVariable Integer id){
        return ResponseEntity.ok().body(turmaFormacaoService.procurarTodosInstrutoresPorIdTurma(id));
    }

    @GetMapping(value = "/procurarTodosInstrutoresCompetenciaPorIdTurma/{id}")
    public ResponseEntity<List<InstrutorCompetenciaTurmaDTO>> procurarTodosInstrutoresCompetenciaPorIdTurma (@PathVariable Integer id){
     return ResponseEntity.ok().body(turmaFormacaoService.procurarTodosInstrutoresCompetenciaPorIdTurma(id));
    }

    @PostMapping(value = "/inserirColaborador")
    public ResponseEntity<TurmaColaboradorCompetenciaDTO> inserirColaboradorTurma (@RequestBody @Valid TurmaColaboradorCompetenciaDTO turmaColaboradorCompetenciaDTO) {
        return ResponseEntity.created(URI.create("./api/turmaFormacao/inserirColaborador")).body(turmaFormacaoService.inserirColaboradorTurma(turmaColaboradorCompetenciaDTO));
    }
    @GetMapping(value = "/turmasFinalizadas")
    public ResponseEntity<List<TurmaFormacaoDTO>> buscaTurmaFinalizada(){
        return ResponseEntity.ok().body(turmaFormacaoService.buscaTurmaFinalizada());
    }

    @GetMapping(value = "/turmasEmAndamento")
    public ResponseEntity<List<TurmaFormacaoDTO>> buscaTurmaAndamento(){
        return ResponseEntity.ok().body(turmaFormacaoService.buscarTurmaAndamento());
    }

    @GetMapping(value = "/todosColaboradorCompetenciaTurma/{id}")
    public ResponseEntity<List<TurmaColaboradorCompetenciaNivelDTO>> procurarTodasTurmasPorIdTurma (@PathVariable Integer id){
        return  ResponseEntity.ok().body(turmaFormacaoService.procurarColaboradorCompetenciaEmTurma (id));
    }

    @GetMapping(value = "/Colaboradores")
    public ResponseEntity<List<TurmaColaboradorCompetenciaNivelDTO>> listarTodosColaboradoresCompetencia(){
        return ResponseEntity.ok().body(turmaFormacaoService.listarColaboradorCompetencia());
    }

    @GetMapping(value = "/ColaboradorCompetencia/{idColaborador}/{idCompetencia}")
    public ResponseEntity<TurmaColaboradorCompetenciaNivelDTO> procurarColaboradorCompetenciaPorIdColaboradorIdCompetencia(@PathVariable Integer idColaborador, @PathVariable Integer idCompetencia){
        return ResponseEntity.ok().body(turmaFormacaoService.procurarNivelColaboradorCompetencia(idColaborador, idCompetencia));
    }

    @DeleteMapping (value = "/turmaColaboradorCompetenciaDeletar/{idTurma}/{idColaborador}/{idCompetencia}")
    public ResponseEntity<Void> deletarTurmaColaboradorCompetencia(@PathVariable Integer idTurma, @PathVariable Integer idColaborador, @PathVariable Integer idCompetencia){
        turmaFormacaoService.deletarTurmaColaboradorCompetencia(idTurma ,idColaborador, idCompetencia);
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PutMapping(value = "colaboradorCompetencia/subirNivel")
    public ResponseEntity<Void> subirNivelColaboradorCompetencia(@RequestBody @Valid List<TurmaColaboradorCompetenciaNivelDTO> turmaColaboradorCompetenciaNivelDTO){
        turmaFormacaoService.subirNivelColaboradorCompetencia(turmaColaboradorCompetenciaNivelDTO);
      return ResponseEntity.accepted().build();
    }

    @PostMapping(value = "cadastrarColaboradorCompetenciaZero/{colaboradorId}/{competenciaId}")
    public ResponseEntity<ColaboradorCompetenciaDTO> inserir(@PathVariable Integer colaboradorId, @PathVariable Integer competenciaId){
        return ResponseEntity.created(URI.create("./api/turmaFormacao")).body(turmaFormacaoService.inserirColaboradorCompetenciaZero(colaboradorId, competenciaId));
    }

    @GetMapping(value = "procurarTurmaColaboradorCompetenciaPorId/{turmaId}/{colaboradorId}/{competenciaId}")
    public ResponseEntity<TurmaColaboradorCompetenciaDTO> procurarTurmaColaboradorCompetenciaPorId(@PathVariable Integer turmaId,@PathVariable Integer colaboradorId,@PathVariable Integer competenciaId){
        return ResponseEntity.ok().body(turmaFormacaoService.procurarTurmaColaboradorCompetenciaPorId(colaboradorId,competenciaId,turmaId));
    }

}

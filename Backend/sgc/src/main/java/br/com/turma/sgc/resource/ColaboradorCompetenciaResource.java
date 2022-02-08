package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.ColaboradorCompetenciaPK;
import br.com.turma.sgc.service.ColaboradorCompetenciaService;
import br.com.turma.sgc.service.dto.ColaboradorCompetenciaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ColaboradoresCompetencias")
public class ColaboradorCompetenciaResource {

    @Autowired
    private final ColaboradorCompetenciaService service;

    @GetMapping
    public ResponseEntity<List<ColaboradorCompetenciaDTO>> buscarTodos(){
        return ResponseEntity.ok().body(service.buscarTodos());
    }//OK

    @GetMapping("/{id}")
    public ResponseEntity<ColaboradorCompetenciaDTO> buscarPorId(ColaboradorCompetenciaPK id) throws Exception {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    } //OK

    @PostMapping
    public ColaboradorCompetenciaDTO inserir(ColaboradorCompetencia ColaboradorCompetencia){
        return service.inserir(ColaboradorCompetencia);
    } //OK

    @DeleteMapping
    public ResponseEntity<Void> excluir(ColaboradorCompetenciaPK id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    } //OK

    @PutMapping
    public ResponseEntity<ColaboradorCompetenciaDTO> atualizar() {
        return ResponseEntity.ok().body(service.atualizar());
    } //OK
}

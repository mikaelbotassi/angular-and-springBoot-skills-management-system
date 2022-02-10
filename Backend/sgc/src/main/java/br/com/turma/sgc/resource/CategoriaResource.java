package br.com.turma.sgc.resource;

import br.com.turma.sgc.service.CategoriaService;
import br.com.turma.sgc.service.dto.CategoriaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/categoria")
@RestController
@RequiredArgsConstructor
public class CategoriaResource {

    private final CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> buscarCategoriaPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.buscarCategoriaPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarTodasCategorias(){
        return ResponseEntity.ok().body(service.listarTodasCategorias());
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> inserirCategoria(@RequestBody CategoriaDTO dto) {
        return ResponseEntity.ok().body(service.inserirCategoria(dto));
    }

    @PutMapping
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@RequestBody CategoriaDTO dto) {
        return ResponseEntity.ok().body(service.atualizarCategoria(dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirCategoria(@PathVariable Integer id) {
        service.excluirCategoria(id);
        return ResponseEntity.noContent().build();
    }
}

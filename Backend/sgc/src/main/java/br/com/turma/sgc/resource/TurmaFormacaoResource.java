package br.com.turma.sgc.resource;

import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.services.TurmaFormacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/TurmaFormacao")
@RestController
public class TurmaFormacaoResource {

    @Autowired
    private TurmaFormacaoService turmaFormacaoService;

    @PostMapping("{nome}/{decricao}/{diciplinas_instrutores}/{inicio}/{termino}/{status}")
    public ResponseEntity<String> addTurmaFormacao (
            @PathVariable(value = "nome") String nome,
            @PathVariable(value = "descricao") String descricao,
            @PathVariable(value = "diciplinas_instrutores") Integer diciplinas_instrutores,
            @PathVariable(value = "inicio") Date inicio,
            @PathVariable(value = "termino") Date termino,
            @PathVariable(value = "status") Integer status
    ){
        //Treat error to Save
        try {
            turmaFormacaoService.save(
                    nome,
                    descricao,
                    diciplinas_instrutores,
                    inicio,
                    termino,
                    status
            );

            return new ResponseEntity(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<TurmaFormacao> getTurmaFormacao() {
        return turmaFormacaoService.getTurmaFormacao();
    }

    @PutMapping
    public ResponseEntity attTurmaFormacao(
            @PathVariable(value = "id") Integer id,
            @PathVariable(value = "nome") String nome,
            @PathVariable(value = "descricao") String descricao,
            @PathVariable(value = "diciplinas_instrutores") Integer diciplinas_instrutores,
            @PathVariable(value = "inicio") Date inicio,
            @PathVariable(value = "termino") Date termino,
            @PathVariable(value = "status") Integer status
    ) {
        //Treat error to Save
        try {
            turmaFormacaoService.update(
                    id,
                    nome,
                    descricao,
                    diciplinas_instrutores,
                    inicio,
                    termino,
                    status
            );

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity delTurmaFormacao(
            @PathVariable(value = "id") Integer id
    ) {
        //Treat error to Save
        try {
            turmaFormacaoService.delete(id);

            //Susses return
            return new ResponseEntity(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            //Error return
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

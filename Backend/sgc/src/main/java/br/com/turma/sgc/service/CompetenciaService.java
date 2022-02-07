package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.repository.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CompetenciaService {
    @Autowired
    CompetenciaRepository competencia;

    public ResponseEntity<List<Competencia>> findAll(){
        return ResponseEntity.ok(competencia.findAll());
    }

    public Competencia findById(Integer id){
        Optional<Competencia> obj = competencia.findById(id);
        if(obj.isPresent())
            return obj.get();
        else
            throw new NoSuchElementException("Elemento não encontrado!");
    }

    public ResponseEntity<String> save(Competencia competencia){

        this.competencia.save(competencia);

        return ResponseEntity.ok("Competencia salva com Sucesso!");
    }

    public ResponseEntity<String> update(Competencia competencia){

        this.competencia.save(competencia);

        return ResponseEntity.ok("Competência atualizada com Sucesso");
    }

    public ResponseEntity<String> delete(Integer id){

        this.competencia.deleteById(id);

        return ResponseEntity.ok("Competência deletada com Sucesso");
    }

}

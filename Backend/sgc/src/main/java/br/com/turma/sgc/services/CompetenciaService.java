package br.com.turma.sgc.services;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.repository.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Service
public class CompetenciaService {
    @Autowired
    CompetenciaRepository competencia;

    public ResponseEntity<List<Competencia>> findAll(){
        return ResponseEntity.ok().body(competencia.findAll());
    }

    public ResponseEntity<String> save(Competencia competencia){

        this.competencia.save(competencia);

        return ResponseEntity.ok("Competencia salva com Sucesso!");
    }

}

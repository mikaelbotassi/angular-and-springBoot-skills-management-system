package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.repository.TurmaColaboradorCompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TurmaColaboradorCompetenciaService {

    @Autowired
    private TurmaColaboradorCompetenciaRepository turmaColaboradorCompetenciaRepository;

    public ResponseEntity<List<TurmaColaboradorCompetencia>>  findAll(){
        return ResponseEntity.ok(turmaColaboradorCompetenciaRepository.findAll());
    }

    public ResponseEntity<String> save(TurmaColaboradorCompetencia turmaColaboradorCompetencia){

        turmaColaboradorCompetenciaRepository.save(turmaColaboradorCompetencia);

        return ResponseEntity.ok("Resgistro incluído com Sucesso!");
    }

}

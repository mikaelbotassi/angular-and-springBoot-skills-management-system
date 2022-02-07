package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.TurmaColaboradorCompetenciaPK;
import br.com.turma.sgc.repository.TurmaColaboradorCompetenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TurmaColaboradorCompetenciaService {

    private final TurmaColaboradorCompetenciaRepository turmaColaboradorCompetenciaRepository;

    public ResponseEntity<List<TurmaColaboradorCompetencia>>  findAll(){
        return ResponseEntity.ok().body(turmaColaboradorCompetenciaRepository.findAll());
    }

    public TurmaColaboradorCompetencia findById(int idTurma, int idColaborador, int idCompetencia){
        Optional<TurmaColaboradorCompetencia> obj = turmaColaboradorCompetenciaRepository.findById(new TurmaColaboradorCompetenciaPK(idTurma, idColaborador, idCompetencia));
        if(obj.isPresent()){
            return obj.get();
        }
        else{
            throw new NoSuchElementException("Elemento não encontrado!");
        }

    }

    public TurmaColaboradorCompetencia save(TurmaColaboradorCompetencia turmaColaboradorCompetencia){

        return turmaColaboradorCompetenciaRepository.save(turmaColaboradorCompetencia);
    }

    public ResponseEntity<String> update(TurmaColaboradorCompetencia turmaColaboradorCompetencia){

        turmaColaboradorCompetenciaRepository.save(turmaColaboradorCompetencia);

        return ResponseEntity.ok("Resgistro atualizado com Sucesso!");
    }


    public void delete(int idTurma, int idColaborador, int idCompetencia) {
        turmaColaboradorCompetenciaRepository.deleteById(new TurmaColaboradorCompetenciaPK(idTurma, idColaborador, idCompetencia));
    }
}

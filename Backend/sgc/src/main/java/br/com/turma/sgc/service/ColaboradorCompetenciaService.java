package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.TurmaColaboradorCompetenciaPK;

import br.com.turma.sgc.repository.ColaboradorCompetenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColaboradorCompetenciaService {

    private final br.com.turma.sgc.repository.ColaboradorCompetenciaRepository ColaboradorCompetenciaRepository;
    private final ColaboradorService colaboradorService;
    private final CompetenciaService competenciaService;

    public ResponseEntity<List<TurmaColaboradorCompetencia>>  findAll(){
        return ResponseEntity.ok().body(br.com.turma.sgc.repository.ColaboradorCompetenciaRepository.findAll());
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

    public TurmaColaboradorCompetencia insertByPK(TurmaColaboradorCompetenciaPK pk){
        return new TurmaColaboradorCompetencia(pk, turmaFormacaoService.findById(pk.getIdTurmaFormacao()),
                colaboradorService.findById(pk.getIdColaborador()), competenciaService.findById(pk.getIdCompetencia()));
    }

    public TurmaColaboradorCompetencia save(TurmaColaboradorCompetenciaPK turmaColaboradorCompetenciaPK){

        TurmaColaboradorCompetencia novo = insertByPK(turmaColaboradorCompetenciaPK);

        return turmaColaboradorCompetenciaRepository.save(novo);
    }


    public void delete(int idTurma, int idColaborador, int idCompetencia) {
        turmaColaboradorCompetenciaRepository.deleteById(new TurmaColaboradorCompetenciaPK(idTurma, idColaborador, idCompetencia));
    }
}

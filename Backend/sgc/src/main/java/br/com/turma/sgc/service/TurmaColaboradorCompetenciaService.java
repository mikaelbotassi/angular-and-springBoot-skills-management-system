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
    private final TurmaFormacaoService turmaFormacaoService;
    private final ColaboradorService colaboradorService;
    private final CompetenciaService competenciaService;

    public ResponseEntity<List<TurmaColaboradorCompetencia>> procurarTodos(){
        return ResponseEntity.ok().body(turmaColaboradorCompetenciaRepository.findAll());
    }

    public TurmaColaboradorCompetencia procurarPorId(int idTurma, int idColaborador, int idCompetencia){
        Optional<TurmaColaboradorCompetencia> obj = turmaColaboradorCompetenciaRepository.findById(new TurmaColaboradorCompetenciaPK(idTurma, idColaborador, idCompetencia));
        if(obj.isPresent()){
            return obj.get();
        }
        else{
            throw new NoSuchElementException("Elemento não encontrado!");
        }

    }

    public TurmaColaboradorCompetencia inserirPorPK(TurmaColaboradorCompetenciaPK pk){
        return new TurmaColaboradorCompetencia(pk, turmaFormacaoService.procurarPorId(pk.getIdTurmaFormacao()),
                colaboradorService.procurarPorId(pk.getIdColaborador()), competenciaService.procurarProId(pk.getIdCompetencia()));
    }

    public TurmaColaboradorCompetencia inserir(TurmaColaboradorCompetenciaPK turmaColaboradorCompetenciaPK){

        TurmaColaboradorCompetencia novo = inserirPorPK(turmaColaboradorCompetenciaPK);

        return turmaColaboradorCompetenciaRepository.save(novo);
    }


    public void deletar(int idTurma, int idColaborador, int idCompetencia) {
        turmaColaboradorCompetenciaRepository.deleteById(new TurmaColaboradorCompetenciaPK(idTurma, idColaborador, idCompetencia));
    }
}

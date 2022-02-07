package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.domain.Colaborador_Competecia;
import br.com.turma.sgc.domain.pk.Colaborador_CompetenciaPK;
import br.com.turma.sgc.repository.Colaborador_Competencia_Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Colaborador_Competencia_Service {
    private final Colaborador_Competencia_Repository colaboradorCompetenciaRepository;
    private final ColaboradorService colaboradorService;
    private final CompetenciaService competenciaService;

    public ResponseEntity<List<Colaborador>> findAll(){
        return ResponseEntity.ok().body(colaboradorCompetenciaRepository.findAll());
    }

    public Colaborador_Competecia findById(int idColaborador, int idCompetencia){
        Optional<Colaborador_Competecia> obj = colaboradorCompetenciaRepository.findById(new Colaborador_CompetenciaPK(idColaborador, idCompetencia));
        if(obj.isPresent()){
            return obj.get();
        }
        else{
            throw new NoSuchElementException("Elemento não encontrado!");
        }

    }

    public Colaborador_Competecia insertByPK(Colaborador_CompetenciaPK pk){
        return new Colaborador_Competecia(pk, ColaboradorService.findById(pk.getIdColaborador()),
                colaboradorService.findById(pk.getIdColaborador()), competenciaService.findById(pk.getIdCompetencia()));
    }

    public Colaborador_Competecia save(Colaborador_CompetenciaPK colaboradorCompetenciaPK){

        Colaborador_Competecia novo = insertByPK(Colaborador_CompetenciaPK);

        return colaboradorCompetenciaRepository.save(novo);
    }

    public void delete(int idTurma, int idColaborador) {
        colaboradorCompetenciaRepository.deleteById(new Colaborador_CompetenciaPK(idColaborador, idCompetencia));
    }
}

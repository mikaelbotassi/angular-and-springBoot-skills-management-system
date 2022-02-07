package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.ColaboradorCompetenciaPK;
import br.com.turma.sgc.repository.ColaboradorCompetenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColaboradorCompetenciaService {

    private final ColaboradorCompetenciaRepository repository;

    public List<ColaboradorCompetencia> findAll(){
        return repository.findAll();
    }

    public ColaboradorCompetencia findById(int idColaborador, int idCompetencia){
        Optional<ColaboradorCompetencia> obj = repository.findById(new ColaboradorCompetenciaPK(idColaborador, idCompetencia));
        if(obj.isPresent()){
            return obj.get();
        }
        else{
            throw new NoSuchElementException("Elemento não encontrado!");
        }

    }

    public ColaboradorCompetencia insert(ColaboradorCompetencia colaboradorCompetencia){
        return repository.save(colaboradorCompetencia);
    }

    public void delete(int idColaborador, int idCompetencia){
        repository.deleteById(new ColaboradorCompetenciaPK(idColaborador, idCompetencia));
    }

    public ColaboradorCompetencia update(ColaboradorCompetencia c){
        return repository.save(c);
    }

}

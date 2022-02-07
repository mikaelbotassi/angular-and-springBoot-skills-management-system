package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.repository.CompetenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompetenciaService {
    private final CompetenciaRepository repository;

    public List<Competencia> procurarTodos(){
        return repository.findAll();
    }

    public Competencia procurarPorId(Integer id){
        Optional<Competencia> obj = repository.findById(id);
        if(obj.isPresent())
            return obj.get();
        else
            throw new NoSuchElementException("Elemento não encontrado!");
    }

    public Competencia inserir(Competencia competencia){

        return repository.save(competencia);
    }

    public Competencia atualizar(Competencia competencia){

        return repository.save(competencia);

    }

    public void deletar(Integer id){

        repository.deleteById(id);

    }

}

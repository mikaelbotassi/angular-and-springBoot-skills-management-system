package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.repository.TurmaFormacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TurmaFormacaoService {

    private final TurmaFormacaoRepository repository;

    public List<TurmaFormacao> findAll(){
        return repository.findAll();
    }

    public TurmaFormacao findById(int id){
        Optional<TurmaFormacao> obj = repository.findById(id);
        if(obj.isPresent())
            return obj.get();
        else
            throw new NoSuchElementException("Elemento não encontrado!");
    }

    public TurmaFormacao insert(TurmaFormacao turma){
        return repository.save(turma);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public TurmaFormacao update(TurmaFormacao turma){
        return repository.save(turma);
    }

}

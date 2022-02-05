package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Senioridade;
import br.com.turma.sgc.repository.SenoridadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SenioridadeService {

    private final SenoridadeRepository repository;

    public List<Senioridade> findAll(){
        return repository.findAll();
    }

    public Senioridade findById(int id){
        Optional<Senioridade> obj = repository.findById(id);
        return obj.get();
    }

}

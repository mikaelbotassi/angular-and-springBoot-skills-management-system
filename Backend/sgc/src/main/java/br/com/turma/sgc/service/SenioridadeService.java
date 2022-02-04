package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Senioridade;
import br.com.turma.sgc.repository.SenoridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SenioridadeService {

    @Autowired
    private SenoridadeRepository repository;

    public List<Senioridade> findAll(){
        return repository.findAll();
    }

    public Senioridade findById(int id){
        Optional<Senioridade> obj = repository.findById(id);
        return obj.get();
    }

}

package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Status;
import br.com.turma.sgc.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository repository;

    public List<Status> procurarTodos(){
        return repository.findAll();
    }

    public Status procurarPorId(int id){
        Optional<Status> obj = repository.findById(id);
        return obj.get();
    }

}

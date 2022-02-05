package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.repository.ColaboradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository repository;

    public List<Colaborador> findAll(){
        return repository.findAll();
    }

    public Colaborador findById(int id){
        Optional<Colaborador> obj = repository.findById(id);
        return obj.get();
    }

    public Colaborador insert(Colaborador colab){
        return repository.save(colab);
    }

}

package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.repository.ColaboradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
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
        if(obj.isPresent()){
            return obj.get();
        }
        else{
            throw new NoSuchElementException("Elemento não encontrado");
        }

    }

    public Colaborador insert(Colaborador colab){
        return repository.save(colab);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public Colaborador update(Colaborador c){
        return repository.save(c);
    }

}

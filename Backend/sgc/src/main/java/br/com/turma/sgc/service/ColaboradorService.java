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

    public List<Colaborador> procurarTodos(){
        return repository.findAll();
    }

    public Colaborador procurarPorId(Integer id){
        Optional<Colaborador> obj = repository.findById(id);
        if(obj.isPresent()){
            return obj.get();
        }
        else{
            throw new NoSuchElementException("Elemento não encontrado!");
        }

    }

    public Colaborador inserir(Colaborador colab){
        return repository.save(colab);
    }

    public void deletar(Integer id){
        repository.deleteById(id);
    }

    public Colaborador atualizar(Colaborador c){
        return repository.save(c);
    }

}

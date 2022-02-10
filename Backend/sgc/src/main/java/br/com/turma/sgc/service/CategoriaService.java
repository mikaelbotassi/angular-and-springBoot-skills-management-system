package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Categoria;
import br.com.turma.sgc.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;

    public List<Categoria> procurarTodos(){
        return repository.findAll();
    }

    public Categoria procurarPorId(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        obj.orElseThrow(()-> throw new )
    }

}

package br.com.turma.sgc.services;

import br.com.turma.sgc.domain.Categoria;
import br.com.turma.sgc.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServices {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listCategoria() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findId(Long id) {
        return categoriaRepository.findById(id);
    }
}

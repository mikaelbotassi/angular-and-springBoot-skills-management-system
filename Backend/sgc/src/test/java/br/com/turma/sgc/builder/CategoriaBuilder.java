package br.com.turma.sgc.builder;

import br.com.turma.sgc.domain.Categoria;
import br.com.turma.sgc.repository.CategoriaRepository;
import br.com.turma.sgc.service.dto.CategoriaDTO;
import br.com.turma.sgc.service.mapper.CategoriaMapper;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;

@Component
public class CategoriaBuilder extends ConstrutorDeEntidade<Categoria>{

    @Autowired
    CategoriaMapper categoriaMapper;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    protected Categoria construirEntidade() throws ParseException {
return null;
    }

    @Override
    protected Categoria persistir(Categoria entidade) {
       return null;
    }

    @Override
    protected Collection<Categoria> obterTodos() {
        return null;
    }

    @Override
    protected Categoria obterPorId(Long id) {
        return null;
    }
}

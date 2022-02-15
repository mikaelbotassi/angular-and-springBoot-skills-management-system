package br.com.turma.sgc.builder;

import br.com.turma.sgc.domain.Categoria;

import java.text.ParseException;
import java.util.Collection;

public class CategoriaBuilder extends ConstrutorDeEntidade<Categoria>{
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

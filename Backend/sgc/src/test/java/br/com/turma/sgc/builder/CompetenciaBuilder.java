package br.com.turma.sgc.builder;

import br.com.turma.sgc.domain.Competencia;

import java.text.ParseException;
import java.util.Collection;

public class CompetenciaBuilder extends ConstrutorDeEntidade<Competencia>{
    @Override
    protected Competencia construirEntidade() throws ParseException {
        return null;
    }

    @Override
    protected Competencia persistir(Competencia entidade) {
        return null;
    }

    @Override
    protected Collection<Competencia> obterTodos() {
        return null;
    }

    @Override
    protected Competencia obterPorId(Long id) {
        return null;
    }
}

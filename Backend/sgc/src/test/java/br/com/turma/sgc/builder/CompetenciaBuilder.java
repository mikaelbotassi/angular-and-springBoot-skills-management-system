package br.com.turma.sgc.builder;

import br.com.turma.sgc.domain.Categoria;
import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.repository.CompetenciaRepository;
import br.com.turma.sgc.service.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;

@Component
public class CompetenciaBuilder extends  ConstrutorDeEntidade<Competencia>{

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Autowired
    private CompetenciaService competenciaService;


    @Override
    protected Competencia construirEntidade() throws ParseException {
        Competencia competencia = new Competencia();
        competencia.setNome("git");
        competencia.setDescricao("versao codigo");
        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setNome("backend");
        categoria.setId(1);
        categoria.setNome("");
        competencia.setCategoria(categoria);
        return competencia;
    }

    @Override
    protected Competencia persistir(Competencia entidade) {
        return competenciaRepository.save(entidade);
    }

    @Override
    protected Collection<Competencia> obterTodos() {
        return competenciaRepository.findAll();
    }

    @Override
    protected Competencia obterPorId(Long id) {
        return competenciaService.procurarPorId(id.intValue());
    }
}

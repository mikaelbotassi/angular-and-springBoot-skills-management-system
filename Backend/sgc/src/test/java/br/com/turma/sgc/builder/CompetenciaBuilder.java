package br.com.turma.sgc.builder;

import br.com.turma.sgc.domain.Categoria;
import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.enums.CategoriaEnum;
import br.com.turma.sgc.repository.CompetenciaRepository;
import br.com.turma.sgc.service.CompetenciaService;
import br.com.turma.sgc.service.mapper.CompetenciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;

@Component
public class CompetenciaBuilder extends ConstrutorDeEntidade<Competencia>{

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Autowired
    private CompetenciaService competenciaService;

    @Autowired
    private CompetenciaMapper competenciaMapper;

    @Override
    protected Competencia construirEntidade() throws ParseException {
        Competencia competencia = new Competencia();
        competencia.setNome("Git");
        competencia.setDescricao("Versionamento de código");
        Categoria categoria = new Categoria(CategoriaEnum.ARQUITETURA);
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
        return competenciaMapper.toEntity(competenciaService.procurarPorId(id.intValue()));
    }
}

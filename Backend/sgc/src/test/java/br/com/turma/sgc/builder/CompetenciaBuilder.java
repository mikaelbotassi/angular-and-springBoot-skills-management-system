package br.com.turma.sgc.builder;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.enums.CategoriaEnum;
import br.com.turma.sgc.repository.CompetenciaRepository;
import br.com.turma.sgc.service.CompetenciaService;
import br.com.turma.sgc.service.dto.CategoriaDTO;
import br.com.turma.sgc.service.dto.CompetenciaDTO;
import br.com.turma.sgc.service.mapper.CompetenciaMapper;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;

@Component
public class CompetenciaBuilder extends ConstrutorDeEntidade<CompetenciaDTO>{

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Autowired
    private CompetenciaService competenciaService;

    @Autowired
    private CompetenciaMapper competenciaMapper;

    @Override
    public CompetenciaDTO construirEntidade() {
        CompetenciaDTO competencia = new CompetenciaDTO();
        competencia.setId(1);
        competencia.setNome("Git");
        competencia.setDescricao("Versionamento de código");
        competencia.setCategoria(new CategoriaDTO(1, "Backend"));
        return competencia;
    }

    @Override
    public CompetenciaDTO persistir(CompetenciaDTO entidade) {
        Competencia competencia = competenciaMapper.toEntity(entidade);
        return competenciaMapper.toDto(competenciaRepository.save(competencia));
    }

    @Override
    public Collection<CompetenciaDTO> obterTodos() {
        return competenciaMapper.toDto(competenciaRepository.findAll());
    }

    @Override
    public CompetenciaDTO obterPorId(Long id) {
        return competenciaService.procurarPorId(id.intValue());
    }
}

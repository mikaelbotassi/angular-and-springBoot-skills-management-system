package br.com.turma.sgc.builder;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.repository.CompetenciaRepository;
import br.com.turma.sgc.service.CompetenciaService;
import br.com.turma.sgc.service.dto.CategoriaDTO;
import br.com.turma.sgc.service.dto.Competencia.CompetenciaDTO;
import br.com.turma.sgc.service.mapper.CategoriaMapper;
import br.com.turma.sgc.service.mapper.CompetenciaMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CompetenciaBuilder extends ConstrutorDeEntidade<CompetenciaDTO>{

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Autowired
    private CompetenciaService competenciaService;

    @Autowired
    private CompetenciaMapper competenciaMapper;

    @Autowired
    private CategoriaBuilder categoriaBuilder;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @SneakyThrows
    @Override
    public CompetenciaDTO construirEntidade() {
        CompetenciaDTO competencia = new CompetenciaDTO();
        competencia.setId(1);
        competencia.setNome("Git");
        competencia.setDescricao("Versionamento de código");
        competencia.setCategoria(new CategoriaDTO(1) );
        return competencia;
    }

    @Override
    public CompetenciaDTO persistir(CompetenciaDTO entidade) {
        Competencia competencia = competenciaMapper.toEntity(entidade);
        competencia.setAtivo(true);
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

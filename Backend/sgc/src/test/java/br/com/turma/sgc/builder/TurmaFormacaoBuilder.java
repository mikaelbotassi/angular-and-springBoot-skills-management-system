package br.com.turma.sgc.builder;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.enums.CategoriaEnum;
import br.com.turma.sgc.repository.TurmaFormacaoRepository;
import br.com.turma.sgc.service.TurmaFormacaoService;
import br.com.turma.sgc.service.dto.CompetenciaDTO;
import br.com.turma.sgc.service.dto.TurmaFormacaoDTO;
import br.com.turma.sgc.service.mapper.TurmaFormacaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collection;

@Component
public class TurmaFormacaoBuilder extends ConstrutorDeEntidade<TurmaFormacaoDTO>{

    @Autowired
    private TurmaFormacaoRepository turmaFormacaoRepository;

    @Autowired
    private TurmaFormacaoService turmaFormacaoService;

    @Autowired
    private TurmaFormacaoMapper turmaFormacaoMapper;

    @Override
    public TurmaFormacaoDTO construirEntidade() {
        TurmaFormacaoDTO turmaFormacaoDTO = new TurmaFormacaoDTO();
        turmaFormacaoDTO.setId(1);
        turmaFormacaoDTO.setNome("turma git");
        turmaFormacaoDTO.setDescricao("Versionamento de código");
        turmaFormacaoDTO.setInicio(LocalDate.ofEpochDay(44459));
        turmaFormacaoDTO.setTermino(LocalDate.ofEpochDay(0));
        turmaFormacaoDTO.setStatusId(2);
        return turmaFormacaoDTO;
    }

    @Override
    public TurmaFormacaoDTO persistir(TurmaFormacaoDTO entidade) {
        TurmaFormacao competencia = turmaFormacaoMapper.toEntity(entidade);
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.save(competencia));
    }

    @Override
    public Collection<TurmaFormacaoDTO> obterTodos() {
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.findAll());
    }

    @Override
    public TurmaFormacaoDTO obterPorId(Long id) {
        return turmaFormacaoService.procurarPorId(id.intValue());
    }
}

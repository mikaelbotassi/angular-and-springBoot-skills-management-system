package br.com.turma.sgc.builder;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.TurmaColaboradorCompetenciaPK;
import br.com.turma.sgc.repository.TurmaColaboradorCompetenciaRepository;
import br.com.turma.sgc.service.TurmaFormacaoService;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorDTO;
import br.com.turma.sgc.service.dto.Competencia.CompetenciaDTO;
import br.com.turma.sgc.service.dto.Turma.TurmaColaboradorCompetenciaDTO;
import br.com.turma.sgc.service.dto.Turma.TurmaFormacaoDTO;
import br.com.turma.sgc.service.mapper.TurmaColaboradorCompetenciaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class TurmaColaboradorCompetenciaBuilder  extends ConstrutorDeEntidade<TurmaColaboradorCompetenciaDTO>{


    @Autowired
    private TurmaColaboradorCompetenciaMapper turmaColaboradorCompetenciaMapper;

    @Autowired
    private TurmaColaboradorCompetenciaRepository turmaColaboradorCompetenciaRepository;

    @Autowired
    private TurmaFormacaoService turmaFormacaoService;

    @Autowired
    private ColaboradorBuilder colaboradorBuilder;

    @Autowired
    private CompetenciaBuilder competenciaBuilder;

    @Autowired
    private TurmaFormacaoBuilder turmaFormacaoBuilder;


    @Override
    public TurmaColaboradorCompetenciaDTO construirEntidade() {
        ColaboradorDTO colaborador = colaboradorBuilder.persistir(colaboradorBuilder.construirEntidade());
        CompetenciaDTO competencia = competenciaBuilder.persistir(competenciaBuilder.construirEntidade());
        TurmaFormacaoDTO turma = turmaFormacaoBuilder.persistir(turmaFormacaoBuilder.construirEntidade());

        TurmaColaboradorCompetenciaDTO turmaColaboradorCompetenciaDTO = new TurmaColaboradorCompetenciaDTO();
        turmaColaboradorCompetenciaDTO.setColaboradorId(colaborador.getId());
        turmaColaboradorCompetenciaDTO.setCompetenciaId(competencia.getId());
        turmaColaboradorCompetenciaDTO.setTurmaId(turma.getId());

        return turmaColaboradorCompetenciaDTO;
    }

    @Override
    public TurmaColaboradorCompetenciaDTO persistir(TurmaColaboradorCompetenciaDTO entidade) {
        TurmaColaboradorCompetenciaPK turmaColaboradorCompetenciaPK = new TurmaColaboradorCompetenciaPK();
        turmaColaboradorCompetenciaPK.setIdCompetencia(entidade.getCompetenciaId());
        turmaColaboradorCompetenciaPK.setIdColaborador(entidade.getColaboradorId());
        turmaColaboradorCompetenciaPK.setIdTurmaFormacao(entidade.getTurmaId());
        TurmaColaboradorCompetencia turma = turmaColaboradorCompetenciaMapper.toEntity(entidade);
        turma.setId(turmaColaboradorCompetenciaPK);

        return turmaColaboradorCompetenciaMapper.toDto( turmaColaboradorCompetenciaRepository.save(turma) );
    }

    @Override
    public Collection<TurmaColaboradorCompetenciaDTO> obterTodos() {
        return turmaColaboradorCompetenciaMapper.toDto(turmaColaboradorCompetenciaRepository.findAll());
    }

    @Override
    protected TurmaColaboradorCompetenciaDTO obterPorId(Long id) {
        return null;
    }

}

package br.com.turma.sgc.builder;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.TurmaColaboradorCompetenciaPK;
import br.com.turma.sgc.repository.TurmaColaboradorCompetenciaRepository;
import br.com.turma.sgc.service.TurmaFormacaoService;
import br.com.turma.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
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


    @Override
    public TurmaColaboradorCompetenciaDTO construirEntidade() {
        TurmaColaboradorCompetenciaDTO turmaColaboradorCompetenciaDTO = new TurmaColaboradorCompetenciaDTO();
        turmaColaboradorCompetenciaDTO.setColaboradorId(1);
        turmaColaboradorCompetenciaDTO.setCompetenciaId(1);
        turmaColaboradorCompetenciaDTO.setTurmaId(1);

        return turmaColaboradorCompetenciaDTO;
    }

    @Override
    public TurmaColaboradorCompetenciaDTO persistir(TurmaColaboradorCompetenciaDTO entidade) {
        TurmaColaboradorCompetenciaPK turmaColaboradorCompetenciaPK = new TurmaColaboradorCompetenciaPK();
        turmaColaboradorCompetenciaPK.setIdCompetencia(entidade.getCompetenciaId());
        turmaColaboradorCompetenciaPK.setIdColaborador(entidade.getColaboradorId());
        turmaColaboradorCompetenciaPK.setIdTurmaFormacao(entidade.getTurmaId());
        TurmaColaboradorCompetencia turma = new TurmaColaboradorCompetencia();
        turma = turmaColaboradorCompetenciaMapper.toEntity(entidade);
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

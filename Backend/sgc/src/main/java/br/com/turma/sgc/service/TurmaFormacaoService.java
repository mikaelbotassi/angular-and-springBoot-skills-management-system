package br.com.turma.sgc.service;


import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.domain.pk.TurmaColaboradorCompetenciaPK;
import br.com.turma.sgc.repository.TurmaColaboradorCompetenciaRepository;
import br.com.turma.sgc.repository.TurmaFormacaoRepository;
import br.com.turma.sgc.service.dto.ColaboradorFuncaoTurmaDTO;
import br.com.turma.sgc.service.dto.InstrutorCompetenciaTurmaDTO;
import br.com.turma.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import br.com.turma.sgc.service.dto.TurmaFormacaoDTO;
import br.com.turma.sgc.service.mapper.ColaboradorFuncaoTurmaMapper;
import br.com.turma.sgc.service.mapper.InstrutorCompetenciaTurmaMapper;
import br.com.turma.sgc.service.mapper.TurmaColaboradorCompetenciaMapper;
import br.com.turma.sgc.service.mapper.TurmaFormacaoMapper;
import br.com.turma.sgc.service.resource.exception.RegraNegocioException;
import br.com.turma.sgc.utils.ConstantUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaFormacaoService {

    private final TurmaFormacaoRepository turmaFormacaoRepository;
    private final TurmaFormacaoMapper turmaFormacaoMapper;
    private final TurmaColaboradorCompetenciaRepository turmaColaboradorCompetenciaRepository;
    private final ColaboradorFuncaoTurmaMapper colaboradorFuncaoTurmaMapper;
    private final InstrutorCompetenciaTurmaMapper instrutorCompetenciaTurmaMapper;
    private final TurmaColaboradorCompetenciaMapper turmaColaboradorCompetenciaMapper;

    public List<TurmaFormacaoDTO> procurarTodos(){
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.findAll());
    }


    public TurmaFormacaoDTO procurarPorId(@Valid Integer id) throws RegraNegocioException{
        return turmaFormacaoMapper.toDto( turmaFormacaoRepository.findById(id).orElseThrow(()-> new RegraNegocioException(ConstantUtils.ERRO_ENCONTRAR_IDTURMA)));
    }

    public TurmaFormacaoDTO inserir(@Valid TurmaFormacaoDTO turma){
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.save(turmaFormacaoMapper.toEntity(turma)));
    }

    public void deletar(@Valid Integer id){
        if(!(turmaFormacaoRepository.findById(id).isPresent()))
            throw new RegraNegocioException(ConstantUtils.ERRO_ENCONTRAR_IDTURMA);

        if(!(turmaColaboradorCompetenciaRepository.procurarTodasTurmasPorIdTurma(id).isEmpty()))
            throw new RegraNegocioException("Essa turma está associada a um colaborador");

        turmaFormacaoRepository.deleteById(id);
    }

    public TurmaFormacaoDTO atualizar(@Valid TurmaFormacaoDTO turma){
        turmaFormacaoRepository.findById(turma.getId()).orElseThrow(() -> new RegraNegocioException(ConstantUtils.ERRO_ENCONTRAR_IDTURMA));
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.save(turmaFormacaoMapper.toEntity(turma)));
    }

    public List<TurmaFormacaoDTO> procurarTodosPorIdStatus(@Valid Integer id){
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.procurarTodosPorIdStatus(id));
    }

    public List<ColaboradorFuncaoTurmaDTO> procurarTodosAlunosPorIdTurma(@Valid Integer id){
        if (!(turmaFormacaoRepository.findById(id).isPresent()))
            throw new RegraNegocioException(ConstantUtils.ERRO_ENCONTRAR_IDTURMA);

        return colaboradorFuncaoTurmaMapper.toDto(turmaColaboradorCompetenciaRepository.procurarTodosAlunosPorIdTurma(id));
    }

    public List<ColaboradorFuncaoTurmaDTO> procurarTodosInstrutoresPorIdTurma(@Valid Integer id){
        if (!(turmaFormacaoRepository.findById(id).isPresent()))
            throw new RegraNegocioException(ConstantUtils.ERRO_ENCONTRAR_IDTURMA);

        return colaboradorFuncaoTurmaMapper.toDto(turmaColaboradorCompetenciaRepository.procurarTodosInstrutoresPorIdTurma(id));
    }

    public List<InstrutorCompetenciaTurmaDTO> procurarTodosInstrutoresCompetenciaPorIdTurma (@Valid Integer id){
        if(!(turmaFormacaoRepository.findById(id).isPresent()))
            throw new RegraNegocioException(ConstantUtils.ERRO_ENCONTRAR_IDTURMA);

        return instrutorCompetenciaTurmaMapper.toDto(turmaColaboradorCompetenciaRepository.procurarTodosInstrutoresPorIdTurma(id));
    }

    public List<TurmaFormacaoDTO> buscarTurmaAndamento(){
        List<TurmaFormacao> turmas = turmaFormacaoRepository.buscarTurmaAndamento();
        return turmaFormacaoMapper.toDto(turmas);
    }

    public List<TurmaFormacaoDTO> buscaTurmaFinalizada() {
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.buscaTurmaFinalizada());
    }

    public List<TurmaFormacaoDTO> buscarTodasTurmasPorIntervalo(String inicio, String fim){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataInicio = LocalDate.parse(inicio, formatter);
        LocalDate dataFim = LocalDate.parse(fim, formatter);

        if (dataFim.isBefore(dataInicio))
            throw new RegraNegocioException("DATA INVÁLIDA: A data de inicio deve preceder a data de fim");

        List<TurmaFormacao> turmas = turmaFormacaoRepository.buscarTodasTurmasPorIntervalo(dataInicio, dataFim);
        return turmaFormacaoMapper.toDto(turmas);
    }

    public TurmaColaboradorCompetenciaDTO inserirColaboradorTurma(TurmaColaboradorCompetenciaDTO turmaColaboradorCompetenciaDTO){
        TurmaColaboradorCompetenciaPK turmaColaboradorCompetenciaPK = new TurmaColaboradorCompetenciaPK();
        turmaColaboradorCompetenciaPK.setIdTurmaFormacao(turmaColaboradorCompetenciaDTO.getTurmaId());
        turmaColaboradorCompetenciaPK.setIdColaborador(turmaColaboradorCompetenciaDTO.getColaboradorId());
        turmaColaboradorCompetenciaPK.setIdCompetencia(turmaColaboradorCompetenciaDTO.getCompetenciaId());
        TurmaColaboradorCompetencia turmaColaboradorCompetencia =turmaColaboradorCompetenciaMapper.toEntity(turmaColaboradorCompetenciaDTO);
        turmaColaboradorCompetencia.setId(turmaColaboradorCompetenciaPK);
          return turmaColaboradorCompetenciaMapper
                  .toDto(turmaColaboradorCompetenciaRepository
                  .save(turmaColaboradorCompetencia));
    }

}

package br.com.turma.sgc.service;


import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.domain.pk.ColaboradorCompetenciaPK;
import br.com.turma.sgc.domain.pk.TurmaColaboradorCompetenciaPK;
import br.com.turma.sgc.repository.ColaboradorCompetenciaRepository;
import br.com.turma.sgc.repository.TurmaColaboradorCompetenciaRepository;
import br.com.turma.sgc.repository.TurmaFormacaoRepository;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorCompetenciaDTO;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorFuncaoTurmaDTO;
import br.com.turma.sgc.service.dto.Colaborador.InstrutorCompetenciaTurmaDTO;
import br.com.turma.sgc.service.dto.Turma.TurmaColaboradorCompetenciaDTO;
import br.com.turma.sgc.service.dto.Turma.TurmaColaboradorCompetenciaNivelDTO;
import br.com.turma.sgc.service.dto.Turma.TurmaFormacaoDTO;
import br.com.turma.sgc.service.mapper.*;
import br.com.turma.sgc.service.resource.exception.RegraNegocioException;
import br.com.turma.sgc.utils.ConstantUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final TurmaColaboradorCompetenciaNivelMapper turmaColaboradorCompetenciaNivelMapper;
    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;
    private final ColaboradorCompetenciaMapper colaboradorCompetenciaMapper;

    public List<TurmaFormacaoDTO> procurarTodos(){
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.buscaTodosAtivos());
    }


    public TurmaFormacaoDTO procurarPorId( Integer id) throws RegraNegocioException{
        return turmaFormacaoMapper.toDto( turmaFormacaoRepository.findById(id).orElseThrow(()-> new RegraNegocioException(ConstantUtils.ERRO_ENCONTRAR_IDTURMA)));
    }

    public TurmaFormacaoDTO inserir( TurmaFormacaoDTO turma){
        TurmaFormacao turmat = turmaFormacaoMapper.toEntity(turma);
        turmat.setAtivo(true);
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository
                .save(turmat));
    }

    @Transactional
    public void deletar( Integer id){
        turmaFormacaoRepository.desativarTurma(id);
    }

    public TurmaFormacaoDTO atualizar( TurmaFormacaoDTO turma){
        procurarPorId(turma.getId());
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.save(turmaFormacaoMapper.toEntity(turma)));
    }

    public List<TurmaFormacaoDTO> procurarTodosPorIdStatus( Integer id){
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.procurarTodosPorIdStatus(id));
    }

    public List<ColaboradorFuncaoTurmaDTO> procurarTodosAlunosPorIdTurma(Integer id){
        procurarPorId(id);
        return colaboradorFuncaoTurmaMapper.toDto(turmaColaboradorCompetenciaRepository.procurarTodosAlunosPorIdTurma(id));
    }

    public List<ColaboradorFuncaoTurmaDTO> procurarTodosInstrutoresPorIdTurma( Integer id){
        procurarPorId(id);
        return colaboradorFuncaoTurmaMapper.toDto(turmaColaboradorCompetenciaRepository.procurarTodosInstrutoresPorIdTurma(id));
    }

    public List<InstrutorCompetenciaTurmaDTO> procurarTodosInstrutoresCompetenciaPorIdTurma (Integer id){
        procurarPorId(id);
        return instrutorCompetenciaTurmaMapper.toDto(turmaColaboradorCompetenciaRepository.procurarTodosInstrutoresPorIdTurma(id));
    }

    public List<TurmaFormacaoDTO> buscarTurmaAndamento(){
        return turmaFormacaoMapper.toDto( turmaFormacaoRepository.buscarTurmaAndamento());
    }

    public List<TurmaFormacaoDTO> buscaTurmaFinalizada() {
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.buscaTurmaFinalizada());
    }

    public TurmaColaboradorCompetenciaDTO inserirColaboradorTurma(TurmaColaboradorCompetenciaDTO turmaColaboradorCompetenciaDTO){
        TurmaColaboradorCompetenciaPK turmaColaboradorCompetenciaPK = new TurmaColaboradorCompetenciaPK(turmaColaboradorCompetenciaDTO.getTurmaId(),turmaColaboradorCompetenciaDTO.getColaboradorId(),turmaColaboradorCompetenciaDTO.getCompetenciaId());
        TurmaColaboradorCompetencia turmaColaboradorCompetencia =turmaColaboradorCompetenciaMapper.toEntity(turmaColaboradorCompetenciaDTO);
        turmaColaboradorCompetencia.setId(turmaColaboradorCompetenciaPK);
          return turmaColaboradorCompetenciaMapper
                  .toDto(turmaColaboradorCompetenciaRepository
                  .save(turmaColaboradorCompetencia));
    }

    public List<TurmaColaboradorCompetenciaNivelDTO> procurarColaboradorCompetenciaEmTurma(Integer id){
        return turmaColaboradorCompetenciaNivelMapper.toDto(turmaColaboradorCompetenciaRepository.procurarColaboradorCompetenciaPorTurma(id));
    }

    public List<TurmaColaboradorCompetenciaNivelDTO> listarColaboradorCompetencia(){
        return  turmaColaboradorCompetenciaNivelMapper.toDto(colaboradorCompetenciaRepository.findAll());
    }

    public TurmaColaboradorCompetenciaNivelDTO procurarNivelColaboradorCompetencia(Integer colaboradorId, Integer competenciaId){
        return turmaColaboradorCompetenciaNivelMapper.toDto( colaboradorCompetenciaRepository.buscarColaboradorCompetenciaPorIdColaboradorIdCompetencia(competenciaId, colaboradorId));
    }

    public void deletarTurmaColaboradorCompetencia(Integer turmaId, Integer colaboradorId, Integer competenciaId){
        TurmaColaboradorCompetenciaPK turmaColaboradorCompetenciaPK = new TurmaColaboradorCompetenciaPK(turmaId, colaboradorId, competenciaId);
         turmaColaboradorCompetenciaRepository.deleteById(turmaColaboradorCompetenciaPK);
    }

    public void subirNivelColaboradorCompetencia (List<TurmaColaboradorCompetenciaNivelDTO> turmaColaboradorCompetenciaNivelDTO){
        turmaColaboradorCompetenciaNivelDTO.forEach(turmaColaboradorCompetenciaNivel -> {
            if(turmaColaboradorCompetenciaNivel.getNivel() != 3){
                colaboradorCompetenciaRepository.aumentarNivelColaboradorCompetencia(turmaColaboradorCompetenciaNivel.getColaboradorId(),turmaColaboradorCompetenciaNivel.getCompetenciaId());
            }
        });


    }

    public ColaboradorCompetenciaDTO inserirColaboradorCompetenciaZero(Integer colaboradorId, Integer competenciaId){
        ColaboradorCompetenciaPK pk = new ColaboradorCompetenciaPK(colaboradorId, competenciaId);
        ColaboradorCompetenciaDTO colaboradorCompetenciaDTO = new ColaboradorCompetenciaDTO(pk,colaboradorId,competenciaId,0);
        return colaboradorCompetenciaMapper.toDto(colaboradorCompetenciaRepository.save(colaboradorCompetenciaMapper.toEntity(colaboradorCompetenciaDTO)));
    }

    public TurmaColaboradorCompetenciaDTO procurarTurmaColaboradorCompetenciaPorId(Integer colaboradorId, Integer competenciaId, Integer turmaId){
        TurmaColaboradorCompetenciaPK pk = new TurmaColaboradorCompetenciaPK(turmaId,colaboradorId,competenciaId);
        return turmaColaboradorCompetenciaMapper.toDto(turmaColaboradorCompetenciaRepository.findById(pk).orElseThrow(()-> new RegraNegocioException("nao encontrado")));
    }

}

package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.TurmaColaboradorCompetenciaPK;
import br.com.turma.sgc.repository.TurmaColaboradorCompetenciaRepository;
import br.com.turma.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import br.com.turma.sgc.service.mapper.TurmaColaboradorCompetenciaMapper;
import br.com.turma.sgc.service.resource.exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TurmaColaboradorCompetenciaService {

    private final TurmaColaboradorCompetenciaRepository turmaColaboradorCompetenciaRepository;
    private final TurmaColaboradorCompetenciaMapper mapper;

    public List<TurmaColaboradorCompetenciaDTO> procurarTodos() {
        List<TurmaColaboradorCompetencia> colaboradorCompetencias = turmaColaboradorCompetenciaRepository.findAll();
        return mapper.toDto(colaboradorCompetencias);
    }

    public TurmaColaboradorCompetenciaDTO procurarPorId(int idTurma, int idColaborador, int idCompetencia){
        Optional<TurmaColaboradorCompetencia> obj = turmaColaboradorCompetenciaRepository.findById(new TurmaColaboradorCompetenciaPK(idTurma, idColaborador, idCompetencia));
        return mapper.toDto(obj.orElseThrow(()->new RegraNegocioException("Disciplina não existe")));

    }

    public List<TurmaColaboradorCompetenciaDTO> procurarTodosPorIdTurma(Integer idTurma){
        List<TurmaColaboradorCompetencia> entitys = turmaColaboradorCompetenciaRepository.procurarTodosPorIdTurma(idTurma);
        return mapper.toDto(entitys);
    }

    public List<TurmaColaboradorCompetenciaDTO> procurarTodosPorIdColaborador(Integer idColaborador){
        List<TurmaColaboradorCompetencia> entitys = turmaColaboradorCompetenciaRepository.procurarTodosPorIdColaborador(idColaborador);
        return mapper.toDto(entitys);
    }

    public List<TurmaColaboradorCompetenciaDTO> procurarTodosPorIdCompetencia(Integer idCompetencia){
        List<TurmaColaboradorCompetencia> entitys = turmaColaboradorCompetenciaRepository.procurarTodosPorIdCompetencia(idCompetencia);
        return mapper.toDto(entitys);
    }

    /*
    public TurmaColaboradorCompetencia inserirPorPK(TurmaColaboradorCompetenciaPK pk){
        return new TurmaColaboradorCompetencia(pk, turmaFormacaoService.procurarPorId(pk.getIdTurmaFormacao()),
                colaboradorService.procurarPorId(pk.getIdColaborador()), competenciaService.procurarPorId(pk.getIdCompetencia()));
    }

    public TurmaColaboradorCompetencia inserir(TurmaColaboradorCompetenciaPK turmaColaboradorCompetenciaPK){

        TurmaColaboradorCompetencia novo = inserirPorPK(turmaColaboradorCompetenciaPK);

        return turmaColaboradorCompetenciaRepository.save(novo);
    }


    public void deletar(int idTurma, int idColaborador, int idCompetencia) {
        turmaColaboradorCompetenciaRepository.deleteById(new TurmaColaboradorCompetenciaPK(idTurma, idColaborador, idCompetencia));
    }*/
}

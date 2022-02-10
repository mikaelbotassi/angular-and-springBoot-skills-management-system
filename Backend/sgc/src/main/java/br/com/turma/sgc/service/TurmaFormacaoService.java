package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.repository.TurmaColaboradorCompetenciaRepository;
import br.com.turma.sgc.repository.TurmaFormacaoRepository;
import br.com.turma.sgc.service.dto.TurmaFormacaoDTO;
import br.com.turma.sgc.service.mapper.TurmaFormacaoMapper;
import br.com.turma.sgc.service.resource.exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaFormacaoService {

    private final TurmaFormacaoRepository repository;
    private final TurmaFormacaoMapper mapper;
    private final TurmaColaboradorCompetenciaRepository turmaColaboradorCompetenciaRepository;

    public List<TurmaFormacaoDTO> procurarTodos(){
        return mapper.toDto(repository.findAll());

    }


    public TurmaFormacaoDTO procurarPorId(@Valid Integer id){
        return mapper.toDto( repository.findById(id).orElseThrow(()-> new RegraNegocioException("turma nao encontrada")));
    }

    public TurmaFormacaoDTO inserir(@Valid TurmaFormacaoDTO turma){
        return mapper.toDto(repository.save(mapper.toEntity(turma)));
    }

    public void deletar(@Valid Integer id){
        TurmaFormacao turma = repository.findById(id).orElseThrow(() -> new RegraNegocioException("turma nao existe"));
        if(!(turmaColaboradorCompetenciaRepository.procurarTodosPorIdTurma(turma.getId()).isEmpty()))
            throw new RegraNegocioException("Essa turma está associada a um colaborador");
        repository.deleteById(id);
    }

    public TurmaFormacaoDTO atualizar(@Valid TurmaFormacaoDTO turma){
        return mapper.toDto(repository.save(mapper.toEntity(turma)));
    }

    public List<TurmaFormacaoDTO> procurarTodosPorIdStatus(@Valid Integer id){
        return mapper.toDto(repository.procurarTodosPorIdStatus(id));
    }

}

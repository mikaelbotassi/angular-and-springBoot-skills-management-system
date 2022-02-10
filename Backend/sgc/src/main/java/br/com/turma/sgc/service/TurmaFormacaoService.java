package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.repository.TurmaFormacaoRepository;
import br.com.turma.sgc.service.dto.TurmaFormacaoDTO;
import br.com.turma.sgc.service.mapper.TurmaFormacaoMapper;
import br.com.turma.sgc.service.resource.exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.Validation;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TurmaFormacaoService {

    private final TurmaFormacaoRepository repository;
    private final TurmaFormacaoMapper mapper;

    public List<TurmaFormacaoDTO> procurarTodos(){
        return mapper.toDto(repository.findAll());
    }


    public TurmaFormacaoDTO procurarPorId(@Valid Integer id){
        return mapper.toDto( repository.findById(id).orElseThrow(()-> new RegraNegocioException("nao encontrado")));
    }

    public TurmaFormacaoDTO inserir(@Valid TurmaFormacaoDTO turma){
        return mapper.toDto(repository.save(mapper.toEntity(turma)));
    }

    public void deletar(@Valid Integer id){
        repository.deleteById(id);
    }

    public TurmaFormacaoDTO atualizar(@Valid TurmaFormacaoDTO turma){
        return mapper.toDto(repository.save(mapper.toEntity(turma)));
    }

    public List<TurmaFormacaoDTO> procurarTodosPorIdStatus(@Valid Integer id){
        return mapper.toDto(repository.procurarTodosPorIdStatus(id));
    }

}

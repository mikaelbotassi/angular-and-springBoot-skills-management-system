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


    public TurmaFormacaoDTO procurarPorId(@Valid int id){
//        Optional<TurmaFormacao> obj = repository.findById(id);
//        obj.orElseThrow(()-> new RegraNegocioException("não encontrado"));
//        return mapper.toDto(obj.get());
        return mapper.toDto( repository.findById(id).orElseThrow(()-> new RegraNegocioException("nao encontrado")));
    }

    public TurmaFormacaoDTO inserir(@Valid TurmaFormacao turma){
        return mapper.toDto(repository.save(turma));
    }

    public void deletar(@Valid int id){
        repository.deleteById(id);
    }

    public TurmaFormacaoDTO atualizar(@Valid TurmaFormacao turma){
        return mapper.toDto(repository.save(turma));
    }

}

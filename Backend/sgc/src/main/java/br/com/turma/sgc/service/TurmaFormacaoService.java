package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.repository.TurmaFormacaoRepository;
import br.com.turma.sgc.service.dto.TurmaFormacaoDTO;
import br.com.turma.sgc.service.mapper.TurmaFormacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public TurmaFormacaoDTO procurarPorId(int id){
        Optional<TurmaFormacao> obj = repository.findById(id);
        if(obj.isPresent())
            return mapper.toDto(obj.get());
        else
            throw new NoSuchElementException("Turma não encontrado!");
    }

    public TurmaFormacaoDTO inserir(TurmaFormacao turma){
        return mapper.toDto(repository.save(turma));
    }

    public void deletar(int id){
        repository.deleteById(id);
    }

    public TurmaFormacaoDTO atualizar(TurmaFormacao turma){
        return mapper.toDto(repository.save(turma));
    }

}

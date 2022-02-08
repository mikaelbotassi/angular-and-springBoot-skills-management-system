package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.repository.TurmaFormacaoRepository;
import br.com.turma.sgc.service.dto.TurmaFormacaoDTO;
import br.com.turma.sgc.service.entity.TurmaFormacaoMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Mapper
@Service
@RequiredArgsConstructor
public class TurmaFormacaoService {

    private final TurmaFormacaoRepository repository;

    private final TurmaFormacaoMapper mapper;




    public List<TurmaFormacaoDTO> procurarTodos(){
        return mapper.toDto(repository.findAll());
    }

    public Optional<TurmaFormacao> procurarPorId(int id){
        Optional<TurmaFormacao> obj = repository.findById(id);
        if(obj.isPresent())
            return obj;
        else
            throw new NoSuchElementException("Turma não encontrado!");
    }

    public TurmaFormacao inserir(TurmaFormacao turma){
        return repository.save(turma);
    }

    public void deletar(int id){
        repository.deleteById(id);
    }

    public TurmaFormacao atualizar(TurmaFormacao turma){
        return repository.save(turma);
    }

}

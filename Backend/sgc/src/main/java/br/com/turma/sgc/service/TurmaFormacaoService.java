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
    private TurmaFormacaoMapper turmaFormacaoMapper;

    public List<TurmaFormacao> procurarTodos() {
        return repository.findAll();
    }

    public TurmaFormacao procurarPorId(int id) {
        Optional<TurmaFormacao> obj = repository.findById(id);
        if (obj.isPresent())
            return obj.get();
        else
            throw new NoSuchElementException("Turma não encontrado!");
    }

    public TurmaFormacao inserir(TurmaFormacao turma) {
        return repository.save(turma);
    }

    public void deletar(int id) {
        repository.deleteById(id);
    }

    public TurmaFormacao atualizar(TurmaFormacao turma) {
        return repository.save(turma);
    }

    public List<TurmaFormacaoDTO> buscarContemColaborador(Integer idColaborador) {
        return turmaFormacaoMapper.toDto(repository.buscarContemColaborador(idColaborador));
    }

    public List<TurmaFormacaoDTO> queryTurmaFormacaoIniciada() {
        return turmaFormacaoMapper.toDto(repository.queryTurmaFormacaoIniciada());
    }
}

package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.dto.TurmaFormacaoDTO;
import br.com.turma.sgc.repository.TurmaColaboradorCompetenciaRepository;
import br.com.turma.sgc.repository.TurmaFormacaoRepository;
import br.com.turma.sgc.service.mapper.TurmaFormacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TurmaFormacaoService {

    private final TurmaFormacaoRepository turmaFormacaoRepository;
    private final TurmaFormacaoMapper turmaFormacaoMapper;

    public List<TurmaFormacao> procurarTodos() {
        return turmaFormacaoRepository.findAll();
    }

    public TurmaFormacao procurarPorId(int id) {
        Optional<TurmaFormacao> obj = turmaFormacaoRepository.findById(id);
        if (obj.isPresent())
            return obj.get();
        else
            throw new NoSuchElementException("Turma não encontrado!");
    }

    public TurmaFormacao inserir(TurmaFormacao turma) {
        return turmaFormacaoRepository.save(turma);
    }

    public void deletar(int id) {
        turmaFormacaoRepository.deleteById(id);
    }

    public TurmaFormacao atualizar(TurmaFormacao turma) {
        return turmaFormacaoRepository.save(turma);
    }

    public List<TurmaFormacaoDTO> queryTurmaFormacaoIniciada() {
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.queryTurmaFormacaoIniciada());
    }

    public List<TurmaFormacaoDTO> buscarContemColaborador(Integer idColaborador) {
        return turmaFormacaoMapper.toDto(turmaFormacaoRepository.buscarContemColaborador(idColaborador));
    }
}

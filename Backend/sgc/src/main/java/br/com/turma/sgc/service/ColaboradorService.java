package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.repository.ColaboradorRepository;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
import br.com.turma.sgc.service.mapper.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository repository;
    private ColaboradorMapper colaboradorMapper;

    public List<Colaborador> procurarTodos() {
        return repository.findAll();
    }

    public Colaborador procurarPorId(int id) {
        Optional<Colaborador> obj = repository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            throw new NoSuchElementException("Elemento não encontrado!");
        }

    }

    public Colaborador inserir(Colaborador colab) {
        return repository.save(colab);
    }

    public void deletar(int id) {
        repository.deleteById(id);
    }

    public Colaborador atualizar(Colaborador c) {
        return repository.save(c);
    }

    public List<ColaboradorDTO> procurarPorSenioridadeId(Integer idSenioridade) {
        return colaboradorMapper.toDto(repository.procurarPorSenioridadeId(idSenioridade));
    }
}

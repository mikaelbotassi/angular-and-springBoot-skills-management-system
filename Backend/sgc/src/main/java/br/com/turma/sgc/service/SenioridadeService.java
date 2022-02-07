package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Senioridade;
import br.com.turma.sgc.repository.SenioridadeRepository;
import com.sun.tools.javac.util.List;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class SenioridadeService {

    private final SenioridadeRepository repository;

    public List<Senioridade> procurarTodos() {
        return (List<Senioridade>) repository.findAll();
    }

    public Senioridade procurarPorId(int id) {
        Optional<Senioridade> obj = repository.findById(id);
        return obj.get();
    }
}

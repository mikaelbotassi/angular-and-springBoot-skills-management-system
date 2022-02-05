package br.com.turma.sgc.services;

import br.com.turma.sgc.domain.TurmaFormacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class TurmaFormacaoService {
    @Autowired
    private TurmaFormacao turmaFormacao;

    public void save(String nome, String descricao, Integer diciplinas_instrutores, Date inicio, Date termino, Integer status) {
    }

    public List<TurmaFormacao> getTurmaFormacao() {
    }

    public void update(Integer id, String nome, String descricao, Integer diciplinas_instrutores, Date inicio, Date termino, Integer status) {
    }

    public void delete(Integer id) {
    }
}

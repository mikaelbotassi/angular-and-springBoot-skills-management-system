package br.com.turma.sgc.services;

import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.repository.TurmaFormacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TurmaFormacaoService {
    @Autowired
    private TurmaFormacaoRepository turmaFormacaoRepository;

    public void save(String nome, String descricao, Integer diciplinas_instrutores, String inicio, String termino, Integer status) throws ParseException {
        TurmaFormacao turmaFormacao = new TurmaFormacao();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        turmaFormacao.setNome(nome);
        turmaFormacao.setDescricao(descricao);
        turmaFormacao.setDiciplinas_instrutores(diciplinas_instrutores);
        turmaFormacao.setInicio(dateFormat.parse(inicio));
        turmaFormacao.setTermino(dateFormat.parse(termino));
        turmaFormacao.setStatus(status);

        this.turmaFormacaoRepository.save(turmaFormacao);
    }

    public List<TurmaFormacao> getTurmaFormacao() {
        return turmaFormacaoRepository.findAll();
    }

    public void update(Integer id, String nome, String descricao, Integer diciplinas_instrutores, String inicio, String termino, Integer status) throws ParseException {
        TurmaFormacao turmaFormacao = this.turmaFormacaoRepository.findById(id).orElse(null);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        turmaFormacao.setNome(nome);
        turmaFormacao.setDescricao(descricao);
        turmaFormacao.setDiciplinas_instrutores(diciplinas_instrutores);
        turmaFormacao.setInicio(dateFormat.parse(inicio));
        turmaFormacao.setTermino(dateFormat.parse(termino));
        turmaFormacao.setStatus(status);

        this.turmaFormacaoRepository.save(turmaFormacao);
    }

    public void delete(Integer id) {
        this.turmaFormacaoRepository.deleteById(id);
    }

    public TurmaFormacao findById(Integer id) {
        return turmaFormacaoRepository.findById(id).orElse(null);
    }
}

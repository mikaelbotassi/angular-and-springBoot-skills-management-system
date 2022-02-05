package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.repository.ColaboradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository repository;

    public List<Colaborador> findAll(){
        return repository.findAll();
    }

    public Colaborador findById(int id){
        Optional<Colaborador> obj = repository.findById(id);
        return obj.get();
    }

    public Colaborador insert(Colaborador colab){
        return repository.save(colab);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public Colaborador update(int id, Colaborador c){
        Colaborador orig = repository.getById(id);
        c = updateDatta(orig, c);
        return repository.save(c);
    }

    private Colaborador updateDatta(Colaborador orig, Colaborador c) {
        orig.setNomeColaborador(c.getNomeColaborador());
        orig.setSobrenomeColaborador(c.getSobrenomeColaborador());
        orig.setCpf(c.getCpf());
        orig.setEmail(c.getEmail());
        orig.setFoto(c.getFoto());
        orig.setDataAdmissao(c.getDataAdmissao());
        orig.setDataNascimento(c.getDataNascimento());
        return orig;
    }

}

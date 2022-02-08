package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.repository.CompetenciaRepository;
import br.com.turma.sgc.service.dto.CompetenciaDTO;
import br.com.turma.sgc.service.mapper.CompetenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompetenciaService {
    private final CompetenciaRepository repository;
    private final CompetenciaMapper competenciaMapper;

    public List<CompetenciaDTO> procurarTodos(){
        List<Competencia> competencias = repository.findAll();
        return competenciaMapper.toDto(competencias);
    }

    public Competencia procurarPorId(Integer id){
        Optional<Competencia> obj = repository.findById(id);
        if(obj.isPresent())
            return obj.get();
        else
            throw new NoSuchElementException("Elemento não encontrado!");
    }

    public void inserir(CompetenciaDTO dto){

        repository.save(competenciaMapper.toEntity(dto));

    }

    public Competencia atualizar(Competencia competencia){

        return repository.save(competencia);

    }

    public void deletar(Integer id){

        repository.deleteById(id);

    }

}

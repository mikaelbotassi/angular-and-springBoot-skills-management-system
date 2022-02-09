package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.dto.CompetenciaDTO;
import br.com.turma.sgc.repository.CompetenciaRepository;
import br.com.turma.sgc.service.mapper.CompetenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CompetenciaService {
    @Autowired
    private final CompetenciaRepository competenciaRepository;
    private final CompetenciaMapper competenciaMapper;

    public List<CompetenciaDTO> procurarTodos() {
        return competenciaMapper.toDto(competenciaRepository.findAll());
    }

    public CompetenciaDTO procurarPorId(Integer id) {
        Competencia competencia = competenciaRepository
                .findById(id)
                .orElseThrow(
                        () -> new NoSuchElementException("Elemento não encontrado!")
                );
        return competenciaMapper.toDto(competencia);
    }

    public CompetenciaDTO inserir(Competencia competencia) {
        return competenciaMapper.toDto(
                competenciaRepository.save(competencia)
        );
    }

    public CompetenciaDTO atualizar(Competencia competencia) {
        return competenciaMapper.toDto(
                competenciaRepository.save(competencia)
        );
    }

    public void deletar(Integer id) {
        competenciaRepository.deleteById(id);
    }

}

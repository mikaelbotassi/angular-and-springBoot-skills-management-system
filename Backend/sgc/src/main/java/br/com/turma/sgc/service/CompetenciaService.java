package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.dto.CompetenciaDTO;
import br.com.turma.sgc.repository.ColaboradorCompetenciaRepository;
import br.com.turma.sgc.repository.CompetenciaRepository;
import br.com.turma.sgc.service.mapper.CompetenciaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CompetenciaService {

    private final CompetenciaRepository competenciaRepository;
    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;
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
        if(!(competenciaRepository.findById(competencia.getId()).isPresent()))
            throw new NoSuchElementException("Competência não encontrada");
        return competenciaMapper.toDto(
                competenciaRepository.save(competencia)
        );
    }

    public List<CompetenciaDTO> buscarCompetenciasPorNivelEPorIdColaborador(Integer idColaborador, Integer idNivel){
        return competenciaMapper.toDto(
                colaboradorCompetenciaRepository.buscarCompetenciasMaximasPorIdColaborador(idColaborador, idNivel)
        );
    }

    public void deletar(Integer id) {
        competenciaRepository.deleteById(id);
    }

}

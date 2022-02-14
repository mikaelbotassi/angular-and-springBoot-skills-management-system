package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.repository.ColaboradorCompetenciaRepository;
import br.com.turma.sgc.service.dto.CompetenciaDTO;
import br.com.turma.sgc.repository.CompetenciaRepository;
import br.com.turma.sgc.service.mapper.CompetenciaMapper;
import br.com.turma.sgc.service.resource.exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CompetenciaService {

    private final CompetenciaRepository competenciaRepository;
    private final CompetenciaMapper competenciaMapper;

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    public List<CompetenciaDTO> procurarTodos() {
        return competenciaMapper.toDto(competenciaRepository.findAll());
    }

    public CompetenciaDTO procurarPorId(Integer id) {
        Competencia competencia = competenciaRepository
                .findById(id)
                .orElseThrow(
                        () -> new RegraNegocioException("Competencia Não Encontrada!")
                );
        return competenciaMapper.toDto(competencia);
    }

    public CompetenciaDTO inserir(CompetenciaDTO competenciaDTO) {
        return competenciaMapper.toDto(
                competenciaRepository.save(
                        competenciaMapper.toEntity(competenciaDTO)
                )
        );
    }

    public CompetenciaDTO atualizar(CompetenciaDTO competenciaDTO) {
        competenciaRepository
                .findById(competenciaDTO.getId())
                .orElseThrow(
                        () -> new RegraNegocioException("Competencia Não Encontrada!")
                );
        return competenciaMapper.toDto(
                competenciaRepository.save(
                        competenciaMapper.toEntity(competenciaDTO)
                )
        );
    }

    public void deletar(Integer id) {
        competenciaRepository.deleteById(id);
    }

    public List<CompetenciaDTO> buscarCompetenciasPorNivelEPorIdColaborador(Integer idColaborador, Integer idNivel) {
        List<Competencia> competencias = colaboradorCompetenciaRepository.buscarCompetenciasPorNivelEPorIdColaborador(idColaborador, idNivel);
        return competenciaMapper.toDto(competencias);
    }
}

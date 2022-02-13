package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.repository.*;
import br.com.turma.sgc.service.dto.CompetenciaDTO;
import br.com.turma.sgc.service.mapper.CompetenciaMapper;
import br.com.turma.sgc.utils.ConstantUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CompetenciaService {

    private final CompetenciaRepository competenciaRepository;

    private final TurmaFormacaoRepository turmaFormacaoRepository;

    private final ColaboradorRepository colaboradorRepository;

    private final CompetenciaMapper competenciaMapper;

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    private final TurmaColaboradorCompetenciaRepository turmaColaboradorCompetenciaRepository;

    public List<CompetenciaDTO> procurarTodos() {
        return competenciaMapper.toDto(competenciaRepository.findAll());
    }

    public CompetenciaDTO procurarPorId(Integer id) {
        return competenciaMapper.toDto(competenciaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Elemento não encontrado!")));
    }

    public CompetenciaDTO inserir(CompetenciaDTO competenciaDTO) {
        return competenciaMapper.toDto(competenciaRepository.save(competenciaMapper.toEntity(competenciaDTO)));
    }

    public CompetenciaDTO atualizar(CompetenciaDTO competencia) {
        if(!(competenciaRepository.findById(competencia.getId()).isPresent()))
            throw new NoSuchElementException("Competência não encontrada");
        return competenciaMapper.toDto(competenciaRepository.save(competenciaMapper.toEntity(competencia)));
    }

    public void deletar(Integer id) {
        competenciaRepository.deleteById(id);
    }

    public List<CompetenciaDTO> buscarCompetenciasPorNivelEPorIdColaborador(Integer idColaborador, Integer idNivel) {
        List<Competencia> competencias = colaboradorCompetenciaRepository.buscarCompetenciasPorNivelEPorIdColaborador(idColaborador,idNivel);
        return competenciaMapper.toDto(competencias);
    }

//    public List<CompetenciaDTO> buscarCompetenciaPorCategoria(Integer categoriaId) {
//        List<Competencia> competencias = competenciaRepository.buscarCompetenciaPorCategoria(categoriaId);
//        return competenciaMapper.toDto(competencias);
//    }

    public List<CompetenciaDTO> pegarTodasCompetenciasDoColaboradorNaTurma(Integer idTurma, Integer idColaborador){
        if(!(turmaFormacaoRepository.findById(idTurma).isPresent()))
            throw new NoSuchElementException(ConstantUtils.ERRO_ENCONTRAR_IDTURMA);

        if(!(colaboradorRepository.findById(idColaborador).isPresent()))
            throw new NoSuchElementException(ConstantUtils.ERRO_ENCONTRAR_IDCOLABORADOR);

        if(!(turmaColaboradorCompetenciaRepository.procurarPorIdColaboradorTurma(idTurma, idColaborador).isPresent()))
            throw new NoSuchElementException(ConstantUtils.ERRO_ENCONTRAR_IDCOLABORADOR);

        return competenciaMapper.toDto(turmaColaboradorCompetenciaRepository.pegarTodasCompetenciasDoColaboradorNaTurma(idTurma, idColaborador));

    }
}

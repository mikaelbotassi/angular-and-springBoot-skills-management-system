package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.repository.*;
import br.com.turma.sgc.service.dto.Competencia.CadastrarCompetenciaDTO;
import br.com.turma.sgc.service.dto.Competencia.CompetenciaDTO;
import br.com.turma.sgc.service.mapper.CompetenciaMapper;
import br.com.turma.sgc.service.resource.exception.RegraNegocioException;
import br.com.turma.sgc.utils.ConstantUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class CompetenciaService {

    private final CompetenciaRepository competenciaRepository;

    private final TurmaFormacaoRepository turmaFormacaoRepository;

    private final ColaboradorRepository colaboradorRepository;

    private final CategoriaRepository categoriaRepository;

    private final CompetenciaMapper competenciaMapper;

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    private final TurmaColaboradorCompetenciaRepository turmaColaboradorCompetenciaRepository;

    public List<CompetenciaDTO> procurarTodos() {
        return competenciaMapper.toDto(competenciaRepository.buscaTodosAtivos());
    }

    public CompetenciaDTO procurarPorId(Integer id) {
        return competenciaMapper.toDto(competenciaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Elemento não encontrado!")));
    }

    public CompetenciaDTO inserir(CompetenciaDTO competenciaDTO) {

        if(ePresent(competenciaDTO))
            throw new RegraNegocioException("NOME INVÁLIDO! Este nome de competência já existe");

        if(competenciaDTO.getDescricao().length() < 5)
            throw new RegraNegocioException("DESCRIÇÃO INVÁLIDA! A Descrição da competência deve ter mais de 5 caracteres.");
            Competencia compencia = competenciaMapper.toEntity(competenciaDTO);
            compencia.setAtivo(true);
        return competenciaMapper.toDto(competenciaRepository.save(compencia));
    }

    public boolean ePresent(CompetenciaDTO competencia){
        return competenciaRepository.buscarPorNome(competencia).isPresent();
    }

    public CompetenciaDTO atualizar(CompetenciaDTO competencia) {
        Competencia competenciaValid =competenciaRepository.findById(competencia.getId()).orElseThrow(
                () -> new NoSuchElementException("Competência não encontrada"));

        if(ePresent(competencia) && !competencia.getNome().equals(competenciaValid.getNome()) )
            throw new RegraNegocioException("NOME INVÁLIDO! Este nome de competência já existe");

        Competencia competenciaMap = competenciaMapper.toEntity(competencia);
        competenciaMap.setAtivo(true);
        return competenciaMapper.toDto(competenciaRepository.save(competenciaMap));
    }

    @Transactional
    public void deletar(Integer id) {
        if(!(turmaColaboradorCompetenciaRepository.procurarPorIdCompetencia(id).isEmpty())){
            throw new RegraNegocioException("Competencia está relacionada a uma turma pendente ou em andamento");
        }
        competenciaRepository.desativarCompetencia(id);
    }

    public List<CompetenciaDTO> buscarCompetenciasPorNivelEPorIdColaborador(Integer idColaborador, Integer idNivel) {
        List<Competencia> competencias = colaboradorCompetenciaRepository.buscarCompetenciasPorNivelEPorIdColaborador(idColaborador,idNivel);
        return competenciaMapper.toDto(competencias);
    }

    public List<CompetenciaDTO> buscaCompetenciaNivel(Integer idColaborador){

        return colaboradorCompetenciaRepository.buscaCompetenciaNivel(idColaborador);

    }

    public List<CompetenciaDTO> buscarCompetenciaPorIdCategoria(Integer idCategoria) { //ok
        if (!(categoriaRepository.findById(idCategoria).isPresent()))
            throw new NoSuchElementException(ConstantUtils.ERRO_ENCONTRAR_IDCATEGORIA);
        return competenciaMapper.toDto(competenciaRepository.buscarCompetenciaPorIdCategoria(idCategoria));
    }


    public List<CompetenciaDTO> pegarTodasCompetenciasDoColaboradorNaTurma(Integer idTurma, Integer idColaborador){
        if(!(turmaFormacaoRepository.findById(idTurma).isPresent()))
            throw new NoSuchElementException(ConstantUtils.ERRO_ENCONTRAR_IDTURMA);

        if(!(colaboradorRepository.findById(idColaborador).isPresent()))
            throw new NoSuchElementException(ConstantUtils.ERRO_ENCONTRAR_IDCOLABORADOR);

        if(!(turmaColaboradorCompetenciaRepository.procurarPorIdColaboradorTurma(idTurma, idColaborador).isPresent()))
            throw new NoSuchElementException(ConstantUtils.ERRO_ENCONTRAR_IDCOLABORADOR);

        return competenciaMapper.toDto(turmaColaboradorCompetenciaRepository.pegarTodasCompetenciasDoColaboradorNaTurma(idTurma, idColaborador));

    }

    public List<CadastrarCompetenciaDTO> buscarCompetenciasDropdown(){
        return competenciaRepository.buscarCompetenciasDropdown();
    }
}

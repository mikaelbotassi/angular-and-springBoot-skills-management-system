package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.repository.ColaboradorCompetenciaRepository;
import br.com.turma.sgc.repository.ColaboradorRepository;
import br.com.turma.sgc.repository.CompetenciaRepository;
import br.com.turma.sgc.repository.TurmaColaboradorCompetenciaRepository;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorBuscaDTO;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorDTO;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorListDTO;
import br.com.turma.sgc.service.dto.Competencia.CadastrarCompetenciaDTO;
import br.com.turma.sgc.service.dto.Competencia.CompetenciaColaboradorDTO;
import br.com.turma.sgc.service.dto.Turma.TurmaColaboradorCompetenciaDTO;
import br.com.turma.sgc.service.mapper.ColaboradorBuscaMapper;
import br.com.turma.sgc.service.mapper.ColaboradorCompetenciaMapper;
import br.com.turma.sgc.service.mapper.ColaboradorMapper;
import br.com.turma.sgc.service.mapper.TurmaColaboradorCompetenciaMapper;
import br.com.turma.sgc.service.resource.exception.RegraNegocioException;
import br.com.turma.sgc.utils.ConstantUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository repository;

    private final CompetenciaRepository competenciaRepository;

    private final ColaboradorMapper colaboradorMapper;

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    private final ColaboradorBuscaMapper colaboradorBuscaMapper;

    private final ColaboradorCompetenciaMapper colaboradorCompetenciaMapper;

    private final TurmaColaboradorCompetenciaRepository turmaColaboradorCompetenciaRepository;

    private final TurmaColaboradorCompetenciaMapper turmaColaboradorCompetenciaMapper;

    public List<ColaboradorListDTO> procurarTodos(){
        return repository.obterTodos();
    }

    @Transactional(readOnly = true)
    public ColaboradorDTO procurarPorId(int id){
        Colaborador obj = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Elemento não encontrado!"));

        ColaboradorDTO colaboradorDTO = colaboradorMapper.toDto(obj);
        colaboradorDTO.setCompetencia(colaboradorCompetenciaRepository.obterCompetenciaColaborador(colaboradorDTO.getId()));
        return colaboradorDTO;

    }

    public CompetenciaColaboradorDTO buscarColaborador(Integer id){
        CompetenciaColaboradorDTO dto = repository.buscarColaborador(id);
        dto.setCompetenciasDTO(colaboradorCompetenciaRepository.buscaCompetenciaNivel(id));
        return dto;

    }

    public List<ColaboradorBuscaDTO> buscarColaboradoresPorCompetencia(Integer id){

        return colaboradorBuscaMapper.toDto(colaboradorCompetenciaRepository.buscarColaboradoresPorCompetencia(id));

    }

    public ColaboradorDTO inserir(ColaboradorDTO colab){
        if(repository.buscarPorCPF(colab.getCpf()).isPresent()){
            throw new RegraNegocioException("Esse CPF já existe em outro Colaborador!");
        }

        if(repository.buscarPorEmail(colab.getEmail()).isPresent()){
            throw new RegraNegocioException("Esse E-mail já existe em outro Colaborador!");
        }
        Colaborador colaboradormap = colaboradorMapper.toEntity(colab);
        colaboradormap.setAtivo(true);

        LocalDate anoNascimento = colaboradormap.getDataNascimento();
        anoNascimento.minusYears(18);

        if(colaboradormap.getDataAdmissao().isBefore(colaboradormap.getDataNascimento().plusYears(18)) ){
            throw new RegraNegocioException("a admissão só pode ser feita depois dos 18 anos");
        }

        Colaborador colaborador = repository.save(colaboradormap);
        salvarCompetencias(colaborador, colab.getCompetencia());
        return colaboradorMapper.toDto(colaborador);
    }

    private void salvarCompetencias(Colaborador colaborador, List<CadastrarCompetenciaDTO> competencias){
        List<Integer> idsCompetencias = new ArrayList<>(Collections.singletonList(-1));
        idsCompetencias.addAll(competencias.stream().map(CadastrarCompetenciaDTO::getId).collect(Collectors.toList()));
        colaboradorCompetenciaRepository.excluirCompetenciaColaborador(colaborador.getId(), idsCompetencias);

        List<ColaboradorCompetencia> colaboradorCompetencias = competencias.stream().map(competencia -> {
            ColaboradorCompetencia colabCompetencia = new ColaboradorCompetencia();
            colabCompetencia.getId().setIdCompetencia(competencia.getId());
            colabCompetencia.getId().setIdColaborador(colaborador.getId());
            colabCompetencia.setNivel(competencia.getNivel());

            colabCompetencia.setColaborador(colaborador);
            colabCompetencia.setCompetencia(colaboradorCompetenciaMapper.toEntity(competencia));
            return colabCompetencia;
        }).collect(Collectors.toList());
        colaboradorCompetenciaRepository.saveAll(colaboradorCompetencias);
    }

    @Transactional
    public void deletar(int id){
        if(!(turmaColaboradorCompetenciaRepository.procurarColaboradorTurma(id).isEmpty())){
            throw new RegraNegocioException("Colaborador esta associado a uma turma pendente ou em andamento");
        }
        repository.desativarColaborador(id);
    }

    public ColaboradorDTO atualizar(ColaboradorDTO c){
        Colaborador colaboradorMap = colaboradorMapper.toEntity(c);
        colaboradorMap.setAtivo(true);
        Colaborador colaborador = repository.save(colaboradorMap);
        salvarCompetencias(colaborador, c.getCompetencia());
        return colaboradorMapper.toDto(colaborador);
    }

    //OK
    public List<ColaboradorDTO> buscarColaboradorPraAplicarCompeteciaPorId(@PathVariable Integer idCompetencia) {
        Optional<Competencia> obj = competenciaRepository.findById(idCompetencia);
        if(obj.isPresent())
            return colaboradorMapper.toDto(colaboradorCompetenciaRepository.buscarColaboradorPraAplicarCompeteciaPorId(idCompetencia));
        else
            throw new NoSuchElementException(ConstantUtils.ERRO_ENCONTRAR_IDCOMPETENCIA);
    }

    public List<TurmaColaboradorCompetenciaDTO> procurarCompetenciasEnsinadaPorColaborador (@PathVariable Integer idColaborador){
        return turmaColaboradorCompetenciaMapper.toDto(turmaColaboradorCompetenciaRepository.procurarCompetenciasEnsinadaPorColaborador(idColaborador));
    }
}

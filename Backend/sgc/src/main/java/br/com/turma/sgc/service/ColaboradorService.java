package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.repository.ColaboradorCompetenciaRepository;
import br.com.turma.sgc.repository.ColaboradorRepository;
import br.com.turma.sgc.service.dto.CadastrarCompetenciaDTO;
import br.com.turma.sgc.service.dto.ColaboradorBuscaDTO;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
import br.com.turma.sgc.service.dto.ColaboradorListDTO;
import br.com.turma.sgc.service.dto.CompetenciaColaboradorDTO;
import br.com.turma.sgc.service.mapper.ColaboradorBuscaMapper;
import br.com.turma.sgc.service.mapper.ColaboradorCompetenciaMapper;
import br.com.turma.sgc.service.mapper.ColaboradorMapper;
import br.com.turma.sgc.utils.ConstantUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository repository;

    private final ColaboradorMapper colaboradorMapper;

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    private final ColaboradorBuscaMapper colaboradorBuscaMapper;

    private final ColaboradorCompetenciaMapper colaboradorCompetenciaMapper;

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
//
//    public List<ColaboradorBuscaDTO> buscaColaboradorInstrutor(){
//
//        Integer nivelMax = Arrays.stream(NivelEnum.values()).map(NivelEnum::getId)
//                .max(Integer::compareTo).orElse(NivelEnum.NIVEL3.getId());
//
//        return colaboradorBuscaMapper.toDto(colaboradorCompetenciaRepository.buscaColaboradorInstrutor(nivelMax));
//    }

    public ColaboradorDTO inserir(ColaboradorDTO colab){
        Colaborador colaborador = repository.save(colaboradorMapper.toEntity(colab));
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

    public void deletar(int id){
        repository.deleteById(id);
    }

    public ColaboradorDTO atualizar(ColaboradorDTO c){
        Colaborador colaborador = repository.save(colaboradorMapper.toEntity(c));
        salvarCompetencias(colaborador, c.getCompetencia());
        return colaboradorMapper.toDto(colaborador);
    }

    //OK
    public List<ColaboradorDTO> buscarColaboradorPraAplicarCompeteciaPorId(@PathVariable Integer idCompetencia) {
        Optional<Colaborador> obj = repository.findById(idCompetencia);
        if(obj.isPresent())
            return colaboradorMapper.toDto(colaboradorCompetenciaRepository.buscarColaboradorPraAplicarCompeteciaPorId(idCompetencia));
        else
            throw new NoSuchElementException(ConstantUtils.ERRO_ENCONTRAR_IDCOMPETENCIA);
    }
}

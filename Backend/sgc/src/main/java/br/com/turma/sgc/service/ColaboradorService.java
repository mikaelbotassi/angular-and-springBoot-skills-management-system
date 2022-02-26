package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.ColaboradorCompetenciaPK;
import br.com.turma.sgc.repository.ColaboradorCompetenciaRepository;
import br.com.turma.sgc.repository.ColaboradorRepository;
import br.com.turma.sgc.service.dto.CadastrarColaboradorDTO;
import br.com.turma.sgc.service.dto.ColaboradorBuscaDTO;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
import br.com.turma.sgc.service.dto.CompetenciaColaboradorDTO;
import br.com.turma.sgc.service.mapper.CadastrarColaboradorMapper;
import br.com.turma.sgc.service.mapper.ColaboradorBuscaMapper;
import br.com.turma.sgc.service.mapper.ColaboradorMapper;
import br.com.turma.sgc.service.mapper.CompetenciaMapper;
import br.com.turma.sgc.utils.ConstantUtils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository repository;

    private final ColaboradorMapper colaboradorMapper;

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    private final CompetenciaService competenciaService;

    private final ColaboradorBuscaMapper colaboradorBuscaMapper;

    private final CompetenciaMapper competenciaMapper;

    private final CadastrarColaboradorMapper cadastrarColaboradorMapper;

    public List<ColaboradorDTO> procurarTodos(){
        List<Colaborador> list = repository.findAll();
        return colaboradorMapper.toDto(list);
    }

    public ColaboradorDTO procurarPorId(int id){
        Colaborador obj = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Elemento não encontrado!"));

        return colaboradorMapper.toDto(obj);

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

    public ColaboradorDTO inserir(CadastrarColaboradorDTO colab){
        ColaboradorDTO colaboradorDTO = colaboradorMapper.toDto(repository.save(cadastrarColaboradorMapper.toEntity(colab)));
        ColaboradorCompetencia colaboradorCompetencia = new ColaboradorCompetencia();
        colab.getCompetencia().forEach(cadastrarCompetencia -> {
            colaboradorCompetencia.setColaborador(colaboradorMapper.toEntity(colaboradorDTO));
            colaboradorCompetencia.setCompetencia(competenciaMapper.toEntity(competenciaService.procurarPorId(cadastrarCompetencia.getId())));
            colaboradorCompetencia.setNivel(cadastrarCompetencia.getNivel());
            ColaboradorCompetenciaPK colaboradorCompetenciaPK = new ColaboradorCompetenciaPK(colaboradorCompetencia.getColaborador().getId(), colaboradorCompetencia.getCompetencia().getId());
            colaboradorCompetencia.setId( colaboradorCompetenciaPK);
            colaboradorCompetenciaRepository.save(colaboradorCompetencia);
        });
        return colaboradorDTO;

    }

    public void deletar(int id){
        repository.deleteById(id);
    }

    public ColaboradorDTO atualizar(ColaboradorDTO c){
        return colaboradorMapper.toDto(repository.save(colaboradorMapper.toEntity(c)));
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

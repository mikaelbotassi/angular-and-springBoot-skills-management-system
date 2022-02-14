package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.ColaboradorCompetenciaPK;
import br.com.turma.sgc.repository.ColaboradorCompetenciaRepository;
import br.com.turma.sgc.repository.ColaboradorRepository;
import br.com.turma.sgc.service.dto.CadastrarColaboradorDTO;
import br.com.turma.sgc.service.dto.ColaboradorBuscaDTO;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
import br.com.turma.sgc.service.dto.CompetenciaDTO;
import br.com.turma.sgc.service.mapper.CadastrarColaboradorMapper;
import br.com.turma.sgc.service.mapper.ColaboradorBuscaMapper;
import br.com.turma.sgc.service.mapper.ColaboradorMapper;
import br.com.turma.sgc.service.mapper.CompetenciaMapper;
import br.com.turma.sgc.service.resource.exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository repository;

    private final ColaboradorBuscaMapper colaboradorBuscaMapper;

    private final ColaboradorMapper colaboradorMapper;

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    private final CompetenciaService competenciaService;

    private final CompetenciaMapper competenciaMapper;

    private final CadastrarColaboradorMapper cadastrarColaboradorMapper;

    public List<ColaboradorBuscaDTO> procurarTodos(){
        return colaboradorBuscaMapper.toDto(repository.findAll());
    }

    public ColaboradorDTO procurarPorId(int id){
        return colaboradorMapper.toDto(repository.findById(id).orElseThrow( () -> new RegraNegocioException("Elemento nao encontrado!")));

    }

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



}

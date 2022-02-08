package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.domain.pk.ColaboradorCompetenciaPK;
import br.com.turma.sgc.repository.ColaboradorCompetenciaRepository;
import br.com.turma.sgc.service.dto.ColaboradorCompetenciaDTO;
import br.com.turma.sgc.service.mapper.ColaboradorCompetenciaMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class ColaboradorCompetenciaService {

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;
    private final ColaboradorCompetenciaMapper colaboradorCompetenciaMapper;

    public List<ColaboradorCompetenciaDTO> buscarTodos() {
        List<ColaboradorCompetencia> colaboradorCompetencias = colaboradorCompetenciaRepository.findAll();
        return colaboradorCompetenciaMapper.toDto(colaboradorCompetencias);
    }

    public ColaboradorCompetenciaDTO salvar(ColaboradorCompetenciaDTO dto) {
        ColaboradorCompetencia colaboradorCompetencia = colaboradorCompetenciaMapper
                .toEntity(dto);
        return colaboradorCompetenciaMapper.toDto(colaboradorCompetenciaRepository.save(colaboradorCompetencia));
    }

    public ColaboradorCompetenciaDTO buscarPorId(ColaboradorCompetenciaPK id) throws Exception {
        ColaboradorCompetencia colaboradorCompetencia = colaboradorCompetenciaRepository.findById(id)
                .orElseThrow(()-> new Exception("Relação Colaborador-Competencia não existe"));
        return colaboradorCompetenciaMapper.toDto(colaboradorCompetencia);
    }

    public ColaboradorCompetenciaDTO inserir(ColaboradorCompetencia colaboradorCompetencia) {
        ColaboradorCompetencia colaboradorCompetenciaDTO = colaboradorCompetenciaMapper
                .toEntity(colaboradorCompetenciaDTO);
        colaboradorCompetencia = colaboradorCompetenciaRepository.save(colaboradorCompetencia);
        
        return colaboradorCompetenciaMapper.toDto(colaboradorCompetencia);
    }

    public ColaboradorCompetenciaDTO atualizar() {
        ColaboradorCompetencia colaboradorCompetencia = colaboradorCompetenciaMapper
                .toEntity(colaboradorCompetenciaDTO);
        colaboradorCompetencia = colaboradorCompetenciaRepository.save(colaboradorCompetencia);

        return colaboradorCompetenciaMapper.toDto(colaboradorCompetencia);
    }

    public void excluir(ColaboradorCompetenciaPK id) {
        colaboradorCompetenciaRepository.deleteById(id);
    }
}

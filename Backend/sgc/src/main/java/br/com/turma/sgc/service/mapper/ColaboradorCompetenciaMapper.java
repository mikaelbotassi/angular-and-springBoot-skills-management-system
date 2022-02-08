package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.service.dto.ColaboradorCompetenciaDTO;
import org.mapstruct.Mapping;

public interface ColaboradorCompetenciaMapper extends EntityMapper <ColaboradorCompetenciaDTO, ColaboradorCompetencia> {
    
    @Override
    @Mapping(source = "colaborador_competencia.nivel", target = "nivel")
    ColaboradorCompetenciaDTO toDto (ColaboradorCompetencia entity);
    
    @Override
    @Mapping(source = "nivel", target = "colaborador_competencia.nivel")
    ColaboradorCompetencia toEntity (ColaboradorCompetenciaDTO dto);
}

package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.service.dto.ColaboradorCompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ColaboradorCompetenciaMapper extends EntityMapper<ColaboradorCompetenciaDTO, ColaboradorCompetencia> {

    @Override
    @Mapping(source = "colaborador.id", target = "colaboradorId")
    @Mapping(source = "competencia.id", target = "competenciaId")
    ColaboradorCompetenciaDTO toDto(ColaboradorCompetencia entity);

    @Override
    @Mapping(source = "colaboradorId", target = "colaborador.id")
    @Mapping(source = "competenciaId", target = "competencia.id")
    ColaboradorCompetencia toEntity(ColaboradorCompetenciaDTO dto);
}

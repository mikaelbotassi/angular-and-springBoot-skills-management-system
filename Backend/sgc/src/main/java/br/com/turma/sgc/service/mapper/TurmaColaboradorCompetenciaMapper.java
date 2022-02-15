package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TurmaColaboradorCompetenciaMapper extends EntityMapper<TurmaColaboradorCompetenciaDTO, TurmaColaboradorCompetencia> {


    @Override
    @Mapping(source = "turma.id", target = "turmaId")
    @Mapping(source = "competencia.id", target = "competenciaId")
    @Mapping(source = "colaborador.id", target = "colaboradorId")
    TurmaColaboradorCompetenciaDTO toDto(TurmaColaboradorCompetencia entity);

    @Override
    @Mapping(source = "turmaId", target = "turma.id")
    @Mapping(source = "competenciaId", target = "competencia.id")
    @Mapping(source = "colaboradorId", target = "colaborador.id")
    TurmaColaboradorCompetencia toEntity(TurmaColaboradorCompetenciaDTO dto);

}

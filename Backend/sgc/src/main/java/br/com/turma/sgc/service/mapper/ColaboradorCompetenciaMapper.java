package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.service.dto.Competencia.CadastrarCompetenciaDTO;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorCompetenciaDTO;
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

    Competencia toEntity(CadastrarCompetenciaDTO dto);
}

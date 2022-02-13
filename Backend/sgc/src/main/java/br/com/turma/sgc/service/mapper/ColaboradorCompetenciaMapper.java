package br.com.turma.sgc.service.mapper;


import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.service.dto.ColaboradorCompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ColaboradorCompetenciaMapper extends EntityMapper<ColaboradorCompetenciaDTO, ColaboradorCompetencia>{

    @Override
    @Mapping(source = "idCompetencia", target = "id.idCompetencia")
    ColaboradorCompetencia toEntity(ColaboradorCompetenciaDTO dto);

    @Override
    @Mapping(source = "id.idCompetencia", target = "idCompetencia")
    @Mapping(source = "competencia.nome", target = "nomeCompetencia")
    ColaboradorCompetenciaDTO toDto(ColaboradorCompetencia entity);

}

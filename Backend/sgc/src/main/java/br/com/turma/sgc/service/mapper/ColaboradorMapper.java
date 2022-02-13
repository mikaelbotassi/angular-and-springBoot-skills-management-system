package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ColaboradorCompetenciaMapper.class})
public interface ColaboradorMapper extends EntityMapper<ColaboradorDTO, Colaborador>{

    @Override
    @Mapping(source = "senioridade.nome", target = "nomeSenioridade")
    @Mapping(source = "senioridade.id", target = "idSenioridade")
    @Mapping(source = "competencias", target = "competenciasDTO")
    ColaboradorDTO toDto(Colaborador entity);

    @Override
    @Mapping(source = "idSenioridade", target = "senioridade.id")
    @Mapping(source = "competenciasDTO", target = "competencias")
    Colaborador toEntity(ColaboradorDTO dto);
}

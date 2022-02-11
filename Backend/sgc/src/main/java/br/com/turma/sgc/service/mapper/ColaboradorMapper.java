package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper extends EntityMapper<ColaboradorDTO, Colaborador>{

    @Override
    @Mapping(source = "senioridade.nome", target = "nomeSenioridade")
    @Mapping(source = "senioridade.id", target = "idSenioridade")
    ColaboradorDTO toDto(Colaborador entity);

    @Override
    @Mapping(source = "idSenioridade", target = "senioridade.id")
    @Mapping(source = "nomeSenioridade", target = "senioridade.nome")
    Colaborador toEntity(ColaboradorDTO dto);
}

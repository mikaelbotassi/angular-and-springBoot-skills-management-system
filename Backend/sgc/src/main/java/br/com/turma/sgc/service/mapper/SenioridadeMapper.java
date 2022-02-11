package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Senioridade;
import br.com.turma.sgc.service.dto.SenioridadeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SenioridadeMapper extends EntityMapper <SenioridadeDTO, Senioridade> {
    @Override
    @Mapping(source = "nome", target = "descricao")
    SenioridadeDTO toDto (Senioridade entity);

    @Override
    @Mapping(source = "descricao", target = "nome")
    Senioridade toEntity (SenioridadeDTO dto);
}

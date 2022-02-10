package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Senioridade;
import br.com.turma.sgc.service.dto.SenioridadeDTO;
import org.mapstruct.Mapping;

public interface SenioridadeMapper extends EntityMapper <SenioridadeDTO, Senioridade> {
    @Override
    @Mapping(source = "senioriade.id", target = "id")
    @Mapping(source = "senioriade.nome", target = "descricao")
    SenioridadeDTO toDto (Senioridade entity);

    @Override
    @Mapping(source = "senioriade.id", target = "id")
    @Mapping(source = "senioriade.nome", target = "descricao")
    Senioridade toEntity (SenioridadeDTO dto);
}

package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.service.dto.ColaboradorBuscaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColaboradorBuscaMapper extends EntityMapper<ColaboradorBuscaDTO, Colaborador> {

    @Override
    @Mapping(source = "senioridade.nome", target = "nomeSenioridade")
    ColaboradorBuscaDTO toDTO(Colaborador entityList);
}

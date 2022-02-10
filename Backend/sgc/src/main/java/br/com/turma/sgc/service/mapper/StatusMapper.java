package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Status;
import br.com.turma.sgc.service.dto.StatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StatusMapper extends EntityMapper <StatusDTO, Status> {
    @Override
    @Mapping(source = "nome", target = "descricao")
    StatusDTO toDto (Status entity);

    @Override
    @Mapping(source = "descricao", target = "nome")
    Status toEntity (StatusDTO dto);
}

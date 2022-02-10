package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Status;
import br.com.turma.sgc.service.dto.StatusDTO;
import org.mapstruct.Mapping;

public interface StatusMapper extends EntityMapper <StatusDTO, Status> {
    @Override
    @Mapping(source = "status.id", target = "statusId")
    @Mapping(source = "status.nome", target = "descricao")
    StatusDTO toDto (Status entity);

    @Override
    @Mapping(source = "statusId", target = "status.id")
    @Mapping(source = "descricao", target = "status.nome")
    Status toEntity (StatusDTO dto);
}

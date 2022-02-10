package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.service.dto.TurmaFormacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface TurmaFormacaoMapper extends EntityMapper<TurmaFormacaoDTO, TurmaFormacao> {



    @Override
    @Mapping(source = "status.id", target = "statusId")
    TurmaFormacaoDTO toDto(TurmaFormacao entity);

    @Override
    @Mapping(source = "statusId", target = "status.id")
    TurmaFormacao toEntity(TurmaFormacaoDTO dto);




}
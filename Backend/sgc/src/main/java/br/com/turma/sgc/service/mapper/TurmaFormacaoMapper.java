package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.service.dto.TurmaFormacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface TurmaFormacaoMapper extends EntityMapper<TurmaFormacaoDTO, TurmaFormacao> {



    @Override
    @Mapping(source = "status.nome", target = "statusNome")
    TurmaFormacaoDTO toDto(TurmaFormacao entity);

    @Override
    @Mapping(source = "statusNome", target = "status.nome")
    TurmaFormacao toEntity(TurmaFormacaoDTO dto);



}
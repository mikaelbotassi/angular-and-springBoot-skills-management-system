package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.TurmaFormacao;
import br.com.turma.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import br.com.turma.sgc.service.dto.TurmaFormacaoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {TurmaColaboradorCompetenciaMapper.class})
public interface TurmaFormacaoMapper extends EntityMapper<TurmaFormacaoDTO, TurmaFormacao> {



    @Override
    @Mapping(source = "status.id", target = "statusId")
    @Mapping(source = "status.nome", target = "nomeStatus")
    @Mapping(target = "colaboradorCompetenciaDTOs", ignore = true)
    TurmaFormacaoDTO toDto(TurmaFormacao entity);

    @Override
    @Mapping(source = "statusId", target = "status.id")
    @Mapping(source = "nomeStatus", target = "status.nome")
    TurmaFormacao toEntity(TurmaFormacaoDTO dto);

}
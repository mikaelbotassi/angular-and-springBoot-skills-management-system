package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TurmaColaboradorCompetenciaMapper extends EntityMapper<TurmaColaboradorCompetenciaDTO, TurmaColaboradorCompetencia>{

    @Override
    @Mapping(source = "turma.nome", target = "nomeTurma")
    @Mapping(source = "turma.id", target = "idTurma")
    @Mapping(source = "colaborador.id", target = "idColaborador")
    @Mapping(source = "colaborador.nomeColaborador", target = "nomeColaborador")
    @Mapping(source = "colaborador.sobrenomeColaborador", target = "sobrenomeColaborador")
    @Mapping(source = "competencia.id", target = "idCompetencia")
    @Mapping(source = "competencia.nome", target = "nomeCompetencia")
    TurmaColaboradorCompetenciaDTO toDto(TurmaColaboradorCompetencia entity);

    @Override
    TurmaColaboradorCompetencia toEntity(TurmaColaboradorCompetenciaDTO dto);

}

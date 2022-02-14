package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TurmaColaboradorCompetenciaMapper extends EntityMapper<TurmaColaboradorCompetenciaDTO, TurmaColaboradorCompetencia>{

    @Override
    @Mapping(source = "colaborador.nome", target = "nomeColaborador")
//    @Mapping(source = "turma.nome", target = "nomeTurma")
    @Mapping(source = "competencia.nome", target = "nomeCompetencia")
    TurmaColaboradorCompetenciaDTO toDto(TurmaColaboradorCompetencia entity);

    @Override
    @Mapping(source = "idTurma", target = "id.idTurmaFormacao")
    @Mapping(source = "idTurma", target = "turma.id")
    @Mapping(source = "idColaborador", target = "colaborador.id")
    @Mapping(source = "idColaborador", target = "id.idColaborador")
    @Mapping(source = "idCompetencia", target = "id.idCompetencia")
    @Mapping(source = "idCompetencia", target = "competencia.id")
    TurmaColaboradorCompetencia toEntity(TurmaColaboradorCompetenciaDTO dto);



}

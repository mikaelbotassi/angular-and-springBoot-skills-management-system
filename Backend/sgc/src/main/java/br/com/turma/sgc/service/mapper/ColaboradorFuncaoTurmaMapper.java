package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorFuncaoTurmaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ColaboradorFuncaoTurmaMapper extends EntityMapper<ColaboradorFuncaoTurmaDTO, TurmaColaboradorCompetencia> {
    @Override
    @Mapping(source = "colaborador.nome", target = "colaboradorNome")
    @Mapping(source = "competencia.nome", target = "nomeCompetencia")
    ColaboradorFuncaoTurmaDTO toDto(TurmaColaboradorCompetencia entity);

    @Override
    @Mapping(source = "colaboradorNome", target = "colaborador.nome")
    @Mapping(source = "nomeCompetencia", target = "competencia.nome")
    TurmaColaboradorCompetencia toEntity(ColaboradorFuncaoTurmaDTO dto);

}

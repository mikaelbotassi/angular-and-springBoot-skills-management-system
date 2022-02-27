package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.ColaboradorCompetencia;
import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.service.dto.TurmaColaboradorCompetenciaNivelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TurmaColaboradorCompetenciaNivelMapper extends EntityMapper<TurmaColaboradorCompetenciaNivelDTO, ColaboradorCompetencia> {

    @Override
    @Mapping(source = "competencia.nome", target = "competenciaNome")
    @Mapping(source = "colaborador.nome", target = "colaboradorNome")
    @Mapping(source = "colaborador.id", target = "colaboradorId")
    @Mapping(source = "competencia.id", target = "competenciaId")
    @Mapping(source = "colaborador.sobrenome", target = "colaboradorSobrenome")
    TurmaColaboradorCompetenciaNivelDTO toDto(ColaboradorCompetencia entity);

    @Override
    @Mapping(source = "competenciaNome", target = "competencia.nome")
    @Mapping(source = "colaboradorNome", target = "colaborador.nome")
    @Mapping(source = "colaboradorId", target = "colaborador.id")
    @Mapping(source = "competenciaId", target = "competencia.id")
    ColaboradorCompetencia toEntity(TurmaColaboradorCompetenciaNivelDTO dto);
}

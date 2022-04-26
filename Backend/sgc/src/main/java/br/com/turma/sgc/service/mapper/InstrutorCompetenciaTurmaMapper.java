package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.TurmaColaboradorCompetencia;
import br.com.turma.sgc.service.dto.Colaborador.InstrutorCompetenciaTurmaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstrutorCompetenciaTurmaMapper extends EntityMapper<InstrutorCompetenciaTurmaDTO, TurmaColaboradorCompetencia> {


    @Override
    @Mapping(source = "colaborador.nome", target = "nomeColaborador")
    @Mapping(source = "competencia.nome", target = "nomeCompetencia")
    @Mapping(source = "turma.nome", target = "nomeTurma")
    InstrutorCompetenciaTurmaDTO toDto(TurmaColaboradorCompetencia entity);

    @Override
    @Mapping(source = "nomeColaborador", target = "colaborador.nome")
    @Mapping(source = "nomeCompetencia", target = "competencia.nome")
    @Mapping(source = "nomeTurma", target = "turma.nome")

    TurmaColaboradorCompetencia toEntity(InstrutorCompetenciaTurmaDTO dto);
}

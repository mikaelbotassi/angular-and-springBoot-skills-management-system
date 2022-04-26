package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.service.dto.Competencia.CompetenciaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CategoriaMapper.class})
public interface CompetenciaMapper extends EntityMapper<CompetenciaDTO, Competencia>{
    @Override
    CompetenciaDTO toDto(Competencia entity);

    @Override
    Competencia toEntity(CompetenciaDTO dto);
}

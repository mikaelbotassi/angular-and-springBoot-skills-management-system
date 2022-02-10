package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.dto.CompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper extends EntityMapper<CompetenciaDTO, Competencia>{
    @Override
    @Mapping(source = "categoria.id", target = "categoriaId")
    CompetenciaDTO toDto(Competencia entity);

    @Override
    @Mapping(source = "categoriaId", target = "categoria.id")
    Competencia toEntity(CompetenciaDTO dto);
}

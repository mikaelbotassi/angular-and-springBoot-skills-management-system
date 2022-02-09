package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.dto.CompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper extends EntityMapper<Competencia, CompetenciaDTO>{
    @Override
    @Mapping(source = "categoria.nome", target = "categoriaNome")
    CompetenciaDTO toDto(Competencia entity);
}

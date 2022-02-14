package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.service.dto.CompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper extends EntityMapper<CompetenciaDTO, Competencia>{
    @Override
//    @Mapping(source = "categoria.id", target = "categoriaId")
    @Mapping(source = "categoria.nome", target = "nomeCategoria")
    CompetenciaDTO toDto(Competencia entity);

    @Override
    @Mapping(source = "categoriaId", target = "categoria.id")
    Competencia toEntity(CompetenciaDTO dto);
}

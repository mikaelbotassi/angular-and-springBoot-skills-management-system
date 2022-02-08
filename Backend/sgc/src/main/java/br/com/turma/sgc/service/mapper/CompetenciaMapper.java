package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.service.dto.CompetenciaDTO;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper  extends EntityMapper<CompetenciaDTO, Competencia>{

    @Override
    @Mapping(source = "Categoria.descricao",target = "categoriaDescricao")
    CompetenciaDTO toDto(Competencia entity);

    @Override
    @Mapping(source = "CategoriaDescricao",target = "categoria.descricao")
    Competencia toEntity(CompetenciaDTO dto);

}

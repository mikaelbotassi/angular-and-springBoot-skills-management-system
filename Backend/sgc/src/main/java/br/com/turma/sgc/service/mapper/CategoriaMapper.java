package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Categoria;
import br.com.turma.sgc.service.dto.CategoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends EntityMapper <CategoriaDTO, Categoria> {

    @Override
    @Mapping(source = "nome", target = "descricao")
    CategoriaDTO toDto (Categoria entity);

    @Override
    @Mapping(source = "descricao", target = "nome")
    Categoria toEntity (CategoriaDTO dto);
}


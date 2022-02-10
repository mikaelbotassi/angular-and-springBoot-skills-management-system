package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Categoria;
import br.com.turma.sgc.service.dto.CategoriaDTO;
import org.mapstruct.Mapping;

public interface CategoriaMapper extends EntityMapper <CategoriaDTO, Categoria> {

    @Override
    @Mapping(source = "categoria.id", target = "categoriaId")
    @Mapping(source = "categoria.nome", target = "descricao")
    CategoriaDTO toDto (Categoria entity);

    @Override
    @Mapping(source = "categoriaId", target = "categoria.id")
    @Mapping(source = "descricao", target = "categoria.nome")
    Categoria toEntity (CategoriaDTO dto);
}


package br.com.turma.sgc.service.mapper;

import java.util.List;

public interface EntityMapper<E, D> {
    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<D> entityList);
}

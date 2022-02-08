package br.com.turma.sgc.service.mapper;

import java.util.List;

public interface EntityMapper <D, E>{

    E toEntity(D dto);

    D toDTO(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDTO(List<E> entityList);

}

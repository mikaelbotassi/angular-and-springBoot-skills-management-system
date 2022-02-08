package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.service.dto.CompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper extends EntityMapper <CompetenciaDTO, Competencia> {
/*
    @Override
    //source -> o que está na entidade (quem eu recebo como parâmetro)
    //target -> atributo no dto
    @Mapping(source = "categoria.descricao", target = "categoriaDescricao") //o que eu quero aonde eu quero
    CompetenciaDTO toDto(Competencia entity);

    @Override
    @Mapping(source = "categoriaDescricao", target = "categoria.descricao")
    Competencia toEntity(CompetenciaDTO dto);
    //duas versões -> uma na mão e outra é anotação

 */
}

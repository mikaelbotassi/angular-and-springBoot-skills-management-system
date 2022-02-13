package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.service.dto.ColaboradorBuscaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ColaboradorCompetenciaMapper.class})
public interface ColaboradorBuscaMapper extends EntityMapper<ColaboradorBuscaDTO, Colaborador> {

    @Override
    @Mapping(source = "senioridade.nome", target = "nomeSenioridade")
    @Mapping(source = "competencias", target = "competenciasDTO")
    ColaboradorBuscaDTO toDto(Colaborador entityList);
}

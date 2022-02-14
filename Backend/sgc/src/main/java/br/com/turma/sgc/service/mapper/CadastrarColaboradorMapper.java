package br.com.turma.sgc.service.mapper;


import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.service.dto.CadastrarColaboradorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CadastrarColaboradorMapper extends EntityMapper<CadastrarColaboradorDTO, Colaborador> {

    @Override
    @Mapping(source = "senioridade.id", target = "idSenioridade")
    CadastrarColaboradorDTO toDto(Colaborador entity);

    @Override
    @Mapping(source = "idSenioridade", target = "senioridade.id")
    Colaborador toEntity(CadastrarColaboradorDTO dto);


}

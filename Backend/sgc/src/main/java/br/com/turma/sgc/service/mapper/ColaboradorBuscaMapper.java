package br.com.turma.sgc.service.mapper;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.service.dto.ColaboradorBuscaDTO;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface ColaboradorBuscaMapper extends EntityMapper<ColaboradorBuscaDTO, Colaborador> {
}

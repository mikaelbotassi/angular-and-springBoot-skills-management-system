package br.com.turma.sgc.builder;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.enums.SenioridadeEnum;
import br.com.turma.sgc.repository.ColaboradorRepository;
import br.com.turma.sgc.service.ColaboradorService;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
import br.com.turma.sgc.service.mapper.ColaboradorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;

@Component
public class ColaboradorBuilder extends ConstrutorDeEntidade<ColaboradorDTO>{

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private ColaboradorMapper colaboradorMapper;

    @Override
    public ColaboradorDTO construirEntidade() {

        ColaboradorDTO colaborador = new ColaboradorDTO();
        colaborador.setNome("Mikael");
        colaborador.setSobrenome("Botassi");
        colaborador.setCpf("34434434");
        colaborador.setEmail("Mikaael@");
        colaborador.setDataNascimento(LocalDate.parse("2001-11-08"));
        colaborador.setDataAdmissao(LocalDate.parse("2022-03-10"));
        colaborador.setIdSenioridade(SenioridadeEnum.SENIOR.getId());
        colaborador.setNomeSenioridade(SenioridadeEnum.SENIOR.getNome());
        return colaborador;
    }

    @Override
    public ColaboradorDTO persistir(ColaboradorDTO entidade) {
        Colaborador colaborador = colaboradorMapper.toEntity(entidade);
        return colaboradorMapper.toDto(colaboradorRepository.save(colaborador));
    }

    @Override
    public Collection<ColaboradorDTO> obterTodos() {
        return colaboradorMapper.toDto(colaboradorRepository.findAll());
    }

    @Override
    public ColaboradorDTO obterPorId(Long id) {
        return colaboradorService.procurarPorId(id.intValue());
    }


}

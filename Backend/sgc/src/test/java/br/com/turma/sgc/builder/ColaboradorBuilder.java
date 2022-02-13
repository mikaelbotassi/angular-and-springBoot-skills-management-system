package br.com.turma.sgc.builder;

import br.com.turma.sgc.domain.Colaborador;
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
        colaborador.setNome("Arthur");
        colaborador.setSobrenome("Alberto");
        colaborador.setCpf("14536985718");
        colaborador.setFoto(null);
        colaborador.setEmail("aaa@gmail.com");
        colaborador.setDataNascimento(LocalDate.parse("2000-05-10"));
        colaborador.setDataAdmissao(LocalDate.parse("2022-01-06"));
        colaborador.setIdSenioridade(1);
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

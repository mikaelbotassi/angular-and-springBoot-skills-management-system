package br.com.turma.sgc.builder;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.repository.ColaboradorRepository;
import br.com.turma.sgc.service.ColaboradorService;
import br.com.turma.sgc.service.dto.Colaborador.ColaboradorDTO;
import br.com.turma.sgc.service.mapper.ColaboradorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;

@Component
public class ColaboradorBuilder extends ConstrutorDeEntidade<ColaboradorDTO> {

    @Autowired
    private ColaboradorMapper colaboradorMapper;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ColaboradorService colaboradorService;


    @Override
    public ColaboradorDTO construirEntidade() {
        ColaboradorDTO colaboradorDTO = new ColaboradorDTO();
        colaboradorDTO.setId(1);
        colaboradorDTO.setNome("nome qualquer");
        colaboradorDTO.setEmail("sauhsda@dsadsa.com.br");
        colaboradorDTO.setDataNascimento(LocalDate.now().minusYears(18));
        colaboradorDTO.setDataAdmissao(LocalDate.now());
        colaboradorDTO.setCpf("13873729717");
        colaboradorDTO.setIdSenioridade(1);
        colaboradorDTO.setSobrenome("dsadasdasda");

        return colaboradorDTO;
    }

    @Override
    public ColaboradorDTO persistir(ColaboradorDTO entidade) {
        Colaborador colaborador = colaboradorMapper.toEntity(entidade);
        colaborador.setAtivo(true);
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

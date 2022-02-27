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
public class ColaboradorBuilder extends ConstrutorDeEntidade<ColaboradorDTO> {

    @Autowired
    private ColaboradorMapper colaboradorMapper;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ColaboradorService colaboradorService;

//    @Autowired
//    private CadastrarColaboradorMapper cadastrarColaboradorMapper;
//
//    @Autowired
//    private CadastrarColaboradorDTO cadastrarColaboradorDTO;


    @Override
    public ColaboradorDTO construirEntidade() {
        ColaboradorDTO colaboradorDTO = new ColaboradorDTO();
        colaboradorDTO.setId(1);
        colaboradorDTO.setNome("nome qualquer");
        colaboradorDTO.setEmail("sauhsda");
        colaboradorDTO.setDataNascimento(LocalDate.ofEpochDay(0));
        colaboradorDTO.setDataAdmissao(LocalDate.ofEpochDay(0));
        colaboradorDTO.setCpf("dsadasdsa");
        colaboradorDTO.setIdSenioridade(1);
        colaboradorDTO.setSobrenome("dsadasdasda");

        return colaboradorDTO;
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

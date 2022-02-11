package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Senioridade;
import br.com.turma.sgc.exeption.RegraNegocioException;
import br.com.turma.sgc.repository.SenioridadeRepository;
import br.com.turma.sgc.service.dto.SenioridadeDTO;
import br.com.turma.sgc.service.mapper.SenioridadeMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SenioridadeService {

    private final SenioridadeRepository repository;
    private final SenioridadeMapper mapper;

    @SneakyThrows(RegraNegocioException.class)

    public SenioridadeDTO buscarSenioridadePorId(Integer id) {
        Senioridade senioridade = repository.findById(id)
                .orElseThrow(()-> new RegraNegocioException("Senioridade não encontrada"));
        return mapper.toDto(senioridade);
    }

    public List<SenioridadeDTO> listarTodasSenioridades() {
        List<Senioridade> list = repository.findAll();
        return mapper.toDto(list);
    }

}

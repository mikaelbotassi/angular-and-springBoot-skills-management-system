package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Status;
import br.com.turma.sgc.service.resource.exception.RegraNegocioException;
import br.com.turma.sgc.repository.StatusRepository;
import br.com.turma.sgc.service.dto.StatusDTO;
import br.com.turma.sgc.service.mapper.StatusMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository repository;
    private final StatusMapper mapper;

    @SneakyThrows(RegraNegocioException.class)

    public StatusDTO buscarStatusPorId(Integer id) {
        Status status = repository.findById(id)
                .orElseThrow(()-> new RegraNegocioException("Status não encontrada"));
        return mapper.toDto(status);
    }

    public List<StatusDTO> listarTodosStatus() {
        List<Status> list = repository.findAll();
        return mapper.toDto(list);
    }

}

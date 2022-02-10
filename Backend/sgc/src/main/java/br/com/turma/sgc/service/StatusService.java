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

    public StatusDTO inserirStatus(StatusDTO dto) {
        Status status = mapper.toEntity(dto);
        status = repository.save(status);
        return mapper.toDto(status);
    }

    public StatusDTO atualizarStatus(StatusDTO dto) {
        Status status = mapper.toEntity(dto);
        status = repository.save(status);
        return mapper.toDto(status);
    }

    public void excluirStatus(Integer id) {
        repository.deleteById(id);
        throw new RegraNegocioException("Não foi possível deletar a senioridade informada");
    }
}

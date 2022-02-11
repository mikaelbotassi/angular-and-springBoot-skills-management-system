package br.com.turma.sgc.service;


import br.com.turma.sgc.domain.Categoria;
import br.com.turma.sgc.exeption.RegraNegocioException;
import br.com.turma.sgc.repository.CategoriaRepository;
import br.com.turma.sgc.service.dto.CategoriaDTO;
import br.com.turma.sgc.service.mapper.CategoriaMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    @SneakyThrows(RegraNegocioException.class)
    public List<CategoriaDTO> listarTodasCategorias() {
        List<Categoria> list = repository.findAll();
        return mapper.toDto(list);
    }

    public CategoriaDTO buscarCategoriaPorId(Integer id) {
        Categoria categoria = repository.findById(id)
                .orElseThrow(()-> new RegraNegocioException("Categoria não encontrada"));
        return mapper.toDto(categoria);
    }
}


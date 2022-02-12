package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.repository.ColaboradorRepository;
import br.com.turma.sgc.service.dto.ColaboradorBuscaDTO;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
import br.com.turma.sgc.service.mapper.ColaboradorBuscaMapper;
import br.com.turma.sgc.service.mapper.ColaboradorMapper;
import br.com.turma.sgc.service.resource.exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository repository;

    private final ColaboradorBuscaMapper colaboradorBuscaMapper;

    private final ColaboradorMapper colaboradorMapper;

    public List<ColaboradorBuscaDTO> procurarTodos(){
        return colaboradorBuscaMapper.toDto(repository.findAll());
    }

    public ColaboradorDTO procurarPorId(int id){
        return colaboradorMapper.toDto(repository.findById(id).orElseThrow( () -> new RegraNegocioException("Elemento nao encontrado!")));

    }

    public ColaboradorDTO inserir(ColaboradorDTO colab){

        return colaboradorMapper.toDto(repository.save(colaboradorMapper.toEntity(colab)));
    }

    public void deletar(int id){
        repository.deleteById(id);
    }

    public ColaboradorDTO atualizar(ColaboradorDTO c){
        return colaboradorMapper.toDto(repository.save(colaboradorMapper.toEntity(c)));
    }



}

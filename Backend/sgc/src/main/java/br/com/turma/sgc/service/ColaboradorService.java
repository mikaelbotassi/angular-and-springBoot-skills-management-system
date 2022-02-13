package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.enums.NivelEnum;
import br.com.turma.sgc.repository.ColaboradorCompetenciaRepository;
import br.com.turma.sgc.repository.ColaboradorRepository;
import br.com.turma.sgc.service.dto.ColaboradorBuscaDTO;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
import br.com.turma.sgc.service.mapper.ColaboradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColaboradorService {

    private final ColaboradorRepository repository;

    private final ColaboradorMapper colaboradorMapper;

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    public List<ColaboradorBuscaDTO> procurarTodos(){

        return repository.buscarTodosColaboradores();

    }

    public ColaboradorDTO procurarPorId(int id){
        Colaborador obj = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Elemento não encontrado!"));

        return colaboradorMapper.toDto(obj);

    }

    public List<ColaboradorBuscaDTO> buscarColaboradoresPorCompetencia(Integer id){

        return colaboradorCompetenciaRepository.buscarColaboradoresPorCompetencia(id);

    }



    public List<ColaboradorBuscaDTO> buscaColaboradorInstrutor(){

        Integer nivelMax = Arrays.stream(NivelEnum.values()).map(NivelEnum::getId)
                .max(Integer::compareTo).orElse(NivelEnum.NIVEL3.getId());

        return colaboradorCompetenciaRepository.buscaColaboradorInstrutor(nivelMax);
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

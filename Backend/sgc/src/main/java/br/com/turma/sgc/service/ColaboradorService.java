package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.domain.Competencia;
import br.com.turma.sgc.repository.ColaboradorCompetenciaRepository;
import br.com.turma.sgc.repository.ColaboradorRepository;
import br.com.turma.sgc.repository.CompetenciaRepository;
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

    private final ColaboradorCompetenciaRepository colaboradorCompetenciaRepository;

    public List<ColaboradorBuscaDTO> procurarTodos(){
        return colaboradorBuscaMapper.toDto(repository.findAll());
    }

    public ColaboradorDTO procurarPorId(int id){
        Optional<Colaborador> obj = repository.findById(id);
        if(obj.isPresent()){
            return colaboradorMapper.toDto(obj.get());
        }
        else{
            throw new NoSuchElementException("Elemento não encontrado!");
        }
    }

    public ColaboradorDTO inserir(ColaboradorDTO colab){
        return colaboradorMapper.toDto(repository.save(colaboradorMapper.toEntity(colab)));
    }

    public void deletar(Integer id){
        procurarPorId(id);
        repository.deleteById(id);
    }

    public ColaboradorDTO atualizar(ColaboradorDTO c){
        procurarPorId(c.getId());
        return colaboradorMapper.toDto(repository.save(colaboradorMapper.toEntity(c)));
    }

//    public List<Colaborador> buscarColaboradorPraAplicarCompetecia(String competencia) {
//        return colaboradorCompetenciaRepository.buscarColaboradorPraAplicarCompetecia(competencia);
//    }
//
//    public List<Integer> buscarColaboradorAplicarCompeteciaID(Integer competenciaId) {
//        return colaboradorCompetenciaRepository.buscarColaboradorAplicarCompeteciaID(competenciaId);
//    }

}

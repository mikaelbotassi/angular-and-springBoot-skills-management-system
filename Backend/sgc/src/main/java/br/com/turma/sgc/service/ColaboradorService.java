package br.com.turma.sgc.service;

import br.com.turma.sgc.domain.Colaborador;
import br.com.turma.sgc.repository.ColaboradorCompetenciaRepository;
import br.com.turma.sgc.repository.ColaboradorRepository;
import br.com.turma.sgc.service.dto.ColaboradorBuscaDTO;
import br.com.turma.sgc.service.dto.ColaboradorDTO;
import br.com.turma.sgc.service.mapper.ColaboradorBuscaMapper;
import br.com.turma.sgc.service.mapper.ColaboradorMapper;
import br.com.turma.sgc.service.resource.exception.RegraNegocioException;
import br.com.turma.sgc.utils.ConstantUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public void deletar(int id){
        repository.deleteById(id);
    }

    public ColaboradorDTO atualizar(ColaboradorDTO c){
        return colaboradorMapper.toDto(repository.save(colaboradorMapper.toEntity(c)));
    }

    //OK
    public List<ColaboradorDTO> buscarColaboradorPraAplicarCompeteciaPorId(@PathVariable Integer idCompetencia) {
        Optional<Colaborador> obj = repository.findById(idCompetencia);
        if(obj.isPresent())
            return colaboradorMapper.toDto(colaboradorCompetenciaRepository.buscarColaboradorPraAplicarCompeteciaPorId(idCompetencia));
        else
            throw new NoSuchElementException(ConstantUtils.ERRO_ENCONTRAR_IDCOMPETENCIA);
    }
}

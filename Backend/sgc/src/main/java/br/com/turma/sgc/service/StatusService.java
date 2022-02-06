package br.com.turma.sgc.service;
import br.com.turma.sgc.enums.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatusService {
    public StatusEnum[] findAll(){
        return StatusEnum.values();
    }

    public StatusEnum findById(int id){
        return StatusEnum.valueOf(id);
    }

}

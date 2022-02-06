package br.com.turma.sgc.service;

import br.com.turma.sgc.enums.SenioridadeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SenioridadeService {

    public SenioridadeEnum[] findAll(){
        return SenioridadeEnum.values();
    }

    public SenioridadeEnum findById(int id){
        return SenioridadeEnum.valueOf(id);
    }

}

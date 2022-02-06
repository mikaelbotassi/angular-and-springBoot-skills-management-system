package br.com.turma.sgc.service;

import br.com.turma.sgc.enums.CategoriaEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaServices {

    public CategoriaEnum[] findAll(){
        return CategoriaEnum.values();
    }

    public CategoriaEnum findById(int id){
        return CategoriaEnum.valueOf(id);
    }
}

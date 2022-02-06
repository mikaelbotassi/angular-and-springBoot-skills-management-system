package br.com.turma.sgc.resource;

import br.com.turma.sgc.service.SenioridadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/senioridade")
@RestController
@RequiredArgsConstructor
public class SenioridadeResource {

    private final SenioridadeService service;



}
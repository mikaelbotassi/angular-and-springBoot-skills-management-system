package br.com.turma.sgc.resource;
import br.com.turma.sgc.service.StatusService;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/status")
@RestController
@RequiredArgsConstructor
public class StatusResource {

    private final StatusService service;

}

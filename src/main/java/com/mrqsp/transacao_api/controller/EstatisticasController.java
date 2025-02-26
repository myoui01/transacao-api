package com.mrqsp.transacao_api.controller;


import com.mrqsp.transacao_api.business.services.EstatisticasService;
import com.mrqsp.transacao_api.controller.dtos.EstatisticasResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/estatistica")
@RequiredArgsConstructor
public class EstatisticasController {

    private EstatisticasService estatisticasService;

    public ResponseEntity<EstatisticasResponseDTO>
    buscarEstatisticas(@RequestParam(value = "intervaloBusca", required = false, defaultValue = "/60") Integer intervaloBusca) {
        return ResponseEntity.ok(estatisticasService.calcularEstatisticasTransacoes(intervaloBusca));
    }
}

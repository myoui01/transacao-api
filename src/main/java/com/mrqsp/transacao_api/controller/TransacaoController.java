package com.mrqsp.transacao_api.controller;

import com.mrqsp.transacao_api.business.services.TransacaoService;
import com.mrqsp.transacao_api.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoRequestDTO dto) {
        transacaoService.adicionarTransacoes(dto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTransacoes() {
        transacaoService.limparTransacoes();

        return ResponseEntity.ok().build();
    }
}

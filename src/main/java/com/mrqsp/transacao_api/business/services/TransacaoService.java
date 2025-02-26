package com.mrqsp.transacao_api.business.services;

import com.mrqsp.transacao_api.controller.dtos.TransacaoRequestDTO;
import com.mrqsp.transacao_api.infrastructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class TransacaoService {
    private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();

    public void adicionarTransacoes(TransacaoRequestDTO dto) {

        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            throw new UnprocessableEntity();
        }

        if (dto.valor() <= 0) {
            throw new UnprocessableEntity();
        }

        listaTransacoes.add(dto);
    }

    public void limparTransacoes() {
        listaTransacoes.clear();
    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloBusca) {
         OffsetDateTime dataHoraIntervalo  = OffsetDateTime.now().minusSeconds(intervaloBusca);

         return listaTransacoes.stream()
                 .filter(transacoes -> transacoes.dataHora()
                 .isAfter(dataHoraIntervalo)).toList();
    }
}

package com.mrqsp.transacao_api.business.services;

import com.mrqsp.transacao_api.controller.dtos.EstatisticasResponseDTO;
import com.mrqsp.transacao_api.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EstatisticasService {
    public TransacaoService transacaoService;

    public EstatisticasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca) {
        List<TransacaoRequestDTO>
                transacoes = transacaoService.buscarTransacoes(intervaloBusca);

        DoubleSummaryStatistics estatisticasTransacao = transacoes.stream()
            .mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();

        return new EstatisticasResponseDTO(estatisticasTransacao.getCount(),
                estatisticasTransacao.getSum(),
                estatisticasTransacao.getAverage(),
                estatisticasTransacao.getMin(),
                estatisticasTransacao.getMax());

    }

}

Desafio Técnico Itaú - API de Transações e Estatísticas
Este projeto é um desafio técnico que envolve tanto desenvolvimento quanto engenharia de software. O objetivo é criar uma API REST capaz de receber transações e fornecer estatísticas sobre elas em tempo real, utilizando Java e Spring Boot.

A API implementa três endpoints principais:
1. POST /transacao - Recebe transações contendo um valor e uma data/hora, armazenando-as em memória.
2. DELETE /transacao - Limpa todas as transações armazenadas.
3. GET /estatistica - Retorna estatísticas (count, sum, avg, min, max) com base nas transações dos últimos 60 segundos.

Regras de Negócio
- A API aceita apenas transações passadas (não pode estar no futuro).
- O valor da transação deve ser maior ou igual a zero.
- O formato das datas deve seguir ISO 8601 (OffsetDateTime).
-  As estatísticas devem refletir apenas os últimos 60 segundos.

 Melhorias Futuras
- Implementação de testes unitários e de integração.
- Otimizações de desempenho para processamento de estatísticas.
- Implementação de segurança básica na API.

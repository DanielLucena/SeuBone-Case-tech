package com.seubone.sistemavendas.dto;

import java.util.List;

import com.seubone.sistemavendas.enums.FormaPagamento;
import com.seubone.sistemavendas.enums.Prazo;
import com.seubone.sistemavendas.enums.SolicitacaoStatus;

public record PedidoFiltroDTO(

    Double soma,

    Double valorFrete,

    Prazo prazo,

    Double desconto,

    FormaPagamento formaPagamento,

    SolicitacaoStatus status,

    String vendedor
) {

}

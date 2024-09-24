package com.seubone.sistemavendas.dto;

import java.util.List;


import com.seubone.sistemavendas.enums.FormaPagamento;
import com.seubone.sistemavendas.enums.Prazo;

public record PedidoRequestDTO(

    Double valorFrete,

    Prazo prazo,

    List<ItemRequestDTO> itens,

    Double desconto,

    FormaPagamento formaPagamento
) {

}

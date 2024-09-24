package com.seubone.sistemavendas.dto;

import java.util.List;

import com.seubone.sistemavendas.enums.FormaPagamento;
import com.seubone.sistemavendas.enums.Prazo;
import com.seubone.sistemavendas.enums.SolicitacaoStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PedidoResponseDTO{
    Long id;

    Double soma;

    Double valorFrete;

    Prazo prazo;

    List<ItemResponseDTO> itens;

    Double desconto;

    FormaPagamento formaPagamento;

    SolicitacaoStatus status;

}

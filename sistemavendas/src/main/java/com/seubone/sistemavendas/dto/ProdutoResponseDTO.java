package com.seubone.sistemavendas.dto;

public record ProdutoResponseDTO(
    Long id,
    String SKU,
    String produto,
    Double preco_cheio,
    Double preco_descontado
) {

}

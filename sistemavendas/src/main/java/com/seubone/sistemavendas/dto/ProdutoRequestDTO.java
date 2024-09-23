package com.seubone.sistemavendas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRequestDTO(
    @NotBlank
    String SKU,

    String produto,

    @NotNull
    Double preco_cheio,

    @NotNull
    Double preco_descontado

) {
}

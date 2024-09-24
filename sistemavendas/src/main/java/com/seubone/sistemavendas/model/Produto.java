package com.seubone.sistemavendas.model;

import com.seubone.sistemavendas.dto.ProdutoRequestDTO;
import com.seubone.sistemavendas.dto.ProdutoResponseDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produto")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String descricao;
    private Double precoCheio;
    private Double precoDescontado;

    public Produto(ProdutoRequestDTO data){
        this.sku = data.SKU();
        this.descricao = data.produto();
        this.precoCheio = data.preco_cheio();
        this.precoDescontado = data.preco_descontado();
    }

    public ProdutoResponseDTO toResponse(){
        return new ProdutoResponseDTO(
            this.id,
            this.sku,
            this.descricao,
            this.precoCheio,
            this.precoDescontado
        );
    }
}

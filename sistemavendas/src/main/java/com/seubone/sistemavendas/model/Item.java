package com.seubone.sistemavendas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seubone.sistemavendas.dto.ItemResponseDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    @JsonIgnore
    private Produto produto;


    // @ManyToOne
    // @JoinColumn(name = "pedido_id", nullable = false)
    // @JsonIgnore
    // private Pedido pedido;

    
    private Integer quantidade;

    public Item(int quantidade, Produto produto){
        this.quantidade = quantidade;
        this.produto = produto;
        // this.pedido = pedido;
    }

    public ItemResponseDTO toResponse(){
        return new ItemResponseDTO(
            this.produto.getId(),
            this.quantidade
            );
    }

    public double getSomaCheio(){
        return produto.getPrecoCheio() * quantidade;
    }

    public double getSomaDescontado(){
        return produto.getPrecoDescontado() * quantidade;
    }

}

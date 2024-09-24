package com.seubone.sistemavendas.model;

import java.util.List;

import com.seubone.sistemavendas.dto.PedidoResponseDTO;
import com.seubone.sistemavendas.enums.FormaPagamento;
import com.seubone.sistemavendas.enums.Prazo;
import com.seubone.sistemavendas.enums.SolicitacaoStatus;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Currency("BRL")
    private Double soma;

    // @Currency("BRL")
    private Double valorFrete;

    @Enumerated(EnumType.ORDINAL)
    private Prazo prazo;

    // @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ElementCollection(targetClass = Item.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "itens", joinColumns = @JoinColumn(name = "pedido_id"))
    @Column(name = "item", nullable = false)
    private List<Item> itens;

    // @Currency("BRL")
    private Double desconto;

    @Enumerated(EnumType.ORDINAL)
    private FormaPagamento formaPagamento;

    @Enumerated(EnumType.ORDINAL)
    private SolicitacaoStatus status;

    public PedidoResponseDTO toResponse(){
        return new PedidoResponseDTO(
            this.id,
            this.soma,
            this.valorFrete,
            this.prazo,
            this.itens.stream().map(Item::toResponse).toList(),
            this.desconto,
            this.formaPagamento,
            this.status
        );
    }


    public double calculaSoma(){
        soma = 0.0;
        if(formaPagamento == FormaPagamento.CARTAO_CREDITO){
            soma += this.itens.stream().map(Item::getSomaCheio).reduce(0.0, Double::sum);
        }
        else{
            soma += this.itens.stream().map(Item::getSomaDescontado).reduce(0.0, Double::sum);
        }

        if(prazo == Prazo.TURBO){
            soma *= 1.1;
        }
        else if(prazo == Prazo.SUPER_TURBO){
            soma *= 1.2;
        }
        soma += valorFrete;

        soma -= desconto;

        return soma;
    }


}

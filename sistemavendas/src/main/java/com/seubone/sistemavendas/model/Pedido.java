package com.seubone.sistemavendas.model;

import java.util.Set;

import com.seubone.sistemavendas.dto.PedidoResponseDTO;
import com.seubone.sistemavendas.enums.FormaPagamento;
import com.seubone.sistemavendas.enums.Prazo;
import com.seubone.sistemavendas.enums.SolicitacaoStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "pedido")
@Table(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
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

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL, orphanRemoval = true)  
    private Set<Item> items; 

    // @Currency("BRL")
    private Double desconto;

    @Enumerated(EnumType.ORDINAL)
    private FormaPagamento formaPagamento;

    @Enumerated(EnumType.ORDINAL)
    private SolicitacaoStatus status;

    public PedidoResponseDTO toResponse(){
        return new PedidoResponseDTO(
            this.id,
            Double.parseDouble(String.format("%.2f", this.soma)),
            Double.parseDouble(String.format("%.2f", this.valorFrete)),
            this.prazo,
            this.items.stream().map(Item::toResponse).toList(),
            Double.parseDouble(String.format("%.2f", this.desconto)),
            this.formaPagamento,
            this.status
        );
    }

    public void setItems(Set<Item> items) {
        this.items = items;
        for (Item item : items) {
            item.setPedido(this);  // Garantindo que cada item tenha a referência ao pai
        }
    }

    public void addItem(Item item) {
        item.setPedido(this);      // Setando a referência da EntidadePai no Item
        this.items.add(item);          // Adicionando o item à lista
    }


    public Double calculaSoma(){
        soma = 0.0;
        soma = calculaSomaProdutos();
        if(prazo == Prazo.TURBO){
            soma *= 1.1;
        }
        else if(prazo == Prazo.SUPER_TURBO){
            soma *= 1.2;
        }
        soma += valorFrete;

        soma -= desconto;

        this.setSoma(soma);
        return soma;
    }

    public SolicitacaoStatus calculaStatusInicial(){
        Double descontoProdutosPorPrazo = 0.0;
        if(this.prazo == Prazo.PADRAO){
            descontoProdutosPorPrazo = calculaSomaProdutos() * 0.05;
        }
        else if(this.prazo == Prazo.TURBO){
            descontoProdutosPorPrazo = calculaSomaProdutos() * 0.1;
        }
        else if(this.prazo == Prazo.SUPER_TURBO){
            descontoProdutosPorPrazo = calculaSomaProdutos() * 0.2;
        }
        Double descontoMaximoPermitido = Double.max(this.valorFrete, descontoProdutosPorPrazo);
        
        if(this.status == null){
            if(this.desconto <= descontoMaximoPermitido){
                this.status = SolicitacaoStatus.APROVADO;
                return SolicitacaoStatus.APROVADO;
            }
            else{
                this.status = SolicitacaoStatus.PENDENTE;
                return SolicitacaoStatus.PENDENTE;
            }
        }

        // System.out.println("Desconto por prazo: " + descontoProdutosPorPrazo);
        // System.out.println("valorFrete: " + this.valorFrete);
        // System.out.println("Desconto máximo permitido: " + descontoMaximoPermitido);
        // System.out.println("Desconto: " + this.desconto);
        return this.status;
    }


    public double calculaSomaProdutos(){
        double soma = 0.0;
        if(formaPagamento == FormaPagamento.CARTAO_CREDITO){
            soma += this.items.stream().map(Item::getSomaCheio).reduce(0.0, Double::sum);
        }
        else{
            soma += this.items.stream().map(Item::getSomaDescontado).reduce(0.0, Double::sum);
        }
        System.out.println("Soma: " + soma);
        return soma;
    }

}

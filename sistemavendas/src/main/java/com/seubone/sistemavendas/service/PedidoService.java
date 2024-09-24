package com.seubone.sistemavendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seubone.sistemavendas.dto.PedidoRequestDTO;
import com.seubone.sistemavendas.enums.SolicitacaoStatus;
import com.seubone.sistemavendas.model.Pedido;
import com.seubone.sistemavendas.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    @Autowired
    ItemService itemService;

    public Pedido create(PedidoRequestDTO dto){
        Pedido pedido = Pedido.builder()
        .status(SolicitacaoStatus.PENDENTE)
        .formaPagamento(dto.formaPagamento())
        .valorFrete(dto.valorFrete())
        .prazo(dto.prazo())
        .desconto(dto.desconto())
        .build();
        repository.save(pedido);
        pedido.setItens(dto.itens().stream().map(itemService::dtoToItem).toList());
        pedido.setSoma(pedido.calculaSoma());
        
        return pedido;
    }

    public List<Pedido> findAll(){
        return repository.findAll();
    }

    
}

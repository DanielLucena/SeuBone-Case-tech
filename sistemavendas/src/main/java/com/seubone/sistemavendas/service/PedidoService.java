package com.seubone.sistemavendas.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seubone.sistemavendas.dto.PedidoRequestDTO;
// import com.seubone.sistemavendas.enums.SolicitacaoStatus;
import com.seubone.sistemavendas.model.Item;
// import com.seubone.sistemavendas.enums.SolicitacaoStatus;
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
        .formaPagamento(dto.formaPagamento())
        .valorFrete(dto.valorFrete())
        .prazo(dto.prazo())
        .desconto(dto.desconto())
        .build();


        //persiste itens ante de adicionar ao pedido
        List<Item> itens = dto.itens().stream()
        .map(item -> itemService.dtoToItem(item)) // Converte DTO para Item
        // .map(item -> itemService.save(item)) // Salvar item no banco de dados
        .toList();

        pedido.setItems(new HashSet<Item>(itens));
        pedido.calculaSoma();
        pedido.calculaStatusInicial();
        
        repository.save(pedido);
        return pedido;
    }

    public List<Pedido> findAll(){
        return repository.findAll();
    }

    
}

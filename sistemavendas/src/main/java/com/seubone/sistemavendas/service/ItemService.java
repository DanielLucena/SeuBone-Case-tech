package com.seubone.sistemavendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seubone.sistemavendas.dto.ItemRequestDTO;
import com.seubone.sistemavendas.model.Item;
import com.seubone.sistemavendas.repository.ItemRepository;
import com.seubone.sistemavendas.repository.PedidoRepository;
import com.seubone.sistemavendas.repository.ProdutoRepository;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    public Item dtoToItem(ItemRequestDTO dto){
        Item item = new Item();
        item.setProduto(produtoRepository.findById(dto.produto_id()).get());
        item.setQuantidade(dto.quantidade());
        // item.setPedido(pedidoRepository.findById(pedido_id).get());
        return item;
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }


}

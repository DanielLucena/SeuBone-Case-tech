package com.seubone.sistemavendas.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.seubone.sistemavendas.dto.PedidoFiltroDTO;
import com.seubone.sistemavendas.dto.PedidoRequestDTO;
import com.seubone.sistemavendas.enums.SolicitacaoStatus;
import com.seubone.sistemavendas.exception.ResourceNotFoundException;
import com.seubone.sistemavendas.model.Item;
import com.seubone.sistemavendas.model.Pedido;
import com.seubone.sistemavendas.model.Produto;
import com.seubone.sistemavendas.repository.PedidoRepository;
import com.seubone.sistemavendas.repository.UserRepository;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    @Autowired
    ItemService itemService;

    @Autowired
    UserRepository userRepository;

    public Pedido create(PedidoRequestDTO dto, String username) {
        Pedido pedido = Pedido.builder()

        .formaPagamento(dto.formaPagamento())
        .valorFrete(dto.valorFrete())
        .prazo(dto.prazo())
        .desconto(dto.desconto())
        .username(username)
        .build();


        //persiste itens ante de adicionar ao pedido
        List<Item> itens = dto.itens().stream()
        .map(item -> itemService.dtoToItem(item)) // Converte DTO para Item
        // .map(item -> itemService.save(item)) // Salvar item no banco de dados
        .toList();
        System.out.println("itens apost dto transformado: " + itens.size());

        pedido.setItems(itens);
        pedido.calculaSoma();
        pedido.calculaStatusInicial();
        
        repository.save(pedido);
        return pedido;
    }

    public List<Pedido> findAll(UserDetails userDetails, PedidoFiltroDTO filtro) {
        if(userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))){
            Pedido pedidoFiltro = Pedido.builder()
            .status(filtro.status())
            .formaPagamento(filtro.formaPagamento())
            .prazo(filtro.prazo())
            .username(filtro.vendedor())
            .valorFrete(filtro.valorFrete())
            .desconto(filtro.desconto())
            .soma(filtro.soma())
            .build();

        ExampleMatcher matcher = ExampleMatcher
            .matching()
            .withIgnorePaths("valorFrete", "desconto", "soma", "id")
            .withIgnoreCase()
            .withStringMatcher(ExampleMatcher.StringMatcher.EXACT);
        Example<Pedido> example = Example.of(pedidoFiltro, matcher);
        List<Pedido> pedidosFiltrados = repository.findAll(example);
        return pedidosFiltrados.stream()
            .toList();
            // List<Pedido> pedidos = repository.findAllByOrderByIdAsc();
        }
        return repository.findByUsernameOrderByIdAsc(userDetails.getUsername());
        // return repository.findAllByOrderByIdAsc();

        
    }

    public Pedido revisar(Long id, SolicitacaoStatus status) {
        Pedido pedido = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));
        pedido.setStatus(status);
        repository.save(pedido);
        return pedido;
    }

    public Pedido findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));
    }

    
}

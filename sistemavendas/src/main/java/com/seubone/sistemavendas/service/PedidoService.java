package com.seubone.sistemavendas.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.seubone.sistemavendas.dto.PedidoRequestDTO;
import com.seubone.sistemavendas.enums.SolicitacaoStatus;
import com.seubone.sistemavendas.exception.ResourceNotFoundException;
import com.seubone.sistemavendas.model.Item;
import com.seubone.sistemavendas.model.Pedido;
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

    public List<Pedido> findAll(UserDetails userDetails){
        if(userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))){
            return repository.findAllByOrderByIdAsc();
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

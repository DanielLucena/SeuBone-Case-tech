package com.seubone.sistemavendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seubone.sistemavendas.dto.PedidoRequestDTO;
import com.seubone.sistemavendas.dto.PedidoResponseDTO;
import com.seubone.sistemavendas.dto.RevisaoDTO;
import com.seubone.sistemavendas.model.Pedido;
import com.seubone.sistemavendas.model.User;
import com.seubone.sistemavendas.service.PedidoService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
// @CrossOrigin
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    PedidoService service;


    @PostMapping
    public ResponseEntity<PedidoResponseDTO> postPedido(@RequestBody @Valid PedidoRequestDTO body, Authentication authentication){
        System.out.println(authentication.getPrincipal());
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                        .getPrincipal();
        Pedido pedidoCriado = service.create(body, userDetails.getUsername());
        
        return ResponseEntity.ok(pedidoCriado.toResponse());
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> getPedidos(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                        .getPrincipal();
        List<Pedido> pedidos = service.findAll(userDetails);


        return ResponseEntity.ok(
            pedidos.stream().map(Pedido::toResponse).toList()
        );
    }

    @PutMapping("revisar/{id}")
    public ResponseEntity<PedidoResponseDTO> revisarPedido(@PathVariable Long id, @RequestBody RevisaoDTO data) {
        Pedido pedido = service.revisar(id, data.status());
        return ResponseEntity.ok(pedido.toResponse());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> getPedido(@PathVariable Long id) {
        Pedido pedido = service.findById(id);
        return ResponseEntity.ok(pedido.toResponse());
    }

}

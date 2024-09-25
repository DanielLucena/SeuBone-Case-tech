package com.seubone.sistemavendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seubone.sistemavendas.dto.PedidoRequestDTO;
import com.seubone.sistemavendas.dto.PedidoResponseDTO;
import com.seubone.sistemavendas.model.Pedido;
import com.seubone.sistemavendas.service.PedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    PedidoService service;


    @PostMapping
    public ResponseEntity<PedidoResponseDTO> postPedido(@RequestBody @Valid PedidoRequestDTO body){
        Pedido pedidoCriado = service.create(body);
        
        return ResponseEntity.ok(pedidoCriado.toResponse());
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> getPedidos(){
        List<Pedido> pedidos = service.findAll();


        return ResponseEntity.ok(
            pedidos.stream().map(Pedido::toResponse).toList()
        );
    }
}

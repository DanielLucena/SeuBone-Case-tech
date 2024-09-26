package com.seubone.sistemavendas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.seubone.sistemavendas.dto.ProdutoRequestDTO;
import com.seubone.sistemavendas.dto.ProdutoResponseDTO;
import com.seubone.sistemavendas.model.Produto;
import com.seubone.sistemavendas.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
// @CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> postProduto(@RequestBody @Valid ProdutoRequestDTO body){
        Produto produto = new Produto(body);
        service.create(produto);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> getProdutos(){
        List<Produto> produtos = service.findAll();
        
        return ResponseEntity.ok(produtos.stream().map(Produto::toResponse).toList());
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Produto>> bulkRegistry(@RequestBody @Valid List<ProdutoRequestDTO> body) {
        return ResponseEntity.ok(service.bulkRegistry(body));
    }
    
}

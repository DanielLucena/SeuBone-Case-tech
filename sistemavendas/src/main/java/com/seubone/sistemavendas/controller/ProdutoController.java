package com.seubone.sistemavendas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seubone.sistemavendas.dto.ProdutoRequestDTO;
import com.seubone.sistemavendas.model.Produto;
import com.seubone.sistemavendas.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ResponseEntity postProduct(@RequestBody @Valid ProdutoRequestDTO body){
        Produto produto = new Produto(body);
        produtoService.create(produto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getProducts(){
        List<Produto> produtos = produtoService.findAll();
        return ResponseEntity.ok(produtos);
    }
}

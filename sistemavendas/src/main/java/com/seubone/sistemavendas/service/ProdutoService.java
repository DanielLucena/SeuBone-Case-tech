package com.seubone.sistemavendas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seubone.sistemavendas.dto.ProdutoRequestDTO;
import com.seubone.sistemavendas.model.Produto;
import com.seubone.sistemavendas.repository.ProdutoRepository;

import jakarta.validation.Valid;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public List<Produto> bulkRegistry(@Valid List<ProdutoRequestDTO> body) {
        return produtoRepository.saveAll(body.stream().map(Produto::new).toList());
    }
}

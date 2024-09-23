package com.seubone.sistemavendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seubone.sistemavendas.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

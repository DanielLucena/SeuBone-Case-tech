package com.seubone.sistemavendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seubone.sistemavendas.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}

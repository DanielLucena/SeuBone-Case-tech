package com.seubone.sistemavendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seubone.sistemavendas.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}

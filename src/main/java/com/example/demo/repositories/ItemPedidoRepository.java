package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.ItemPedido;

import org.springframework.data.jpa.repository.JpaRepository;

 
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
	

}

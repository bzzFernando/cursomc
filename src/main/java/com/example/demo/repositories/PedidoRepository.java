package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import com.example.demo.domain.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

 
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
}

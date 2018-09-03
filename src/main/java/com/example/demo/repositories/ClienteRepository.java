package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import com.example.demo.domain.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

 
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	

}

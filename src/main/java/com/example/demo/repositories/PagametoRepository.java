package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

 
@Repository
public interface PagametoRepository extends JpaRepository<Pagamento, Integer> {
	
}

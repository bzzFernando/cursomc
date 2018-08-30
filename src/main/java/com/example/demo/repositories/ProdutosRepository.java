package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import com.example.demo.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

 
@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Integer> {
	
	

	

}

package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import com.example.demo.domain.Categorias;
import com.example.demo.domain.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;

 
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	
	

	

}

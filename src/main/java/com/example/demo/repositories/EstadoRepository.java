package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import com.example.demo.domain.Estado;

import org.springframework.data.jpa.repository.JpaRepository;

 
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	

	

}

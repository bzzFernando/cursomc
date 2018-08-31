package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import com.example.demo.domain.Categorias;
import com.example.demo.domain.Cidade;
import com.example.demo.domain.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;

 
@Repository
public interface Enderecorepository extends JpaRepository<Endereco, Integer> {
	
	

	

}

package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categorias;
import com.example.demo.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categorias buscar(Integer id) {
		
		Optional<Categorias> obj = repo.findById(id);
		
		return obj.orElse(null);
	}

}

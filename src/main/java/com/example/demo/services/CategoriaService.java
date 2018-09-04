package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categorias;
import com.example.demo.repositories.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categorias buscar(Integer id) throws ObjectNotFoundException {
		
		Optional<Categorias> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:" + id + ", Tipo:" + Categorias.class.getName()));
	}

	
	public Categorias insert(Categorias obj) {
		
		obj.setId(null);
		return repo.save(obj);
	}
}

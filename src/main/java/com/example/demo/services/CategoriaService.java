package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categorias;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.services.exception.DataIntegrityException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categorias select (Integer id) throws ObjectNotFoundException {
		
		Optional<Categorias> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:" + id + ", Tipo:" + Categorias.class.getName()));
	}

	
	public Categorias insert(Categorias obj) {
		
		obj.setId(null);
		return repo.save(obj);
	}
	
	
	public Categorias update(Categorias obj) throws ObjectNotFoundException {
		
		select(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) throws ObjectNotFoundException {
		
		select(id);
		try {
			repo.deleteById(id);
		}catch(DataIntegrityException e) {
			
			throw new DataIntegrityViolationException("Não é possivle excluir uma categoria que possui produtos cadastrados");
		}
		
	}
}


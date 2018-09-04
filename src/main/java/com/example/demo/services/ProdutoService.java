package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Produto;
import com.example.demo.repositories.ProdutosRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	
	@Autowired
	private ProdutosRepository repo;
	
	public Produto find(Integer id) throws ObjectNotFoundException {
		
		Optional<Produto> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:" + id + ", Tipo:" + Produto.class.getName()));
	}

	
}

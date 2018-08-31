package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categorias;
import com.example.demo.domain.Produto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.ProdutosRepository;





@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository caterogiaRepository;
	@Autowired
	private ProdutosRepository produtosRepository;

	public static void main(String[] args) {
		
		SpringApplication.run(CursomcApplication.class, args);
		
		
	
	}
	
	public void run(String...args) throws Exception {
		
		Categorias cat1 = new Categorias(null,"Informatica");
		Categorias cat2 = new Categorias(null,"Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 8000.00);
		Produto p2 = new Produto(null, "Ventilador", 200.00);
		Produto p3 = new Produto(null, "Show", 50.00);		
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2 , p3));
		cat2.getProdutos().addAll(Arrays.asList(p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat1,cat2));
		
		caterogiaRepository.saveAll(Arrays.asList(cat1 ,cat2));
		produtosRepository.saveAll(Arrays.asList(p1,p2,p3));
		
	}
}

package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categorias;
import com.example.demo.repositories.CategoriaRepository;





@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository caterogiaRepository;

	public static void main(String[] args) {
		
		SpringApplication.run(CursomcApplication.class, args);
	
	}
	
	public void run(String...args) throws Exception {
		
		Categorias cat1 = new Categorias(null,"Informatica");
		Categorias cat2 = new Categorias(null,"Escritorio");
		
		
		caterogiaRepository.saveAll(Arrays.asList(cat1 =,cat2));
	}
}

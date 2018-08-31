package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Categorias;
import com.example.demo.domain.Cidade;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Produto;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.repositories.EstadoRepository;
import com.example.demo.repositories.ProdutosRepository;





@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository caterogiaRepository;
	@Autowired
	private ProdutosRepository produtosRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

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
		

		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"Sao Paulo");
		Estado est3 = new Estado(null,"Rio de janeiro");
		
		Cidade cid1 = new Cidade(null,"BH", est1);
		Cidade cid2 = new Cidade(null,"Campinas", est2);
		Cidade cid3 = new Cidade(null,"Niteroi", est3);
		Cidade cid4 = new Cidade(null,"SP", est2);
		
		
		est1.getCidadesList().addAll(Arrays.asList(cid1));
		est2.getCidadesList().addAll(Arrays.asList(cid2,cid4));
		est3.getCidadesList().addAll(Arrays.asList(cid3));
		
		
		caterogiaRepository.saveAll(Arrays.asList(cat1 ,cat2));
		produtosRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2,est3));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2,cid3,cid4));
		
	}
}

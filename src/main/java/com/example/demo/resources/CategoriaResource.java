package com.example.demo.resources;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Categorias;

@Controller
@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET)
	public java.util.List<Categorias> listar() {
		
		
		Categorias cat1 = new Categorias(1 , "informatica");
		Categorias cat2 = new Categorias(2, "Software");
		
		java.util.List<Categorias> listaCat =new ArrayList<>();
		listaCat.add(cat1);
		listaCat.add(cat2);
		
		
		return listaCat;
	}
}

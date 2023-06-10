package com.example.demo.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Categorias;
import com.example.demo.models.services.ICategoriasService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriasRestController {
@Autowired
private ICategoriasService CateSer;
@GetMapping("/Lista Cate")

public List<Categorias>listarCat(){
	return CateSer.listarTodo();
}
@PostMapping("/categorias")
@ResponseStatus(HttpStatus.CREATED)
public Categorias guardarcat(@RequestBody Categorias categoria ) {
	return CateSer.save(categoria);
}

@PutMapping("/categoria/{id}")
public Categorias categoria(@RequestBody Categorias categoria,@PathVariable("id") Long id) {
	Categorias Ctg = CateSer.buscarPorID(id);
	if (Objects.nonNull(categoria.getDescripcion())&&!"".equalsIgnoreCase(categoria.getDescripcion())) {
		Ctg.setDescripcion(categoria.getDescripcion());
	}
	return CateSer.save(Ctg);
	
}

@DeleteMapping("/Eliminar/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void Eliminar (@PathVariable("id") Long Categoriaid) {
	CateSer.Eliminar(Categoriaid);

}
}

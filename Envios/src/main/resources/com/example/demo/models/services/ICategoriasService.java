package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Categorias;

public interface ICategoriasService {
	public List<Categorias> listarTodo();
	public Categorias  save(Categorias categorias);
	public  Categorias buscarPorID(Long id);
	public void Eliminar(Long id);

}

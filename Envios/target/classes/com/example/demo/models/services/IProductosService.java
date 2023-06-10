package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.productos;

public interface IProductosService {
	public List<productos> listarTodo();
	public productos  save(productos productosa);
	public  productos buscarPorID(Long id);
	public void Eliminar(Long id);
}

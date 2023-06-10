package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Proveedores;

public interface IProveedorService {
	
	public List<Proveedores> listarTodo();
	public Proveedores  save(Proveedores provee);
	public  Proveedores buscarPorID(Long id);
	public void Eliminar(Long id);
}

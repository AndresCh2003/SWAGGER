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

import com.example.demo.models.entity.Proveedores;
import com.example.demo.models.services.IProveedorService;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorRestController {

@Autowired
private IProveedorService ProveSer;
@GetMapping("/ListaProve")

public List< Proveedores> listaPro(){
	return ProveSer.listarTodo();
}
@PostMapping("/Proveedor")
@ResponseStatus(HttpStatus.CREATED)
public Proveedores guardarpro(@RequestBody Proveedores proveedor) {
	return ProveSer.save(proveedor);
	
}

@PutMapping("/proveedor/{id}")
public Proveedores proveedor(@RequestBody Proveedores proveedor,@PathVariable("id") Long id) {
	Proveedores Prv = 	ProveSer.buscarPorID(id);

	
	if (Objects.nonNull(proveedor.getNombre()) && !"".equalsIgnoreCase(proveedor.getNombre())) {
		Prv.setNombre(proveedor.getNombre());
	}
	
	if (Objects.nonNull(proveedor.getDireccion()) && !"".equalsIgnoreCase(proveedor.getDireccion())) {
		Prv.setDireccion(proveedor.getDireccion());
	}
	
	if (Objects.nonNull(proveedor.getTelefono()) && !"".equalsIgnoreCase(proveedor.getTelefono())) {
		Prv.setTelefono(proveedor.getTelefono());
	}
	return ProveSer.save(proveedor);
	
}

@DeleteMapping("/Eliminar/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void Eliminar (@PathVariable("id") Long Proveser) {
	ProveSer.Eliminar(Proveser);

}
}

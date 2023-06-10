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

import com.example.demo.models.entity.productos;
import com.example.demo.models.services.IProductosService;

@RestController
@RequestMapping("/api/producto")
public class ProductoRestController {

	@Autowired
	private IProductosService Proser;
	@GetMapping("/Lista Prod")
	
	public List<productos> listaprod(){
		return Proser.listarTodo();
	}
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	
	public productos guardarpro(@RequestBody productos produ) {
		return Proser.save(produ);
	}
	
	@PutMapping("/productos/{id}")
	public productos producto(@RequestBody productos producto,@PathVariable("id") Long id) {
		productos prd = Proser.buscarPorID(id);
				if (Objects.nonNull(producto.getDescripcion()) && !"".equalsIgnoreCase(producto.getDescripcion())) {
					prd.setDescripcion(producto.getDescripcion());
				}
				
				if (Objects.nonNull(producto.getPrecio()) && (producto.getPrecio()>0)) {
					prd.setPrecio(producto.getPrecio());
				}
				
				if (Objects.nonNull(producto.getProveedor()) && (producto.getProveedor().getId_proveedor()!=0)) {
					prd.setProveedor(producto.getProveedor());
				}
				
				if(Objects.nonNull(producto.getCategoria()) && (producto.getCategoria().getId_categoria()!=0)) {
					prd.setCategoria(producto.getCategoria());
				}
				return Proser.save(prd);
	}
	
	@DeleteMapping("/Eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void Eliminar (@PathVariable("id") Long proid) {
		Proser.Eliminar(proid);

	}
}

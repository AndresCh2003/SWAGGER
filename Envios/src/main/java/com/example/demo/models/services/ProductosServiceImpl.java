package com.example.demo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IProductosDao;
import com.example.demo.models.entity.productos;


@Service
public class ProductosServiceImpl implements IProductosService {

	@Autowired
	private IProductosDao ProductoDao;
	@Override
	@Transactional(readOnly = true)
	public List<productos> listarTodo() {
		// TODO Auto-generated method stub
		return (List<productos>) ProductoDao.findAll();
	}

	@Override
	@Transactional
	public productos save(productos productosa) {
		// TODO Auto-generated method stub
		return ProductoDao.save(productosa);
	}

	@Override
	@Transactional
	public productos buscarPorID(Long id) {
		// TODO Auto-generated method stub
		return ProductoDao.findById(id).get();
	}

	@Override
	@Transactional
	public void Eliminar(Long id) {
		// TODO Auto-generated method stub
		ProductoDao.deleteById(id);
		
	}



}

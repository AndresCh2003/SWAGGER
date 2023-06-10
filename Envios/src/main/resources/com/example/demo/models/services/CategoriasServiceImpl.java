package com.example.demo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.ICategoriasDao;
import com.example.demo.models.entity.Categorias;

@Service
public class CategoriasServiceImpl implements ICategoriasService {

	@Autowired
	private ICategoriasDao CategoriaDao;
	@Override
	@Transactional(readOnly = true)
	public List<Categorias> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Categorias>) CategoriaDao.findAll();
	}

	@Override
	@Transactional
	public Categorias save(Categorias categorias) {
		// TODO Auto-generated method stub
		return CategoriaDao.save(categorias);
	}

	@Override
	@Transactional
	public Categorias buscarPorID(Long id) {
		// TODO Auto-generated method stub
		return CategoriaDao.findById(id).get();
	}

	@Override
	@Transactional
	public void Eliminar(Long id) {
		// TODO Auto-generated method stub
		CategoriaDao.deleteById(id);
	}



	
}

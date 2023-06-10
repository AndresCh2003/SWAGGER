package com.example.demo.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.dao.IProveedorDao;
import com.example.demo.models.entity.Proveedores;

@Service
public class ProveedorServiceImpl implements IProveedorService {

	@Autowired
	private IProveedorDao ProveedorDao;
	@Override
	@Transactional(readOnly = true)
	public List<Proveedores> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Proveedores>) ProveedorDao.findAll();
	}

	@Override
	@Transactional
	public Proveedores save(Proveedores provee) {
		// TODO Auto-generated method stub
		return ProveedorDao.save(provee);
	}

	@Override
	@Transactional
	public Proveedores buscarPorID(Long id) {
		// TODO Auto-generated method stub
		return ProveedorDao.findById(id).get();
	}

	@Override
	@Transactional
	public void Eliminar(Long id) {
		// TODO Auto-generated method stub
		ProveedorDao.deleteById(id);
	}

}

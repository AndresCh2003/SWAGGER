package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Proveedores;

public interface IProveedorDao extends CrudRepository<Proveedores, Long>{

}

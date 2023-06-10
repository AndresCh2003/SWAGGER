package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.productos;

public interface IProductosDao extends CrudRepository<productos,Long> {

}

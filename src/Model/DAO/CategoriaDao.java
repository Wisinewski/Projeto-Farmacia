package model.dao;

import java.util.List;

import model.entities.Categoria;

public interface CategoriaDao {
	
	boolean insert(Categoria categoria);
	void deleteById(Integer id);
	Categoria findById(Integer id);
	List<Categoria> findAll();
}

package model.dao;

import java.util.List;

import model.entities.Categoria;

public interface CategoriaDao {
	
	void insert(Categoria categoria);
	void update(Categoria categoria);
	void deleteById(Long id);
	Categoria findById(Long id);
	List<Categoria> findAll();
}

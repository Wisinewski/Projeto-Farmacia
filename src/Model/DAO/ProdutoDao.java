package model.dao;

import java.util.List;

import model.entities.Produto;

public interface ProdutoDao {
	
	void insert(Produto produto);
	void update(Produto produto);
	void deleteById(Long id);
	Produto findById(Long id);
	List<Produto> findAll();
}

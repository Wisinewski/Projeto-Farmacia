package model.dao;

import java.util.List;

import model.entities.ProdutoItem;

public interface ProdutoItemDao {
	
	void insert(ProdutoItem categoria);
	ProdutoItem findById(Long id);
	List<ProdutoItem> findAll();
}

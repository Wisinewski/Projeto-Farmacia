package model.dao;

import java.util.List;

import model.entities.ProdutoItem;

public interface ProdutoItemDao {
	
	boolean insert(ProdutoItem categoria);
	List<ProdutoItem> findAllById(Integer id);
}

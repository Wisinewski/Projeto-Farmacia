package controller;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProdutoItemDao;
import model.entities.ProdutoItem;

public class ProdutoItemController {
	ProdutoItemDao produtoItemDao = DaoFactory.createProdutoItemDao();
	
	public ProdutoItemController() {
	}

	public boolean insert(ProdutoItem produtoItem) {
		return produtoItemDao.insert(produtoItem);
	}

	public List<ProdutoItem> findAllById(Integer id) {
		return produtoItemDao.findAllById(id);
	}
	
}

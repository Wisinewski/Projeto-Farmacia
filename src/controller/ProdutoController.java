package controller;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Produto;

public class ProdutoController {
    ProdutoDao produtoDao = DaoFactory.createProdutoDao();
    
    public ProdutoController() {
    }
    
    public void insert(Produto produto) {
    	produtoDao.insert(produto); 
    }
    
    public void update(Produto produto) {
    	produtoDao.update(produto);
    }
    
    public void deleteById(Long id) {
    	produtoDao.deleteById(id);
    }
    
    public Produto findById(Long id) {
    	return produtoDao.findById(id);
    }
  
    public List<Produto> findAll() {
    	List<Produto> listaProdutos = produtoDao.findAll();
    	return listaProdutos;
    }

}

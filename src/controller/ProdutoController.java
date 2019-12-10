package controller;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Produto;

public class ProdutoController {
    ProdutoDao produtoDao = DaoFactory.createProdutoDao();
    
    public ProdutoController() {
    }
    
    
    public boolean insert(Produto produto) {
        
    	boolean cadastrar = produtoDao.insert(produto); 
        return cadastrar;
    }
    
    public void update(Produto produto) {
    	produtoDao.update(produto);
    }
    
    public boolean deleteById(Integer id) {
    	boolean t = produtoDao.deleteById(id);
        return t;
    }
    
    public Produto findById(Integer id) {
    	return produtoDao.findById(id);
    }
  
    public List<Produto> findAll() {
    	List<Produto> listaProdutos = produtoDao.findAll();
    	return listaProdutos;
    }
    public List<Produto> findbyWord(String desc)
    {
        List<Produto> listaProdutos = produtoDao.findByWord(desc);
    	return listaProdutos;
    }
  
    
    
     
    

}

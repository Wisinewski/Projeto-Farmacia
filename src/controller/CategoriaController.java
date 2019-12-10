package controller;

import java.sql.SQLException;
import java.util.List;

import model.dao.CategoriaDao;
import model.dao.DaoFactory;
import model.entities.Categoria;

public class CategoriaController {
	CategoriaDao categoriaDao = DaoFactory.createCategoriaDao();
	
	public CategoriaController() {
	}
  
    public boolean insert(Categoria categoria) {
      boolean inserir =  categoriaDao.insert(categoria);
        
        return inserir;
    }
    
    public void deleteById(Integer id) {
    	categoriaDao.deleteById(id);
    }
    
    public Categoria findById(Integer id) {
    	return categoriaDao.findById(id);
    }
    
	public List<Categoria> listarCategoria() throws SQLException {     
        List<Categoria> listaCategorias = categoriaDao.findAll();    
        return listaCategorias;       
    }

}

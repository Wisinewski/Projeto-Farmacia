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
  
    public void insert(Categoria categoria) {
        categoriaDao.insert(categoria);
    }
    
    public void update(Categoria categoria) {
    	categoriaDao.update(categoria);
    }
    
    public void deleteById(Long id) {
    	categoriaDao.deleteById(id);
    }
    
    public Categoria findById(Long id) {
    	return categoriaDao.findById(id);
    }
    
	public List<Categoria> listarCategoria() throws SQLException {     
        List<Categoria> listaCategorias = categoriaDao.findAll();    
        return listaCategorias;       
    }

}

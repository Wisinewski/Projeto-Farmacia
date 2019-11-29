package controller;

import model.entities.Categoria;
import model.dao.CategoriaDAO;
import model.dao.Conexao1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaController {
  CategoriaDAO categoria = new CategoriaDAO();
  
    public CategoriaController(Categoria objCate) throws SQLException {
       
        categoria.InsertCategoriaDAO(objCate);
    }
    public CategoriaController()
    {
        
    }
    
    public List<Categoria> listarCategoria() throws SQLException
    {     
        List<Categoria> lst_categoria = categoria.BuscarCategorias();    
        return lst_categoria;       
    }

}

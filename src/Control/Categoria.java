package Control;

import Model.DAO.CategoriaDAO;
import Model.DAO.Conexao1;
import Model.Entidades.CategoriaEnt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Categoria {
  CategoriaDAO categoria = new CategoriaDAO();
  
    public Categoria(CategoriaEnt objCate) throws SQLException {
       
        categoria.InsertCategoriaDAO(objCate);
    }
    public Categoria()
    {
        
    }
    
    public List<CategoriaEnt> listarCategoria() throws SQLException
    {     
        List<CategoriaEnt> lst_categoria = categoria.BuscarCategorias();    
        return lst_categoria;       
    }

}

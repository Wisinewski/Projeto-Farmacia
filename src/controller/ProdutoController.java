package controller;

import model.entities.Produto;
import model.dao.ProdutoDAO;

import java.sql.SQLException;

public class ProdutoController {
    ProdutoDAO produto = new ProdutoDAO();
    
  public ProdutoController(Produto objproduto) throws SQLException {
      produto.InsertProduto(objproduto);
      
  }
  

  
    
}

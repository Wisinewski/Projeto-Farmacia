
package Control;

import Model.DAO.ProdutoDAO;
import Model.Entidades.ProdutoEnt;
import java.sql.SQLException;


public class Produto {
    ProdutoDAO produto = new ProdutoDAO();
    
  public Produto(ProdutoEnt objproduto) throws SQLException
  {
      produto.InsertProduto(objproduto);
      
  }
  

  
    
}

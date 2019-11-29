
package model.dao;

import model.entities.Categoria;
import model.entities.Produto;
import controller.ProdutoController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProdutoDAO {
    
 
    public boolean  InsertProduto(Produto objProduto) throws SQLException
    {
        Connection conexao = Conexao1.getConnection();
         
        PreparedStatement insert;
        
        String conteudo = " INSERT INTO Produto (nome,preco,vencimento,lote,prescmedica,qtd,idcategoria) VALUES (?,?,?,?,?,?,?)" ;
        insert =conexao.prepareStatement(conteudo);
        
        insert.setString(1,objProduto.getNome());
        insert.setDouble(2,objProduto.getPreco());
        insert.setString(3,objProduto.getValidade());
        insert.setString(4,objProduto.getLote());
        insert.setInt(5,objProduto.getPrescricao());
        insert.setInt(6,objProduto.getQtd());
        System.out.println(""+objProduto.getCategoria().getId());
        insert.setInt(7,objProduto.getCategoria().getId());
        
           
        
        int registro = insert.executeUpdate();
        insert.close();
        
        if(registro == 1)
        {
            System.out.println("Inserido!");
            return true;         
        }
        else
            return false;
        
         
    }
    
    
    
}

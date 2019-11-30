
package model.dao.impl;

import model.dao.ProdutoDao;
import model.entities.Categoria;
import model.entities.Produto;
import controller.ProdutoController;
import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class ProdutoDaoJDBC implements ProdutoDao {
	private Connection conexao;
	
	public ProdutoDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}
    
    public boolean  InsertProduto(Produto objProduto) throws SQLException
    {
         
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

	@Override
	public void insert(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
    
    
    
}

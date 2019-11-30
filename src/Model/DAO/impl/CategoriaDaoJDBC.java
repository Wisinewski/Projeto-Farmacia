
package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.CategoriaDao;
import model.entities.Categoria;

public class CategoriaDaoJDBC implements CategoriaDao {
	private Connection conexao;

	public CategoriaDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	public void insert(Categoria categoria){
    	
        PreparedStatement insert;
        try {
	        String conteudo = " INSERT INTO Categoria (nome) VALUES (?)" ;
	        insert = conexao.prepareStatement(conteudo);
	        
	        insert.setString(1,categoria.getNome());
	        
	        int registro = insert.executeUpdate();
	        insert.close();
	        
	        if(registro == 1)
	        {
	            System.out.println("Inserido!");        
	        }    
        }
        catch(SQLException e) {
        	System.out.println(e.getMessage());
        }
    }

	public List<Categoria> findAll() {
		List<Categoria> lst_categoria = new ArrayList<>();
		try {
		PreparedStatement pstmt = conexao.prepareStatement("SELECT * FROM Categoria ");
		
		
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			Categoria categoriaEnt = new Categoria(rs.getInt("idcategoria"), rs.getString("nome"));
			lst_categoria.add(categoriaEnt);
		}
		pstmt.close();
		
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return lst_categoria;
	}

	@Override
	public void update(Categoria categoria) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Categoria findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}

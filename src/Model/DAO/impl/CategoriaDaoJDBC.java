
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
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement(
					"UPDATE Categoria "
					+ "SET nome = ? "
					+ "WHERE idcategoria = ?");
			
			st.setString(1, categoria.getNome());
			st.setInt(2, categoria.getId());
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteById(Long id) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("DELETE FROM Categoria WHERE idcategoria = ?");
			
			st.setLong(1, id);
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public Categoria findById(Long id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conexao.prepareStatement(
					"SELECT * FROM Categoria WHERE idcategoria = ?");
			
			st.setLong(1, id);
			
			rs = st.executeQuery();
			if(rs.next()) {
				Categoria categoria = new Categoria(rs.getInt("idcategoria"), rs.getString("nome"));
				return categoria;
			}
			return null;
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}


}

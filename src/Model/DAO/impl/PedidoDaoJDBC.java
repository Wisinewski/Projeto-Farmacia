package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.dao.PedidoDao;
import model.entities.Pedido;

public class PedidoDaoJDBC implements PedidoDao {

	private Connection conexao;

	public PedidoDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}
	
	@Override
	public boolean insert(Pedido pedido) {
		PreparedStatement insert;
		ResultSet rs = null;
		
        try {
	        String conteudo = " INSERT INTO Pedido (data) VALUES (?)" ;
	        insert = conexao.prepareStatement(conteudo, Statement.RETURN_GENERATED_KEYS);
	        
	        insert.setString(1,pedido.getDatapedido());
	        
	        int registro = insert.executeUpdate();
	        insert.close();
	        
	        // PEGA PRIMARY KEY DO Pedido QUE ACABOU DE SER PERSISTIDO
	        rs = insert.getGeneratedKeys();
	        if(rs.next()) {
	        	int lastId = rs.getInt(1);
	        	pedido.setIdpedido(lastId);
	        }
	        
	        if(registro == 1)
	        {
	            System.out.println("Inserido!");  
                    return true;
                 
	        }   
	        
        }
        catch(SQLException e) {
        	System.out.println(e.getMessage());
               
        }
        return false;
	}

	@Override
	public void update(Pedido pedido) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("UPDATE Pedido " + "SET precopedido = ? " + "WHERE idpedido = ?");

			st.setDouble(1, pedido.getPrecopedido());
			st.setInt(2, pedido.getIdpedido());

			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public boolean deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("DELETE FROM Pedido WHERE idpedido = ?");

			st.setInt(1, id);

			st.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Pedido findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conexao.prepareStatement("SELECT * FROM Pedido WHERE idpedido = ?");

			st.setLong(1, id);

			rs = st.executeQuery();
			if (rs.next()) {
				Pedido pedido = new Pedido(rs.getInt("idpedido"), rs.getString("data"), rs.getDouble("precopedido"));
				return pedido;
			}
			return null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Pedido> findAll() {
		List<Pedido> lst_pedido = new ArrayList<>();
		try {
			PreparedStatement pstmt = conexao.prepareStatement("SELECT * FROM Pedido ");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Pedido pedido = new Pedido(rs.getInt("idpedido"), rs.getString("data"), rs.getDouble("precopedido"));
				lst_pedido.add(pedido);
			}
			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lst_pedido;
	}

}

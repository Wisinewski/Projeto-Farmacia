package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.dao.ProdutoItemDao;
import model.entities.Pedido;
import model.entities.Produto;
import model.entities.ProdutoItem;

public class ProdutoItemDaoJDBC implements ProdutoItemDao {

	private Connection conexao;

	public ProdutoItemDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}
	
	@Override
	public boolean insert(ProdutoItem produtoItem) {

		PreparedStatement insert;

		String conteudo = " INSERT INTO PedidoItem (idpedido,idproduto,qtd) VALUES (?,?,?)";
		try {
			insert = conexao.prepareStatement(conteudo);
			insert.setInt(1, produtoItem.getIdpedido());
			insert.setInt(2, produtoItem.getIdproduto());
			insert.setInt(3, produtoItem.getQtd());

			int registro = insert.executeUpdate();
			insert.close();

			if (registro == 1) {
				System.out.println("Inserido!");
				return true;

			} else {
				System.out.println("Erro ao Inserir!");

			}
		} catch (SQLException ex) {
			Logger.getLogger(ProdutoItemDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	@Override
	public List<ProdutoItem> findAllById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		List<ProdutoItem> lst_produtoItem = new ArrayList<>();
		try {
			st = conexao.prepareStatement("SELECT * FROM PedidoItem WHERE idpedido = ?");
			
			st.setInt(1, id);

			rs = st.executeQuery();

			while (rs.next()) {

				ProdutoItem produtoItem = new ProdutoItem(rs.getInt("idpedido"), rs.getInt("idproduto"), rs.getInt("qtd"));
				lst_produtoItem.add(produtoItem);
			}
			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lst_produtoItem;
	}

}

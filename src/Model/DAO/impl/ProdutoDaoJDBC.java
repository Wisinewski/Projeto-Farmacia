package model.dao.impl;

import model.dao.ProdutoDao;
import model.entities.Categoria;
import model.entities.Produto;
import controller.ProdutoController;
import db.DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDaoJDBC implements ProdutoDao {

	private Connection conexao;

	public ProdutoDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public boolean insert(Produto produto) {

		PreparedStatement insert;

		String conteudo = " INSERT INTO Produto (nome,preco,vencimento,lote,prescmedica,qtd,idcategoria) VALUES (?,?,?,?,?,?,?)";
		try {
			insert = conexao.prepareStatement(conteudo);
			insert.setString(1, produto.getNome());
			insert.setDouble(2, produto.getPreco());
			insert.setString(3, produto.getVencimento());
			insert.setString(4, produto.getLote());
			insert.setInt(5, produto.getPrescricao());
			insert.setInt(6, produto.getQtd());
			insert.setInt(7, produto.getCategoria().getId());

			int registro = insert.executeUpdate();
			insert.close();

			if (registro == 1) {
				System.out.println("Inserido!");
				return true;

			} else {
				System.out.println("Erro ao Inserir!");

			}
		} catch (SQLException ex) {
			Logger.getLogger(ProdutoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	@Override
	public boolean update(Produto produto) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("UPDATE Produto SET nome = ?,"
                                + "preco=?,"
				+ "vencimento=?,"
                                + "lote=?,"
                                + "prescmedica=?,"
                                + "qtd=?,"
			        + "idcategoria=?"
                                + "WHERE idproduto=?");

			st.setString(1, produto.getNome());
			st.setDouble(2, produto.getPreco());
                        st.setString(3, produto.getVencimento());
                        st.setString(4, produto.getLote());
                        st.setInt(5, produto.getPrescricao());
                        st.setInt(6, produto.getQtd());
                        st.setInt(7, produto.getCategoria().getId());
                        st.setInt(8, produto.getId());

			if(st.executeUpdate() ==1)
                        {
                            return true;
                        }
                        
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
                return false;
	}

	@Override
	public boolean deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conexao.prepareStatement("DELETE FROM Produto WHERE idproduto = ?");

			st.setLong(1, id);

			st.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	@Override
	public Produto findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conexao.prepareStatement("SELECT * FROM Produto WHERE idproduto = ?");

			st.setLong(1, id);

			rs = st.executeQuery();
			if (rs.next()) {
				Produto produto = new Produto(rs.getInt("idproduto"), rs.getString("nome"), rs.getDouble("preco"),
						rs.getString("vencimento"), rs.getString("lote"), rs.getInt("prescmedica"), rs.getInt("qtd"),
						rs.getInt("idcategoria"));
				return produto;
			}
			return null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Produto> findAll() {
		List<Produto> lst_produto = new ArrayList<>();
		try {
			PreparedStatement pstmt = conexao.prepareStatement("SELECT * FROM Produto ");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Produto produto = new Produto(rs.getInt("idproduto"), rs.getString("nome"), rs.getDouble("preco"),
						rs.getString("vencimento"), rs.getString("lote"), rs.getInt("prescmedica"), rs.getInt("qtd"),
						rs.getInt("idcategoria"));
				lst_produto.add(produto);
			}
			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lst_produto;
	}

	@Override
	public List<Produto> findByWord(String desc) {

		List<Produto> lst_produto = new ArrayList<>();
		try {
			PreparedStatement pstmt = conexao.prepareStatement("SELECT * FROM Produto WHERE nome LIKE ?");
			pstmt.setString(1, "%" + desc + "%");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Produto produto = new Produto(rs.getInt("idproduto"), rs.getString("nome"), rs.getDouble("preco"),
						rs.getString("vencimento"), rs.getString("lote"), rs.getInt("prescmedica"), rs.getInt("qtd"),
						rs.getInt("idcategoria"));
				lst_produto.add(produto);
			}
			pstmt.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lst_produto;

	}

}

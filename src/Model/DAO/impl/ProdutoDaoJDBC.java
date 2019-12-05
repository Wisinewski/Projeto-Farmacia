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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDaoJDBC implements ProdutoDao {

    private Connection conexao;

    public ProdutoDaoJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void insert(Produto produto) {

        PreparedStatement insert;

        String conteudo = " INSERT INTO Produto (nome,preco,vencimento,lote,prescmedica,qtd,idcategoria) VALUES (?,?,?,?,?,?,?)";
        try {
            insert = conexao.prepareStatement(conteudo);
            insert.setString(1, produto.getNome());
            insert.setDouble(2, produto.getPreco());
            insert.setDate(3, (Date) produto.getVencimento());
            insert.setString(4, produto.getLote());
            insert.setInt(5, produto.getPrescricao());
            insert.setInt(6, produto.getQtd());
            insert.setInt(7, produto.getCategoria().getId());

            int registro = insert.executeUpdate();
            insert.close();

            if (registro == 1) {
                System.out.println("Inserido!");

            } else {
                System.out.println("Erro ao Inserir!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Produto produto) {
        PreparedStatement st = null;
        try {
            st = conexao.prepareStatement(
                    "UPDATE Categoria "
                    + "SET nome = ? "
                    + "SET preco = ? "
                    + "SET vencimento = ? "
                    + "SET lote = ? "
                    + "SET prescmedica = ? "
                    + "SET qtd = ? "
                    + "SET idcategoria = ? "
                    + "WHERE idcategoria = ?");

            st.setString(1, produto.getNome());
            st.setInt(2, produto.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conexao.prepareStatement("DELETE FROM Produto WHERE idproduto = ?");

            st.setLong(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Produto findById(Integer id) {
        PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conexao.prepareStatement(
					"SELECT * FROM Produto WHERE idproduto = ?");
			
			st.setLong(1, id);
			
			rs = st.executeQuery();
			if(rs.next()) {
				Produto produto = new Produto(rs.getInt("idproduto"), 
                                                              rs.getString("nome"),
                                                              rs.getDouble("preco"),
                                                              rs.getDate("vecimento"),
                                                              rs.getString("lote"),
                                                              rs.getInt("prescmedica"),
                                                              rs.getInt("qtd"),
                                                              rs.getInt("idcategoria"));
				return produto;
			}
			return null;
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
    }

    @Override
    public List<Produto> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

}

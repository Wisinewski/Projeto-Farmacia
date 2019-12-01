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
            insert.setString(3, produto.getValidade());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Javassim
 */
public class LoginDAO {

    public boolean Pesquisar(String nome, String senha) throws SQLException {

        boolean result = false;
        Connection conexao = Conexao1.getConnection();
        PreparedStatement pstmt
                = conexao.prepareStatement(
                        "SELECT * FROM login where nm_login = ? and ds_senha = ?");
        pstmt.setString(1, nome);
        pstmt.setString(2, senha);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println("Encontrado");
            result = true;

        }
        pstmt.close();
        return result;

    }

    public boolean Incluir(String nome, String senha) throws SQLException {
        Connection conexao = Conexao1.getConnection();

        PreparedStatement insert;
        String conteudo = "INSERT INTO login (nm_login,ds_senha)"
                + " VALUES (?,?)";

        insert = conexao.prepareStatement(conteudo);

        insert.setString(1, nome);
        insert.setString(2, senha);

        int registros = insert.executeUpdate();
        insert.close();// fecha a conexao
        if (registros == 1) {
            return true;
        } else {
            return false;
        }

    }

}

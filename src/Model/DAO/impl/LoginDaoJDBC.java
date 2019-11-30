/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import model.dao.LoginDao;
import model.entities.Login;

/**
 *
 * @author Javassim
 */
public class LoginDaoJDBC implements LoginDao {
	private Connection conexao;
	
	public LoginDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}

    public boolean logar(String nome, String senha) {

        boolean result = false;
        try {
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
        }
        catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return result;

    }

    public boolean Incluir(String nome, String senha) throws SQLException {

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

	@Override
	public void insert(Login login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Login login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Login findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Login> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

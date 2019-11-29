
package controller;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.dao.LoginDAO;


public class LoginController {
  private String login;
  private String senha;
   
    public LoginController(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
   public boolean Logar() throws SQLException
   {
       boolean a ;
       
       LoginDAO logar = new LoginDAO();
       a =  logar.Pesquisar(login, senha);
       
      System.out.println(""+a);   
      return false;
       
   }
   
   }
   


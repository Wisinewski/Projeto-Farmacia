
package controller;


import java.sql.SQLException;

import model.dao.DaoFactory;
import model.dao.LoginDao;


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
       
       LoginDao logar = DaoFactory.createLoginDao();
       a =  logar.verify(login, senha);
       
      System.out.println(""+a);   
      return false;
       
   }
   
   }
   


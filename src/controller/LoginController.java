package controller;

import java.sql.SQLException;

import model.dao.DaoFactory;
import model.dao.LoginDao;
import model.entities.Login;

public class LoginController {

    private LoginDao loginDao = DaoFactory.createLoginDao();

    public LoginController() {
    }

    public boolean verify(Login login) {
        boolean a;

        a = loginDao.verify(login);

        return a;

    }

}

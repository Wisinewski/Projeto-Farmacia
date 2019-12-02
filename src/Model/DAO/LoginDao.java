package model.dao;

import java.util.List;

import model.entities.Login;

public interface LoginDao {

	void insert(Login login);
	void update(Login login);
	void deleteById(Long id);
	Login findById(Long id);
	List<Login> findAll();
	
	boolean verify(Login login);
}

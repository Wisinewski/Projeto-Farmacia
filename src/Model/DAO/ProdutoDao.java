package model.dao;

import java.sql.PreparedStatement;
import java.util.List;

import model.entities.Produto;

public interface ProdutoDao {
	
	boolean insert(Produto produto);
	boolean update(Produto produto);
	boolean deleteById(Integer id);
	Produto findById(Integer id);
	List<Produto> findAll();
    List<Produto> findByWord(String desc);
    
}

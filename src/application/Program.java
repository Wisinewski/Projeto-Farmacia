/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import db.DB;
import model.dao.CategoriaDao;
import model.dao.ProdutoDao;
import model.dao.impl.CategoriaDaoJDBC;
import model.dao.impl.ProdutoDaoJDBC;
import model.entities.Categoria;
import model.entities.Produto;

/**
 *
 * @author Morais
 */
public class Program {

    /**
     * @param args the command line arguments
     * @throws ParseException 
     */
    public static void main(String[] args) throws SQLException, ParseException  {
 
    	// OPERACOES CATEGORIA
    	/*
    	CategoriaDao categoriaDao = new CategoriaDaoJDBC(DB.getConnection());
    	categoriaDao.insert(new Categoria(null, "Quimicos"));
    	
    	System.out.println(categoriaDao.findById(1));
    	
    	categoriaDao.deleteById(32);
    	
    	List<Categoria> listaCategorias = categoriaDao.findAll();
    	listaCategorias.stream().forEach(System.out::println);
    	*/
    	//
    	
    	
    	// OPERACOES PRODUTO
    /*
    	ProdutoDao produtoDao = new ProdutoDaoJDBC(DB.getConnection());
    	
    	produtoDao.insert(new Produto(null, "Salgadinho", 5.0, "30-05-2020", "123", 0, 400, 2));
    	
    	System.out.println("teste"+produtoDao.findById(2));
    	
    	produtoDao.deleteById(1);
    	
    	List<Produto> listaProdutos = produtoDao.findAll();
    	listaProdutos.stream().forEach(System.out::println);
      */
    
    
    // OPERACAO PRODUTO PESQUISA POR NOME
    
    	ProdutoDao produtoDao = new ProdutoDaoJDBC(DB.getConnection());
 
    	
   
    	String desc = "Mateus";
    	List<Produto> listaProdutos = produtoDao.findByWord(desc);
    	listaProdutos.stream().forEach(System.out::println);
      
        
    }
    
}

package model.dao;

import db.DB;
import model.dao.impl.CategoriaDaoJDBC;
import model.dao.impl.LoginDaoJDBC;
import model.dao.impl.PedidoDaoJDBC;
import model.dao.impl.ProdutoDaoJDBC;
import model.dao.impl.ProdutoItemDaoJDBC;

public class DaoFactory {

	public static CategoriaDao createCategoriaDao() {
		return new CategoriaDaoJDBC(DB.getConnection());
	}
	
	public static LoginDao createLoginDao() {
		return new LoginDaoJDBC(DB.getConnection());
	}
	
	public static ProdutoDao createProdutoDao() {
		return new ProdutoDaoJDBC(DB.getConnection());
	}
	
	public static PedidoDao createPedidoDao() {
		return new PedidoDaoJDBC(DB.getConnection());
	}
	
	public static ProdutoItemDao createProdutoItemDao() {
		return new ProdutoItemDaoJDBC(DB.getConnection());
	}
}

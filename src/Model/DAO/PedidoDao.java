package model.dao;

import java.util.List;

import model.entities.Pedido;

public interface PedidoDao {
	
	boolean insert(Pedido categoria);
	void update(Pedido categoria);
	boolean deleteById(Integer id);
	Pedido findById(Integer id);
	List<Pedido> findAll();
}

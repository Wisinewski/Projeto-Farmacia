package model.dao;

import java.util.List;

import model.entities.Pedido;

public interface PedidoDao {
	
	void insert(Pedido categoria);
	void update(Pedido categoria);
	void deleteById(Long id);
	Pedido findById(Long id);
	List<Pedido> findAll();
}

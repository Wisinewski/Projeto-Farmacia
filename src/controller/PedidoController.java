package controller;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.PedidoDao;
import model.entities.Pedido;

public class PedidoController {
	PedidoDao pedidoDao = DaoFactory.createPedidoDao();
	
	public PedidoController() {
	}

	public boolean insert(Pedido pedido) {
		return pedidoDao.insert(pedido);
	}

	public void update(Pedido pedido) {
		pedidoDao.update(pedido);
	}

	public boolean deleteById(Integer id) {
		return pedidoDao.deleteById(id);
	}

	public Pedido findById(Integer id) {
		return pedidoDao.findById(id);
	}

	public List<Pedido> findAll() {
		return pedidoDao.findAll();
	}

}

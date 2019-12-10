package model.entities;

import controller.ProdutoController;
import db.DB;
import model.dao.ProdutoDao;
import model.dao.impl.ProdutoDaoJDBC;

public class ProdutoItem {
	private Integer idpedido;
	private Integer idproduto;
	private Integer qtd;
	
	public ProdutoItem() {
	}

	public ProdutoItem(Integer idpedido, Integer idproduto, Integer qtd) {
		super();
		this.idpedido = idpedido;
		this.idproduto = idproduto;
		this.qtd = qtd;
	}

	public Integer getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}

	public Integer getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(Integer idproduto) {
		this.idproduto = idproduto;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}
	
	public Double getPrecoProdutoItem() {
		ProdutoController pc = new ProdutoController();
		Produto produto = pc.findById(idproduto);
		return this.qtd * produto.getPreco();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpedido == null) ? 0 : idpedido.hashCode());
		result = prime * result + ((idproduto == null) ? 0 : idproduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoItem other = (ProdutoItem) obj;
		if (idpedido == null) {
			if (other.idpedido != null)
				return false;
		} else if (!idpedido.equals(other.idpedido))
			return false;
		if (idproduto == null) {
			if (other.idproduto != null)
				return false;
		} else if (!idproduto.equals(other.idproduto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProdutoItem [idpedido=" + idpedido + ", idproduto=" + idproduto + ", qtd=" + qtd + "]";
	}

}

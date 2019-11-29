package model.entities;

public class ProdutoItem {
	private Long idpedido;
	private Long idproduto;
	private Long qtd;
	
	public ProdutoItem() {
	}

	public ProdutoItem(Long idpedido, Long idproduto, Long qtd) {
		super();
		this.idpedido = idpedido;
		this.idproduto = idproduto;
		this.qtd = qtd;
	}

	public Long getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Long idpedido) {
		this.idpedido = idpedido;
	}

	public Long getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(Long idproduto) {
		this.idproduto = idproduto;
	}

	public Long getQtd() {
		return qtd;
	}

	public void setQtd(Long qtd) {
		this.qtd = qtd;
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

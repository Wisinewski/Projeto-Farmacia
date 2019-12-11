package model.entities;

public class Pedido {
	private Integer idpedido;
	private String datapedido;
	private Double precopedido;
	
	public Pedido() {
	}

	public Pedido(Integer idpedido, String datapedido, Double precopedido) {
		super();
		this.idpedido = idpedido;
		this.datapedido = datapedido;
		this.precopedido = precopedido;
	}

	public Integer getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}

	public String getDatapedido() {
		return datapedido;
	}

	public void setDatapedido(String datapedido) {
		this.datapedido = datapedido;
	}

	public Double getPrecopedido() {
		return precopedido;
	}
        
        
        

	public void setPrecopedido(Double precopedido) {
		this.precopedido = precopedido;
	}
	
	public void adicionaPrecoPedido(ProdutoItem produtoItem) {
		this.precopedido += produtoItem.getPrecoProdutoItem();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datapedido == null) ? 0 : datapedido.hashCode());
		result = prime * result + ((idpedido == null) ? 0 : idpedido.hashCode());
		result = prime * result + ((precopedido == null) ? 0 : precopedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (datapedido == null) {
			if (other.datapedido != null)
				return false;
		} else if (!datapedido.equals(other.datapedido))
			return false;
		if (idpedido == null) {
			if (other.idpedido != null)
				return false;
		} else if (!idpedido.equals(other.idpedido))
			return false;
		if (precopedido == null) {
			if (other.precopedido != null)
				return false;
		} else if (!precopedido.equals(other.precopedido))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [idpedido=" + idpedido + ", datapedido=" + datapedido + ", precopedido=" + precopedido + "]";
	}
	
}

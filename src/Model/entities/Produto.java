
package model.entities;

import controller.CategoriaController;
import java.util.Date;


public class Produto {
    private Integer idproduto;
    private String nome;
    private Double preco;
    private Date vencimento;
    private String lote;
    private int prescricao;
    private Integer qtd;
    
    private Categoria categoria;
    
    CategoriaController cc = new CategoriaController();
    
    public Produto() {
    }

    public Produto(Integer idproduto, String nome, Double preco, Date vencimento, String lote, int prescricao, Integer qtd, Integer idcategoria) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.preco = preco;
        this.vencimento = vencimento;
        this.lote = lote;
        this.prescricao = prescricao;
        this.qtd = qtd;
        this.categoria = cc.findById(idcategoria);
    }

    public Produto(Object object, String text, double parseDouble, String date, String text0, int receita, int qtd, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return this.idproduto;
    }
    
    public void setId(Integer idproduto) {
        this.idproduto = idproduto;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    public Date getVencimento() {
        return this.vencimento;
    }
    
    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(int prescricao) {
        this.prescricao = prescricao;
    }
  
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

	@Override
	public String toString() {
		return "Produto [idproduto=" + idproduto + ", nome=" + nome + ", preco=" + preco + ", qtd=" + qtd
				+ ", lote=" + lote + ", prescricao=" + prescricao + ", categoria="
				+ categoria + "]";
	}
   
}

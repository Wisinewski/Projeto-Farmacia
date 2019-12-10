package model.entities;

import controller.CategoriaController;
import java.util.Date;

public class Produto {

    private Integer idproduto;
    private String nome;
    private Double preco;
    private String vencimento;
    private String lote;
    private int prescricao;
    private Integer qtd;
    private Categoria categoria;

    CategoriaController cc = new CategoriaController();

    public Produto() {
    }

    public Produto(Integer idproduto, String nome, Double preco, String vencimento, String lote, int prescricao, Integer qtd, Integer idcategoria) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.preco = preco;
        this.vencimento = vencimento;
        this.lote = lote;
        this.prescricao = prescricao;
        this.qtd = qtd;
        this.categoria = cc.findById(idcategoria);
    }

    public Produto(Object object, String string, double d, Date date, int i, int j, int k, int l) {
        // TODO Auto-generated constructor stub
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

    public String getVencimento() {
        return this.vencimento;
    }

    public void setVencimento(String vencimento) {
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

    public boolean toBooleanPrescricao() {
        if (prescricao == 1) {
            return true;
        } else {
            return false;
        }
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
                + ", data=" + vencimento + ", lote=" + lote + ", prescricao=" + prescricao + ", categoria="
                + categoria + "]";
    }

}

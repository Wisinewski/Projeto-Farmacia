
package model.entities;


public class Produto {
    Integer idproduto;
    String nome;
    Double preco;
    Integer qtd;
    String validade;
    String lote;
    int prescricao;
    Categoria categoria;
    
    public Produto(Integer idproduto,String nome, Double preco, Integer qtd, String validade, String lote, int prescricao, Categoria categoria) {
     
        this.idproduto = idproduto;
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
        this.validade = validade;
        this.lote = lote;
        this.prescricao = prescricao;
        this.categoria = categoria;
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

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
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
   
 
    
    
    
    
    
}

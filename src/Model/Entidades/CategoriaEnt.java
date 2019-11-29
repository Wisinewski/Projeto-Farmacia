
package Model.Entidades;

import java.util.Objects;


public class CategoriaEnt {

    private String nome;
    private Integer id;
    
    public CategoriaEnt()
    {
        
    }
    public CategoriaEnt(Integer id, String nome)
    {
     this.id = id;
     this.nome = nome;   
    }
      public String getNome() {
      return nome;
    }

    public Integer getId() {
        return id;
    }
    public void setNome(String nm)
    {
        this.nome =  nm;
    }
    
@Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoriaEnt other = (CategoriaEnt) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}

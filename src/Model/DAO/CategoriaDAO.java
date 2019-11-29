
package Model.DAO;


import Model.DAO.Conexao1;
import Model.Entidades.CategoriaEnt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.Soundbank;
import javax.swing.SpringLayout;


public class CategoriaDAO {
    
    public boolean  InsertCategoriaDAO(CategoriaEnt categoria) throws SQLException
    {
        Connection conexao = Conexao1.getConnection();
         
        PreparedStatement insert;
        
        String conteudo = " INSERT INTO Categoria (nome) VALUES (?)" ;
        insert =conexao.prepareStatement(conteudo);
        
        insert.setString(1,categoria.getNome());
        
        int registro = insert.executeUpdate();
        insert.close();
        
        if(registro == 1)
        {
            System.out.println("Inserido!");
            return true;         
        }
        else
            return false;
        
         
    }
    
    
    public List<CategoriaEnt> BuscarCategorias() throws SQLException {
        List<CategoriaEnt> lst_categoria = new ArrayList<>();
       
     
        Connection conexao = Conexao1.getConnection();
        PreparedStatement pstmt
                = conexao.prepareStatement(
                        "SELECT * FROM Categoria ");
      

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {           
            
            CategoriaEnt categoriaEnt =  new CategoriaEnt(rs.getInt("idcategoria"),rs.getString("nome"));
            lst_categoria.add(categoriaEnt);
        }
        pstmt.close();
        return lst_categoria;

    }
    
    
}
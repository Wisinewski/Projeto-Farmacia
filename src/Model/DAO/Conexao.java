package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao {

    private static Connection conexao;

    public Conexao() {
     
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:/Users/TEMP.FATECRL.002/Documents/prj_Farmacia/pharma.db";
            conexao = DriverManager.getConnection(url);
            System.out.println("Banco Conectado!");       
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro de conexão. Verifique a Base de Dados indicada !" + "\n" + erro.getMessage(), "Conexão", 3);
            erro.printStackTrace();
        }
        

    }
    
    public Connection getConexao() {
        return conexao;
    }

    
}

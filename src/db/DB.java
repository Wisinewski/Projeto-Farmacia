package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DB {

    private static Connection conexao = null;

    public static Connection getConnection() {

        if (conexao == null) {
            try {
                Class.forName("org.sqlite.JDBC");
            //  String url = "jdbc:sqlite:C:/Users/TEMP.FATECRL.002/Documents/prj_Farmacia/pharma.db";
               // String url = "jdbc:sqlite:C:/Users/wisinewski/Desktop/projetin/Projeto-Farmacia/pharma.db";
                  String url = "jdbc:sqlite:C:/Users/Morais/Documents/NetBeansProjects/Projeto-Farmacia/pharma.db";
                conexao = DriverManager.getConnection(url);
                System.out.println("Banco Conectado!");
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null,
                        "Ocorreu um erro de conexão. Verifique a Base de Dados indicada !" + "\n" + erro.getMessage(), "Conexão", 3);
                erro.printStackTrace();
            }
            
        }
        return conexao;

    }
    public static void closeConnection(){
        if(conexao !=null)
        {
            try{
             conexao.close();
            }catch(Exception e){
                 JOptionPane.showMessageDialog(null,
                        "Ocorreu um erro de conexão. Verifique a Base de Dados indicada !" + "\n" + e.getMessage(), "Conexão", 3);
                e.printStackTrace();
            }
           
        }   
    }
}

package cadastromotorbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lhries
 */
public class CadastroMotorBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Passo 1:
            Class.forName("org.postgresql.Driver");
            
            //Passo 2:
            String url = "jdbc:postgresql://localhost:5432/motor";
            String username = "postgres";
            String password = "123456";            
            Connection conexao = DriverManager.getConnection(url, username, password);
            
            //Passo 3 e 4: Comando
            String sqlInsert = "INSERT INTO motor(nome,descricao,uso) VALUES (?,?,?)";
            String sqlSelect = "SELECT * FROM motor";
            
            String nome = JOptionPane.showInputDialog("Nome:");
            String descricao = JOptionPane.showInputDialog("Descricao:");
            String uso = JOptionPane.showInputDialog("Uso:");
            
            PreparedStatement comando = conexao.prepareStatement(sqlInsert);
            comando.setString(1,nome);
            comando.setString(2,descricao);
            comando.setString(3,uso);
            
            PreparedStatement comandoSelect = conexao.prepareStatement(sqlSelect);
            
            comando.executeUpdate();
            ResultSet resultado = comandoSelect.executeQuery();
            
            while (resultado.next()) {
            String n = resultado.getString("nome");
            String d = resultado.getString("descricao");
            String u = resultado.getString("uso");
            
            System.out.println("Nome: " + n + " Descriçao: " + d + " Uso: " + u);
            
            }
            
            
            
            //Passo 5: fechar conexao
            comando.close();
            conexao.close();
            
            comandoSelect.close();
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroMotorBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroMotorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

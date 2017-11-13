/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 630610194
 */
public class ExemploBD {

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
            
            Connection conexao = DriverManager.getConnection(url,username,password);
            
            //Passo 3 e 4
            String sql = "INSERT INTO motor(nome,descricao,uso) VALUES (?,?,?)";
            
            String nome = JOptionPane.showInputDialog("Nome:");
            String descricao = JOptionPane.showInputDialog("Descrição:");
            String uso = JOptionPane.showInputDialog("Uso:");
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            
           comando.setString(1, nome);
           comando.setString(2, descricao);
           comando.setString(3, uso);
           
           comando.executeUpdate();
           
           //Passo 5: fechar conexao
           comando.close();
           conexao.close();
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExemploBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ExemploBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

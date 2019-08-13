/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.RecemNascido;
/**
 *
 * @author Administrador
 */
public class DaoRecemNascido {
    public static boolean inserir(RecemNascido objeto) {
        String sql = "INSERT INTO recemnascido (nomemae, peso, numeroquarto, sexo) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNomemae());
            ps.setDouble(2, objeto.getPeso());
            ps.setInt(3, objeto.getNumeroquarto());
            ps.setString(4, objeto.getSexo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     public static void main(String[] args) {
        RecemNascido objeto = new RecemNascido();
        objeto.setNomemae("Maria");
        objeto.setPeso(3.2);
        objeto.setNumeroquarto(43);
        objeto.setSexo("F");
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
     public static boolean alterar(RecemNascido objeto) {
        String sql = "UPDATE recemnascido SET codigo = ?, nomemae = ?, peso = ?, numeroquarto = ? WHERE sexo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo()); 
            ps.setString(2, objeto.getNomemae());
            ps.setDouble(3, objeto.getPeso());
            ps.setInt(4, objeto.getNumeroquarto());
            ps.setString(5, objeto.getSexo());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     public static boolean excluir(RecemNascido objeto) {
        String sql = "DELETE FROM recemnascido WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}

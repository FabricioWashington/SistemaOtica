package DAO.Vetores;

import DAO.Conexao.ConexaoDAO;
import DTO.Login.Tipos_LoginDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JComboBox;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VetorTipoLogin {
    
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ArrayList<Integer> idtipos_login = new ArrayList<>();
    private JComboBox<String> cbxTipoLogin;

    // Construtor que recebe o JComboBox Tipos Login
    public VetorTipoLogin(JComboBox<String> cbxTipoLogin) {
        this.cbxTipoLogin = cbxTipoLogin;
    }

    public void restaurarDadosCbxTiposLogin() {

        try {
            Tipos_LoginDTO objtiposlogindto = new Tipos_LoginDTO();
            rs = ListarTipo_Login(objtiposlogindto);

            //Limpa os itens anteriores
            idtipos_login.clear();
            cbxTipoLogin.removeAllItems();

            //Adiciona a opção "Selecione"
            cbxTipoLogin.addItem("Selecione");

            // Adiciona novos dados no VetorTipoLogin e no ComboBox
            while (rs.next()) {
                idtipos_login.add(rs.getInt(1));   // Adiciona o ID no VetorTipoLogin
                cbxTipoLogin.addItem(rs.getString(2));   // Adiciona o nome no ComboBox

            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro em Class Vector no metodo restaurarDadosCbxTiposLogin: " + erro);
        }
    }
    
     public ResultSet ListarTipo_Login(Tipos_LoginDTO objtiposlogindto) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "SELECT * FROM tipos_login ORDER BY tipos_login";
        try {

            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Método para obter o VetorTipoLogin de IDs
    public ArrayList<Integer> getIdTiposLogin() {
        return idtipos_login;
    }

}

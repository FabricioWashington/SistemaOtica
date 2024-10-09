package DAO.Vetores;

import DAO.Login.LoginDAO;
import DTO.Login.Tipos_LoginDTO;
import javax.swing.JComboBox;
import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VetorTipoLogin {

    private ArrayList<Integer> idtipos_login = new ArrayList<>();
    private JComboBox<String> cbxTipoLogin;

    // Construtor que recebe o JComboBox Tipos Login
    public VetorTipoLogin(JComboBox<String> cbxTipoLogin) {
        this.cbxTipoLogin = cbxTipoLogin;
    }

    public void restaurarDadosCbxTiposLogin() {

        try {
            Tipos_LoginDTO objtiposlogindto = new Tipos_LoginDTO();
            LoginDAO objlogindao = new LoginDAO();
            ResultSet rs = objlogindao.ListarTipo_Login(objtiposlogindto);

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

    // Método para obter o VetorTipoLogin de IDs
    public ArrayList<Integer> getIdTiposLogin() {
        return idtipos_login;
    }

}

package DAO.Vetores;

import DAO.Login.LoginDAO;
import DTO.Login.Tipos_LoginDTO;
import javax.swing.JComboBox;
import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Vector {

    private ArrayList<Integer> idtipos_login = new ArrayList<>();
    private JComboBox<String> cbxTipoLogin;

    // Construtor que recebe o JComboBox
    public Vector(JComboBox<String> cbxTipoLogin) {
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
            
            // Adiciona novos dados no Vector e no ComboBox
            while (rs.next()) {
                idtipos_login.add(rs.getInt(1));   // Adiciona o ID no Vector
                cbxTipoLogin.addItem(rs.getString(2));   // Adiciona o nome no ComboBox

            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro em Class Vector no metodo restarurarDadosCbxTiposLogin: " + erro);
        }
    }
    // Método para obter o Vector de IDs

    public ArrayList<Integer> getIdTiposLogin() {
        return idtipos_login;
    }
}

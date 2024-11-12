package DAO.Vetores;

import DAO.Conexao.ConexaoDAO;
import DTO.Vetores.DDD_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JComboBox;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VetorDdd {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ArrayList<Integer> idDDD = new ArrayList<>();
    private JComboBox<String> cbxDDD;
    
    public VetorDdd(JComboBox<String> cbxDDD){
        this.cbxDDD = cbxDDD;
    }
    
     public void restaurarDadosCbxDDD() {

        try {
            DDD_DTO objddddto = new DDD_DTO();
            rs = ListarDDD(objddddto);
            
            idDDD.clear();
            cbxDDD.removeAllItems();
            
            cbxDDD.addItem("Selecione");
            while (rs.next()) {
                idDDD.add(rs.getInt(1));
                cbxDDD.addItem(rs.getString(2));
            }


        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro em Class Vector no metodo restarurarDadosCbxDDD: " + erro);
        }
    }
    
        private ResultSet ListarDDD(DDD_DTO objDddDto) {
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "SELECT * FROM ddd ORDER BY numero";
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
        
    public ArrayList<Integer> getIdDDD(){
        return idDDD;
    }
    

}

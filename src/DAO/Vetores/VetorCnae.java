package DAO.Vetores;

import DTO.Vetores.CnaeDTO;
import DTO.Login.LoginDTO;
import DAO.Conexao.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class VetorCnae {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ArrayList<Integer> idCNAE = new ArrayList<>();
    private JComboBox<String> cbxCnaePrincipal;
    private CnaeDTO cnaeDto = new CnaeDTO();
    
    public VetorCnae(JComboBox<String> cbxCnaePrincipal){
        this.cbxCnaePrincipal = cbxCnaePrincipal;
    }
    
    
    
    public void restaurardadosComboBoxCNAE() {
        try {
            cnaeDto = new CnaeDTO();
            rs = listarCNAE(cnaeDto);
            
            idCNAE.clear();
            cbxCnaePrincipal.removeAllItems();
            
            cbxCnaePrincipal.addItem("Selecione");
            
            while (rs.next()) {
                idCNAE.add(rs.getInt(1));
                cbxCnaePrincipal.addItem(rs.getString(2));

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "erro em restaurar dados da cbx CNAE" + erro);
        }
    }

    private ResultSet listarCNAE(CnaeDTO objcnaedto) {
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "SELECT * FROM cnae ORDER BY CNAE_Principal";
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Integer> getCNAE(){
        return  idCNAE;
    }

}

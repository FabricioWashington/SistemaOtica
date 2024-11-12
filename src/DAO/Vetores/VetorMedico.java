package DAO.Vetores;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.MedicoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class VetorMedico {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ArrayList<Integer> idMedico = new ArrayList<>();
    private JComboBox<String> cbxMedico;

    public VetorMedico(JComboBox<String> cbxMedico) {
        this.cbxMedico = cbxMedico;
    }

    public void restaurarDadosCbxMedico() {
        try {
            MedicoDTO cadastroMedicoDTO = new MedicoDTO();
            rs = listarMedico(cadastroMedicoDTO);

            idMedico.clear();
            cbxMedico.removeAllItems();

            cbxMedico.addItem("Selecione");

            while (rs.next()) {
                String nome = rs.getString("Nome");
                String registro = rs.getString("registro_profissional");
                
                idMedico.add(rs.getInt(1));
                cbxMedico.addItem(nome + " - Registro: " + registro);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro em Class VetorMedico no metodo restaurarDadosCbxMedico: " + erro);

        }
    }

    private ResultSet listarMedico(MedicoDTO cadastroMedicoDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "select id_Optometrista, Nome, registro_profissional from optometrista";
        try {
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Integer> getMedico() {
        return idMedico;
    }
}

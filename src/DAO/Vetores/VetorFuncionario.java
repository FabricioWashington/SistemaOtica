package DAO.Vetores;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class VetorFuncionario {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ArrayList<Integer> idFuncionario = new ArrayList<>();
    private JComboBox<String> cbxFuncionario;

    public VetorFuncionario(JComboBox<String> cbxFuncionario) {
        this.cbxFuncionario = cbxFuncionario;
    }

    public void restaurarDadosCbxFuncionario() {
        try {
            FuncionarioDTO cadastroFuncionarioDTO = new FuncionarioDTO();
            rs = listarFuncionario(cadastroFuncionarioDTO);

            idFuncionario.clear();
            cbxFuncionario.removeAllItems();

            cbxFuncionario.addItem("Selecione");

            while (rs.next()) {
                String nome = rs.getString("Nome_Completo");
                String cpf = rs.getString("CPF");
                
                idFuncionario.add(rs.getInt("idFuncionario"));
                cbxFuncionario.addItem(nome + " - CPF: " + cpf);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro em Class VetorFuncionario no metodo restaurarDadosCbxFuncionario: " + erro);

        }
    }

    public ResultSet listarFuncionario(FuncionarioDTO cadastroFuncionarioDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "select idFuncionario, Nome_Completo, CPF from cadastro_funcionarios";
        try {
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Integer> getFuncionario() {
        return idFuncionario;
    }

}

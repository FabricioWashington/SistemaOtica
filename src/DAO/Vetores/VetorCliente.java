package DAO.Vetores;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class VetorCliente {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ArrayList<Integer> idCliente = new ArrayList<>();
    private JComboBox<String> cbxCliente;

    public VetorCliente(JComboBox<String> cbxCliente) {
        this.cbxCliente = cbxCliente;
    }

    public void restaurarDadosCbxCliente() {
        try {
            ClienteDTO cadastroClienteDTO = new ClienteDTO();
            rs = listarClientes(cadastroClienteDTO);

            idCliente.clear();
            cbxCliente.removeAllItems();

            cbxCliente.addItem("Selecione");

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String cnpj = rs.getString("cnpj");

                idCliente.add(rs.getInt("idClientes"));

                if (cpf != null) {
                    cbxCliente.addItem(nome + " - CPF: " + cpf);
                } else if (cnpj != null) {
                    cbxCliente.addItem(nome + " - CNPJ: " + cnpj);
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro em Class VetorCliente no metodo restaurarDadosCbxCliente: " + erro);

        }
    }

    private ResultSet listarClientes(ClienteDTO cadastroClienteDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "SELECT c.idClientes, c.nome, pf.cpf, pj.cnpj "
                + "FROM clientes c "
                + "LEFT JOIN pessoafisica pf ON c.idClientes = pf.idCliente "
                + "LEFT JOIN pessoajuridica pj ON c.idClientes = pj.idCliente "
                + "ORDER BY c.nome";
        try {
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Integer> getCliente() {
        return idCliente;
    }

}

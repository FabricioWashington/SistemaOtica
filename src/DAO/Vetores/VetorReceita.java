package DAO.Vetores;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.ClienteDTO;
import DTO.Crud.ReceitaExameDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class VetorReceita {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ArrayList<Integer> idReceita = new ArrayList<>();
    private JComboBox<String> cbxReceita;

    public VetorReceita(JComboBox<String> cbxReceita) {
        this.cbxReceita = cbxReceita;
    }

    public void restaurarDadosCbxReceita() {
        try {
            ReceitaExameDTO cadastroReceitaExameDTO = new ReceitaExameDTO();
            rs = listarReceitas(cadastroReceitaExameDTO);

            idReceita.clear();
            cbxReceita.removeAllItems();
            cbxReceita.addItem("Selecione");

            while (rs.next()) {
                int receitaId = rs.getInt("idReceita");
                int clienteId = rs.getInt("idClientes");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String cnpj = rs.getString("cnpj");

                // Adiciona o ID da Receita ao ArrayList
                idReceita.add(receitaId);

                // Monta a string de exibição
                String item = "Receita: " + receitaId + " - " + nome;
                if (cpf != null) {
                    item += " - CPF: " + cpf;
                } else if (cnpj != null) {
                    item += " - CNPJ: " + cnpj;
                }

                // Adiciona ao JComboBox
                cbxReceita.addItem(item);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro em Class VetorReceita no metodo restaurarDadosCbxReceita: " + erro);

        }
    }

    private ResultSet listarReceitas(ReceitaExameDTO cadastroReceitaExameDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "SELECT r.idReceita, c.idClientes, c.nome, pf.cpf, pj.cnpj "
                + "FROM receita_exame r "
                + "INNER JOIN clientes c ON r.id_Cliente = c.idClientes "
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

    public ArrayList<Integer> getReceita() {
        return idReceita;
    }

}

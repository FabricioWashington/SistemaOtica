package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.OrdemServicoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class OrdemServicoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    public void cadastrarOrdemServico(OrdemServicoDTO cadastroOrdemServicoDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            String sqlCadastro = "insert into ordem_servico (id_ordem, idCliente, id_Optometrista, id_Funcionario, id_Receita, idProduto, data_emissao, data_entrega, tipo_servico, status_servico, valor, valor_entrada, valor_restante, observacoes) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setInt(1, cadastroOrdemServicoDTO.getIdOrdemServico());
            pstmCadastro.setInt(2, cadastroOrdemServicoDTO.getIdCliente());
            pstmCadastro.setInt(3, cadastroOrdemServicoDTO.getIdMedico());
            pstmCadastro.setInt(4, cadastroOrdemServicoDTO.getIdFuncionario());
            pstmCadastro.setInt(5, cadastroOrdemServicoDTO.getIdReceita());
            pstmCadastro.setInt(6, cadastroOrdemServicoDTO.getIdProduto());
            if (cadastroOrdemServicoDTO.getDataEmissao() != null) {
                pstmCadastro.setDate(7, new java.sql.Date(cadastroOrdemServicoDTO.getDataEmissao().getTime()));
            } else {
                JOptionPane.showMessageDialog(null, "A data de emissão está nula", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            if (cadastroOrdemServicoDTO.getDataEntrega() != null) {
                pstmCadastro.setDate(8, new java.sql.Date(cadastroOrdemServicoDTO.getDataEntrega().getTime()));

            } else {
                JOptionPane.showMessageDialog(null, "A data de entrega está nula", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            pstmCadastro.setString(9, cadastroOrdemServicoDTO.getTipoServico());
            pstmCadastro.setString(10, cadastroOrdemServicoDTO.getStatusServico());
            pstmCadastro.setBigDecimal(11, cadastroOrdemServicoDTO.getValor());
            pstmCadastro.setBigDecimal(12, cadastroOrdemServicoDTO.getValorEntrada());
            pstmCadastro.setBigDecimal(13, cadastroOrdemServicoDTO.getValorRestante());
            pstmCadastro.setString(14, cadastroOrdemServicoDTO.getObservacoes());

            pstmCadastro.execute();
            conn.commit();

            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Essa Ordem de Serviço já foi cadastrado no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showInputDialog(e);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

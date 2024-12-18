package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.OrdemServicoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    // Metodo para listar Ordens de Serviço

    public ArrayList<OrdemServicoDTO> listarOrdemServicos() {
        conn = new ConexaoDAO().conectaBD();
        ArrayList<OrdemServicoDTO> listaOrdens = new ArrayList<>();
        String sql = "SELECT * FROM ordem_servico";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                OrdemServicoDTO ordem = new OrdemServicoDTO();
                ordem.setIdOrdemServico(rs.getInt("id_ordem"));
                ordem.setIdCliente(rs.getInt("idCliente"));
                ordem.setIdMedico(rs.getInt("id_Optometrista"));
                ordem.setIdFuncionario(rs.getInt("id_Funcionario"));
                ordem.setIdReceita(rs.getInt("id_Receita"));
                ordem.setIdProduto(rs.getInt("idProduto"));
                ordem.setDataEmissao(rs.getDate("data_emissao"));
                ordem.setDataEntrega(rs.getDate("data_entrega"));
                ordem.setTipoServico(rs.getString("tipo_servico"));
                ordem.setStatusServico(rs.getString("status_servico"));
                ordem.setValor(rs.getBigDecimal("valor"));
                ordem.setValorEntrada(rs.getBigDecimal("valor_entrada"));
                ordem.setValorRestante(rs.getBigDecimal("valor_restante"));
                ordem.setObservacoes(rs.getString("observacoes"));
                listaOrdens.add(ordem);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Ordens de Serviço: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaOrdens;
    }

    // Metodo para atualizar Ordem de Serviço
    public void atualizarOrdemServico(OrdemServicoDTO ordemDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "UPDATE ordem_servico SET idCliente = ?, id_Optometrista = ?, id_Funcionario = ?, id_Receita = ?, idProduto = ?, data_emissao = ?, data_entrega = ?, tipo_servico = ?, status_servico = ?, valor = ?, valor_entrada = ?, valor_restante = ?, observacoes = ? WHERE id_ordem = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ordemDTO.getIdCliente());
            pstm.setInt(2, ordemDTO.getIdMedico());
            pstm.setInt(3, ordemDTO.getIdFuncionario());
            pstm.setInt(4, ordemDTO.getIdReceita());
            pstm.setInt(5, ordemDTO.getIdProduto());
            pstm.setDate(6, new java.sql.Date(ordemDTO.getDataEmissao().getTime()));
            pstm.setDate(7, new java.sql.Date(ordemDTO.getDataEntrega().getTime()));
            pstm.setString(8, ordemDTO.getTipoServico());
            pstm.setString(9, ordemDTO.getStatusServico());
            pstm.setBigDecimal(10, ordemDTO.getValor());
            pstm.setBigDecimal(11, ordemDTO.getValorEntrada());
            pstm.setBigDecimal(12, ordemDTO.getValorRestante());
            pstm.setString(13, ordemDTO.getObservacoes());
            pstm.setInt(14, ordemDTO.getIdOrdemServico());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Ordem de Serviço atualizada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma Ordem de Serviço foi atualizada. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Ordem de Serviço: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo para excluir Ordem de Serviço
    public void excluirOrdemServico(int idOrdemServico) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "DELETE FROM ordem_servico WHERE id_ordem = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idOrdemServico);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Ordem de Serviço excluída com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma Ordem de Serviço foi excluída. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Ordem de Serviço: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

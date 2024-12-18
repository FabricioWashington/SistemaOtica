package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.PagamentoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PagamentoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    public void cadastrarPagamento(PagamentoDTO cadastroPagamento) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false); // Desliga o modo de commit automático

            // Registrar o cadastro
            String sqlCadastro = "insert into tipo_pagamento (Tipo_Pagamento) values (?)";
            PreparedStatement pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setString(1, cadastroPagamento.getTipoPagamento());

            pstmCadastro.execute();
            conn.commit(); // Efetua o commit das transações

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse tipo de pagamento já foi cadastrado no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showInputDialog(e);
            try {
                conn.rollback(); // Em caso de erro, faz rollback para desfazer as alterações
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true); // Restaura o modo de commit automático
                conn.close(); // Fecha a conexão
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ResultSet listarIdPagamento(PagamentoDTO pagamentoDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "SELECT * FROM tipo_pagamento ORDER BY Tipo_Pagamento";
        try {

            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Metodo para listar todos os pagamentos
    public ArrayList<PagamentoDTO> listarPagamentos() {
        conn = new ConexaoDAO().conectaBD();
        ArrayList<PagamentoDTO> listaPagamentos = new ArrayList<>();
        String sql = "SELECT * FROM tipo_pagamento";
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                PagamentoDTO pagamento = new PagamentoDTO();
                pagamento.setIdPagamento(rs.getInt("idPagamento"));
                pagamento.setTipoPagamento(rs.getString("Tipo_Pagamento"));
                listaPagamentos.add(pagamento);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar pagamentos: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaPagamentos;
    }

    // Metodo para atualizar pagamento
    public void atualizarPagamento(PagamentoDTO pagamentoDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "UPDATE tipo_pagamento SET Tipo_Pagamento = ? WHERE idPagamento = ?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pagamentoDTO.getTipoPagamento());
            pstm.setInt(2, pagamentoDTO.getIdPagamento());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Pagamento atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum pagamento foi atualizado. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar pagamento: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo para excluir pagamento
    public void excluirPagamento(int idPagamento) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "DELETE FROM tipo_pagamento WHERE idPagamento = ?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idPagamento);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Pagamento excluído com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum pagamento foi excluído. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir pagamento: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

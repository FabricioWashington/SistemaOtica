package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.NotaFiscalDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class NotaFiscalDAO {

    Connection conn;
    PreparedStatement pstmCadastro;
    String sqlCadastro;
    NotaFiscalDTO notaFiscalDTO;

    public void cadastrarNotaFiscal(NotaFiscalDTO notaFiscalDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            sqlCadastro = "insert into nota_fiscal (idVenda, idCliente, numero_nota, data_emissao, valor_total, observacoes) values (?,?,?,?,?,?)";
            pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setInt(1, notaFiscalDTO.getIdVenda());
            pstmCadastro.setInt(2, notaFiscalDTO.getIdCliente());
            pstmCadastro.setString(3, notaFiscalDTO.getNumeroNota());
            pstmCadastro.setDate(4, new java.sql.Date(notaFiscalDTO.getDataEmissao().getTime()));
            pstmCadastro.setBigDecimal(5, notaFiscalDTO.getValorTotal());
            pstmCadastro.setString(6, notaFiscalDTO.getObservacoes());

            pstmCadastro.execute();
            conn.commit();

            JOptionPane.showMessageDialog(null, "A Nota Fiscal foi cadastrada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar a Nota Fiscal", "Erro", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showInputDialog(e.getMessage());
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

    // Metodo para listar notas fiscais
    public ArrayList<NotaFiscalDTO> listarNotasFiscais() {
        conn = new ConexaoDAO().conectaBD();
        ArrayList<NotaFiscalDTO> listaNotas = new ArrayList<>();
        String sql = "SELECT * FROM nota_fiscal";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                NotaFiscalDTO notaFiscal = new NotaFiscalDTO();
                notaFiscal.setIdVenda(rs.getInt("idVenda"));
                notaFiscal.setIdCliente(rs.getInt("idCliente"));
                notaFiscal.setNumeroNota(rs.getString("numero_nota"));
                notaFiscal.setDataEmissao(rs.getDate("data_emissao"));
                notaFiscal.setValorTotal(rs.getBigDecimal("valor_total"));
                notaFiscal.setObservacoes(rs.getString("observacoes"));
                listaNotas.add(notaFiscal);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar Notas Fiscais: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaNotas;
    }

    // Metodo para atualizar nota fiscal
    public void atualizarNotaFiscal(NotaFiscalDTO notaFiscalDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "UPDATE nota_fiscal SET numero_nota = ?, data_emissao = ?, valor_total = ?, observacoes = ? WHERE idVenda = ? AND idCliente = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, notaFiscalDTO.getNumeroNota());
            pstm.setDate(2, new java.sql.Date(notaFiscalDTO.getDataEmissao().getTime()));
            pstm.setBigDecimal(3, notaFiscalDTO.getValorTotal());
            pstm.setString(4, notaFiscalDTO.getObservacoes());
            pstm.setInt(5, notaFiscalDTO.getIdVenda());
            pstm.setInt(6, notaFiscalDTO.getIdCliente());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Nota Fiscal atualizada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma Nota Fiscal foi atualizada. Verifique os IDs.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Nota Fiscal: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo para excluir nota fiscal
    public void excluirNotaFiscal(int idVenda, int idCliente) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "DELETE FROM nota_fiscal WHERE idVenda = ? AND idCliente = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idVenda);
            pstm.setInt(2, idCliente);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Nota Fiscal excluida com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma Nota Fiscal foi excluida. Verifique os IDs.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Nota Fiscal: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

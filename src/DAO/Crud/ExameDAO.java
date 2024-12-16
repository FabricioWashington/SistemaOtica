package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.ExameDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class ExameDAO {

    Connection conn;
    PreparedStatement pstmCadastro;
    ResultSet rs;
    PreparedStatement pstm;

    public void cadastrarExame(ExameDTO exameDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            String sqlCadastro = "insert into exame (idCliente, id_Optometrista, data_exame, tipo_exame, resultados, observacoes) values (?,?,?,?,?,?)";
            pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setInt(1, exameDTO.getIdCliente());
            pstmCadastro.setInt(2, exameDTO.getIdMedico());
            pstmCadastro.setDate(3, new java.sql.Date(exameDTO.getDataExame().getTime()));
            pstmCadastro.setString(4, exameDTO.getTipoExame());
            pstmCadastro.setString(5, exameDTO.getResultados());
            pstmCadastro.setString(6, exameDTO.getObservacoes());

            pstmCadastro.execute();
            conn.commit();

            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Esse exame já foi cadastrado no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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

    // Método para listar todos os exames
    public List<ExameDTO> listarExames() {
        List<ExameDTO> listaExames = new ArrayList<>();
        conn = new ConexaoDAO().conectaBD();

        String sql = "SELECT * FROM exame";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ExameDTO exame = new ExameDTO();
                exame.setIdExame(rs.getInt("idExame"));
                exame.setIdCliente(rs.getInt("idCliente"));
                exame.setIdMedico(rs.getInt("id_Optometrista"));
                exame.setDataExame(rs.getDate("data_exame"));
                exame.setTipoExame(rs.getString("tipo_exame"));
                exame.setResultados(rs.getString("resultados"));
                exame.setObservacoes(rs.getString("observacoes"));

                listaExames.add(exame);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar exames: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaExames;
    }

    // Método para atualizar um exame
    public void atualizarExame(ExameDTO exameDTO) {
        conn = new ConexaoDAO().conectaBD();

        String sql = "UPDATE exame SET idCliente = ?, id_Optometrista = ?, data_exame = ?, tipo_exame = ?, resultados = ?, observacoes = ? WHERE idExame = ?";

        try {
            conn.setAutoCommit(false);

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, exameDTO.getIdCliente());
            pstm.setInt(2, exameDTO.getIdMedico());
            pstm.setDate(3, new java.sql.Date(exameDTO.getDataExame().getTime()));
            pstm.setString(4, exameDTO.getTipoExame());
            pstm.setString(5, exameDTO.getResultados());
            pstm.setString(6, exameDTO.getObservacoes());
            pstm.setInt(7, exameDTO.getIdExame());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Exame atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                conn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum exame encontrado para atualização.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar exame: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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

    // Método para excluir um exame
    public void excluirExame(int idExame) {
        conn = new ConexaoDAO().conectaBD();

        String sql = "DELETE FROM exame WHERE idExame = ?";

        try {
            conn.setAutoCommit(false);

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idExame);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Exame excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                conn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum exame encontrado para exclusão.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir exame: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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

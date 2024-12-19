package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.AgendamentoExameDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class AgendamentoExameDAO {

    Connection conn;
    PreparedStatement pstmCadastro;
    String sqlCadastro;
    AgendamentoExameDTO agendamentoDTO;

    public void cadastrarAgendamento(AgendamentoExameDTO agendamentoDTO) {
        conn = new ConexaoDAO().conectaBD();
        try {
            conn.setAutoCommit(false);
            sqlCadastro = "insert into agendamento_exame (idCliente, Data_Exame, Data_Agendamento) values (?,?,?)";
            pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setInt(1, agendamentoDTO.getIdCliente());
            pstmCadastro.setDate(2, new java.sql.Date(agendamentoDTO.getDataExame().getTime()));
            pstmCadastro.setDate(3, new java.sql.Date(agendamentoDTO.getDataAgendamento().getTime()));

            pstmCadastro.execute();
            conn.commit();
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Houve um problema ao agendar o exame", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public ArrayList<AgendamentoExameDTO> listarAgendamentos() {
        conn = new ConexaoDAO().conectaBD();
        ArrayList<AgendamentoExameDTO> listaAgendamentos = new ArrayList<>();
        String sql = "SELECT * FROM agendamento_exame";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                AgendamentoExameDTO agendamento = new AgendamentoExameDTO();
                agendamento.setIdAgendamento(rs.getInt("idAgendamento"));
                agendamento.setIdCliente(rs.getInt("idCliente"));
                agendamento.setDataExame(rs.getDate("Data_Exame"));
                agendamento.setDataAgendamento(rs.getDate("Data_Agendamento"));
                listaAgendamentos.add(agendamento);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar agendamentos: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaAgendamentos;
    }

    public void atualizarAgendamento(AgendamentoExameDTO agendamentoDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "UPDATE agendamento_exame SET idCliente = ?, Data_Exame = ?, Data_Agendamento = ? WHERE idAgendamento = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, agendamentoDTO.getIdCliente());
            pstm.setDate(2, new java.sql.Date(agendamentoDTO.getDataExame().getTime()));
            pstm.setDate(3, new java.sql.Date(agendamentoDTO.getDataAgendamento().getTime()));
            pstm.setInt(4, agendamentoDTO.getIdAgendamento());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Agendamento atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum agendamento foi atualizado. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar agendamento: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void excluirAgendamento(int idAgendamento) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "DELETE FROM agendamento_exame WHERE idAgendamento = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idAgendamento);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Agendamento excluído com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum agendamento foi excluído. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir agendamento: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

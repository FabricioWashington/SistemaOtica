package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.AgendamentoExameDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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

}

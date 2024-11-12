package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.ExameDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class ExameDAO {

    Connection conn;
    PreparedStatement pstmCadastro;
    ResultSet rs;

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

}

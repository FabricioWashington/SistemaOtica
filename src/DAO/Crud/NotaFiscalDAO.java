package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.NotaFiscalDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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

}

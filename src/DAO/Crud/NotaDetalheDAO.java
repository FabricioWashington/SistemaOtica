package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.NotaDetalheDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class NotaDetalheDAO {

    Connection conn;
    PreparedStatement pstmCadastro;
    String sqlCadastro;
    NotaDetalheDTO notaDetalheDTO;

    public void cadastrarNotaDetalhe(NotaDetalheDTO notaDetalheDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);
            sqlCadastro = "insert into nota_detalhe (idnota, idProduto, valor_unitario, valor_total) values (?,?,?,?)";
            pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setInt(1, notaDetalheDTO.getIdNota());
            pstmCadastro.setInt(2, notaDetalheDTO.getIdProduto());
            pstmCadastro.setBigDecimal(3, notaDetalheDTO.getVlrUnitario());
            pstmCadastro.setBigDecimal(4, notaDetalheDTO.getVlrTotal());

            pstmCadastro.execute();
            conn.commit();
            JOptionPane.showMessageDialog(null, "A Nota Detalhe foi cadastrada.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "A Nota Detalhe não foi cadastrada", "Erro", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showInputDialog(e.getMessage());
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

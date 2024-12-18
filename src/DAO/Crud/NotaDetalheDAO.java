package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.NotaDetalheDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

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

    // Metodo para listar os detalhes da nota
    public ArrayList<NotaDetalheDTO> listarNotaDetalhes() {
        conn = new ConexaoDAO().conectaBD();
        ArrayList<NotaDetalheDTO> listaDetalhes = new ArrayList<>();
        String sql = "SELECT * FROM nota_detalhe";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                NotaDetalheDTO notaDetalhe = new NotaDetalheDTO();
                notaDetalhe.setIdNota(rs.getInt("idnota"));
                notaDetalhe.setIdProduto(rs.getInt("idProduto"));
                notaDetalhe.setVlrUnitario(rs.getBigDecimal("valor_unitario"));
                notaDetalhe.setVlrTotal(rs.getBigDecimal("valor_total"));
                listaDetalhes.add(notaDetalhe);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar detalhes da nota: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaDetalhes;
    }

    // Metodo para atualizar uma nota detalhe
    public void atualizarNotaDetalhe(NotaDetalheDTO notaDetalheDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "UPDATE nota_detalhe SET valor_unitario = ?, valor_total = ? WHERE idnota = ? AND idProduto = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setBigDecimal(1, notaDetalheDTO.getVlrUnitario());
            pstm.setBigDecimal(2, notaDetalheDTO.getVlrTotal());
            pstm.setInt(3, notaDetalheDTO.getIdNota());
            pstm.setInt(4, notaDetalheDTO.getIdProduto());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Nota Detalhe atualizada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma Nota Detalhe foi atualizada. Verifique os IDs.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Nota Detalhe: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo para excluir uma nota detalhe
    public void excluirNotaDetalhe(int idNota, int idProduto) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "DELETE FROM nota_detalhe WHERE idnota = ? AND idProduto = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idNota);
            pstm.setInt(2, idProduto);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Nota Detalhe excluida com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma Nota Detalhe foi excluida. Verifique os IDs.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Nota Detalhe: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

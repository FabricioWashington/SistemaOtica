package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.VendaItemDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class VendaItemDAO {

    private Connection conn;
    private String sqlCadastro;
    private PreparedStatement pstmCadastro;
    private VendaItemDTO vendaItemDTO;
    
    public void cadastrarVendaItem(VendaItemDTO vendaItemDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);
            sqlCadastro = "insert into venda_itens (idVenda, idProduto, quantidade, desconto, preco, vlrTotal) values (?,?,?,?,?,?)";
            pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setInt(1, vendaItemDTO.getIdVenda());
            pstmCadastro.setInt(2, vendaItemDTO.getIdProduto());
            pstmCadastro.setInt(3, vendaItemDTO.getQuantidade());
            pstmCadastro.setBigDecimal(4, vendaItemDTO.getDesconto());
            pstmCadastro.setBigDecimal(5, vendaItemDTO.getPreco());
            pstmCadastro.setBigDecimal(6, vendaItemDTO.getVlrTotal());

            pstmCadastro.execute();
            conn.commit();
            JOptionPane.showMessageDialog(null, "A venda detalhada foi efetuada.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "A venda detalhada falhou", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public ArrayList<VendaItemDTO> listarVendaItens() {
        conn = new ConexaoDAO().conectaBD();
        ArrayList<VendaItemDTO> listaItens = new ArrayList<>();
        String sql = "SELECT * FROM venda_itens";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                VendaItemDTO vendaItem = new VendaItemDTO();
                vendaItem.setIdVenda(rs.getInt("idVenda"));
                vendaItem.setIdProduto(rs.getInt("idProduto"));
                vendaItem.setQuantidade(rs.getInt("quantidade"));
                vendaItem.setDesconto(rs.getBigDecimal("desconto"));
                vendaItem.setPreco(rs.getBigDecimal("preco"));
                vendaItem.setVlrTotal(rs.getBigDecimal("vlrTotal"));
                listaItens.add(vendaItem);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar itens de venda: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaItens;
    }

    public void atualizarVendaItem(VendaItemDTO vendaItemDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "UPDATE venda_itens SET quantidade = ?, desconto = ?, preco = ?, vlrTotal = ? WHERE idVenda = ? AND idProduto = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, vendaItemDTO.getQuantidade());
            pstm.setBigDecimal(2, vendaItemDTO.getDesconto());
            pstm.setBigDecimal(3, vendaItemDTO.getPreco());
            pstm.setBigDecimal(4, vendaItemDTO.getVlrTotal());
            pstm.setInt(5, vendaItemDTO.getIdVenda());
            pstm.setInt(6, vendaItemDTO.getIdProduto());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Item de venda atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum item foi atualizado. Verifique os IDs.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar item de venda: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void excluirVendaItem(int idVenda, int idProduto) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "DELETE FROM venda_itens WHERE idVenda = ? AND idProduto = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idVenda);
            pstm.setInt(2, idProduto);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Item de venda excluído com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum item foi excluído. Verifique os IDs.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir item de venda: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

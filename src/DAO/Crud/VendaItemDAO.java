package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.VendaItemDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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
}

package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.VendaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class VendaDAO {

    private Connection conn;
    private String sqlCadastro;
    private PreparedStatement pstmCadastro;
    private VendaDTO vendaDTO;

    public void cadastrarVenda(VendaDTO vendaDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            sqlCadastro = "insert into venda (idFuncionario, idCliente, idPagamento, data, vlrSugerido, desconto, totalVenda, parcela, vencimento, status, recebeu, restante, vlrFinal) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setInt(1, vendaDTO.getIdFuncionario());
            pstmCadastro.setInt(2, vendaDTO.getIdCliente());
            pstmCadastro.setInt(3, vendaDTO.getIdPagamento());
            pstmCadastro.setDate(4, new java.sql.Date(vendaDTO.getData().getTime()));
            pstmCadastro.setBigDecimal(5, vendaDTO.getVlrSugerido());
            pstmCadastro.setBigDecimal(6, vendaDTO.getDesconto());
            pstmCadastro.setBigDecimal(7, vendaDTO.getTotalVenda());
            pstmCadastro.setString(8, vendaDTO.getParcela());
            pstmCadastro.setDate(9, new java.sql.Date(vendaDTO.getDataVencimento().getTime()));
            pstmCadastro.setString(10, vendaDTO.getStatus());
            pstmCadastro.setBigDecimal(11, vendaDTO.getVlrRecebido());
            pstmCadastro.setBigDecimal(12, vendaDTO.getVlrRestante());
            pstmCadastro.setBigDecimal(13, vendaDTO.getVlrFinal());

            pstmCadastro.execute();
            conn.commit();
            JOptionPane.showMessageDialog(null, "A venda foi cadastrada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Essa venda já foi cadastrada no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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

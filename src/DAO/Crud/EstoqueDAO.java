package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.EstoqueDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EstoqueDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    public void cadastrarEstoque(EstoqueDTO cadastroEstoqueDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false); // Desliga o modo de commit automático

            // Registrar o cadastro
            String sqlCadastro = "insert into estoque (idProduto, idCategoria, descricao,  quantidade, preco_unitario) values (?,?,?,?,?)";
            PreparedStatement pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setInt(1, cadastroEstoqueDTO.getIdProduto());
            pstmCadastro.setInt(2, cadastroEstoqueDTO.getIdCategoria());
            pstmCadastro.setString(3, cadastroEstoqueDTO.getDescricao());
            pstmCadastro.setInt(4, cadastroEstoqueDTO.getQuantidade());
            pstmCadastro.setBigDecimal(5, cadastroEstoqueDTO.getPrecoUnitario());

            pstmCadastro.execute();
            conn.commit(); // Efetua o commit das transações

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse produto já foi cadastrado no estoque do sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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

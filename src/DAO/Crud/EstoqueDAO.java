package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.EstoqueDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    // Método para listar todos os registros do estoque
    public ArrayList<EstoqueDTO> listarEstoque() {
        ArrayList<EstoqueDTO> listaEstoque = new ArrayList<>();
        conn = new ConexaoDAO().conectaBD();

        String sql = "SELECT * FROM estoque";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                EstoqueDTO estoque = new EstoqueDTO();
                estoque.setIdProduto(rs.getInt("idProduto"));
                estoque.setIdCategoria(rs.getInt("idCategoria"));
                estoque.setDescricao(rs.getString("descricao"));
                estoque.setQuantidade(rs.getInt("quantidade"));
                estoque.setPrecoUnitario(rs.getBigDecimal("preco_unitario"));

                listaEstoque.add(estoque);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar estoque: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaEstoque;
    }

    // Método para atualizar um registro do estoque
    public void atualizarEstoque(EstoqueDTO estoqueDTO) {
        conn = new ConexaoDAO().conectaBD();

        String sql = "UPDATE estoque SET idProduto = ?, idCategoria = ?, descricao = ?, quantidade = ?, preco_unitario = ? WHERE idProduto = ?";

        try {
            conn.setAutoCommit(false);

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, estoqueDTO.getIdProduto());
            pstm.setInt(2, estoqueDTO.getIdCategoria());
            pstm.setString(3, estoqueDTO.getDescricao());
            pstm.setInt(4, estoqueDTO.getQuantidade());
            pstm.setBigDecimal(5, estoqueDTO.getPrecoUnitario());
            pstm.setInt(6, estoqueDTO.getIdProduto());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                conn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para atualização.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar estoque: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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

    // Método para excluir um registro do estoque
    public void excluirEstoque(int idEstoque) {
        conn = new ConexaoDAO().conectaBD();

        String sql = "DELETE FROM estoque WHERE idProduto = ?";

        try {
            conn.setAutoCommit(false);

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idEstoque);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Estoque excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                conn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado para exclusão.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir estoque: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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

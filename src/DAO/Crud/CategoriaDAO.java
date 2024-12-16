package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.CategoriaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    public void cadastrarCategoria(CategoriaDTO cadastroCategoriaDTO) {

        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            //Registrar o cadastro
            String sqlCadastro = "insert into categoria (Nome_Categoria) values (?)";
            PreparedStatement pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setString(1, cadastroCategoriaDTO.getNome_Categoria());

            pstmCadastro.execute();
            conn.commit();

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Essa categoria ja foi cadastrada no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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
    
    // Método para listar todas as categorias
    public List<CategoriaDTO> listarCategorias() {
        List<CategoriaDTO> listaCategorias = new ArrayList<>();
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "SELECT * FROM categoria";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                CategoriaDTO categoria = new CategoriaDTO();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNome_Categoria(rs.getString("Nome_Categoria"));

                listaCategorias.add(categoria);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar categorias: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaCategorias;
    }

    // Método para atualizar uma categoria
    public void atualizarCategoria(CategoriaDTO categoriaDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "UPDATE categoria SET Nome_Categoria = ? WHERE idCategoria = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, categoriaDTO.getNome_Categoria());
            pstm.setInt(2, categoriaDTO.getIdCategoria());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Categoria atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma categoria encontrada para atualização.", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar categoria: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Método para excluir uma categoria
    public void excluirCategoria(int id) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "DELETE FROM categoria WHERE idCategoria = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Categoria excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma categoria encontrada para exclusão.", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir categoria: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
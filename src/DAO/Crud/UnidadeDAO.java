package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.UnidadeDTO;
import DTO.Login.LoginDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UnidadeDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LoginDTO> lista = new ArrayList<>();

    public void cadastrarUnidade(UnidadeDTO cadastroUnidadeDTO) {

        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            //Registrar o cadastro
            String sqlCadastro = "insert into unidade (descricao) values (?)";
            PreparedStatement pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setString(1, cadastroUnidadeDTO.getDescricao());

            pstmCadastro.execute();
            conn.commit();

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Essa unidade ja foi cadastrada no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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

    // Metodo para listar unidades
    public ArrayList<UnidadeDTO> listarUnidades() {
        conn = new ConexaoDAO().conectaBD();
        ArrayList<UnidadeDTO> listaUnidades = new ArrayList<>();
        String sql = "SELECT * FROM unidade";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                UnidadeDTO unidade = new UnidadeDTO();
                unidade.setId(rs.getInt("id"));
                unidade.setDescricao(rs.getString("descricao"));
                listaUnidades.add(unidade);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar unidades: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaUnidades;
    }

    // Metodo para atualizar unidade
    public void atualizarUnidade(UnidadeDTO unidadeDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "UPDATE unidade SET descricao = ? WHERE id = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, unidadeDTO.getDescricao());
            pstm.setInt(2, unidadeDTO.getId());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Unidade atualizada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma unidade foi atualizada. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar unidade: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo para excluir unidade
    public void excluirUnidade(int idUnidade) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "DELETE FROM unidade WHERE id = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idUnidade);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Unidade excluída com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma unidade foi excluída. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir unidade: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

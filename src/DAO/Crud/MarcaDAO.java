package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.MarcaDTO;
import DTO.Login.LoginDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MarcaDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<MarcaDTO> lista = new ArrayList<>();
    

    public void cadastrarMarca(MarcaDTO cadastroMarcaDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            //Registrar o cadastro
            String sqlCadastro = "insert into marca (Nome_Marca) values (?)";
            PreparedStatement pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setString(1, cadastroMarcaDTO.getNome_Marca());

            pstmCadastro.execute();
            conn.commit();

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Essa marca ja foi cadastrada no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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

    // Metodo para listar todas as marcas
    public ArrayList<MarcaDTO> listarMarcas() {
        conn = new ConexaoDAO().conectaBD();
        String sql = "SELECT * FROM marca";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                MarcaDTO marca = new MarcaDTO();
                marca.setIdMarca(rs.getInt("IdMarca"));
                marca.setNome_Marca(rs.getString("Nome_Marca"));
                lista.add(marca);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar marcas: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    // Metodo para atualizar uma marca existente
    public void atualizarMarca(MarcaDTO marcaDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "UPDATE marca SET Nome_Marca = ? WHERE IdMarca = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, marcaDTO.getNome_Marca());
            pstm.setInt(2, marcaDTO.getIdMarca());

            int rowsUpdated = pstm.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Marca atualizada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma marca foi atualizada. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar marca: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo para excluir uma marca pelo ID
    public void excluirMarca(int idMarca) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "DELETE FROM marca WHERE IdMarca = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idMarca);

            int rowsDeleted = pstm.executeUpdate();

            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Marca excluida com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma marca foi excluida. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir marca: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

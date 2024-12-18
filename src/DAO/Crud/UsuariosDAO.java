package DAO.Crud;

import DTO.Crud.UsuariosDTO;
import DTO.Login.LoginDTO;
import DAO.Conexao.ConexaoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LoginDTO> lista = new ArrayList<>();

    public int cadastrarUsuario(UsuariosDTO objcadastrodto, Connection conn) throws SQLException {
        conn = new ConexaoDAO().conectaBD();
        int idUsuario = -1;

        try {
            conn.setAutoCommit(false); // Desliga o modo de commit automático

            // Registrar o cadastro
            String sqlCadastro = "insert into usuarios (CPF, Nome_Completo, Data_Cadastro, Data_Modificacao) values (?,?,?,?)";
            PreparedStatement pstmCadastro = conn.prepareStatement(sqlCadastro, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmCadastro.setString(1, objcadastrodto.getCPF());
            pstmCadastro.setString(2, objcadastrodto.getNome_Completo());
            pstmCadastro.setTimestamp(3, new java.sql.Timestamp(objcadastrodto.getData_Cadastro().getTime()));
            pstmCadastro.setTimestamp(4, new java.sql.Timestamp(objcadastrodto.getData_Modificacao().getTime()));

            pstmCadastro.executeUpdate();

            //Obter o ID gerado automaticamente
            ResultSet generatedKeys = pstmCadastro.getGeneratedKeys();
            if (generatedKeys.next()) {
                idUsuario = generatedKeys.getInt(1);
            }

            conn.commit(); // Efetua o commit das transações

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse cpf já foi cadastrado no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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
        return idUsuario;
    }

    public boolean verificarCadastroAdminExistente() {
        conn = new ConexaoDAO().conectaBD();
        boolean adminCadastrado = false;

        try {
            String sqlVerificarAdmin = "SELECT COUNT(*) FROM login WHERE idtipos_login = 1";
            PreparedStatement pstmVerificarAdmin = conn.prepareStatement(sqlVerificarAdmin);
            ResultSet rsVerificarAdmin = pstmVerificarAdmin.executeQuery();
            rsVerificarAdmin.next();
            int countAdmin = rsVerificarAdmin.getInt(1);

            if (countAdmin >= 1) {
                adminCadastrado = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close(); // Fecha a conexão
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return adminCadastrado;
    }
// Metodo para listar usuarios

    public ArrayList<UsuariosDTO> listarUsuarios() {
        conn = new ConexaoDAO().conectaBD();
        ArrayList<UsuariosDTO> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                UsuariosDTO usuario = new UsuariosDTO();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setCPF(rs.getString("CPF"));
                usuario.setNome_Completo(rs.getString("Nome_Completo"));
                usuario.setData_Cadastro(rs.getTimestamp("Data_Cadastro"));
                usuario.setData_Modificacao(rs.getTimestamp("Data_Modificacao"));
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar usuarios: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaUsuarios;
    }

    // Metodo para atualizar usuario
    public void atualizarUsuario(UsuariosDTO usuarioDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "UPDATE usuarios SET CPF = ?, Nome_Completo = ?, Data_Modificacao = ? WHERE idUsuario = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuarioDTO.getCPF());
            pstm.setString(2, usuarioDTO.getNome_Completo());
            pstm.setTimestamp(3, new java.sql.Timestamp(usuarioDTO.getData_Modificacao().getTime()));
            pstm.setInt(4, usuarioDTO.getIdUsuario());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum usuario foi atualizado. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuario: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo para excluir usuario
    public void excluirUsuario(int idUsuario) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "DELETE FROM usuarios WHERE idUsuario = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idUsuario);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Usuario excluido com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum usuario foi excluido. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuario: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

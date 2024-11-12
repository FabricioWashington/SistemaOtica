package DAO.Login;

import DAO.Conexao.ConexaoDAO;
import DTO.Contato_Endereco.ContatoDTO;
import DTO.Vetores.DDD_DTO;
import DTO.Login.LoginDTO;
import DTO.Login.Tipos_LoginDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LoginDTO> lista = new ArrayList<>();

    public ResultSet autenticacaoLogin(LoginDTO objlogindto) {
        conn = new ConexaoDAO().conectaBD();
        try {
            if (conn == null) {
                // Tratar o caso em que a conexão não foi estabelecida corretamente
                return null;
            }

            String sql = "SELECT * FROM login WHERE Login_Usuario = ? AND Login_Senha = ? AND idtipos_login = ?";

            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objlogindto.getLogin_Usuario());
            pstm.setString(2, objlogindto.getLogin_Senha());
            pstm.setInt(3, objlogindto.getIdtipos_login());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro em LoginDAO" + erro);
            return null;
        }
    }

    public boolean verificarUsuarioCadastrado(LoginDTO objlogindto) {
        conn = new ConexaoDAO().conectaBD();
        try {
            if (conn == null) {
                // Tratar o caso em que a conexão não foi estabelecida corretamente
                return false;
            }

            String sql = "SELECT * FROM login WHERE Login_Usuario = ? AND idtipos_login = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objlogindto.getLogin_Usuario());
            pstm.setInt(2, objlogindto.getIdtipos_login());
            ResultSet rs = pstm.executeQuery();

            return rs.next(); // Retorna true se encontrou algum registro, false caso contrário

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro em LoginDAO" + erro);
            return false;
        }
    }

    public void cadastrarLogin(LoginDTO objlogindto, Connection conn) throws SQLException {
        conn = new ConexaoDAO().conectaBD();
        try {
            conn.setAutoCommit(false);

            // Registrar o usuário
            String sqlLogin = "insert into login (Login_Usuario, Login_Senha, idtipos_login, idUsuario, Data_Cadastro, Data_Modificacao) value (?,?,?,?,?,?)";
            PreparedStatement pstmUsuario = conn.prepareStatement(sqlLogin);
            pstmUsuario.setString(1, objlogindto.getLogin_Usuario());
            pstmUsuario.setString(2, objlogindto.getLogin_Senha());
            pstmUsuario.setInt(3, objlogindto.getIdtipos_login());
            pstmUsuario.setInt(4, objlogindto.getIdUsuario());
            pstmUsuario.setTimestamp(5, new java.sql.Timestamp(objlogindto.getData_Cadastro().getTime()));
            pstmUsuario.setTimestamp(6, new java.sql.Timestamp(objlogindto.getData_Modificacao().getTime()));

            pstmUsuario.executeUpdate();

            conn.commit(); // Efetua o commit das transações

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse Usuario já foi cadastrado no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public ResultSet ListarDDD(DDD_DTO objddddto) {
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "SELECT * FROM ddd ORDER BY numero";
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ResultSet ListarContatos(ContatoDTO objcontatodto) {
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "SELECT * FROM contato ORDER BY Telefone";
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String ListarTipo_LoginPorId(LoginDTO objlogindto) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "SELECT tipos_login FROM tipos_login WHERE idtipos_login = ?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objlogindto.getIdtipos_login());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getString("tipos_login");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}

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
}

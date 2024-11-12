package DAO.ResetSenha;

import DTO.Contato_Endereco.ContatoDTO;
import DTO.Login.LoginDTO;
import DTO.ResetSenha.Token_Reset_SenhaDTO;
import DAO.Conexao.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ResetarSenhaDAO {
    Connection conn;
    PreparedStatement pstm;
    
    public boolean verificarEmailExistente (ContatoDTO objcontatodto){
       conn = new ConexaoDAO().conectaBD();
        try {
            if (conn == null) {
                // Tratar o caso em que a conexão não foi estabelecida corretamente
                return false;
            }
            String sql = "SELECT Email FROM contato WHERE Email = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objcontatodto.getEmail());
            ResultSet rs = pstm.executeQuery();
            return rs.next(); // Retorna true se encontrou algum registro, false caso contrário
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro em ResetSenhaDAO" + erro);
            return false;
        }
    }
    public void gerarTokenRedefinicaoSenha (Token_Reset_SenhaDTO objtoken){
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "insert into token_reset_senha (Email, Token, Data_Expiracao) values (?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objtoken.getEmail());
            pstm.setString(2, objtoken.getToken());
            pstm.setDate(3, new java.sql.Date(objtoken.getData_Expiracao().getTime()));
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro em GerarToken(ResetSenhaDAO)" + e);
        }
    }
    public ResultSet enviarEmailRedefinicaoSenha(Token_Reset_SenhaDTO objtoken){
        conn = new ConexaoDAO().conectaBD();
        try {
            if (conn == null) {
                return null;
            }
            String sql = "select * from token_reset_senha where Email = ? and Token = ? and Data_Expiracao";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objtoken.getEmail());
            pstm.setString(2, objtoken.getToken());
            pstm.setDate(3, new java.sql.Date(objtoken.getData_Expiracao().getTime()));
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu em erro em enviarEmail(ResetSenhaDAO)" +  e);
            return null;
        }
    }
    public boolean validarTokenRedenificaoSenha (Token_Reset_SenhaDTO objtoken){
       conn = new ConexaoDAO().conectaBD();
        try {
            if (conn == null) {
                // Tratar o caso em que a conexão não foi estabelecida corretamente
                return false;
            }
            String sql = "SELECT * FROM token_reset_senha WHERE Token = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objtoken.getToken());
            ResultSet rs = pstm.executeQuery();
            return rs.next(); // Retorna true se encontrou algum registro, false caso contrário
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro em validarToken(ResetSenhaDAO)" + erro);
            return false;
        }
    }
 public boolean processarRedefinicaoSenha(LoginDTO objlogindto) {
    conn = new ConexaoDAO().conectaBD();
    try {
        if (conn == null) {
            return false;
        }
        String sql = "update login set Login_Senha = ? where idContato = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, objlogindto.getLogin_Senha());
        pstm.setInt(2, objlogindto.getIdContato());
        int rowsAffected = pstm.executeUpdate();
        return rowsAffected > 0; // Retorna true se a atualização foi bem-sucedida
    } catch (SQLException e) {
        // Aqui você deve tratar a exceção de forma adequada, por exemplo, mostrando uma mensagem de erro
        JOptionPane.showMessageDialog(null, "Erro ao atualizar a senha: " + e.getMessage());
        return false;
    } finally {
        // Sempre feche a conexão no bloco finally para garantir que ela seja fechada, mesmo em caso de exceção
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            // Trate o erro ao fechar a conexão, se necessário
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}
 public boolean apagarDadosTabelaToken() {
    conn = new ConexaoDAO().conectaBD();
    try {
        if (conn == null) {
            // Tratar o caso em que a conexão não foi estabelecida corretamente
            return false;
        }
        String sql = "DELETE FROM token_reset_senha";
        pstm = conn.prepareStatement(sql);
        int rowsAffected = pstm.executeUpdate();
        return rowsAffected > 0; // Retorna true se pelo menos uma linha foi afetada, indicando que os registros foram apagados

    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro em apagarDadosTabelaToken(ResetSenhaDAO)" + erro);
        return false;
    } finally {
        // Fechar conexão e recursos
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
}

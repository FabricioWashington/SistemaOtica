package DAO.Cadastro;

import DTO.Cadastro.CadastroFuncionarioDTO;
import DTO.Login.LoginDTO;
import DAO.Conexao.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CadastroFuncionarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LoginDTO> lista = new ArrayList<>();

    public void cadastrarFuncionarioCompleto(CadastroFuncionarioDTO objcadastrofuncionario) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false); // Desliga o modo de commit automático

            // Registrar o cadastro
            String sqlCadastro = "insert into cadastro_funcionarios (CPF, Nome_Completo, Data_Cadastro, Data_Modificacao) values (?,?,?,?)";
            PreparedStatement pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setString(1, objcadastrofuncionario.getCPF());
            pstmCadastro.setString(2, objcadastrofuncionario.getNome_Completo());
            pstmCadastro.setTimestamp(3, new java.sql.Timestamp(objcadastrofuncionario.getData_Cadastro().getTime()));
            pstmCadastro.setTimestamp(4, new java.sql.Timestamp(objcadastrofuncionario.getData_Modificacao().getTime()));
            pstmCadastro.execute();

            conn.commit(); // Efetua o commit das transações

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse funcionario já foi cadastrado no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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

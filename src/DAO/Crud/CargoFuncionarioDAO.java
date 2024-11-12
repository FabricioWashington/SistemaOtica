package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.CargoFuncionarioDTO;
import DTO.Crud.CargoFuncionarioDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CargoFuncionarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    public void cadastrarCargo(CargoFuncionarioDTO cadastroCargoFuncionarioDTO) {

        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            //Registrar o cadastro
            String sqlCadastro = "insert into cargo_funcionario (Cargo, salario) values (?,?)";
            PreparedStatement pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setString(1, cadastroCargoFuncionarioDTO.getCargo());
            pstmCadastro.setBigDecimal(2, cadastroCargoFuncionarioDTO.getSalario());
            
            pstmCadastro.execute();
            conn.commit();

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse cargo ja foi cadastrado no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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



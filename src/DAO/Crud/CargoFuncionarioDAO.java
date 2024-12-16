package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.CargoFuncionarioDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;

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
      public List<CargoFuncionarioDTO> listarCargos() {
        List<CargoFuncionarioDTO> listaCargos = new ArrayList<>();
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "SELECT * FROM cargo_funcionario";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                CargoFuncionarioDTO cargo = new CargoFuncionarioDTO();
                cargo.setIdCargo_Funcionario(rs.getInt("idCargo_Funcionario"));
                cargo.setCargo(rs.getString("Cargo"));
                cargo.setSalario(rs.getBigDecimal("salario"));

                listaCargos.add(cargo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar cargos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conn.close(); // Fecha a conexão
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listaCargos;
    }

    public void atualizarCargo(CargoFuncionarioDTO cargoFuncionarioDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "UPDATE cargo_funcionario SET Cargo = ?, salario = ? WHERE idCargo_Funcionario = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cargoFuncionarioDTO.getCargo());
            pstm.setBigDecimal(2, cargoFuncionarioDTO.getSalario());
            pstm.setInt(3, cargoFuncionarioDTO.getIdCargo_Funcionario());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Cargo atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum cargo foi encontrado para atualização.", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cargo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conn.close(); // Fecha a conexão
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void excluirCargo(int id) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "DELETE FROM cargo_funcionario WHERE idCargo_Funcionario = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Cargo excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum cargo foi encontrado para exclusão.", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cargo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conn.close(); // Fecha a conexão
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}



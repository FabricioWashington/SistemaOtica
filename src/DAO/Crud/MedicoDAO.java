package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.MedicoDTO;
import DTO.Contato_Endereco.ContatoDTO;
import DTO.Contato_Endereco.EnderecoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MedicoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    public void cadastrarMedico(MedicoDTO cadastroMedicoDTO, EnderecoDTO enderecoDTO, ContatoDTO contatoDTO) {
        conn = new ConexaoDAO().conectaBD();
        int idContato = -1;
        int idEndereco = -1;

        try {
            conn.setAutoCommit(false);

            // Registrar o contato
            String sqlContato = "insert into contato(Email, idDDD, Telefone, Telefone2) values(?,?,?,?)";
            PreparedStatement pstmContato = conn.prepareStatement(sqlContato, Statement.RETURN_GENERATED_KEYS);
            pstmContato.setString(1, contatoDTO.getEmail());
            pstmContato.setInt(2, contatoDTO.getIdDDD());
            pstmContato.setString(3, contatoDTO.getTelefone());
            pstmContato.setString(4, contatoDTO.getTelefone2());

            pstmContato.executeUpdate();

            ResultSet rsContato = pstmContato.getGeneratedKeys();
            if (rsContato.next()) {
                idContato = rsContato.getInt(1);
            }

            // Registrar o endereço
            String sqlEndereco = "insert into endereco(Logradouro, Bairro, Numero, Complemento, CEP, UF, Municipio) values (?,?,?,?,?,?,?)";
            PreparedStatement pstmEndereco = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
            pstmEndereco.setString(1, enderecoDTO.getLogradouro());
            pstmEndereco.setString(2, enderecoDTO.getBairro());
            pstmEndereco.setString(3, enderecoDTO.getNumero());
            pstmEndereco.setString(4, enderecoDTO.getComplemento());
            pstmEndereco.setString(5, enderecoDTO.getCEP());
            pstmEndereco.setString(6, enderecoDTO.getUF());
            pstmEndereco.setString(7, enderecoDTO.getMunicipio());

            pstmEndereco.executeUpdate();

            ResultSet rsEndereco = pstmEndereco.getGeneratedKeys();
            if (rsEndereco.next()) {
                idEndereco = rsEndereco.getInt(1);
            }

            //Registrar o cadastro do medico
            String sqlCadastroMedico = "insert into optometrista (Nome, registro_profissional, idEndereco, idContato, Data_Cadastro) values (?,?,?,?,?)";
            PreparedStatement pstmCadastroMedico = conn.prepareStatement(sqlCadastroMedico);
            pstmCadastroMedico.setString(1, cadastroMedicoDTO.getNome());
            pstmCadastroMedico.setString(2, cadastroMedicoDTO.getRegistroProfissional());
            pstmCadastroMedico.setInt(3, idEndereco);
            pstmCadastroMedico.setInt(4, idContato);
            pstmCadastroMedico.setTimestamp(5, new java.sql.Timestamp(cadastroMedicoDTO.getDataCadastro().getTime()));

            pstmCadastroMedico.executeUpdate();

            conn.commit();
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse médico ja foi cadastrado no sistema.", "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
    // Metodo para listar medicos

    public ArrayList<MedicoDTO> listarMedicos() {
        conn = new ConexaoDAO().conectaBD();
        ArrayList<MedicoDTO> listaMedicos = new ArrayList<>();
        String sql = "SELECT * FROM optometrista";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                MedicoDTO medico = new MedicoDTO();
                medico.setIdMedico(rs.getInt("id_Optometrista"));
                medico.setNome(rs.getString("Nome"));
                medico.setRegistroProfissional(rs.getString("registro_profissional"));
                medico.setIdEndereco(rs.getInt("idEndereco"));
                medico.setIdContato(rs.getInt("idContato"));
                medico.setDataCadastro(rs.getTimestamp("Data_Cadastro"));
                listaMedicos.add(medico);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar médicos: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaMedicos;
    }

    // Metodo para atualizar medico
    public void atualizarMedico(MedicoDTO medicoDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "UPDATE optometrista SET Nome = ?, registro_profissional = ?, idEndereco = ?, idContato = ? WHERE id_Optometrista = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, medicoDTO.getNome());
            pstm.setString(2, medicoDTO.getRegistroProfissional());
            pstm.setInt(3, medicoDTO.getIdEndereco());
            pstm.setInt(4, medicoDTO.getIdContato());
            pstm.setInt(5, medicoDTO.getIdMedico());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Medico atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum medico foi atualizado. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar medico: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo para excluir medico
    public void excluirMedico(int idMedico) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "DELETE FROM optometrista WHERE id_Optometrista = ?";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idMedico);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Medico excluido com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum medico foi excluido. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir medico: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

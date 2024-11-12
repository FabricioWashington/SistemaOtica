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
}

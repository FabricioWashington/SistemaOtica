package DAO.Cadastro;

import DTO.Cadastro.CadastroPessoaFisicaDTO;
import DTO.Contato_Endereco.ContatoDTO;
import DTO.Contato_Endereco.EnderecoDTO;
import DTO.Login.LoginDTO;
import DAO.Conexao.ConexaoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CadastroPessoaFisicaDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LoginDTO> lista = new ArrayList<>();

    public void cadastrarUsuarioCompleto(EnderecoDTO objenderecodto, CadastroPessoaFisicaDTO objcadastrofisicadto, ContatoDTO objcontatodto) {
        conn = new ConexaoDAO().conectaBD();
        int idContato = -1; // Valor padrão para indicar erro
        int idEndereco = -1;

        try {
            conn.setAutoCommit(false); // Desliga o modo de commit automático

            // Registrar o contato
            String sqlContato = "insert into contato (idDDD, Email, Telefone, Telefone2) values (?,?,?,?)";
            PreparedStatement pstmContato = conn.prepareStatement(sqlContato, Statement.RETURN_GENERATED_KEYS);
            pstmContato.setInt(1, objcontatodto.getIdDDD());
            pstmContato.setString(2, objcontatodto.getEmail());
            pstmContato.setString(3, objcontatodto.getTelefone());
            pstmContato.setString(4, objcontatodto.getTelefone2());
            pstmContato.executeUpdate(); // Use executeUpdate() para inserções

            // Recuperar o idContato gerado
            ResultSet rsContato = pstmContato.getGeneratedKeys();
            if (rsContato.next()) {
                idContato = rsContato.getInt(1);
            }

            // Registrar o endereço
            String sqlEndereco = "insert into endereco (Logradouro, Bairro, Numero, Complemento, CEP, UF, Municipio) values (?,?,?,?,?,?,?)";
            PreparedStatement pstmEndereco = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
            pstmEndereco.setString(1, objenderecodto.getLogradouro());
            pstmEndereco.setString(2, objenderecodto.getBairro());
            pstmEndereco.setString(3, objenderecodto.getNumero());
            pstmEndereco.setString(4, objenderecodto.getComplemento());
            pstmEndereco.setString(5, objenderecodto.getCEP());
            pstmEndereco.setString(6, objenderecodto.getUF());
            pstmEndereco.setString(7, objenderecodto.getMunicipio());
            pstmEndereco.executeUpdate(); // Use executeUpdate() para inserções

            // Recuperar o idEndereco gerado
            ResultSet rsEndereco = pstmEndereco.getGeneratedKeys();
            if (rsEndereco.next()) {
                idEndereco = rsEndereco.getInt(1);
            }

            // Registrar o cadastro
            String sqlCadastroPessoaFisica = "insert into cadastro_cliente_fisico (CPF, Nome_Completo, idContato, idEndereco, Data_Cadastro, Data_Modificacao) values (?,?,?,?,?,?)";
            PreparedStatement pstmCadastroPessoaFisica = conn.prepareStatement(sqlCadastroPessoaFisica, Statement.RETURN_GENERATED_KEYS);
            pstmCadastroPessoaFisica.setString(1, objcadastrofisicadto.getCPF());
            pstmCadastroPessoaFisica.setString(2, objcadastrofisicadto.getNome_Completo());
            pstmCadastroPessoaFisica.setInt(3, idContato);
            pstmCadastroPessoaFisica.setInt(4, idEndereco);
            pstmCadastroPessoaFisica.setTimestamp(5, new java.sql.Timestamp(objcadastrofisicadto.getData_Cadastro().getTime()));
            pstmCadastroPessoaFisica.setTimestamp(6, new java.sql.Timestamp(objcadastrofisicadto.getData_Modificacao().getTime()));
            pstmCadastroPessoaFisica.executeUpdate(); // Use executeUpdate() para inserções

            conn.commit(); // Efetua o commit das transações

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            try {
                conn.rollback(); // Em caso de erro, faz rollback para desfazer as alterações
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no cadastro\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conn.setAutoCommit(true); // Restaura o modo de commit automático
                conn.close(); // Fecha a conexão
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean verificarCadastroAdminExistente(CadastroPessoaFisicaDTO objcadastroPessoaFisica) {
        conn = new ConexaoDAO().conectaBD();
        boolean empresaCadastrada = false;

        try {
            String sqlVerificarEmpresa = "SELECT COUNT(*) FROM cadastro_cliente_fisico WHERE CPF = ?";
            PreparedStatement pstmVerificarEmpresa = conn.prepareStatement(sqlVerificarEmpresa);
            pstmVerificarEmpresa.setString(1, objcadastroPessoaFisica.getCPF());
            ResultSet rsVerificarEmpresa = pstmVerificarEmpresa.executeQuery();
            rsVerificarEmpresa.next();
            int countAdmin = rsVerificarEmpresa.getInt(1);

            if (countAdmin >= 1) {
                empresaCadastrada = true;
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

        return empresaCadastrada;
    }

}

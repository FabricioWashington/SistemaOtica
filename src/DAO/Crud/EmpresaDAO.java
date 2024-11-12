package DAO.Crud;

import DTO.Crud.EmpresaDTO;
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

public class EmpresaDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LoginDTO> lista = new ArrayList<>();

    public void cadastrarUsuarioCompleto(EnderecoDTO objenderecodto, EmpresaDTO objcadastrodto, ContatoDTO objcontatodto) {
        conn = new ConexaoDAO().conectaBD();
        int idContato = -1; // Valor padrão para indicar erro
        int idEndereco = -1;
        int idCNAE = -1;
        int idEmpresa = -1;

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
            String sqlCadastroEmpresa = "insert into cadastro_empresa (CNPJ, Razao_Social, Nome_Fantasia, Regime_Tributario, Inscricao_Estadual, Indicador_IE, idContato, idEndereco, idCNAE, Data_Cadastro, Data_Modificacao) values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmCadastroEmpresa = conn.prepareStatement(sqlCadastroEmpresa, Statement.RETURN_GENERATED_KEYS);
            pstmCadastroEmpresa.setString(1, objcadastrodto.getCNPJ());
            pstmCadastroEmpresa.setString(2, objcadastrodto.getRazao_Social());
            pstmCadastroEmpresa.setString(3, objcadastrodto.getNome_Fantasia());
            pstmCadastroEmpresa.setString(4, objcadastrodto.getRegime_Tributario());
            pstmCadastroEmpresa.setString(5, objcadastrodto.getInscricao_Estadual());
            pstmCadastroEmpresa.setString(6, objcadastrodto.getIndicador_IE());
            pstmCadastroEmpresa.setInt(7, idContato);
            pstmCadastroEmpresa.setInt(8, idEndereco);
            pstmCadastroEmpresa.setInt(9, objcadastrodto.getIdCNAE());
            pstmCadastroEmpresa.setTimestamp(10, new java.sql.Timestamp(objcadastrodto.getData_Cadastro().getTime()));
            pstmCadastroEmpresa.setTimestamp(11, new java.sql.Timestamp(objcadastrodto.getData_Modificacao().getTime()));
            pstmCadastroEmpresa.executeUpdate(); // Use executeUpdate() para inserções

            // Recuperar o idEmpresa gerado
            ResultSet rsEmpresa = pstmCadastroEmpresa.getGeneratedKeys();
            if (rsEmpresa.next()) {
                idEmpresa = rsEmpresa.getInt(1);
            }
            ResultSet rsCNAE = pstmCadastroEmpresa.getGeneratedKeys();
            
            if (rsCNAE.next()) {
                idCNAE = rsCNAE.getInt(1);
                
            }

            conn.commit(); // Efetua o commit das transações

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Essa empresa já foi cadastrada no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public boolean verificarCadastroAdminExistente(EmpresaDTO objcadastroempresadto) {
        conn = new ConexaoDAO().conectaBD();
        boolean empresaCadastrada = false;

        try {
            String sqlVerificarEmpresa = "SELECT COUNT(*) FROM cadastro_empresa WHERE Cnpj = ?";
            PreparedStatement pstmVerificarEmpresa = conn.prepareStatement(sqlVerificarEmpresa);
            pstmVerificarEmpresa.setString(1, objcadastroempresadto.getCNPJ());
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

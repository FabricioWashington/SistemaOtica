package DAO.Crud;

import DTO.Crud.EmpresaDTO;
import DTO.Contato_Endereco.ContatoDTO;
import DTO.Contato_Endereco.EnderecoDTO;
import DTO.Login.LoginDTO;
import DAO.Conexao.ConexaoDAO;
import DTO.Crud.ConfiguracaoDTO;
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
    int idEmpresa = -1;
    int idCNAE = -1;
    int idContato = -1; // Valor padrão para indicar erro
    int idEndereco = -1;
    private ConfiguracaoDTO configuracaoDTO;
    private PreparedStatement pstmCertificado;
    private PreparedStatement pstmSenha;
    private PreparedStatement pstmEstado;
    private PreparedStatement pstmAmbiente;

    public void cadastrarEmpresa(EnderecoDTO objenderecodto, EmpresaDTO objcadastrodto, ContatoDTO objcontatodto, ConfiguracaoDTO configuracaoDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false); // Desliga o modo de commit automático

            // Registrar o contato
            String sqlContato = "insert into contato (Email, idDDD, Telefone, Telefone2) values (?,?,?,?)";
            PreparedStatement pstmContato = conn.prepareStatement(sqlContato, Statement.RETURN_GENERATED_KEYS);
            pstmContato.setString(1, objcontatodto.getEmail());
            pstmContato.setInt(2, objcontatodto.getIdDDD());
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
            String sqlCadastroEmpresa = "insert into empresa (CNPJ, Razao_Social, Nome_Fantasia, Regime_Tributario, Inscricao_Estadual, Indicador_IE, idContato, idEndereco, idCNAE, Data_Cadastro, Data_Modificacao) values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmCadastroEmpresa = conn.prepareStatement(sqlCadastroEmpresa, Statement.RETURN_GENERATED_KEYS);
            pstmCadastroEmpresa.setString(1, objcadastrodto.getCnpj());
            pstmCadastroEmpresa.setString(2, objcadastrodto.getRazaoSocial());
            pstmCadastroEmpresa.setString(3, objcadastrodto.getNomeFantasia());
            pstmCadastroEmpresa.setString(4, objcadastrodto.getRegimeTributario());
            pstmCadastroEmpresa.setString(5, objcadastrodto.getInscricaoEstadual());
            pstmCadastroEmpresa.setString(6, objcadastrodto.getIndicadorIE());
            pstmCadastroEmpresa.setInt(7, idContato);
            pstmCadastroEmpresa.setInt(8, idEndereco);
            pstmCadastroEmpresa.setInt(9, objcadastrodto.getIdCNAE());
            pstmCadastroEmpresa.setDate(10, new java.sql.Date(objcadastrodto.getDataCadastro().getTime()));
            pstmCadastroEmpresa.setDate(11, new java.sql.Date(objcadastrodto.getDataModificacao().getTime()));

            pstmCadastroEmpresa.executeUpdate(); // Use executeUpdate() para inserções

            // Recuperar o idEmpresa gerado
            ResultSet rsEmpresa = pstmCadastroEmpresa.getGeneratedKeys();
            if (rsEmpresa.next()) {
                idEmpresa = rsEmpresa.getInt(1);
            }
            String sqlCertificado = "INSERT INTO configuracoesnfe (chave, valor, descricao, idEmpresa) values (?,?,?,?)";
            String sqlSenha = "INSERT INTO configuracoesnfe (chave, valor, descricao, idEmpresa) values (?,?,?,?)";
            String sqlEstado = "INSERT INTO configuracoesnfe (chave, valor, descricao, idEmpresa) values (?,?,?,?)";
            String sqlAmbiente = "INSERT INTO configuracoesnfe (chave, valor, descricao, idEmpresa) values (?,?,?,?)";
            
            // sql certificado
            pstmCertificado = conn.prepareStatement(sqlCertificado);
            pstmCertificado.setString(1, configuracaoDTO.getChaveCaminhoCertificado());
            pstmCertificado.setString(2, configuracaoDTO.getCertificado());
            pstmCertificado.setString(3, configuracaoDTO.getDescricaoCertificado());
            pstmCertificado.setInt(4, idEmpresa);
            
            // sql senha
            pstmSenha = conn.prepareStatement(sqlSenha);
            pstmSenha.setString(1, configuracaoDTO.getChaveSenhaCertificado());
            pstmSenha.setString(2, configuracaoDTO.getSenha());
            pstmSenha.setString(3, configuracaoDTO.getDescricaoSenha());
            pstmSenha.setInt(4, idEmpresa);
            
            // sql estado
            pstmEstado = conn.prepareStatement(sqlEstado);
            pstmEstado.setString(1, configuracaoDTO.getChaveEstado());
            pstmEstado.setString(2, configuracaoDTO.getEstado());
            pstmEstado.setString(3, configuracaoDTO.getDescricaoEstado());
            pstmEstado.setInt(4, idEmpresa);
            
            // sql ambiente
            pstmAmbiente = conn.prepareStatement(sqlAmbiente);
            pstmAmbiente.setString(1, configuracaoDTO.getChaveAmbiente());
            pstmAmbiente.setString(2, configuracaoDTO.getAmbiente());
            pstmAmbiente.setString(3, configuracaoDTO.getDescricacaoAmbiente());
            pstmAmbiente.setInt(4, idEmpresa);

            pstmCertificado.executeUpdate();
            pstmSenha.executeUpdate();
            pstmEstado.executeUpdate();
            pstmAmbiente.executeUpdate();
         
            conn.commit(); // Efetua o commit das transações

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Essa empresa já foi cadastrada no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public boolean verificarCadastro(EmpresaDTO objcadastroempresadto) {
        conn = new ConexaoDAO().conectaBD();
        boolean empresaCadastrada = false;

        try {
            String sqlVerificarEmpresa = "SELECT COUNT(*) FROM cadastro_empresa WHERE Cnpj = ?";
            PreparedStatement pstmVerificarEmpresa = conn.prepareStatement(sqlVerificarEmpresa);
            pstmVerificarEmpresa.setString(1, objcadastroempresadto.getCnpj());
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
   
    // Método para editar uma empresa
    public void editarEmpresa(EmpresaDTO empresaDTO) {
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "UPDATE empresa SET Razao_Social = ?, Nome_Fantasia = ?, Regime_Tributario = ?, Inscricao_Estadual = ?, Indicador_IE = ?, idCNAE = ? WHERE CNPJ = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, empresaDTO.getRazaoSocial());
            pstm.setString(2, empresaDTO.getNomeFantasia());
            pstm.setString(3, empresaDTO.getRegimeTributario());
            pstm.setString(4, empresaDTO.getInscricaoEstadual());
            pstm.setString(5, empresaDTO.getIndicadorIE());
            pstm.setInt(6, empresaDTO.getIdCNAE());
            pstm.setString(7, empresaDTO.getCnpj());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Empresa editada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar empresa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            fecharConexao();
        }
    }

    // Método para excluir uma empresa
    public void excluirEmpresa(String cnpj) {
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "DELETE FROM empresa WHERE CNPJ = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cnpj);
            int rowsAffected = pstm.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Empresa excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma empresa encontrada com o CNPJ informado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir empresa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            fecharConexao();
        }
    }

    // Método para consultar uma empresa
    public EmpresaDTO consultarEmpresa(String cnpj) {
        conn = new ConexaoDAO().conectaBD();
        EmpresaDTO empresaDTO = null;
        try {
            String sql = "SELECT * FROM empresa WHERE CNPJ = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cnpj);
            rs = pstm.executeQuery();
            if (rs.next()) {
                empresaDTO = new EmpresaDTO();
                empresaDTO.setCnpj(rs.getString("CNPJ"));
                empresaDTO.setRazaoSocial(rs.getString("Razao_Social"));
                empresaDTO.setNomeFantasia(rs.getString("Nome_Fantasia"));
                empresaDTO.setRegimeTributario(rs.getString("Regime_Tributario"));
                empresaDTO.setInscricaoEstadual(rs.getString("Inscricao_Estadual"));
                empresaDTO.setIndicadorIE(rs.getString("Indicador_IE"));
                empresaDTO.setIdCNAE(rs.getInt("idCNAE"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar empresa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            fecharConexao();
        }
        return empresaDTO;
    }

    // Método para fechar conexão com o banco
    private void fecharConexao() {
        try {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para retornar o ID da última empresa cadastrada
    public int getIdEmpresa() {
        return idEmpresa;
    }
}

package DAO.Crud;

import DTO.Crud.EmpresaDTO;
import DTO.Contato_Endereco.ContatoDTO;
import DTO.Contato_Endereco.EnderecoDTO;
import DTO.Crud.ConfiguracaoDTO;
import DAO.Conexao.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EmpresaDAO {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    private int idEmpresa = -1;

    // Método para cadastrar uma nova empresa
    public void cadastrarEmpresa(EnderecoDTO objenderecodto, EmpresaDTO objcadastrodto, ContatoDTO objcontatodto, ConfiguracaoDTO configuracaoDTO) {
        conn = new ConexaoDAO().conectaBD();
        try {
            conn.setAutoCommit(false); // Desliga o modo de commit automático

            // Registrar contato
            String sqlContato = "INSERT INTO contato (Email, idDDD, Telefone, Telefone2) VALUES (?,?,?,?)";
            PreparedStatement pstmContato = conn.prepareStatement(sqlContato, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmContato.setString(1, objcontatodto.getEmail());
            pstmContato.setInt(2, objcontatodto.getIdDDD());
            pstmContato.setString(3, objcontatodto.getTelefone());
            pstmContato.setString(4, objcontatodto.getTelefone2());
            pstmContato.executeUpdate();
            ResultSet rsContato = pstmContato.getGeneratedKeys();
            if (rsContato.next()) idEmpresa = rsContato.getInt(1);

            // Registrar endereço
            String sqlEndereco = "INSERT INTO endereco (Logradouro, Bairro, Numero, Complemento, CEP, UF, Municipio) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmEndereco = conn.prepareStatement(sqlEndereco, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmEndereco.setString(1, objenderecodto.getLogradouro());
            pstmEndereco.setString(2, objenderecodto.getBairro());
            pstmEndereco.setString(3, objenderecodto.getNumero());
            pstmEndereco.setString(4, objenderecodto.getComplemento());
            pstmEndereco.setString(5, objenderecodto.getCEP());
            pstmEndereco.setString(6, objenderecodto.getUF());
            pstmEndereco.setString(7, objenderecodto.getMunicipio());
            pstmEndereco.executeUpdate();
            ResultSet rsEndereco = pstmEndereco.getGeneratedKeys();
            if (rsEndereco.next()) idEmpresa = rsEndereco.getInt(1);

            // Registrar empresa
            String sqlEmpresa = "INSERT INTO empresa (CNPJ, Razao_Social, Nome_Fantasia, Regime_Tributario, Inscricao_Estadual, Indicador_IE, idContato, idEndereco, idCNAE, Data_Cadastro, Data_Modificacao) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmEmpresa = conn.prepareStatement(sqlEmpresa, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmEmpresa.setString(1, objcadastrodto.getCnpj());
            pstmEmpresa.setString(2, objcadastrodto.getRazaoSocial());
            pstmEmpresa.setString(3, objcadastrodto.getNomeFantasia());
            pstmEmpresa.setString(4, objcadastrodto.getRegimeTributario());
            pstmEmpresa.setString(5, objcadastrodto.getInscricaoEstadual());
            pstmEmpresa.setString(6, objcadastrodto.getIndicadorIE());
            pstmEmpresa.setInt(7, idEmpresa);
            pstmEmpresa.setInt(8, idEmpresa);
            pstmEmpresa.setInt(9, objcadastrodto.getIdCNAE());
            pstmEmpresa.setDate(10, new java.sql.Date(objcadastrodto.getDataCadastro().getTime()));
            pstmEmpresa.setDate(11, new java.sql.Date(objcadastrodto.getDataModificacao().getTime()));
            pstmEmpresa.executeUpdate();

            conn.commit(); // Confirma transações
            JOptionPane.showMessageDialog(null, "Empresa cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar empresa: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            fecharConexao();
        }
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
}

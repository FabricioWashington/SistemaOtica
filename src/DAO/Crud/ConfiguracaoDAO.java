package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.ConfiguracaoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class ConfiguracaoDAO {

    private Connection conn;
    private ConfiguracaoDTO configuracaoDTO;
    private PreparedStatement pstmCertificado;
    private PreparedStatement pstmSenha;
    private PreparedStatement pstmEstado;
    private PreparedStatement pstmAmbiente;
    private PreparedStatement pstm;
    private ResultSet rs;

    public ConfiguracaoDAO() {

    }

    public ConfiguracaoDAO(Connection conn) {
        this.conn = conn;
    }

    public List<ConfiguracaoDTO> carregarConfiguracoes() throws SQLException {
        List<ConfiguracaoDTO> configuracoes = new ArrayList<>();
        conn = new ConexaoDAO().conectaBD();

        // Consulta os dados da tabela configuracoesnfe
        String sql = "SELECT chave, valor FROM configuracoesnfe";
        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            ConfiguracaoDTO dto = new ConfiguracaoDTO(); // Um único objeto para consolidar os dados

            while (rs.next()) {
                String chave = rs.getString("chave");
                String valor = rs.getString("valor");

                switch (chave) {
                    case "empresa.estado":
                        dto.setEstado(valor);
                        break;
                    case "empresa.senhaCertificado":
                        dto.setSenha(valor);
                        break;
                    case "empresa.caminhoCertificado":
                        dto.setCertificado(valor);
                        break;
                    case "empresa.ambiente":
                        dto.setAmbiente(valor);
                        break;
                }
            }

            // Adiciona o objeto ao final, apenas se contiver dados válidos
            if (dto.getEstado() != null || dto.getAmbiente() != null || dto.getCertificado() != null) {
                configuracoes.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao carregar configurações: " + e.getMessage());
        }

        return configuracoes;
    }

    public void salvarConfiguracao(String chave, String valor) throws SQLException {
        conn = new ConexaoDAO().conectaBD();
        String sql = "INSERT INTO configuracoesNfe (chave, valor) VALUES (?, ?) "
                + "ON DUPLICATE KEY UPDATE valor = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, chave);
            stmt.setString(2, valor);
            stmt.setString(3, valor);
            stmt.executeUpdate();
        }
    }

    public void cadastrarConfiguracao(ConfiguracaoDTO configuracaoDTO) {
        conn = new ConexaoDAO().conectaBD();
        try {
            conn.setAutoCommit(false);

            String sqlCertificado = "INSERT INTO configuracoesnfe (chave, valor, descricao, idEmpresa) values (?,?,?,?)";
            String sqlSenha = "INSERT INTO configuracoesnfe (chave, valor, descricao, idEmpresa) values (?,?,?,?)";
            String sqlEstado = "INSERT INTO configuracoesnfe (chave, valor, descricao, idEmpresa) values (?,?,?,?)";
            String sqlAmbiente = "INSERT INTO configuracoesnfe (chave, valor, descricao, idEmpresa) values (?,?,?,?)";

            // sql certificado
            pstmCertificado = conn.prepareStatement(sqlCertificado);
            pstmCertificado.setString(1, configuracaoDTO.getChaveCaminhoCertificado());
            pstmCertificado.setString(2, configuracaoDTO.getCertificado());
            pstmCertificado.setString(3, configuracaoDTO.getDescricaoCertificado());
            pstmCertificado.setInt(4, configuracaoDTO.getIdEmpresa());

            // sql senha
            pstmSenha = conn.prepareStatement(sqlSenha);
            pstmSenha.setString(1, configuracaoDTO.getChaveSenhaCertificado());
            pstmSenha.setString(2, configuracaoDTO.getSenha());
            pstmSenha.setString(3, configuracaoDTO.getDescricaoSenha());
            pstmSenha.setInt(4, configuracaoDTO.getIdEmpresa());

            // sql estado
            pstmEstado = conn.prepareStatement(sqlEstado);
            pstmEstado.setString(1, configuracaoDTO.getChaveEstado());
            pstmEstado.setString(2, configuracaoDTO.getEstado());
            pstmEstado.setString(3, configuracaoDTO.getDescricaoEstado());
            pstmEstado.setInt(4, configuracaoDTO.getIdEmpresa());

            // sql ambiente
            pstmAmbiente = conn.prepareStatement(sqlAmbiente);
            pstmAmbiente.setString(1, configuracaoDTO.getChaveAmbiente());
            pstmAmbiente.setString(2, configuracaoDTO.getAmbiente());
            pstmAmbiente.setString(3, configuracaoDTO.getDescricacaoAmbiente());
            pstmAmbiente.setInt(4, configuracaoDTO.getIdEmpresa());

            pstmCertificado.execute();
            pstmSenha.execute();
            pstmEstado.execute();
            pstmAmbiente.execute();
            conn.commit();
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro no cadastro", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public void atualizarConfiguracao(String chave, String valor) throws SQLException {
        conn = new ConexaoDAO().conectaBD();
        String sql = "UPDATE configuracoesNfe SET valor = ? WHERE chave = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, valor);
            stmt.setString(2, chave);
            stmt.executeUpdate();
        }
    }

    // Método para listar todas as configurações
    public List<ConfiguracaoDTO> listarConfiguracoes() {
        List<ConfiguracaoDTO> listaConfiguracoes = new ArrayList<>();
        conn = new ConexaoDAO().conectaBD();

        String sql = "SELECT id_configuracao, chave, valor, descricao, idEmpresa FROM configuracoesnfe";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ConfiguracaoDTO configuracao = new ConfiguracaoDTO();
                configuracao.setIdConfiguracao(rs.getInt("id_configuracao"));
                configuracao.setChaveCaminhoCertificado(rs.getString("chave"));
                configuracao.setValor(rs.getString("valor"));
                configuracao.setDescricao(rs.getString("descricao"));
                configuracao.setIdEmpresa(rs.getInt("idEmpresa"));

                listaConfiguracoes.add(configuracao);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar configurações: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return listaConfiguracoes;
    }

    // Método para excluir uma configuração
    public void excluirConfiguracao(int idConfiguracao) {
        conn = new ConexaoDAO().conectaBD();

        String sql = "DELETE FROM configuracoesnfe WHERE id_configuracao = ?";

        try {
            conn.setAutoCommit(false);
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idConfiguracao);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Configuração excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                conn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma configuração encontrada com o ID informado.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir configuração: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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

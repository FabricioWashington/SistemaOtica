package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.ConfiguracaoDAO;
import DAO.Crud.EmpresaDAO;
import DTO.Crud.ConfiguracaoDTO;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class ConfiguracaoService {

    private ConfiguracaoDAO configuracaoDAO;
    private ConfiguracaoDTO configuracaoDTO;
    private Map<String, String> configuracoes;
    private int idConfiguracao, idEmpresa;
    private static String chaveCaminhoCertificado, chaveSenhaCertificado, chaveEstado, chaveAmbiente;
    private String certificado, senha, estado, ambiente;
    private static String descricaoCertificado, descricaoSenha, descricaoEstado, descricacaoAmbiente;
    private EmpresaDAO empresaDAO;

    public ConfiguracaoService() {
        this.configuracaoDAO = new ConfiguracaoDAO();
        this.configuracaoDTO = new ConfiguracaoDTO();
        this.empresaDAO = new EmpresaDAO();
    }

    public ConfiguracaoService(Connection connection) throws SQLException {
        this.configuracaoDAO = new ConfiguracaoDAO(connection);
        this.configuracaoDTO = new ConfiguracaoDTO();
        this.empresaDAO = new EmpresaDAO();
    }

    public ConfiguracaoService(String certificado, String senha, String estado, String ambiente) {
        this();
        this.certificado = certificado;
        this.senha = senha;
        this.estado = estado;
        this.ambiente = ambiente;
    }

 

    // Método para obter o caminho do certificado
    public String getCaminhoCertificado() {
        return getConfiguracoes().get("empresa.caminhoCertificado");
    }

    // Método para obter a senha do certificado como char array
    public char[] getSenhaCertificado() {
        String senha = getConfiguracoes().get("empresa.senhaCertificado");
        return senha != null ? senha.toCharArray() : null;
    }

    // Método para obter o estado de emissão
    public EstadosEnum getEstadoObter() {
        String estado = getConfiguracoes().get("empresa.estado");
        return estado != null ? EstadosEnum.valueOf(estado) : null;
    }

    // Método para obter o ambiente de emissão
    public AmbienteEnum getAmbienteObter() {
        String ambiente = getConfiguracoes().get("empresa.ambiente");
        return ambiente != null ? AmbienteEnum.valueOf(ambiente) : null;
    }

    // Método para atualizar uma configuração específica e salvá-la no banco
    public void atualizarConfiguracao(String chave, String valor) throws SQLException {
        configuracaoDAO.atualizarConfiguracao(chave, valor);
        getConfiguracoes().put(chave, valor);  // Atualiza o cache em memória
    }

    // Método para salvar uma nova configuração
    public void salvarConfiguracao(String chave, String valor) throws SQLException {
        configuracaoDAO.salvarConfiguracao(chave, valor);
        getConfiguracoes().put(chave, valor);  // Atualiza o cache em memória
    }

    public void cadastrarConfiguracao() {
        empresaDAO = new EmpresaDAO();
        idEmpresa = empresaDAO.getIdEmpresa();
        configuracaoDTO.setCertificado(certificado);
        configuracaoDTO.setAmbiente(ambiente);
        configuracaoDTO.setEstado(estado);
        configuracaoDTO.setSenha(senha);
        configuracaoDTO.setIdEmpresa(idEmpresa);

        configuracaoDAO.cadastrarConfiguracao(configuracaoDTO);

    }

    /**
     * @return the configuracoes
     */
    public Map<String, String> getConfiguracoes() {
        return configuracoes;
    }

    /**
     * @param configuracoes the configuracoes to set
     */
    public void setConfiguracoes(Map<String, String> configuracoes) {
        this.configuracoes = configuracoes;
    }

    /**
     * @return the chaveCaminhoCertificado
     */
    public static String getChaveCaminhoCertificado() {
        return chaveCaminhoCertificado;
    }

    /**
     * @param aChaveCaminhoCertificado the chaveCaminhoCertificado to set
     */
    public static void setChaveCaminhoCertificado(String aChaveCaminhoCertificado) {
        chaveCaminhoCertificado = aChaveCaminhoCertificado;
    }

    /**
     * @return the chaveSenhaCertificado
     */
    public static String getChaveSenhaCertificado() {
        return chaveSenhaCertificado;
    }

    /**
     * @param aChaveSenhaCertificado the chaveSenhaCertificado to set
     */
    public static void setChaveSenhaCertificado(String aChaveSenhaCertificado) {
        chaveSenhaCertificado = aChaveSenhaCertificado;
    }

    /**
     * @return the chaveEstado
     */
    public static String getChaveEstado() {
        return chaveEstado;
    }

    /**
     * @param aChaveEstado the chaveEstado to set
     */
    public static void setChaveEstado(String aChaveEstado) {
        chaveEstado = aChaveEstado;
    }

    /**
     * @return the chaveAmbiente
     */
    public static String getChaveAmbiente() {
        return chaveAmbiente;
    }

    /**
     * @param aChaveAmbiente the chaveAmbiente to set
     */
    public static void setChaveAmbiente(String aChaveAmbiente) {
        chaveAmbiente = aChaveAmbiente;
    }

    /**
     * @return the certificado
     */
    public String getCertificado() {
        return certificado;
    }

    /**
     * @param certificado the certificado to set
     */
    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @param ambiente the ambiente to set
     */
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    /**
     * @return the descricaoCertificado
     */
    public static String getDescricaoCertificado() {
        return descricaoCertificado;
    }

    /**
     * @param aDescricaoCertificado the descricaoCertificado to set
     */
    public static void setDescricaoCertificado(String aDescricaoCertificado) {
        descricaoCertificado = aDescricaoCertificado;
    }

    /**
     * @return the descricaoSenha
     */
    public static String getDescricaoSenha() {
        return descricaoSenha;
    }

    /**
     * @param aDescricaoSenha the descricaoSenha to set
     */
    public static void setDescricaoSenha(String aDescricaoSenha) {
        descricaoSenha = aDescricaoSenha;
    }

    /**
     * @return the descricaoEstado
     */
    public static String getDescricaoEstado() {
        return descricaoEstado;
    }

    /**
     * @param aDescricaoEstado the descricaoEstado to set
     */
    public static void setDescricaoEstado(String aDescricaoEstado) {
        descricaoEstado = aDescricaoEstado;
    }

    /**
     * @return the descricacaoAmbiente
     */
    public static String getDescricacaoAmbiente() {
        return descricacaoAmbiente;
    }

    /**
     * @param aDescricacaoAmbiente the descricacaoAmbiente to set
     */
    public static void setDescricacaoAmbiente(String aDescricacaoAmbiente) {
        descricacaoAmbiente = aDescricacaoAmbiente;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @return the ambiente
     */
    public String getAmbiente() {
        return ambiente;
    }

    /**
     * @return the idConfiguracao
     */
    public int getIdConfiguracao() {
        return idConfiguracao;
    }

    /**
     * @param idConfiguracao the idConfiguracao to set
     */
    public void setIdConfiguracao(int idConfiguracao) {
        this.idConfiguracao = idConfiguracao;
    }

    /**
     * @return the idEmpresa
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}

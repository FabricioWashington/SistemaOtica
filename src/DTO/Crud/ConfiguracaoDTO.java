package DTO.Crud;

public class ConfiguracaoDTO {

    private int idConfiguracao, idEmpresa;
    //atributo chave da tabela
    private static String chaveCaminhoCertificado = "empresa.caminhoCertificado", chaveSenhaCertificado = "empresa.senhaCertificado", chaveEstado = "empresa.estado", chaveAmbiente = "empresa.ambiente";
    //atributo valor da tabela
    private String certificado, senha, estado, ambiente;
    //atributo descricao da tabela
    private static String descricaoCertificado = "Caminho para o certificado digital", descricaoSenha = "Senha do certificado digital", descricaoEstado = "Estado de emissão", descricacaoAmbiente = "Ambiente de emissão (PRODUCAO ou HOMOLOGACAO)";
    
    private String valor, descricao;
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
     * @return the chaveCaminhoCertificado
     */
    public static String getChaveCaminhoCertificado() {
        return chaveCaminhoCertificado;
    }

    /**
     * @param chaveCaminhoCertificado the chaveCaminhoCertificado to set
     */
    public void setChaveCaminhoCertificado(String chaveCaminhoCertificado) {
        this.chaveCaminhoCertificado = chaveCaminhoCertificado;
    }

    /**
     * @return the chaveSenhaCertificado
     */
    public static String getChaveSenhaCertificado() {
        return chaveSenhaCertificado;
    }

    /**
     * @param chaveSenhaCertificado the chaveSenhaCertificado to set
     */
    public void setChaveSenhaCertificado(String chaveSenhaCertificado) {
        this.chaveSenhaCertificado = chaveSenhaCertificado;
    }

    /**
     * @return the chaveEstado
     */
    public static String getChaveEstado() {
        return chaveEstado;
    }

    /**
     * @param chaveEstado the chaveEstado to set
     */
    public void setChaveEstado(String chaveEstado) {
        this.chaveEstado = chaveEstado;
    }

    /**
     * @return the chaveAmbiente
     */
    public static String getChaveAmbiente() {
        return chaveAmbiente;
    }

    /**
     * @param chaveAmbiente the chaveAmbiente to set
     */
    public void setChaveAmbiente(String chaveAmbiente) {
        this.chaveAmbiente = chaveAmbiente;
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
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the ambiente
     */
    public String getAmbiente() {
        return ambiente;
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
    public String getDescricaoCertificado() {
        return descricaoCertificado;
    }

    /**
     * @param descricaoCertificado the descricaoCertificado to set
     */
    public void setDescricaoCertificado(String descricaoCertificado) {
        this.descricaoCertificado = descricaoCertificado;
    }

    /**
     * @return the descricaoSenha
     */
    public String getDescricaoSenha() {
        return descricaoSenha;
    }

    /**
     * @param descricaoSenha the descricaoSenha to set
     */
    public void setDescricaoSenha(String descricaoSenha) {
        this.descricaoSenha = descricaoSenha;
    }

    /**
     * @return the descricaoEstado
     */
    public String getDescricaoEstado() {
        return descricaoEstado;
    }

    /**
     * @param descricaoEstado the descricaoEstado to set
     */
    public void setDescricaoEstado(String descricaoEstado) {
        this.descricaoEstado = descricaoEstado;
    }

    /**
     * @return the descricacaoAmbiente
     */
    public String getDescricacaoAmbiente() {
        return descricacaoAmbiente;
    }

    /**
     * @param descricacaoAmbiente the descricacaoAmbiente to set
     */
    public void setDescricacaoAmbiente(String descricacaoAmbiente) {
        this.descricacaoAmbiente = descricacaoAmbiente;
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

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
  

}

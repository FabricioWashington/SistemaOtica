package DTO.Crud;

import java.util.Date;


public class EmpresaDTO {
    private int idContato, idEndereco, idCNAE, idEmpresa, idEmpresa_CnaeSecundario, idCNAE_Secundario; 
    private String CNPJ, Razao_Social, Nome_Fantasia, Regime_Tributario, Inscricao_Estadual, Indicador_IE;
    private Date Data_Cadastro, Data_Modificacao;

    /**
     * @return the idContato
     */
    public int getIdContato() {
        return idContato;
    }

    /**
     * @param idContato the idContato to set
     */
    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    /**
     * @return the idEndereco
     */
    public int getIdEndereco() {
        return idEndereco;
    }

    /**
     * @param idEndereco the idEndereco to set
     */
    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    /**
     * @return the idCNAE
     */
    public int getIdCNAE() {
        return idCNAE;
    }

    /**
     * @param idCNAE the idCNAE to set
     */
    public void setIdCNAE(int idCNAE) {
        this.idCNAE = idCNAE;
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
     * @return the CNPJ
     */
    public String getCNPJ() {
        return CNPJ;
    }

    /**
     * @param CNPJ the CNPJ to set
     */
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    /**
     * @return the Razao_Social
     */
    public String getRazao_Social() {
        return Razao_Social;
    }

    /**
     * @param Razao_Social the Razao_Social to set
     */
    public void setRazao_Social(String Razao_Social) {
        this.Razao_Social = Razao_Social;
    }

    /**
     * @return the Nome_Fantasia
     */
    public String getNome_Fantasia() {
        return Nome_Fantasia;
    }

    /**
     * @param Nome_Fantasia the Nome_Fantasia to set
     */
    public void setNome_Fantasia(String Nome_Fantasia) {
        this.Nome_Fantasia = Nome_Fantasia;
    }

    /**
     * @return the Regime_Tributario
     */
    public String getRegime_Tributario() {
        return Regime_Tributario;
    }

    /**
     * @param Regime_Tributario the Regime_Tributario to set
     */
    public void setRegime_Tributario(String Regime_Tributario) {
        this.Regime_Tributario = Regime_Tributario;
    }

    /**
     * @return the Inscricao_Estadual
     */
    public String getInscricao_Estadual() {
        return Inscricao_Estadual;
    }

    /**
     * @param Inscricao_Estadual the Inscricao_Estadual to set
     */
    public void setInscricao_Estadual(String Inscricao_Estadual) {
        this.Inscricao_Estadual = Inscricao_Estadual;
    }

    /**
     * @return the Indicador_IE
     */
    public String getIndicador_IE() {
        return Indicador_IE;
    }

    /**
     * @param Indicador_IE the Indicador_IE to set
     */
    public void setIndicador_IE(String Indicador_IE) {
        this.Indicador_IE = Indicador_IE;
    }

    /**
     * @return the Data_Cadastro
     */
    public Date getData_Cadastro() {
        return Data_Cadastro;
    }

    /**
     * @param Data_Cadastro the Data_Cadastro to set
     */
    public void setData_Cadastro(Date Data_Cadastro) {
        this.Data_Cadastro = Data_Cadastro;
    }

    /**
     * @return the idEmpresa_CnaeSecundario
     */
    public int getIdEmpresa_CnaeSecundario() {
        return idEmpresa_CnaeSecundario;
    }

    /**
     * @param idEmpresa_CnaeSecundario the idEmpresa_CnaeSecundario to set
     */
    public void setIdEmpresa_CnaeSecundario(int idEmpresa_CnaeSecundario) {
        this.idEmpresa_CnaeSecundario = idEmpresa_CnaeSecundario;
    }

    /**
     * @return the idCNAE_Secundario
     */
    public int getIdCNAE_Secundario() {
        return idCNAE_Secundario;
    }

    /**
     * @param idCNAE_Secundario the idCNAE_Secundario to set
     */
    public void setIdCNAE_Secundario(int idCNAE_Secundario) {
        this.idCNAE_Secundario = idCNAE_Secundario;
    }

    /**
     * @return the Data_Modificacao
     */
    public Date getData_Modificacao() {
        return Data_Modificacao;
    }

    /**
     * @param Data_Modificacao the Data_Modificacao to set
     */
    public void setData_Modificacao(Date Data_Modificacao) {
        this.Data_Modificacao = Data_Modificacao;
    }
}

   
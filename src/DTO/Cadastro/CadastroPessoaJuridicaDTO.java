package DTO.Cadastro;

import java.util.Date;


public class CadastroPessoaJuridicaDTO {
    private int idContato, idEndereco, idCliente_Juridico; 
    private String CNPJ, Razao_Social, Nome_Fantasia;
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

    /**
     * @return the idCliente_Fisico
     */
    public int getIdCliente_Fisico() {
        return idCliente_Juridico;
    }

    /**
     * @param idCliente_Fisico the idCliente_Fisico to set
     */
    public void setIdCliente_Fisico(int idCliente_Fisico) {
        this.idCliente_Juridico = idCliente_Fisico;
    }
}

   
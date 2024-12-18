package DTO.Crud;

import java.util.Date;


public class UsuariosDTO {
    private int idContato, idDDD, idUsuario; 
    private String CPF;
    private String Nome_Completo;
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
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return the Nome_Completo
     */
    public String getNome_Completo() {
        return Nome_Completo;
    }

    /**
     * @param Nome_Completo the Nome_Completo to set
     */
    public void setNome_Completo(String Nome_Completo) {
        this.Nome_Completo = Nome_Completo;
    }

    /**
     * @return the idDDD
     */
    public int getIdDDD() {
        return idDDD;
    }

    /**
     * @param idDDD the idDDD to set
     */
    public void setIdDDD(int idDDD) {
        this.idDDD = idDDD;
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
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}

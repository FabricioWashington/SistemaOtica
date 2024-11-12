package DTO.Crud;

import java.util.Date;

public class FuncionarioDTO {

    private int idFuncionarios, idFuncao;
    private String CPF, Nome_Completo;
    private Date Data_Modificacao, Data_Cadastro;

    public int getIdFuncionarios() {
        return idFuncionarios;
    }

    public void setIdFuncionarios(int idFuncionarios) {
        this.idFuncionarios = idFuncionarios;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome_Completo() {
        return Nome_Completo;
    }

    public void setNome_Completo(String Nome_Completo) {
        this.Nome_Completo = Nome_Completo;
    }

    public Date getData_Modificacao() {
        return Data_Modificacao;
    }

    public void setData_Modificacao(Date Data_Modificacao) {
        this.Data_Modificacao = Data_Modificacao;
    }

    public Date getData_Cadastro() {
        return Data_Cadastro;
    }

    public void setData_Cadastro(Date Data_Cadastro) {
        this.Data_Cadastro = Data_Cadastro;
    }

    /**
     * @return the idFuncao
     */
    public int getIdFuncao() {
        return idFuncao;
    }

    /**
     * @param idFuncao the idFuncao to set
     */
    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }

}

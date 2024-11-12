package DTO.Login;

import java.util.Date;


public class LoginDTO {
    private int idlogin, idtipos_login, idContato, idUsuario;
    private String Login_Usuario, Login_Senha, CPF;
    private Date Data_Cadastro, Data_Modificacao;

    /**
     * @return the idlogin
     */
    public int getIdlogin() {
        return idlogin;
    }

    /**
     * @param idlogin the idlogin to set
     */
    public void setIdlogin(int idlogin) {
        this.idlogin = idlogin;
    }

    /**
     * @return the Login_Usuario
     */
    public String getLogin_Usuario() {
        return Login_Usuario;
    }

    /**
     * @param Login_Usuario the Login_Usuario to set
     */
    public void setLogin_Usuario(String Login_Usuario) {
        this.Login_Usuario = Login_Usuario;
    }

    /**
     * @return the Login_Senha
     */
    public String getLogin_Senha() {
        return Login_Senha;
    }

    /**
     * @param Login_Senha the Login_Senha to set
     */
    public void setLogin_Senha(String Login_Senha) {
        this.Login_Senha = Login_Senha;
    }

    public void setSenha_Usuario(String Login_Usuario) {
    }

    /**
     * @return the idtipos_login
     */
    public int getIdtipos_login() {
        return idtipos_login;
    }

    /**
     * @param idtipos_login the idtipos_login to set
     */
    public void setIdtipos_login(int idtipos_login) {
        this.idtipos_login = idtipos_login;
    }

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

    
package DTO.Contato_Endereco;

import java.util.Date;


public class ContatoDTO {
    private int idContato, idDDD;
    private String Telefone, Telefone2; 
    private String Email;
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
     * @return the Telefone
     */
    public String getTelefone() {
        return Telefone;
    }

    /**
     * @param Telefone the Telefone to set
     */
    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
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
     * @return the Telefone2
     */
    public String getTelefone2() {
        return Telefone2;
    }

    /**
     * @param Telefone2 the Telefone2 to set
     */
    public void setTelefone2(String Telefone2) {
        this.Telefone2 = Telefone2;
    }
}

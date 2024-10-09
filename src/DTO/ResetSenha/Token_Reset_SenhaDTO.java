package DTO.ResetSenha;

import java.util.Date;


public class Token_Reset_SenhaDTO {
    private String Email;
    private String Token;
    private Date Data_Expiracao;

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
     * @return the Token
     */
    public String getToken() {
        return Token;
    }

    /**
     * @param Token the Token to set
     */
    public void setToken(String Token) {
        this.Token = Token;
    }

    /**
     * @return the Data_Expiracao
     */
    public Date getData_Expiracao() {
        return Data_Expiracao;
    }

    /**
     * @param Data_Expiracao the Data_Expiracao to set
     */
    public void setData_Expiracao(Date Data_Expiracao) {
        this.Data_Expiracao = Data_Expiracao;
    }
    
}

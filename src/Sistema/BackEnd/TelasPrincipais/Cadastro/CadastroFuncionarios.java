package Sistema.BackEnd.TelasPrincipais.Cadastro;

import DAO.Cadastro.CadastroFuncionarioDAO;
import Sistema.BackEnd.Validacoes;
import java.util.Date;

public class CadastroFuncionarios {

    private String nomeCompleto;
    private String cpf;
    private Date dataCadastro;
    private Date dataModificacao;
    private Validacoes validador;
    private CadastroUsuarios metodoObterHorario;
    private CadastroFuncionarioDAO cadastroFuncionariosDAO;

    public CadastroFuncionarios() {
        this.cadastroFuncionariosDAO = new CadastroFuncionarioDAO();
        this.validador = new Validacoes();
        this.metodoObterHorario = new CadastroUsuarios();
        metodoObterHorario.obterDataAtual();

    }

    public CadastroFuncionarios(String cpf, String nomeCompleto) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;

    }

    /**
     * @return the nomeCompleto
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    /**
     * @param nomeCompleto the nomeCompleto to set
     */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the dataCadastro
     */
    public Date getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param dataCadastro the dataCadastro to set
     */
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /**
     * @return the dataModificacao
     */
    public Date getDataModificacao() {
        return dataModificacao;
    }

    /**
     * @param dataModificacao the dataModificacao to set
     */
    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    /**
     * @return the validador
     */
    public Validacoes getValidador() {
        return validador;
    }

    /**
     * @param validador the validador to set
     */
    public void setValidador(Validacoes validador) {
        this.validador = validador;
    }

}

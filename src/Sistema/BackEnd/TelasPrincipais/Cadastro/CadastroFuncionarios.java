package Sistema.BackEnd.TelasPrincipais.Cadastro;

import DAO.Cadastro.CadastroFuncionarioDAO;
import DTO.Cadastro.CadastroFuncionarioDTO;
import Sistema.BackEnd.Validacoes;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CadastroFuncionarios {

    private String nomeCompleto;
    private String cpf;
    private Date dataCadastro;
    private int IdFuncao;
    private Date dataModificacao;
    private Validacoes validador;
    private CadastroFuncionarioDAO cadastroFuncionariosDAO;
    private CadastroFuncionarioDTO cadastroFuncionariosDTO;

    public CadastroFuncionarios() {
        this.cadastroFuncionariosDAO = new CadastroFuncionarioDAO();
        this.validador = new Validacoes();
        this.cadastroFuncionariosDTO = new CadastroFuncionarioDTO();
        obterDataAtual();
    }

    public CadastroFuncionarios(String cpf, String nomeCompleto, int IdFuncao) {
        this();
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.IdFuncao = IdFuncao;

    }

    public void cadastrar() {
        if (!validarCampos()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!validador.validarCpf(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Formatar o CPF
        cpf = validador.formatarCpf(cpf);

        cadastroFuncionariosDTO.setCPF(cpf);
        cadastroFuncionariosDTO.setNome_Completo(nomeCompleto);
        cadastroFuncionariosDTO.setIdFuncao(IdFuncao);
        cadastroFuncionariosDTO.setData_Cadastro(dataCadastro);
        cadastroFuncionariosDTO.setData_Modificacao(dataModificacao);

        cadastroFuncionariosDAO.cadastrarFuncionarioCompleto(cadastroFuncionariosDTO);

    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Validacoes getValidador() {
        return validador;
    }

    public void setValidador(Validacoes validador) {
        this.validador = validador;
    }

    public boolean validarCampos() {
        return !cpf.isEmpty() && !nomeCompleto.isEmpty();
    }

    public void limparCampos(JFormattedTextField txtCpf, JTextField txtNomeCompleto) {
        txtCpf.setText("");
        txtNomeCompleto.setText("");
    }

    public void obterDataAtual() {
        Calendar cal = Calendar.getInstance();
        this.dataCadastro = cal.getTime();
        this.dataModificacao = cal.getTime();
    }

    /**
     * @return the IdFuncao
     */
    public int getIdFuncao() {
        return IdFuncao;
    }

    /**
     * @param IdFuncao the IdFuncao to set
     */
    public void setIdFuncao(int IdFuncao) {
        this.IdFuncao = IdFuncao;
    }

}

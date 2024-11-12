package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.ClienteDAO;
import DAO.Conexao.ConexaoDAO;
import DTO.Crud.ClienteDTO;
import DTO.Crud.PessoaFisicaDTO;
import DTO.Crud.PessoaJuridicaDTO;
import DTO.Contato_Endereco.ContatoDTO;
import DTO.Contato_Endereco.EnderecoDTO;
import Sistema.BackEnd.Validacoes;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

public class Cliente {

    private String nome;
    private int idEndereco;
    private int idContato;
    private int idClientes;
    private int idDDD;
    private String logradouro;
    private String bairro;
    private String numero;
    private String complemento;
    private String cep;
    private String uf;
    private String municipio;
    private String telefone;
    private String telefone2;
    private String email;
    private Date dataCadastro;
    private Date dataModificacao;
    private String nomeFantasia;
    private String cnpj;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private String cpf;
    private PessoaJuridicaDTO cadastroPessoaJuridicaDTO;
    private PessoaFisicaDTO cadastroPessoaFisicaDTO;
    private ClienteDTO cadastroClienteDTO;
    private ClienteDAO cadastroClienteDAO;
    private Validacoes validador;
    private ContatoDTO cadastroContatoDTO;
    private EnderecoDTO cadastroEnderecoDTO;

    // Construtor Padrão
    public Cliente() {
        cadastroClienteDAO = new ClienteDAO();
        cadastroClienteDTO = new ClienteDTO();
        cadastroEnderecoDTO = new EnderecoDTO();
        cadastroContatoDTO = new ContatoDTO();
        cadastroPessoaJuridicaDTO = new PessoaJuridicaDTO();
        cadastroPessoaFisicaDTO = new PessoaFisicaDTO();
        validador = new Validacoes();
        obterDataAtual();
    }

    // Construtor PF
    public Cliente(String nome, int idDDD, String logradouro, String bairro, String numero, String complemento,
            String cep, String uf, String municipio, String telefone, String telefone2, String email, String cpf) {
        this();
        this.nome = nome;
        this.idDDD = idDDD;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.uf = uf;
        this.municipio = municipio;
        this.telefone = telefone;
        this.telefone2 = telefone2;
        this.email = email;
        this.cpf = cpf;
    }

    // Construtor PJ
    public Cliente(String nome, int idDDD, String logradouro, String bairro, String numero, String complemento,
            String cep, String uf, String municipio, String telefone, String telefone2, String email, String cnpj,
            String nomeFantasia, String inscricaoEstadual, String inscricaoMunicipal) {
        this();
        this.nome = nome;
        this.idDDD = idDDD;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.uf = uf;
        this.municipio = municipio;
        this.telefone = telefone;
        this.telefone2 = telefone2;
        this.email = email;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.nomeFantasia = nomeFantasia;
    }

    // Método para obter data e hora atuais
    public void obterDataAtual() {
        Calendar cal = Calendar.getInstance();
        this.setDataCadastro(cal.getTime());
        this.setDataModificacao(cal.getTime());
    }

    public void preencherDadosPJ(JFormattedTextField txtCnpj) {

    }

    public void cadastrarPJ() {
        // Cadastro Contato
        cadastroContatoDTO.setEmail(email);
        cadastroContatoDTO.setIdDDD(idDDD);
        cadastroContatoDTO.setTelefone(telefone);
        cadastroContatoDTO.setTelefone2(telefone);

        // Cadastro Cliente
        cadastroClienteDTO.setNome(nome);
        cadastroClienteDTO.setIdEndereco(idEndereco);
        cadastroClienteDTO.setIdContato(idContato);
        cadastroClienteDTO.setDataCadastro(dataCadastro);
        cadastroClienteDTO.setDataModificacao(dataModificacao);

        // Cadastro Endereço
        cadastroEnderecoDTO.setLogradouro(logradouro);
        cadastroEnderecoDTO.setBairro(bairro);
        cadastroEnderecoDTO.setNumero(numero);
        cadastroEnderecoDTO.setComplemento(complemento);
        cadastroEnderecoDTO.setCEP(cep);
        cadastroEnderecoDTO.setUF(uf);
        cadastroEnderecoDTO.setMunicipio(municipio);
        
         if (!validador.validarCNPJ(cnpj)) {
            JOptionPane.showMessageDialog(null, "CNPJ inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Formatar o CPF
        cnpj = validador.formatarCNPJ(cnpj);

        // Cadastro PJ
        cadastroPessoaJuridicaDTO.setNomeFantasia(nomeFantasia);
        cadastroPessoaJuridicaDTO.setCnpj(cnpj);
        cadastroPessoaJuridicaDTO.setInscricaoEstadual(inscricaoEstadual);
        cadastroPessoaJuridicaDTO.setInscricaoMunicipal(inscricaoMunicipal);
        cadastroPessoaJuridicaDTO.setIdCliente(idClientes);

        cadastroClienteDAO.cadastrarClientePJ(cadastroClienteDTO, cadastroPessoaJuridicaDTO, cadastroEnderecoDTO, cadastroContatoDTO);

    }

    public void cadastrarPF() {
        // Cadastro Contato
        cadastroContatoDTO.setEmail(email);
        cadastroContatoDTO.setIdDDD(idDDD);
        cadastroContatoDTO.setTelefone(telefone);
        cadastroContatoDTO.setTelefone2(telefone);

        // Cadastro Cliente
        cadastroClienteDTO.setNome(nome);
        cadastroClienteDTO.setIdEndereco(idEndereco);
        cadastroClienteDTO.setIdContato(idContato);
        cadastroClienteDTO.setDataCadastro(dataCadastro);
        cadastroClienteDTO.setDataModificacao(dataModificacao);

        // Cadastro Endereço
        cadastroEnderecoDTO.setLogradouro(logradouro);
        cadastroEnderecoDTO.setBairro(bairro);
        cadastroEnderecoDTO.setNumero(numero);
        cadastroEnderecoDTO.setComplemento(complemento);
        cadastroEnderecoDTO.setCEP(cep);
        cadastroEnderecoDTO.setUF(uf);
        cadastroEnderecoDTO.setMunicipio(municipio);

        if (!validador.validarCpf(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Formatar o CPF
        cpf = validador.formatarCpf(cpf);

        // Cadastro PF
        cadastroPessoaFisicaDTO.setCpf(cpf);
        cadastroPessoaFisicaDTO.setIdCliente(idClientes);

        cadastroClienteDAO.cadastrarClientePF(cadastroClienteDTO, cadastroPessoaFisicaDTO, cadastroEnderecoDTO, cadastroContatoDTO);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the contato
     */
    public String setTelefone2() {
        return getTelefone2();
    }

    /**
     * @param contato the contato to set
     */
    public void setTelefone2(String contato) {
        this.telefone2 = getTelefone2();
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the nomeFantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * @param nomeFantasia the nomeFantasia to set
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the inscricaoEstadual
     */
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    /**
     * @param inscricaoEstadual the inscricaoEstadual to set
     */
    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    /**
     * @return the inscricaoMunicipal
     */
    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    /**
     * @param inscricaoMunicipal the inscricaoMunicipal to set
     */
    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    /**
     * @return the idClientes
     */
    public int getIdClientes() {
        return idClientes;
    }

    /**
     * @param idClientes the idClientes to set
     */
    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }

    /**
     * @return the telefone2
     */
    public String getTelefone2() {
        return telefone2;
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

}

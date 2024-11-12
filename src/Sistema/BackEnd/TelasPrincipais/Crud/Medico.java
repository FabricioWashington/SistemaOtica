package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.MedicoDAO;
import DTO.Crud.MedicoDTO;
import DTO.Contato_Endereco.ContatoDTO;
import DTO.Contato_Endereco.EnderecoDTO;
import java.util.Calendar;
import java.util.Date;

public class Medico {
    
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
    private String nome;
    private String registroProfissional;
    private int idEndereco;
    private int idContato;
    private int idDDD;
    private Date dataCadastro;
    private MedicoDTO cadastroMedicoDTO;
    private MedicoDAO cadastroMedicoDAO;
    private EnderecoDTO cadastroEnderecoDTO;
    private ContatoDTO cadastroContatoDTO;
    
    public Medico() {
        cadastroMedicoDTO = new MedicoDTO();
        cadastroMedicoDAO = new MedicoDAO();
        cadastroEnderecoDTO = new EnderecoDTO();
        cadastroContatoDTO = new ContatoDTO();
        obterDataAtual();
        
    }
    
    public Medico(String logradouro, String bairro, String numero,
            String complemento, String cep, String uf, int idDDD, String municipio,
            String telefone, String telefone2, String email, String nome,
            String registroProfissional) {
        this();
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.uf = uf;
        this.idDDD = idDDD;
        this.municipio = municipio;
        this.telefone = telefone;
        this.telefone2 = telefone2;
        this.email = email;
        this.nome = nome;
        this.registroProfissional = registroProfissional;
    }
    
    public void cadastrar() {
        cadastroContatoDTO.setEmail(email);
        cadastroContatoDTO.setIdDDD(getIdDDD());
        cadastroContatoDTO.setTelefone(telefone);
        cadastroContatoDTO.setTelefone2(telefone);
        
        cadastroEnderecoDTO.setLogradouro(logradouro);
        cadastroEnderecoDTO.setBairro(bairro);
        cadastroEnderecoDTO.setNumero(numero);
        cadastroEnderecoDTO.setComplemento(complemento);
        cadastroEnderecoDTO.setCEP(cep);
        cadastroEnderecoDTO.setUF(uf);
        cadastroEnderecoDTO.setMunicipio(municipio);
        
        cadastroMedicoDTO.setNome(nome);
        cadastroMedicoDTO.setRegistroProfissional(registroProfissional);
        cadastroMedicoDTO.setIdEndereco(idEndereco);
        cadastroMedicoDTO.setIdContato(idContato);
        cadastroMedicoDTO.setDataCadastro(dataCadastro);
        
        cadastroMedicoDAO.cadastrarMedico(cadastroMedicoDTO, cadastroEnderecoDTO, cadastroContatoDTO);
    }

    // Método para obter data e hora atuais
    public void obterDataAtual() {
        Calendar cal = Calendar.getInstance();
        this.setDataCadastro(cal.getTime());
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
     * @return the telefone2
     */
    public String getTelefone2() {
        return telefone2;
    }

    /**
     * @param telefone2 the telefone2 to set
     */
    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
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
     * @return the registroProfissional
     */
    public String getRegistroProfissional() {
        return registroProfissional;
    }

    /**
     * @param registroProfissional the registroProfissional to set
     */
    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
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
    
}

package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.ConfiguracaoDAO;
import DAO.Crud.EmpresaDAO;
import DTO.Contato_Endereco.ContatoDTO;
import DTO.Contato_Endereco.EnderecoDTO;
import DTO.Crud.ConfiguracaoDTO;
import DTO.Crud.EmpresaDTO;
import Sistema.BackEnd.Validacoes;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;

public class Empresa {

    private int idContato, idEndereco, idEmpresa, idCNAE;
    private String cnpj, razaoSocial, nomeFantasia, regimeTributario, inscricaoEstadual, indicadorIE;
    private Date dataCadastro, dataModificacao;
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
    private EmpresaDTO empresaDTO;
    private EmpresaDAO empresaDAO;
    private EnderecoDTO enderecoDTO;
    private ContatoDTO contatoDTO;
    private Validacoes validador;
    private ConfiguracaoDAO configuracaoDAO;
    private ConfiguracaoDTO configuracaoDTO;
    private Map<String, String> configuracoes;
    private int idConfiguracao;
    private static String chaveCaminhoCertificado, chaveSenhaCertificado, chaveEstado, chaveAmbiente;
    private String certificado, senha, estado, ambiente;
    private static String descricaoCertificado, descricaoSenha, descricaoEstado, descricacaoAmbiente;

    public Empresa() {
        this.empresaDAO = new EmpresaDAO();
        this.empresaDTO = new EmpresaDTO();
        this.enderecoDTO = new EnderecoDTO();
        this.contatoDTO = new ContatoDTO();
        this.configuracaoDTO = new ConfiguracaoDTO();
        this.configuracaoDAO = new ConfiguracaoDAO();
        this.validador = new Validacoes();
        obterDataAtual();
    }

    public Empresa(int idCNAE, String cnpj, String razaoSocial, String nomeFantasia, String regimeTributario, String inscricaoEstadual, String indicadorIE, int idDDD, String logradouro, String bairro, String numero, String complemento, String cep, String uf, String municipio, String telefone, String telefone2, String email, String certificado, String senha, String estado, String ambiente) {
        this();
        this.idCNAE = idCNAE;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.regimeTributario = regimeTributario;
        this.inscricaoEstadual = inscricaoEstadual;
        this.indicadorIE = indicadorIE;
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
        this.certificado = certificado;
        this.senha = senha;
        this.estado = estado;
        this.ambiente = ambiente;
    }

    public void cadastrar() {
        contatoDTO.setEmail(email);
        contatoDTO.setTelefone(telefone);
        contatoDTO.setTelefone2(telefone2);
        contatoDTO.setIdDDD(idDDD);

        enderecoDTO.setLogradouro(logradouro);
        enderecoDTO.setBairro(bairro);
        enderecoDTO.setCEP(cep);
        enderecoDTO.setComplemento(complemento);
        enderecoDTO.setUF(uf);
        enderecoDTO.setNumero(numero);
        enderecoDTO.setMunicipio(municipio);

        empresaDTO.setCnpj(cnpj);
        empresaDTO.setNomeFantasia(nomeFantasia);
        empresaDTO.setRazaoSocial(razaoSocial);
        empresaDTO.setRegimeTributario(regimeTributario);
        empresaDTO.setIndicadorIE(indicadorIE);
        empresaDTO.setInscricaoEstadual(inscricaoEstadual);
        empresaDTO.setIdCNAE(idCNAE);
        empresaDTO.setDataCadastro(dataCadastro);
        empresaDTO.setDataModificacao(dataModificacao);

        configuracaoDTO.setCertificado(certificado);
        configuracaoDTO.setAmbiente(ambiente);
        configuracaoDTO.setEstado(estado);
        configuracaoDTO.setSenha(senha);
        configuracaoDTO.setIdEmpresa(idEmpresa);

        if (!validador.validarCNPJ(cnpj)) {
            JOptionPane.showMessageDialog(null, "CNPJ inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Formatar o CPF
        cnpj = validador.formatarCNPJ(cnpj);

        empresaDAO.cadastrarEmpresa(enderecoDTO, empresaDTO, contatoDTO, configuracaoDTO);
    }

    public ArrayList<EmpresaDTO> listar() {
        ArrayList<EmpresaDTO> empresas = new ArrayList<>();
        EmpresaDTO empresa = empresaDAO.consultarEmpresa(cnpj);
        if (empresa != null) {
            empresas.add(empresa);
        }
        return empresas;
    }

    public void atualizar() {
        empresaDTO.setCnpj(cnpj);
        empresaDTO.setNomeFantasia(nomeFantasia);
        empresaDTO.setRazaoSocial(razaoSocial);
        empresaDTO.setRegimeTributario(regimeTributario);
        empresaDTO.setIndicadorIE(indicadorIE);
        empresaDTO.setInscricaoEstadual(inscricaoEstadual);
        empresaDTO.setIdCNAE(idCNAE);

        empresaDAO.editarEmpresa(empresaDTO);
    }

    public void excluir() {
        empresaDAO.excluirEmpresa(cnpj);
    }

    public void obterDataAtual() {
        Calendar cal = Calendar.getInstance();
        this.setDataCadastro(cal.getTime());
        this.setDataModificacao(cal.getTime());
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
     * @return the idEmpresa
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * @return the idCNAE
     */
    public int getIdCNAE() {
        return idCNAE;
    }

    /**
     * @param idCNAE the idCNAE to set
     */
    public void setIdCNAE(int idCNAE) {
        this.idCNAE = idCNAE;
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
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
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
     * @return the regimeTributario
     */
    public String getRegimeTributario() {
        return regimeTributario;
    }

    /**
     * @param regimeTributario the regimeTributario to set
     */
    public void setRegimeTributario(String regimeTributario) {
        this.regimeTributario = regimeTributario;
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
     * @return the indicadorIE
     */
    public String getIndicadorIE() {
        return indicadorIE;
    }

    /**
     * @param indicadorIE the indicadorIE to set
     */
    public void setIndicadorIE(String indicadorIE) {
        this.indicadorIE = indicadorIE;
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
     * @return the configuracoes
     */
    public Map<String, String> getConfiguracoes() {
        return configuracoes;
    }

    /**
     * @param configuracoes the configuracoes to set
     */
    public void setConfiguracoes(Map<String, String> configuracoes) {
        this.configuracoes = configuracoes;
    }

    /**
     * @return the idConfiguracao
     */
    public int getIdConfiguracao() {
        return idConfiguracao;
    }

    /**
     * @param idConfiguracao the idConfiguracao to set
     */
    public void setIdConfiguracao(int idConfiguracao) {
        this.idConfiguracao = idConfiguracao;
    }

    /**
     * @return the chaveCaminhoCertificado
     */
    public static String getChaveCaminhoCertificado() {
        return chaveCaminhoCertificado;
    }

    /**
     * @param aChaveCaminhoCertificado the chaveCaminhoCertificado to set
     */
    public static void setChaveCaminhoCertificado(String aChaveCaminhoCertificado) {
        chaveCaminhoCertificado = aChaveCaminhoCertificado;
    }

    /**
     * @return the chaveSenhaCertificado
     */
    public static String getChaveSenhaCertificado() {
        return chaveSenhaCertificado;
    }

    /**
     * @param aChaveSenhaCertificado the chaveSenhaCertificado to set
     */
    public static void setChaveSenhaCertificado(String aChaveSenhaCertificado) {
        chaveSenhaCertificado = aChaveSenhaCertificado;
    }

    /**
     * @return the chaveEstado
     */
    public static String getChaveEstado() {
        return chaveEstado;
    }

    /**
     * @param aChaveEstado the chaveEstado to set
     */
    public static void setChaveEstado(String aChaveEstado) {
        chaveEstado = aChaveEstado;
    }

    /**
     * @return the chaveAmbiente
     */
    public static String getChaveAmbiente() {
        return chaveAmbiente;
    }

    /**
     * @param aChaveAmbiente the chaveAmbiente to set
     */
    public static void setChaveAmbiente(String aChaveAmbiente) {
        chaveAmbiente = aChaveAmbiente;
    }

    /**
     * @return the certificado
     */
    public String getCertificado() {
        return certificado;
    }

    /**
     * @param certificado the certificado to set
     */
    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the ambiente
     */
    public String getAmbiente() {
        return ambiente;
    }

    /**
     * @param ambiente the ambiente to set
     */
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    /**
     * @return the descricaoCertificado
     */
    public static String getDescricaoCertificado() {
        return descricaoCertificado;
    }

    /**
     * @param aDescricaoCertificado the descricaoCertificado to set
     */
    public static void setDescricaoCertificado(String aDescricaoCertificado) {
        descricaoCertificado = aDescricaoCertificado;
    }

    /**
     * @return the descricaoSenha
     */
    public static String getDescricaoSenha() {
        return descricaoSenha;
    }

    /**
     * @param aDescricaoSenha the descricaoSenha to set
     */
    public static void setDescricaoSenha(String aDescricaoSenha) {
        descricaoSenha = aDescricaoSenha;
    }

    /**
     * @return the descricaoEstado
     */
    public static String getDescricaoEstado() {
        return descricaoEstado;
    }

    /**
     * @param aDescricaoEstado the descricaoEstado to set
     */
    public static void setDescricaoEstado(String aDescricaoEstado) {
        descricaoEstado = aDescricaoEstado;
    }

    /**
     * @return the descricacaoAmbiente
     */
    public static String getDescricacaoAmbiente() {
        return descricacaoAmbiente;
    }

    /**
     * @param aDescricacaoAmbiente the descricacaoAmbiente to set
     */
    public static void setDescricacaoAmbiente(String aDescricacaoAmbiente) {
        descricacaoAmbiente = aDescricacaoAmbiente;
    }

}

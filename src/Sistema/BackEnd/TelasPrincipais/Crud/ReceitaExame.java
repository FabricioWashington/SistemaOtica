package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.ReceitaExameDAO;
import DTO.Crud.ReceitaExameDTO;
import java.util.Date;

public class ReceitaExame {

    private ReceitaExameDAO receitaExameDAO;
    private ReceitaExameDTO receitaExameDTO;
    private int idCliente, idMedico, idExame;
    private Date dataReceita;
    private String esferaDireito, cilindroDireito, eixoDireito, dipDireito, dnpDireito,
            adicaoDireito, esferaEsquerdo, cilindroEsquerdo, eixoEsquerdo, dipEsquerdo,
            dnpEsquerdo, adicaoEsquerdo, observacoes;

    public ReceitaExame() {
        this.receitaExameDAO = new ReceitaExameDAO();
        this.receitaExameDTO = new ReceitaExameDTO();
    }

    public ReceitaExame(int idCliente, int idMedico, int idExame, Date dataReceita, String esferaDireito, String cilindroDireito, String eixoDireito, String dipDireito, String dnpDireito, String adicaoDireito, String esferaEsquerdo, String cilindroEsquerdo, String eixoEsquerdo, String dipEsquerdo, String dnpEsquerdo, String adicaoEsquerdo, String observacoes) {
        this();
        this.idCliente = idCliente;
        this.idMedico = idMedico;
        this.idExame = idExame;
        this.dataReceita = dataReceita;
        this.esferaDireito = esferaDireito;
        this.cilindroDireito = cilindroDireito;
        this.eixoDireito = eixoDireito;
        this.dipDireito = dipDireito;
        this.dnpDireito = dnpDireito;
        this.adicaoDireito = adicaoDireito;
        this.esferaEsquerdo = esferaEsquerdo;
        this.cilindroEsquerdo = cilindroEsquerdo;
        this.eixoEsquerdo = eixoEsquerdo;
        this.dipEsquerdo = dipEsquerdo;
        this.dnpEsquerdo = dnpEsquerdo;
        this.adicaoEsquerdo = adicaoEsquerdo;
        this.observacoes = observacoes;
    }

    public void cadastrar() {
        receitaExameDTO.setIdExame(idExame);
        receitaExameDTO.setIdMedico(idMedico);
        receitaExameDTO.setIdCliente(idCliente);
        receitaExameDTO.setDataReceita(dataReceita);
        receitaExameDTO.setEsferaDireito(esferaDireito);
        receitaExameDTO.setCilindroDireito(cilindroDireito);
        receitaExameDTO.setEixoDireito(eixoDireito);
        receitaExameDTO.setDipDireito(dipDireito);
        receitaExameDTO.setDnpDireito(dnpDireito);
        receitaExameDTO.setAdicaoDireito(adicaoDireito);
        receitaExameDTO.setEsferaEsquerdo(esferaEsquerdo);
        receitaExameDTO.setCilindroEsquerdo(cilindroEsquerdo);
        receitaExameDTO.setEixoEsquerdo(eixoEsquerdo);
        receitaExameDTO.setDipEsquerdo(dipEsquerdo);
        receitaExameDTO.setDnpEsquerdo(dnpEsquerdo);
        receitaExameDTO.setAdicaoEsquerdo(adicaoEsquerdo);
        receitaExameDTO.setObservacoes(observacoes);
        
        receitaExameDAO.cadastrarReceita(receitaExameDTO);

    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idMedico
     */
    public int getIdMedico() {
        return idMedico;
    }

    /**
     * @param idMedico the idMedico to set
     */
    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    /**
     * @return the idExame
     */
    public int getIdExame() {
        return idExame;
    }

    /**
     * @param idExame the idExame to set
     */
    public void setIdExame(int idExame) {
        this.idExame = idExame;
    }

    /**
     * @return the dataReceita
     */
    public Date getDataReceita() {
        return dataReceita;
    }

    /**
     * @param dataReceita the dataReceita to set
     */
    public void setDataReceita(Date dataReceita) {
        this.dataReceita = dataReceita;
    }

    /**
     * @return the esferaDireito
     */
    public String getEsferaDireito() {
        return esferaDireito;
    }

    /**
     * @param esferaDireito the esferaDireito to set
     */
    public void setEsferaDireito(String esferaDireito) {
        this.esferaDireito = esferaDireito;
    }

    /**
     * @return the cilindroDireito
     */
    public String getCilindroDireito() {
        return cilindroDireito;
    }

    /**
     * @param cilindroDireito the cilindroDireito to set
     */
    public void setCilindroDireito(String cilindroDireito) {
        this.cilindroDireito = cilindroDireito;
    }

    /**
     * @return the eixoDireito
     */
    public String getEixoDireito() {
        return eixoDireito;
    }

    /**
     * @param eixoDireito the eixoDireito to set
     */
    public void setEixoDireito(String eixoDireito) {
        this.eixoDireito = eixoDireito;
    }

    /**
     * @return the dipDireito
     */
    public String getDipDireito() {
        return dipDireito;
    }

    /**
     * @param dipDireito the dipDireito to set
     */
    public void setDipDireito(String dipDireito) {
        this.dipDireito = dipDireito;
    }

    /**
     * @return the dnpDireito
     */
    public String getDnpDireito() {
        return dnpDireito;
    }

    /**
     * @param dnpDireito the dnpDireito to set
     */
    public void setDnpDireito(String dnpDireito) {
        this.dnpDireito = dnpDireito;
    }

    /**
     * @return the adicaoDireito
     */
    public String getAdicaoDireito() {
        return adicaoDireito;
    }

    /**
     * @param adicaoDireito the adicaoDireito to set
     */
    public void setAdicaoDireito(String adicaoDireito) {
        this.adicaoDireito = adicaoDireito;
    }

    /**
     * @return the esferaEsquerdo
     */
    public String getEsferaEsquerdo() {
        return esferaEsquerdo;
    }

    /**
     * @param esferaEsquerdo the esferaEsquerdo to set
     */
    public void setEsferaEsquerdo(String esferaEsquerdo) {
        this.esferaEsquerdo = esferaEsquerdo;
    }

    /**
     * @return the cilindroEsquerdo
     */
    public String getCilindroEsquerdo() {
        return cilindroEsquerdo;
    }

    /**
     * @param cilindroEsquerdo the cilindroEsquerdo to set
     */
    public void setCilindroEsquerdo(String cilindroEsquerdo) {
        this.cilindroEsquerdo = cilindroEsquerdo;
    }

    /**
     * @return the eixoEsquerdo
     */
    public String getEixoEsquerdo() {
        return eixoEsquerdo;
    }

    /**
     * @param eixoEsquerdo the eixoEsquerdo to set
     */
    public void setEixoEsquerdo(String eixoEsquerdo) {
        this.eixoEsquerdo = eixoEsquerdo;
    }

    /**
     * @return the dipEsquerdo
     */
    public String getDipEsquerdo() {
        return dipEsquerdo;
    }

    /**
     * @param dipEsquerdo the dipEsquerdo to set
     */
    public void setDipEsquerdo(String dipEsquerdo) {
        this.dipEsquerdo = dipEsquerdo;
    }

    /**
     * @return the dnpEsquerdo
     */
    public String getDnpEsquerdo() {
        return dnpEsquerdo;
    }

    /**
     * @param dnpEsquerdo the dnpEsquerdo to set
     */
    public void setDnpEsquerdo(String dnpEsquerdo) {
        this.dnpEsquerdo = dnpEsquerdo;
    }

    /**
     * @return the adicaoEsquerdo
     */
    public String getAdicaoEsquerdo() {
        return adicaoEsquerdo;
    }

    /**
     * @param adicaoEsquerdo the adicaoEsquerdo to set
     */
    public void setAdicaoEsquerdo(String adicaoEsquerdo) {
        this.adicaoEsquerdo = adicaoEsquerdo;
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}

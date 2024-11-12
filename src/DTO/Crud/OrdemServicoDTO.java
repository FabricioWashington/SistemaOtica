package DTO.Crud;

import java.math.BigDecimal;
import java.util.Date;

public class OrdemServicoDTO {
    private int idCliente, idFuncionario, idReceita, idProduto, idMedico, idOrdemServico;
    private String tipoServico, statusServico, observacoes;
    private BigDecimal valor, valorEntrada, valorRestante;
    private Date dataEmissao, dataEntrega;

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
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the idReceita
     */
    public int getIdReceita() {
        return idReceita;
    }

    /**
     * @param idReceita the idReceita to set
     */
    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
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
     * @return the tipoServico
     */
    public String getTipoServico() {
        return tipoServico;
    }

    /**
     * @param tipoServico the tipoServico to set
     */
    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    /**
     * @return the statusServico
     */
    public String getStatusServico() {
        return statusServico;
    }

    /**
     * @param statusServico the statusServico to set
     */
    public void setStatusServico(String statusServico) {
        this.statusServico = statusServico;
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

    /**
     * @return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * @return the valorEntrada
     */
    public BigDecimal getValorEntrada() {
        return valorEntrada;
    }

    /**
     * @param valorEntrada the valorEntrada to set
     */
    public void setValorEntrada(BigDecimal valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    /**
     * @return the valorRestante
     */
    public BigDecimal getValorRestante() {
        return valorRestante;
    }

    /**
     * @param valorRestante the valorRestante to set
     */
    public void setValorRestante(BigDecimal valorRestante) {
        this.valorRestante = valorRestante;
    }

    /**
     * @return the dataEmissao
     */
    public Date getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * @return the dataEntrega
     */
    public Date getDataEntrega() {
        return dataEntrega;
    }

    /**
     * @param dataEntrega the dataEntrega to set
     */
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    /**
     * @return the idOrdemServico
     */
    public int getIdOrdemServico() {
        return idOrdemServico;
    }

    /**
     * @param idOrdemServico the idOrdemServico to set
     */
    public void setIdOrdemServico(int idOrdemServico) {
        this.idOrdemServico = idOrdemServico;
    }
    
    
}

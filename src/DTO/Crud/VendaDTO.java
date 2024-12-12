package DTO.Crud;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VendaDTO {

    private int idVenda, idFuncionario, idCliente, idPagamento, idCaixa;
    private Date data, dataVencimento;
    private BigDecimal vlrSugerido, vlrFinal, desconto, vlrRecebido, vlrRestante, totalVenda;
    private String parcela, status;
    private List<VendaItemDTO> itensVenda;

    public VendaDTO() {
        this.itensVenda = new ArrayList<>();
    }

    /**
     * @return the idVenda
     */
    public int getIdVenda() {
        return idVenda;
    }

    /**
     * @param idVenda the idVenda to set
     */
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
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
     * @return the idPagamento
     */
    public int getIdPagamento() {
        return idPagamento;
    }

    /**
     * @param idPagamento the idPagamento to set
     */
    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the dataVencimento
     */
    public Date getDataVencimento() {
        return dataVencimento;
    }

    /**
     * @param dataVencimento the dataVencimento to set
     */
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    /**
     * @return the vlrSugerido
     */
    public BigDecimal getVlrSugerido() {
        return vlrSugerido;
    }

    /**
     * @param vlrSugerido the vlrSugerido to set
     */
    public void setVlrSugerido(BigDecimal vlrSugerido) {
        this.vlrSugerido = vlrSugerido;
    }

    /**
     * @return the vlrFinal
     */
    public BigDecimal getVlrFinal() {
        return vlrFinal;
    }

    /**
     * @param vlrFinal the vlrFinal to set
     */
    public void setVlrFinal(BigDecimal vlrFinal) {
        this.vlrFinal = vlrFinal;
    }

    /**
     * @return the desconto
     */
    public BigDecimal getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the vlrRecebido
     */
    public BigDecimal getVlrRecebido() {
        return vlrRecebido;
    }

    /**
     * @param vlrRecebido the vlrRecebido to set
     */
    public void setVlrRecebido(BigDecimal vlrRecebido) {
        this.vlrRecebido = vlrRecebido;
    }

    /**
     * @return the vlrRestante
     */
    public BigDecimal getVlrRestante() {
        return vlrRestante;
    }

    /**
     * @param vlrRestante the vlrRestante to set
     */
    public void setVlrRestante(BigDecimal vlrRestante) {
        this.vlrRestante = vlrRestante;
    }

    /**
     * @return the totalVenda
     */
    public BigDecimal getTotalVenda() {
        return totalVenda;
    }

    /**
     * @param totalVenda the totalVenda to set
     */
    public void setTotalVenda(BigDecimal totalVenda) {
        this.totalVenda = totalVenda;
    }

    /**
     * @return the parcela
     */
    public String getParcela() {
        return parcela;
    }

    /**
     * @param parcela the parcela to set
     */
    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the itensVenda
     */
    public List<VendaItemDTO> getItensVenda() {
        return itensVenda;
    }

    /**
     * @param itensVenda the itensVenda to set
     */
    public void setItensVenda(List<VendaItemDTO> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public void addItemVenda(VendaItemDTO item) {
        this.itensVenda.add(item);
    }

    public void removeItemVenda(VendaItemDTO item) {
        this.itensVenda.remove(item);
    }

    /**
     * @return the idCaixa
     */
    public int getIdCaixa() {
        return idCaixa;
    }

    /**
     * @param idCaixa the idCaixa to set
     */
    public void setIdCaixa(int idCaixa) {
        this.idCaixa = idCaixa;
    }
}

package DTO.Crud;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotaFiscalDTO {

    private int idNota, idVenda, idCliente;
    private BigDecimal valorTotal;
    private String observacoes, numeroNota;
    private Date dataEmissao;
    private List<NotaDetalheDTO> detalhes;

    public NotaFiscalDTO() {
        this.detalhes = new ArrayList<>();
    }

    public NotaFiscalDTO(int idNota, int idVenda, int idCliente, BigDecimal valorTotal, String observacoes, String numeroNota, Date dataEmissao) {
        this.idNota = idNota;
        this.idVenda = idVenda;
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
        this.observacoes = observacoes;
        this.numeroNota = numeroNota;
        this.dataEmissao = dataEmissao;
    }

    /**
     * @return the idNota
     */
    public int getIdNota() {
        return idNota;
    }

    /**
     * @param idNota the idNota to set
     */
    public void setIdNota(int idNota) {
        this.idNota = idNota;
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
     * @return the valorTotal
     */
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
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
     * @return the numeroNota
     */
    public String getNumeroNota() {
        return numeroNota;
    }

    /**
     * @param numeroNota the numeroNota to set
     */
    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
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
     * @return the detalhes
     */
    public List<NotaDetalheDTO> getDetalhes() {
        return detalhes;
    }

    /**
     * @param detalhes the detalhes to set
     */
    public void setDetalhes(List<NotaDetalheDTO> detalhes) {
        this.detalhes = detalhes;
    }

    public void adicionarDetalhe(NotaDetalheDTO detalhe) {
        this.detalhes.add(detalhe);
    }
}

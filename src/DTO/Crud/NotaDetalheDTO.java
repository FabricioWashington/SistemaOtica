package DTO.Crud;

import java.math.BigDecimal;

public class NotaDetalheDTO {

    private int idNota, idProduto, quantidade;
    private BigDecimal vlrUnitario, vlrTotal;

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
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the vlrUnitario
     */
    public BigDecimal getVlrUnitario() {
        return vlrUnitario;
    }

    /**
     * @param vlrUnitario the vlrUnitario to set
     */
    public void setVlrUnitario(BigDecimal vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }

    /**
     * @return the vlrTotal
     */
    public BigDecimal getVlrTotal() {
        return vlrTotal;
    }

    /**
     * @param vlrTotal the vlrTotal to set
     */
    public void setVlrTotal(BigDecimal vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

}

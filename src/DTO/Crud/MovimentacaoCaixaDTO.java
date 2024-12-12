package DTO.Crud;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class MovimentacaoCaixaDTO {
    private int id;
    private int idVenda;
    private int idCaixa;
    private LocalDateTime dataMovimentacao;
    private String tipo; // 'entrada' ou 'saida'
    private BigDecimal valor;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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

    /**
     * @return the dataMovimentacao
     */
    public LocalDateTime getDataMovimentacao() {
        return dataMovimentacao;
    }

    /**
     * @param dataMovimentacao the dataMovimentacao to set
     */
    public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}

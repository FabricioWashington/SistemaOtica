package DTO.Crud;

import java.math.BigDecimal;
import java.util.List;

public class RelatorioCaixaDTO {

    private CaixaDTO caixa;
    private List<MovimentacaoCaixaDTO> movimentacoes;
    private BigDecimal totalEntradas;
    private BigDecimal totalSaidas;
    private BigDecimal saldoFinal;

    public CaixaDTO getCaixa() {
        return caixa;
    }

    public void setCaixa(CaixaDTO caixa) {
        this.caixa = caixa;
    }

    public List<MovimentacaoCaixaDTO> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<MovimentacaoCaixaDTO> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public BigDecimal getTotalEntradas() {
        return totalEntradas;
    }

    public void setTotalEntradas(BigDecimal totalEntradas) {
        this.totalEntradas = totalEntradas;
    }

    public BigDecimal getTotalSaidas() {
        return totalSaidas;
    }

    public void setTotalSaidas(BigDecimal totalSaidas) {
        this.totalSaidas = totalSaidas;
    }

    public BigDecimal getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(BigDecimal saldoFinal) {
        this.saldoFinal = saldoFinal;
    }
}

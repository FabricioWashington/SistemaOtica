package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.CaixaDAO;
import DTO.Crud.CaixaDTO;
import DTO.Crud.MovimentacaoCaixaDTO;
import DTO.Crud.RelatorioCaixaDTO;
import DTO.Crud.VendaDTO;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class Caixa {

    private CaixaDAO caixaDAO = new CaixaDAO();

    // ========================= CRUD PARA CAIXA =========================
    
    // Abrir Caixa
    public void abrirCaixa(BigDecimal saldoInicial, String operador) throws SQLException {
        CaixaDTO caixa = new CaixaDTO();
        caixa.setDataAbertura(LocalDateTime.now());
        caixa.setSaldoInicial(saldoInicial);
        caixa.setOperador(operador); // Define o operador

        caixaDAO.abrirCaixa(caixa);
    }

    // Fechar Caixa
    public void fecharCaixa() throws SQLException {
        CaixaDTO caixaAberto = caixaDAO.listarCaixas().stream()
                .filter(c -> "aberto".equals(c.getStatus()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Não há caixa aberto."));

        // Calcula o saldo final com base nas movimentações
        List<MovimentacaoCaixaDTO> movimentacoes = caixaDAO.listarMovimentacoes(caixaAberto.getId());
        BigDecimal saldoFinal = caixaAberto.getSaldoInicial();

        for (MovimentacaoCaixaDTO mov : movimentacoes) {
            if ("entrada".equals(mov.getTipo())) {
                saldoFinal = saldoFinal.add(mov.getValor());
            } else if ("saida".equals(mov.getTipo())) {
                saldoFinal = saldoFinal.subtract(mov.getValor());
            }
        }

        caixaAberto.setSaldoFinal(saldoFinal);
        caixaAberto.setDataFechamento(LocalDateTime.now());
        caixaDAO.fecharCaixa(caixaAberto);
    }

    // Deletar Caixa
    public void deletarCaixa(int idCaixa) throws SQLException {
        caixaDAO.deletarCaixa(idCaixa);
    }

    // Listar Caixas
    public List<CaixaDTO> listarCaixas() throws SQLException {
        return caixaDAO.listarCaixas();
    }

    // ========================= CRUD PARA MOVIMENTAÇÕES =========================
    // Registrar Movimentação
    public void registrarMovimentacao(MovimentacaoCaixaDTO movimentacao) throws SQLException {
        caixaDAO.registrarMovimentacao(movimentacao);
    }

    // Atualizar Movimentação
    public void atualizarMovimentacao(MovimentacaoCaixaDTO movimentacao) throws SQLException {
        caixaDAO.atualizarMovimentacao(movimentacao);
    }

    // Deletar Movimentação
    public void deletarMovimentacao(int idMovimentacao) throws SQLException {
        caixaDAO.deletarMovimentacao(idMovimentacao);
    }

    // Listar Movimentações
    public List<MovimentacaoCaixaDTO> listarMovimentacoes(int idCaixa) throws SQLException {
        return caixaDAO.listarMovimentacoes(idCaixa);
    }

    // ========================= FUNCIONALIDADES AVANÇADAS =========================
    // Registrar Venda Automaticamente no Caixa
    public void registrarVenda(VendaDTO venda) throws SQLException {
        CaixaDTO caixaAberto = caixaDAO.listarCaixas().stream()
                .filter(c -> "aberto".equals(c.getStatus()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Não há caixa aberto."));

        // Registrar venda como movimentação de entrada
        MovimentacaoCaixaDTO movimentacao = new MovimentacaoCaixaDTO();
        movimentacao.setIdCaixa(caixaAberto.getId());
        movimentacao.setDataMovimentacao(LocalDateTime.now());
        movimentacao.setTipo("entrada");
        movimentacao.setIdVenda(venda.getIdVenda());
        movimentacao.setValor(venda.getTotalVenda());

        caixaDAO.registrarMovimentacao(movimentacao);
    }

    // Garantir Fechamento Automático ao Iniciar o Sistema
    public void verificarEstadoDoCaixa() throws SQLException {
        List<CaixaDTO> caixas = caixaDAO.listarCaixas();

        for (CaixaDTO caixa : caixas) {
            if ("aberto".equals(caixa.getStatus())) {
                System.out.println("Caixa aberto detectado! Fechando automaticamente...");
                fecharCaixa();
            }
        }
    }

    // Relatório do Caixa
    public RelatorioCaixaDTO gerarRelatorioDoCaixa(int idCaixa) throws SQLException {
        CaixaDTO caixa = caixaDAO.listarCaixas().stream()
                .filter(c -> c.getId() == idCaixa)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Caixa não encontrado."));

        List<MovimentacaoCaixaDTO> movimentacoes = caixaDAO.listarMovimentacoes(idCaixa);

        RelatorioCaixaDTO relatorio = new RelatorioCaixaDTO();
        relatorio.setCaixa(caixa);
        relatorio.setMovimentacoes(movimentacoes);

        BigDecimal totalEntradas = BigDecimal.ZERO;
        BigDecimal totalSaidas = BigDecimal.ZERO;

        for (MovimentacaoCaixaDTO mov : movimentacoes) {
            if ("entrada".equals(mov.getTipo())) {
                totalEntradas = totalEntradas.add(mov.getValor());
            } else if ("saida".equals(mov.getTipo())) {
                totalSaidas = totalSaidas.add(mov.getValor());
            }
        }

        relatorio.setTotalEntradas(totalEntradas);
        relatorio.setTotalSaidas(totalSaidas);
        relatorio.setSaldoFinal(caixa.getSaldoInicial().add(totalEntradas).subtract(totalSaidas));

        return relatorio;
    }
}

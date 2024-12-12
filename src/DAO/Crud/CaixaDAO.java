package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.CaixaDTO;
import DTO.Crud.MovimentacaoCaixaDTO;
import DTO.Crud.RelatorioCaixaDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CaixaDAO {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    // ========================= CRUD PARA CAIXA =========================
    // ABRIR CAIXA
    public void abrirCaixa(CaixaDTO caixa) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "INSERT INTO caixa (data_abertura, saldo_inicial, status) VALUES (?, ?, 'aberto')";
            pstm = conn.prepareStatement(sql);
            pstm.setTimestamp(1, Timestamp.valueOf(caixa.getDataAbertura()));
            pstm.setBigDecimal(2, caixa.getSaldoInicial());
            pstm.executeUpdate();
            conn.commit();

            JOptionPane.showMessageDialog(null, "O caixa foi aberto com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir caixa", "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            fecharConexao();
        }
    }

    // FECHAR CAIXA
    public void fecharCaixa(CaixaDTO caixa) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "UPDATE caixa SET data_fechamento = ?, saldo_final = ?, status = 'fechado' WHERE id_caixa = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setTimestamp(1, Timestamp.valueOf(caixa.getDataFechamento()));
            pstm.setBigDecimal(2, caixa.getSaldoFinal());
            pstm.setInt(3, caixa.getId());
            pstm.executeUpdate();
            conn.commit();

            JOptionPane.showMessageDialog(null, "O caixa foi fechado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar caixa", "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            fecharConexao();
        }
    }

    // DELETAR CAIXA
    public void deletarCaixa(int idCaixa) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "DELETE FROM caixa WHERE id_caixa = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idCaixa);
            pstm.executeUpdate();
            conn.commit();

            JOptionPane.showMessageDialog(null, "O caixa foi deletado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar caixa", "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            fecharConexao();
        }
    }

    // LISTAR CAIXAS
    public List<CaixaDTO> listarCaixas() {
        List<CaixaDTO> caixas = new ArrayList<>();
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "SELECT * FROM caixa";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                CaixaDTO caixa = new CaixaDTO();
                caixa.setId(rs.getInt("id_caixa"));
                caixa.setDataAbertura(rs.getTimestamp("data_abertura").toLocalDateTime());
                caixa.setDataFechamento(rs.getTimestamp("data_fechamento") != null ? rs.getTimestamp("data_fechamento").toLocalDateTime() : null);
                caixa.setSaldoInicial(rs.getBigDecimal("saldo_inicial"));
                caixa.setSaldoFinal(rs.getBigDecimal("saldo_final"));
                caixa.setStatus(rs.getString("status"));
                caixas.add(caixa);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar caixas", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            fecharConexao();
        }

        return caixas;
    }

    // ========================= CRUD PARA MOVIMENTAÇÕES =========================
    // REGISTRAR MOVIMENTAÇÃO
    public void registrarMovimentacao(MovimentacaoCaixaDTO movimentacao) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "INSERT INTO movimentacoes_caixa (id_caixa, data_movimentacao, tipo, valor, idVenda) VALUES (?, ?, ?, ?, ?)";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, movimentacao.getIdCaixa());
            pstm.setTimestamp(2, Timestamp.valueOf(movimentacao.getDataMovimentacao()));
            pstm.setString(3, movimentacao.getTipo());
            pstm.setInt(4, movimentacao.getIdVenda());
            pstm.setBigDecimal(5, movimentacao.getValor());
            pstm.executeUpdate();
            conn.commit();

            JOptionPane.showMessageDialog(null, "A movimentação foi registrada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar movimentação", "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            fecharConexao();
        }
    }

    // LISTAR MOVIMENTAÇÕES
    public List<MovimentacaoCaixaDTO> listarMovimentacoes(int idCaixa) {
        List<MovimentacaoCaixaDTO> movimentacoes = new ArrayList<>();
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "SELECT * FROM movimentacoes_caixa WHERE id_caixa = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idCaixa);
            rs = pstm.executeQuery();

            while (rs.next()) {
                MovimentacaoCaixaDTO movimentacao = new MovimentacaoCaixaDTO();
                movimentacao.setId(rs.getInt("id_movimentacao"));
                movimentacao.setIdCaixa(rs.getInt("id_caixa"));
                movimentacao.setDataMovimentacao(rs.getTimestamp("data_movimentacao").toLocalDateTime());
                movimentacao.setTipo(rs.getString("tipo"));
                movimentacao.setValor(rs.getBigDecimal("valor"));
                movimentacao.setIdVenda(rs.getInt("idVenda"));
                movimentacoes.add(movimentacao);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar movimentações", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            fecharConexao();
        }

        return movimentacoes;
    }

    // ATUALIZAR MOVIMENTAÇÃO
    public void atualizarMovimentacao(MovimentacaoCaixaDTO movimentacao) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "UPDATE movimentacoes_caixa SET data_movimentacao = ?, tipo = ?, valor = ?, idVenda = ? WHERE id_movimentacao = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setTimestamp(1, Timestamp.valueOf(movimentacao.getDataMovimentacao()));
            pstm.setString(2, movimentacao.getTipo());
            pstm.setInt(3, movimentacao.getIdVenda());
            pstm.setBigDecimal(4, movimentacao.getValor());
            pstm.setInt(5, movimentacao.getId());
            pstm.executeUpdate();
            conn.commit();

            JOptionPane.showMessageDialog(null, "A movimentação foi atualizada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar movimentação", "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            fecharConexao();
        }
    }

    // DELETAR MOVIMENTAÇÃO
    public void deletarMovimentacao(int idMovimentacao) {
        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "DELETE FROM movimentacoes_caixa WHERE id_movimentacao = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idMovimentacao);
            pstm.executeUpdate();
            conn.commit();

            JOptionPane.showMessageDialog(null, "A movimentação foi deletada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar movimentação", "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            fecharConexao();
        }
    }

    // ========================= RELATÓRIO DO CAIXA =========================
    public RelatorioCaixaDTO gerarRelatorio(int idCaixa) throws SQLException {
        conn = new ConexaoDAO().conectaBD();
        RelatorioCaixaDTO relatorio = new RelatorioCaixaDTO();

        // Consulta o caixa
        String sqlCaixa = "SELECT * FROM caixa WHERE id_caixa = ?";
        PreparedStatement stmtCaixa = conn.prepareStatement(sqlCaixa);
        stmtCaixa.setInt(1, idCaixa);
        ResultSet rsCaixa = stmtCaixa.executeQuery();

        if (rsCaixa.next()) {
            CaixaDTO caixa = new CaixaDTO();
            caixa.setId(rsCaixa.getInt("id_caixa"));
            caixa.setDataAbertura(rsCaixa.getTimestamp("data_abertura").toLocalDateTime());
            caixa.setDataFechamento(rsCaixa.getTimestamp("data_fechamento") != null
                    ? rsCaixa.getTimestamp("data_fechamento").toLocalDateTime()
                    : null);
            caixa.setSaldoInicial(rsCaixa.getBigDecimal("saldo_inicial"));
            caixa.setSaldoFinal(rsCaixa.getBigDecimal("saldo_final"));
            caixa.setStatus(rsCaixa.getString("status"));
            relatorio.setCaixa(caixa);
        }

        // Consulta as movimentações
        String sqlMovimentacoes = "SELECT * FROM movimentacoes_caixa WHERE id_caixa = ?";
        PreparedStatement stmtMov = conn.prepareStatement(sqlMovimentacoes);
        stmtMov.setInt(1, idCaixa);
        ResultSet rsMov = stmtMov.executeQuery();

        List<MovimentacaoCaixaDTO> movimentacoes = new ArrayList<>();
        BigDecimal totalEntradas = BigDecimal.ZERO;
        BigDecimal totalSaidas = BigDecimal.ZERO;

        while (rsMov.next()) {
            MovimentacaoCaixaDTO mov = new MovimentacaoCaixaDTO();
            mov.setId(rsMov.getInt("id_movimentacao"));
            mov.setIdCaixa(rsMov.getInt("id_caixa"));
            mov.setDataMovimentacao(rsMov.getTimestamp("data_movimentacao").toLocalDateTime());
            mov.setTipo(rsMov.getString("tipo"));
            mov.setIdVenda(rsMov.getInt("idVenda")); // Substituído 'descricao' por 'idVenda'
            mov.setValor(rsMov.getBigDecimal("valor"));

            if ("entrada".equals(mov.getTipo())) {
                totalEntradas = totalEntradas.add(mov.getValor());
            } else if ("saida".equals(mov.getTipo())) {
                totalSaidas = totalSaidas.add(mov.getValor());
            }

            movimentacoes.add(mov);
        }

        relatorio.setMovimentacoes(movimentacoes);
        relatorio.setTotalEntradas(totalEntradas);
        relatorio.setTotalSaidas(totalSaidas);

        BigDecimal saldoFinal = relatorio.getCaixa().getSaldoInicial()
                .add(totalEntradas)
                .subtract(totalSaidas);

        relatorio.setSaldoFinal(saldoFinal);

        conn.close();
        return relatorio;
    }

    // ========================= MÉTODOS AUXILIARES =========================
    private void fecharConexao() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

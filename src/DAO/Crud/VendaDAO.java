package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.VendaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class VendaDAO {

    private Connection conn;
    private String sqlCadastro;
    private PreparedStatement pstmCadastro;
    private VendaDTO vendaDTO;

    public void cadastrarVenda(VendaDTO vendaDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            sqlCadastro = "insert into venda (idFuncionario, idCliente, idPagamento, data, vlrSugerido, desconto, totalVenda, parcela, vencimento, status, recebeu, restante, vlrFinal) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setInt(1, vendaDTO.getIdFuncionario());
            pstmCadastro.setInt(2, vendaDTO.getIdCliente());
            pstmCadastro.setInt(3, vendaDTO.getIdPagamento());
            pstmCadastro.setDate(4, new java.sql.Date(vendaDTO.getData().getTime()));
            pstmCadastro.setBigDecimal(5, vendaDTO.getVlrSugerido());
            pstmCadastro.setBigDecimal(6, vendaDTO.getDesconto());
            pstmCadastro.setBigDecimal(7, vendaDTO.getTotalVenda());
            pstmCadastro.setString(8, vendaDTO.getParcela());
            pstmCadastro.setDate(9, new java.sql.Date(vendaDTO.getDataVencimento().getTime()));
            pstmCadastro.setString(10, vendaDTO.getStatus());
            pstmCadastro.setBigDecimal(11, vendaDTO.getVlrRecebido());
            pstmCadastro.setBigDecimal(12, vendaDTO.getVlrRestante());
            pstmCadastro.setBigDecimal(13, vendaDTO.getVlrFinal());

            pstmCadastro.execute();
            conn.commit();
            JOptionPane.showMessageDialog(null, "A venda foi cadastrada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Essa venda já foi cadastrada no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showInputDialog(e);
            try {
                conn.rollback(); // Em caso de erro, faz rollback para desfazer as alterações
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true); // Restaura o modo de commit automático
                conn.close(); // Fecha a conexão
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<VendaDTO> listarVendas() {
        conn = new ConexaoDAO().conectaBD();
        ArrayList<VendaDTO> listaVendas = new ArrayList<>();
        String sql = "SELECT * FROM venda";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                VendaDTO venda = new VendaDTO();
                venda.setIdVenda(rs.getInt("idVenda"));
                venda.setIdFuncionario(rs.getInt("idFuncionario"));
                venda.setIdCliente(rs.getInt("idCliente"));
                venda.setIdPagamento(rs.getInt("idPagamento"));
                venda.setData(rs.getDate("data"));
                venda.setVlrSugerido(rs.getBigDecimal("vlrSugerido"));
                venda.setDesconto(rs.getBigDecimal("desconto"));
                venda.setTotalVenda(rs.getBigDecimal("totalVenda"));
                venda.setParcela(rs.getString("parcela"));
                venda.setDataVencimento(rs.getDate("vencimento"));
                venda.setStatus(rs.getString("status"));
                venda.setVlrRecebido(rs.getBigDecimal("recebeu"));
                venda.setVlrRestante(rs.getBigDecimal("restante"));
                venda.setVlrFinal(rs.getBigDecimal("vlrFinal"));
                listaVendas.add(venda);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar vendas: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaVendas;
    }

    public void atualizarVenda(VendaDTO vendaDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "UPDATE venda SET idFuncionario = ?, idCliente = ?, idPagamento = ?, data = ?, vlrSugerido = ?, desconto = ?, totalVenda = ?, parcela = ?, vencimento = ?, status = ?, recebeu = ?, restante = ?, vlrFinal = ? WHERE idVenda = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, vendaDTO.getIdFuncionario());
            pstm.setInt(2, vendaDTO.getIdCliente());
            pstm.setInt(3, vendaDTO.getIdPagamento());
            pstm.setDate(4, new java.sql.Date(vendaDTO.getData().getTime()));
            pstm.setBigDecimal(5, vendaDTO.getVlrSugerido());
            pstm.setBigDecimal(6, vendaDTO.getDesconto());
            pstm.setBigDecimal(7, vendaDTO.getTotalVenda());
            pstm.setString(8, vendaDTO.getParcela());
            pstm.setDate(9, new java.sql.Date(vendaDTO.getDataVencimento().getTime()));
            pstm.setString(10, vendaDTO.getStatus());
            pstm.setBigDecimal(11, vendaDTO.getVlrRecebido());
            pstm.setBigDecimal(12, vendaDTO.getVlrRestante());
            pstm.setBigDecimal(13, vendaDTO.getVlrFinal());
            pstm.setInt(14, vendaDTO.getIdVenda());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Venda atualizada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma venda foi atualizada. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar venda: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void excluirVenda(int idVenda) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "DELETE FROM venda WHERE idVenda = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idVenda);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Venda excluída com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma venda foi excluída. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir venda: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.LentesDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LentesDAO {

    Connection conn;
    PreparedStatement pstmCadastro;
    ResultSet rs;
    PreparedStatement pstm;

    public void cadastrarLente(LentesDTO lenteDTO) {
        conn = new ConexaoDAO().conectaBD();
        try {
            conn.setAutoCommit(false);

            String sqlCadastro = "INSERT INTO lentes (idProduto, idTipo_Lente, idMaterial, idTratamento, indice_refracao, preco_custo, preco_venda, quantidade, grau, eixo) VALUES (?,?,?,?,?,?,?,?,?,?)";
            pstmCadastro = conn.prepareStatement(sqlCadastro);

            pstmCadastro.setInt(1, lenteDTO.getIdProduto());
            pstmCadastro.setInt(2, lenteDTO.getIdTipoLente());
            pstmCadastro.setInt(3, lenteDTO.getIdMaterial());
            pstmCadastro.setInt(4, lenteDTO.getIdTratamento());
            pstmCadastro.setBigDecimal(5, lenteDTO.getIndiceRefracao());
            pstmCadastro.setBigDecimal(6, lenteDTO.getPrecoCusto());
            pstmCadastro.setBigDecimal(7, lenteDTO.getPrecoVenda());
            pstmCadastro.setInt(8, lenteDTO.getQuantidade());
            pstmCadastro.setBigDecimal(9, lenteDTO.getGrau());
            pstmCadastro.setInt(10, lenteDTO.getEixo());

            pstmCadastro.execute();
            conn.commit();

            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Esse exame já foi cadastrado no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public void cadastrarLenteContato(LentesDTO lenteDTO) {
        conn = new ConexaoDAO().conectaBD();
        try {
            conn.setAutoCommit(false);

            String sqlCadastro = "INSERT INTO lentes_contato (idProduto, idTipo_Lente, idMaterial, idTratamento, curva_base, diametro, preco_custo, preco_venda, quantidade, grau) VALUES (?,?,?,?,?,?,?,?,?,?)";
            pstmCadastro = conn.prepareStatement(sqlCadastro);

            pstmCadastro.setInt(1, lenteDTO.getIdProduto());
            pstmCadastro.setInt(2, lenteDTO.getIdTipoLente());
            pstmCadastro.setInt(3, lenteDTO.getIdMaterial());
            pstmCadastro.setInt(4, lenteDTO.getIdTratamento());
            pstmCadastro.setBigDecimal(5, lenteDTO.getCurvaBase());
            pstmCadastro.setBigDecimal(6, lenteDTO.getDiametro());
            pstmCadastro.setBigDecimal(7, lenteDTO.getPrecoCusto());
            pstmCadastro.setBigDecimal(8, lenteDTO.getPrecoVenda());
            pstmCadastro.setInt(9, lenteDTO.getQuantidade());
            pstmCadastro.setBigDecimal(10, lenteDTO.getGrau());

            pstmCadastro.execute();
            conn.commit();
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Esse exame já foi cadastrado no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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
  // Listar lentes
    public ArrayList<LentesDTO> listarLentes() {
        ArrayList<LentesDTO> lista = new ArrayList<>();
        conn = new ConexaoDAO().conectaBD();

        String sql = "SELECT * FROM lentes";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                LentesDTO lente = new LentesDTO();
                lente.setIdProduto(rs.getInt("idProduto"));
                lente.setIdTipoLente(rs.getInt("idTipo_Lente"));
                lente.setIdMaterial(rs.getInt("idMaterial"));
                lente.setIdTratamento(rs.getInt("idTratamento"));
                lente.setIndiceRefracao(rs.getBigDecimal("indice_refracao"));
                lente.setPrecoCusto(rs.getBigDecimal("preco_custo"));
                lente.setPrecoVenda(rs.getBigDecimal("preco_venda"));
                lente.setQuantidade(rs.getInt("quantidade"));
                lente.setGrau(rs.getBigDecimal("grau"));
                lente.setEixo(rs.getInt("eixo"));

                lista.add(lente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar lentes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            fecharConexao();
        }
        return lista;
    }

    // Listar lentes de contato
    public ArrayList<LentesDTO> listarLentesContato() {
        ArrayList<LentesDTO> lista = new ArrayList<>();
        conn = new ConexaoDAO().conectaBD();

        String sql = "SELECT * FROM lentes_contato";

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                LentesDTO lente = new LentesDTO();
                lente.setIdProduto(rs.getInt("idProduto"));
                lente.setIdTipoLente(rs.getInt("idTipo_Lente"));
                lente.setIdMaterial(rs.getInt("idMaterial"));
                lente.setIdTratamento(rs.getInt("idTratamento"));
                lente.setCurvaBase(rs.getBigDecimal("curva_base"));
                lente.setDiametro(rs.getBigDecimal("diametro"));
                lente.setPrecoCusto(rs.getBigDecimal("preco_custo"));
                lente.setPrecoVenda(rs.getBigDecimal("preco_venda"));
                lente.setQuantidade(rs.getInt("quantidade"));
                lente.setGrau(rs.getBigDecimal("grau"));

                lista.add(lente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar lentes de contato: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            fecharConexao();
        }
        return lista;
    }

    // Atualizar lente
    public void atualizarLente(LentesDTO lenteDTO) {
        conn = new ConexaoDAO().conectaBD();

        String sql = "UPDATE lentes SET idTipo_Lente = ?, idMaterial = ?, idTratamento = ?, indice_refracao = ?, preco_custo = ?, preco_venda = ?, quantidade = ?, grau = ?, eixo = ? WHERE idProduto = ?";

        try {
            conn.setAutoCommit(false);
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, lenteDTO.getIdTipoLente());
            pstm.setInt(2, lenteDTO.getIdMaterial());
            pstm.setInt(3, lenteDTO.getIdTratamento());
            pstm.setBigDecimal(4, lenteDTO.getIndiceRefracao());
            pstm.setBigDecimal(5, lenteDTO.getPrecoCusto());
            pstm.setBigDecimal(6, lenteDTO.getPrecoVenda());
            pstm.setInt(7, lenteDTO.getQuantidade());
            pstm.setBigDecimal(8, lenteDTO.getGrau());
            pstm.setInt(9, lenteDTO.getEixo());
            pstm.setInt(10, lenteDTO.getIdProduto());

            pstm.executeUpdate();
            conn.commit();
            JOptionPane.showMessageDialog(null, "Lente atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar lente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            fecharConexao();
        }
    }

    // Atualizar lente de contato
    public void atualizarLenteContato(LentesDTO lenteDTO) {
        conn = new ConexaoDAO().conectaBD();

        String sql = "UPDATE lentes_contato SET idTipo_Lente = ?, idMaterial = ?, idTratamento = ?, curva_base = ?, diametro = ?, preco_custo = ?, preco_venda = ?, quantidade = ?, grau = ? WHERE idProduto = ?";

        try {
            conn.setAutoCommit(false);
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, lenteDTO.getIdTipoLente());
            pstm.setInt(2, lenteDTO.getIdMaterial());
            pstm.setInt(3, lenteDTO.getIdTratamento());
            pstm.setBigDecimal(4, lenteDTO.getCurvaBase());
            pstm.setBigDecimal(5, lenteDTO.getDiametro());
            pstm.setBigDecimal(6, lenteDTO.getPrecoCusto());
            pstm.setBigDecimal(7, lenteDTO.getPrecoVenda());
            pstm.setInt(8, lenteDTO.getQuantidade());
            pstm.setBigDecimal(9, lenteDTO.getGrau());
            pstm.setInt(10, lenteDTO.getIdProduto());

            pstm.executeUpdate();
            conn.commit();
            JOptionPane.showMessageDialog(null, "Lente de contato atualizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar lente de contato: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            fecharConexao();
        }
    }
    
     // Método para excluir lente
    public void excluirLente(int idProduto) {
        conn = new ConexaoDAO().conectaBD();

        String sql = "DELETE FROM lentes WHERE idProduto = ?";

        try {
            conn.setAutoCommit(false);
            pstmCadastro = conn.prepareStatement(sql);
            pstmCadastro.setInt(1, idProduto);

            int rowsDeleted = pstmCadastro.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Lente excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                conn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma lente encontrada para exclusão.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir lente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            fecharConexao();
        }
    }

    // Método para excluir lente de contato
    public void excluirLenteContato(int idProduto) {
        conn = new ConexaoDAO().conectaBD();

        String sql = "DELETE FROM lentes_contato WHERE idProduto = ?";

        try {
            conn.setAutoCommit(false);
            pstmCadastro = conn.prepareStatement(sql);
            pstmCadastro.setInt(1, idProduto);

            int rowsDeleted = pstmCadastro.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Lente de contato excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                conn.commit();
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma lente de contato encontrada para exclusão.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir lente de contato: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            fecharConexao();
        }
    }

    // Método auxiliar para fechar a conexão
    private void fecharConexao() {
        try {
            conn.setAutoCommit(true);
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

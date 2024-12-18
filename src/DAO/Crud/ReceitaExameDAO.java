package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.ReceitaExameDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ReceitaExameDAO {

    Connection conn;
    PreparedStatement pstmCadastro;
    ResultSet rs;

    public void cadastrarReceita(ReceitaExameDTO receitaExameDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            String sqlCadastro = "insert into receita_exame (idExame, id_Optometrista, id_Cliente,"
                    + " data_receita, esfera_direito, cilindro_direito, eixo_direito, dip_direito, dnp_direito, "
                    + "adicao_direito, esfera_esquerdo, cilindro_esquerdo, eixo_esquerdo, dip_esquerdo, dnp_esquerdo, "
                    + "adicao_esquerdo, observacoes) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setInt(1, receitaExameDTO.getIdExame());
            pstmCadastro.setInt(2, receitaExameDTO.getIdMedico());
            pstmCadastro.setInt(3, receitaExameDTO.getIdCliente());
            pstmCadastro.setDate(4, new java.sql.Date(receitaExameDTO.getDataReceita().getTime()));
            pstmCadastro.setString(5, receitaExameDTO.getEsferaDireito());
            pstmCadastro.setString(6, receitaExameDTO.getCilindroDireito());
            pstmCadastro.setString(7, receitaExameDTO.getEixoDireito());
            pstmCadastro.setString(8, receitaExameDTO.getDipDireito());
            pstmCadastro.setString(9, receitaExameDTO.getDnpDireito());
            pstmCadastro.setString(10, receitaExameDTO.getAdicaoDireito());
            pstmCadastro.setString(11, receitaExameDTO.getEsferaEsquerdo());
            pstmCadastro.setString(12, receitaExameDTO.getCilindroEsquerdo());
            pstmCadastro.setString(13, receitaExameDTO.getEixoEsquerdo());
            pstmCadastro.setString(14, receitaExameDTO.getDipEsquerdo());
            pstmCadastro.setString(15, receitaExameDTO.getDnpEsquerdo());
            pstmCadastro.setString(16, receitaExameDTO.getAdicaoEsquerdo());
            pstmCadastro.setString(17, receitaExameDTO.getObservacoes());

            pstmCadastro.execute();
            conn.commit();
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Essa Receita já foi cadastrada no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public ArrayList<ReceitaExameDTO> listarReceitas() {
        conn = new ConexaoDAO().conectaBD();
        ArrayList<ReceitaExameDTO> listaReceitas = new ArrayList<>();
        String sql = "SELECT * FROM receita_exame";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                ReceitaExameDTO receita = new ReceitaExameDTO();
                receita.setIdExame(rs.getInt("idExame"));
                receita.setIdMedico(rs.getInt("id_Optometrista"));
                receita.setIdCliente(rs.getInt("id_Cliente"));
                receita.setDataReceita(rs.getDate("data_receita"));
                receita.setEsferaDireito(rs.getString("esfera_direito"));
                receita.setCilindroDireito(rs.getString("cilindro_direito"));
                receita.setEixoDireito(rs.getString("eixo_direito"));
                receita.setDipDireito(rs.getString("dip_direito"));
                receita.setDnpDireito(rs.getString("dnp_direito"));
                receita.setAdicaoDireito(rs.getString("adicao_direito"));
                receita.setEsferaEsquerdo(rs.getString("esfera_esquerdo"));
                receita.setCilindroEsquerdo(rs.getString("cilindro_esquerdo"));
                receita.setEixoEsquerdo(rs.getString("eixo_esquerdo"));
                receita.setDipEsquerdo(rs.getString("dip_esquerdo"));
                receita.setDnpEsquerdo(rs.getString("dnp_esquerdo"));
                receita.setAdicaoEsquerdo(rs.getString("adicao_esquerdo"));
                receita.setObservacoes(rs.getString("observacoes"));
                listaReceitas.add(receita);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar receitas: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaReceitas;
    }

    public void excluirReceita(int idReceita) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "DELETE FROM receita_exame WHERE idReceita = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idReceita);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Receita excluída com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma receita foi excluída. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir receita: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void atualizarReceita(ReceitaExameDTO receitaExameDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "UPDATE receita_exame SET id_Optometrista = ?, id_Cliente = ?, idExame = ?, data_receita = ?, "
                + "esfera_direito = ?, cilindro_direito = ?, eixo_direito = ?, dip_direito = ?, dnp_direito = ?, "
                + "adicao_direito = ?, esfera_esquerdo = ?, cilindro_esquerdo = ?, eixo_esquerdo = ?, dip_esquerdo = ?, "
                + "dnp_esquerdo = ?, adicao_esquerdo = ?, observacoes = ? WHERE idReceita = ?";

        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, receitaExameDTO.getIdMedico());
            pstm.setInt(2, receitaExameDTO.getIdCliente());
            pstm.setInt(3, receitaExameDTO.getIdExame());
            pstm.setDate(4, new java.sql.Date(receitaExameDTO.getDataReceita().getTime()));
            pstm.setString(5, receitaExameDTO.getEsferaDireito());
            pstm.setString(6, receitaExameDTO.getCilindroDireito());
            pstm.setString(7, receitaExameDTO.getEixoDireito());
            pstm.setString(8, receitaExameDTO.getDipDireito());
            pstm.setString(9, receitaExameDTO.getDnpDireito());
            pstm.setString(10, receitaExameDTO.getAdicaoDireito());
            pstm.setString(11, receitaExameDTO.getEsferaEsquerdo());
            pstm.setString(12, receitaExameDTO.getCilindroEsquerdo());
            pstm.setString(13, receitaExameDTO.getEixoEsquerdo());
            pstm.setString(14, receitaExameDTO.getDipEsquerdo());
            pstm.setString(15, receitaExameDTO.getDnpEsquerdo());
            pstm.setString(16, receitaExameDTO.getAdicaoEsquerdo());
            pstm.setString(17, receitaExameDTO.getObservacoes());
            pstm.setInt(18, receitaExameDTO.getIdReceita());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Receita atualizada com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma receita foi atualizada. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar receita: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

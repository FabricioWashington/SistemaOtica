package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.LentesDTO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LentesDAO {

    Connection conn;
    PreparedStatement pstmCadastro;
    ResultSet rs;

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

}

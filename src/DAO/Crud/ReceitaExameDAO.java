package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.ReceitaExameDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

}

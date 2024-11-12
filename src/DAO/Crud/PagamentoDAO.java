
package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.PagamentoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class PagamentoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;


public void cadastrarPagamento(PagamentoDTO cadastroPagamento){
    conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false); // Desliga o modo de commit automático

            // Registrar o cadastro
            String sqlCadastro = "insert into tipo_pagamento (Tipo_Pagamento) values (?)";
            PreparedStatement pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setString(1, cadastroPagamento.getTipoPagamento());

            pstmCadastro.execute();
            conn.commit(); // Efetua o commit das transações

            // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse tipo de pagamento já foi cadastrado no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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
   public ResultSet listarIdPagamento(PagamentoDTO pagamentoDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "SELECT * FROM tipo_pagamento ORDER BY Tipo_Pagamento";
        try {

            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}



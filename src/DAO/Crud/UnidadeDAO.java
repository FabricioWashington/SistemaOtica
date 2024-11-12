package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.UnidadeDTO;
import DTO.Login.LoginDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UnidadeDAO {
    
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<LoginDTO> lista = new ArrayList<>();
    
    public void cadastrarUnidade(UnidadeDTO cadastroUnidadeDTO){
        
    
     conn = new ConexaoDAO().conectaBD(); 
      
        try {
            conn.setAutoCommit(false);
            
            //Registrar o cadastro
            String sqlCadastro = "insert into unidade (descricao) values (?)";
            PreparedStatement pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setString(1, cadastroUnidadeDTO.getDescricao());
            
            pstmCadastro.execute();
            conn.commit();
            
          // Exibir mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Essa unidade ja foi cadastrada no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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

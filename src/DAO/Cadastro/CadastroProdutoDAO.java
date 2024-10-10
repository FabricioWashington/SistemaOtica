package DAO.Cadastro;

import DAO.Conexao.ConexaoDAO;
import DTO.Cadastro.CadastroProdutoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class CadastroProdutoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    public void cadastrarProduto(CadastroProdutoDTO cadastroProdutoDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            String sqlCadastro = "insert into produto (Nome_Produto, idUnidade, idCategoria, Preco, data, Imagem, Codigo_de_Barras, Observacoes)values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setString(1, cadastroProdutoDTO.getNome_Produto());
            pstmCadastro.setInt(2, cadastroProdutoDTO.getIdUnidade());
            pstmCadastro.setInt(3, cadastroProdutoDTO.getIdCategoria());
            pstmCadastro.setBigDecimal(4, cadastroProdutoDTO.getPreco());
            // Verifica se a data é nula antes de definir
            if (cadastroProdutoDTO.getData() != null) {
                pstmCadastro.setDate(5, new java.sql.Date(cadastroProdutoDTO.getData().getTime()));
            } else {
                pstmCadastro.setNull(5, java.sql.Types.DATE); // Se a data for nula, insere NULL no banco
            }
            pstmCadastro.setString(6, cadastroProdutoDTO.getImagem());
            pstmCadastro.setString(7, cadastroProdutoDTO.getCodigo_de_Barras());
            pstmCadastro.setString(8, cadastroProdutoDTO.getObservacoes());

            pstmCadastro.execute();
            conn.commit();

            JOptionPane.showMessageDialog(null, "Os dados foram registrados corretamente.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse produto já foi cadastrado no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
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

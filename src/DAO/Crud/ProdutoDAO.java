package DAO.Crud;

import DAO.Conexao.ConexaoDAO;
import DTO.Crud.ProdutoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    private Connection conn;
    private String sqlCadastro;
    private String sqlConsulta;
    private PreparedStatement pstmCadastro;
    private PreparedStatement pstmConsulta;
    private ArrayList<ProdutoDTO> listaProduto = new ArrayList<ProdutoDTO>();
    private ResultSet rsConsulta;
    private ProdutoDTO produtoDTO;

    public void cadastrarProduto(ProdutoDTO produtoDTO) {
        conn = new ConexaoDAO().conectaBD();

        try {
            conn.setAutoCommit(false);

            sqlCadastro = "insert into produto (Nome_Produto, idUnidade, idCategoria, Preco, data, Imagem, Codigo_de_Barras, Observacoes)values (?,?,?,?,?,?,?,?)";
            pstmCadastro = conn.prepareStatement(sqlCadastro);
            pstmCadastro.setString(1, produtoDTO.getNome_Produto());
            pstmCadastro.setInt(2, produtoDTO.getIdUnidade());
            pstmCadastro.setInt(3, produtoDTO.getIdCategoria());
            pstmCadastro.setBigDecimal(4, produtoDTO.getPreco());
            // Verifica se a data é nula antes de definir
            if (produtoDTO.getData() != null) {
                pstmCadastro.setDate(5, new java.sql.Date(produtoDTO.getData().getTime()));
            } else {
                pstmCadastro.setNull(5, java.sql.Types.DATE); // Se a data for nula, insere NULL no banco
            }
            pstmCadastro.setString(6, produtoDTO.getImagem());
            pstmCadastro.setString(7, produtoDTO.getCodigo_de_Barras());
            pstmCadastro.setString(8, produtoDTO.getObservacoes());

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

    public ArrayList<ProdutoDTO> consultarProduto(String nomeProduto, String codigoBarras) {
        conn = new ConexaoDAO().conectaBD();

        sqlConsulta = "SELECT idProduto, Nome_Produto, Preco, Codigo_de_Barras FROM produto WHERE Nome_Produto LIKE ? OR Codigo_de_Barras LIKE ?";
        listaProduto = new ArrayList<>();
        try {
            pstmConsulta = conn.prepareStatement(sqlConsulta);
            pstmConsulta.setString(1, "%" + nomeProduto + "%");  // Filtro para o nome do produto
            pstmConsulta.setString(2, "%" + codigoBarras + "%");  // Filtro para o código de barras
            rsConsulta = pstmConsulta.executeQuery();

            while (rsConsulta.next()) {
                ProdutoDTO produtoDTO = new ProdutoDTO();  // Instancia um novo objeto para cada produto
                produtoDTO.setIdProduto(rsConsulta.getInt("idProduto"));
                produtoDTO.setNome_Produto(rsConsulta.getString("Nome_Produto"));
                produtoDTO.setPreco(rsConsulta.getBigDecimal("Preco"));
                produtoDTO.setCodigo_de_Barras(rsConsulta.getString("Codigo_de_Barras"));

                listaProduto.add(produtoDTO);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro em consultarProduto: " + erro);
        } finally {
            try {
                if (rsConsulta != null) {
                    rsConsulta.close();
                }
                if (pstmConsulta != null) {
                    pstmConsulta.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaProduto;
    }

}

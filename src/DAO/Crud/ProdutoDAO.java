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
    private PreparedStatement pstm;

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

    public ArrayList<ProdutoDTO> listarProdutos() {
        conn = new ConexaoDAO().conectaBD();
        ArrayList<ProdutoDTO> listaProduto = new ArrayList<>();
        String sqlListar = "SELECT * FROM produto";

        try {
            pstm = conn.prepareStatement(sqlListar);
            rsConsulta = pstm.executeQuery();

            while (rsConsulta.next()) {
                ProdutoDTO produto = new ProdutoDTO();
                produto.setIdProduto(rsConsulta.getInt("idProduto"));
                produto.setNome_Produto(rsConsulta.getString("Nome_Produto"));
                produto.setIdUnidade(rsConsulta.getInt("idUnidade"));
                produto.setIdCategoria(rsConsulta.getInt("idCategoria"));
                produto.setPreco(rsConsulta.getBigDecimal("Preco"));
                produto.setData(rsConsulta.getDate("data"));
                produto.setImagem(rsConsulta.getString("Imagem"));
                produto.setCodigo_de_Barras(rsConsulta.getString("Codigo_de_Barras"));
                produto.setObservacoes(rsConsulta.getString("Observacoes"));

                listaProduto.add(produto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaProduto;
    }

    public void atualizarProduto(ProdutoDTO produtoDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sqlAtualizar = "UPDATE produto SET Nome_Produto = ?, idUnidade = ?, idCategoria = ?, Preco = ?, data = ?, Imagem = ?, Codigo_de_Barras = ?, Observacoes = ? WHERE idProduto = ?";

        try {
            pstm = conn.prepareStatement(sqlAtualizar);
            pstm.setString(1, produtoDTO.getNome_Produto());
            pstm.setInt(2, produtoDTO.getIdUnidade());
            pstm.setInt(3, produtoDTO.getIdCategoria());
            pstm.setBigDecimal(4, produtoDTO.getPreco());
            if (produtoDTO.getData() != null) {
                pstm.setDate(5, new java.sql.Date(produtoDTO.getData().getTime()));
            } else {
                pstm.setNull(5, java.sql.Types.DATE);
            }
            pstm.setString(6, produtoDTO.getImagem());
            pstm.setString(7, produtoDTO.getCodigo_de_Barras());
            pstm.setString(8, produtoDTO.getObservacoes());
            pstm.setInt(9, produtoDTO.getIdProduto());

            int rowsUpdated = pstm.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum produto foi atualizado. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void excluirProduto(int idProduto) {
        conn = new ConexaoDAO().conectaBD();
        String sqlExcluir = "DELETE FROM produto WHERE idProduto = ?";

        try {
            pstm = conn.prepareStatement(sqlExcluir);
            pstm.setInt(1, idProduto);

            int rowsDeleted = pstm.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum produto foi excluído. Verifique o ID.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

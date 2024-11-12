package DAO.Vetores;

import DAO.Crud.FuncionarioDAO;
import DAO.Conexao.ConexaoDAO;
import DTO.Crud.ProdutoDTO;
import DTO.Crud.CargoFuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VetorProdutos {

    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ArrayList<Integer> idProduto = new ArrayList<>();
    private ArrayList<Integer> idCategoria = new ArrayList<>(); // Adicionado para armazenar idCategoria
    private JComboBox<String> cbxProduto;
    private JTextField txtCategoria;
    private int idCategoriaSelecionada; // Variável para armazenar o idCategoria selecionado

    // Construtor que recebe o JComboBox Função funcionario
    public VetorProdutos(JComboBox<String> cbxProduto, JTextField txtCategoria) {
        this.cbxProduto = cbxProduto;
        this.txtCategoria = txtCategoria;
    }

    public VetorProdutos(JComboBox<String> cbxProduto) {
        this.cbxProduto = cbxProduto;
    }

    // Restaura os dados da ComboBox de produtos e Adiciona automaticamente a categoria do produto
    public void completaTxtCategoria() {
        try {
            ProdutoDTO cadastroProdutoDTO = new ProdutoDTO();
            ResultSet rs = listarIdProduto(cadastroProdutoDTO);

            // Limpa os itens anteriores
            idProduto.clear();
            cbxProduto.removeAllItems();
            idCategoria.clear(); // Limpa a lista de idCategoria

            // Adiciona a opção "Selecione"
            cbxProduto.addItem("Selecione");

            // Adiciona novos dados no VetoresTipoLogin e no ComboBox
            while (rs.next()) {
                idProduto.add(rs.getInt(1));   // Adiciona o ID no VetoresTipoLogin
                cbxProduto.addItem(rs.getString(2));   // Adiciona o nome no ComboBox
                idCategoria.add(rs.getInt("idCategoria")); // Adiciona o idCategoria correspondente
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro em Class Vector no metodo restaurarDadosCbxIdFuncao: " + erro);
        }
    }

    public void restaurarDadosCbxProduto() {
        try {
            ProdutoDTO cadastroProdutoDTO = new ProdutoDTO();
            ResultSet rs = listarIdProduto(cadastroProdutoDTO);

            // Limpa os itens anteriores
            idProduto.clear();
            cbxProduto.removeAllItems();

            // Adiciona a opção "Selecione"
            cbxProduto.addItem("Selecione");

            // Adiciona novos dados no VetoresTipoLogin e no ComboBox
            while (rs.next()) {
                idProduto.add(rs.getInt(1));   // Adiciona o ID no VetoresTipoLogin
                cbxProduto.addItem(rs.getString(2));   // Adiciona o nome no ComboBox
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro em Class Vector no metodo restaurarDadosCbxIdFuncao: " + erro);
        }
    }

    private ResultSet listarIdProduto(ProdutoDTO cadastroProdutoDTO) {
        conn = new ConexaoDAO().conectaBD();
        String sql = "SELECT p.idProduto, p.Nome_Produto, c.idCategoria FROM produto p "
                + "JOIN categoria c ON p.idCategoria = c.idCategoria ORDER BY p.Nome_Produto";
        try {
            pstm = conn.prepareStatement(sql);
            return pstm.executeQuery();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Exibir a categoria do produto selecionado
    public void exibirCategoria() {
        int produtoSelecionado = cbxProduto.getSelectedIndex();
        if (produtoSelecionado > 0) {  // Verifica se o produto selecionado é válido
            try {
                int idProdutoSelecionado = idProduto.get(produtoSelecionado - 1);  // Obtém o ID do produto com base na seleção
                String sql = "SELECT categoria.idCategoria, categoria.Nome_Categoria FROM categoria "
                        + "JOIN produto ON categoria.idCategoria = produto.idCategoria "
                        + "WHERE produto.idProduto = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, idProdutoSelecionado);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    String categoria = rs.getString("Nome_Categoria");
                    idCategoriaSelecionada = rs.getInt("idCategoria"); // Armazena o idCategoria
                    txtCategoria.setText(categoria);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para obter o idCategoria selecionado
    public int getIdCategoriaSelecionada() {
        return idCategoriaSelecionada;
    }

    // Método para obter o VetoresTipoLogin de IDs
    public ArrayList<Integer> getIdProduto() {
        return idProduto;
    }

}

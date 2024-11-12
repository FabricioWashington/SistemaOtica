package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.ProdutoDAO;
import DTO.Crud.ProdutoDTO;
import Sistema.FrontEnd.Componentes.Pesquisar;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Produto {

    private String pesquisa;
    private JList<String> produtoJList;
    private ArrayList<ProdutoDTO> listaProduto = new ArrayList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private String item;
    private JTextField txtPesquisa;
    private String nomeProduto, codigoBarras, imagem, observacoes;
    private int idCategoria, idUnidade, idProduto;
    private BigDecimal preco;
    private Date data;
    private ProdutoDAO produtoDAO;
    private ProdutoDTO produtoDTO;

    public Produto() {
        this.produtoDAO = new ProdutoDAO();
        this.produtoDTO = new ProdutoDTO();

    }

    public Produto(JList<String> produtoJList, String pesquisa, String item, JTextField txtPesquisa, ArrayList<ProdutoDTO> listaProduto, DefaultListModel<String> listModel) {
        this();
        this.pesquisa = pesquisa;
        this.txtPesquisa = txtPesquisa;
        this.listaProduto = listaProduto;
        this.listModel = listModel;
        this.item = item;
        this.produtoJList = produtoJList;
    }

    public Produto(String nomeProduto, String codigoBarras,
            String imagem, String observacoes, int idCategoria,
            int idUnidade, BigDecimal preco) {
        this();
        this.nomeProduto = nomeProduto;
        this.codigoBarras = codigoBarras;
        this.imagem = imagem;
        this.observacoes = observacoes;
        this.idCategoria = idCategoria;
        this.idUnidade = idUnidade;
        this.preco = preco;
    }

    public void cadastrar() {
        obterDataAtual();

        produtoDTO.setNome_Produto(getNomeProduto());
        produtoDTO.setCodigo_de_Barras(getCodigoBarras());
        produtoDTO.setImagem(getImagem());
        produtoDTO.setObservacoes(getObservacoes());
        produtoDTO.setIdCategoria(getIdCategoria());
        produtoDTO.setIdUnidade(getIdUnidade());
        produtoDTO.setPreco(getPreco());
        produtoDTO.setData(getData());

        produtoDAO.cadastrarProduto(produtoDTO);

    }

    public void consultar() {
        try {
            pesquisa = getTxtPesquisa().getText();

            produtoDAO = new ProdutoDAO();
            listaProduto = produtoDAO.consultarProduto(pesquisa, pesquisa);
            listModel = new DefaultListModel<>();

            for (ProdutoDTO produtoDTO : getListaProduto()) {

                item = produtoDTO.getNome_Produto() + " - R$" + produtoDTO.getPreco() + " - Código: " + produtoDTO.getCodigo_de_Barras();
                listModel.addElement(item);
            }
            getProdutoJList().setModel(listModel);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar produtos: " + e.getMessage());
        }

    }

    public DefaultListModel<String> consultar(String pesquisa) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        try {
            ArrayList<ProdutoDTO> listaProduto = produtoDAO.consultarProduto(pesquisa, pesquisa);

            // Preenche o modelo de lista com os resultados da consulta
            for (ProdutoDTO produtoDTO : listaProduto) {
                String item = produtoDTO.getNome_Produto() + " - R$" + produtoDTO.getPreco() + " - Código: " + produtoDTO.getCodigo_de_Barras();
                listModel.addElement(item);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar produtos: " + e.getMessage());
        }
        return listModel; // Retorna o modelo de lista com os resultados
    }

    public void adicionarProdutoTabela(ProdutoDTO produtoSelecionado, JTable tabelaProdutos, JLabel lblSaldo, JLabel lblItens, JLabel lblIntegral, JLabel lblDesconto, JLabel lblTotal) {
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaProdutos.getModel();

        // Adicionar o produto na tabela
        BigDecimal valorUnitario = produtoSelecionado.getPreco();
        BigDecimal valorTotal = valorUnitario; // Se a quantidade for 1
        Object[] novaLinha = {
            produtoSelecionado.getNome_Produto(),
            produtoSelecionado.getCodigo_de_Barras(),
            valorUnitario,
            valorTotal
        };
        modeloTabela.addRow(novaLinha);

        // Atualizar as informações de saldo, itens, integral, desconto e total
        atualizarInformacoesTotais(tabelaProdutos, lblSaldo, lblItens, lblIntegral, lblDesconto, lblTotal);
    }

    private void atualizarInformacoesTotais(JTable tabelaProdutos, JLabel lblSaldo, JLabel lblItens, JLabel lblIntegral, JLabel lblDesconto, JLabel lblTotal) {
        BigDecimal saldo = BigDecimal.ZERO;
        int itens = tabelaProdutos.getRowCount();
        BigDecimal integral = BigDecimal.ZERO;
        BigDecimal desconto = BigDecimal.ZERO; // Implementar a lógica para desconto, se houver
        BigDecimal total = BigDecimal.ZERO;

        for (int i = 0; i < itens; i++) {
            BigDecimal valorTotalProduto = (BigDecimal) tabelaProdutos.getValueAt(i, 3); // Coluna de valor total do produto
            total = total.add(valorTotalProduto);
        }

        // Atualizar labels
        lblSaldo.setText("Saldo: R$" + saldo.toString());
        lblItens.setText("Itens: " + itens);
        lblIntegral.setText("Integral: R$" + integral.toString());
        lblDesconto.setText("Desconto: R$" + desconto.toString());
        lblTotal.setText("Total: R$" + total.toString());
    }

    public ProdutoDTO obterProdutoPorNome(String nome) {
        // Lógica para buscar o produto no banco de dados com base no nome
        // Aqui você pode usar SQL ou outra lógica de busca para retornar o ProdutoDTO

        // Exemplo fictício:
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome_Produto(nome);
        produtoDTO.setIdProduto(1); // Substitua por dados reais do banco de dados
        produtoDTO.setCodigo_de_Barras("12345678");
        produtoDTO.setPreco(BigDecimal.valueOf(10.00));

        return produtoDTO;
    }

    public void limparCampos(JTextField txtNomeProduto, JTextArea txtAreaObservacoes, JFormattedTextField txtPreco, JTextField txtCodigoBarras, JComboBox cbxUnidade, JComboBox cbxCategoria, JLabel lblImg) {
        txtNomeProduto.setText("");
        txtPreco.setText("");
        txtAreaObservacoes.setText("");
        txtCodigoBarras.setText("");
        cbxUnidade.setSelectedIndex(-1);
        cbxCategoria.setSelectedIndex(-1);
        lblImg.setText("");

    }

    public void obterDataAtual() {
        Calendar cal = Calendar.getInstance();
        this.data = cal.getTime();
    }

    /**
     * @return the nomeProduto
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     * @param nomeProduto the nomeProduto to set
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     * @return the codigoBarras
     */
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * @param codigoBarras the codigoBarras to set
     */
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    /**
     * @return the imagem
     */
    public String getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    /**
     * @return the idCategoria
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return the idUnidade
     */
    public int getIdUnidade() {
        return idUnidade;
    }

    /**
     * @param idUnidade the idUnidade to set
     */
    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    /**
     * @return the preco
     */
    public BigDecimal getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    /**
     * @return the listaProduto
     */
    public ArrayList<ProdutoDTO> getListaProduto() {
        return listaProduto;
    }

    /**
     * @return the listModel
     */
    public DefaultListModel<String> getListModel() {
        return listModel;
    }

    /**
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @return the txtPesquisa
     */
    public JTextField getTxtPesquisa() {
        return txtPesquisa;
    }

    /**
     * @param txtPesquisa the txtPesquisa to set
     */
    public void setTxtPesquisa(JTextField txtPesquisa) {
        this.txtPesquisa = txtPesquisa;
    }

    /**
     * @return the produtoJList
     */
    public JList<String> getProdutoJList() {
        return produtoJList;
    }

    /**
     * @param produtoJList the produtoJList to set
     */
    public void setProdutoJList(JList<String> produtoJList) {
        this.produtoJList = produtoJList;
    }

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

}

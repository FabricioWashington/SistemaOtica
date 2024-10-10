package Sistema.BackEnd.TelasPrincipais.Cadastro;

import DAO.Cadastro.CadastroProdutoDAO;
import DTO.Cadastro.CadastroProdutoDTO;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CadastroProduto {

    private String nomeProduto, codigoBarras, imagem, observacoes;
    private int idCategoria, idUnidade;
    private BigDecimal preco;
    private Date data;
    private CadastroProdutoDAO cadastroProdutoDAO;
    private CadastroProdutoDTO cadastroProdutoDTO;

    public CadastroProduto() {
        this.cadastroProdutoDAO = new CadastroProdutoDAO();
        this.cadastroProdutoDTO = new CadastroProdutoDTO();

    }

    public CadastroProduto(String nomeProduto, String codigoBarras,
            String imagem, String observacoes,int idCategoria,
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
    
    public void cadastrar(){
        obterDataAtual();
        
        cadastroProdutoDTO.setNome_Produto(getNomeProduto());
        cadastroProdutoDTO.setCodigo_de_Barras(getCodigoBarras());
        cadastroProdutoDTO.setImagem(getImagem());
        cadastroProdutoDTO.setObservacoes(getObservacoes());
        cadastroProdutoDTO.setIdCategoria(getIdCategoria());
        cadastroProdutoDTO.setIdUnidade(getIdUnidade());
        cadastroProdutoDTO.setPreco(getPreco());
        cadastroProdutoDTO.setData(getData());
        
        cadastroProdutoDAO.cadastrarProduto(cadastroProdutoDTO);
        
    }
    
    public void limparCampos(JTextField txtNomeProduto, JTextArea txtAreaObservacoes, JFormattedTextField txtPreco, JTextField txtCodigoBarras, JComboBox cbxUnidade, JComboBox cbxCategoria, JLabel lblImg){
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

}

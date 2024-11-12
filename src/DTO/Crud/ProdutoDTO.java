package DTO.Crud;

import java.math.BigDecimal;
import java.util.Date;

public class ProdutoDTO {
    private int idProduto, idCategoria, idUnidade;
    private String Nome_Produto, Codigo_de_Barras, Imagem, Observacoes;
    private BigDecimal Preco;
    private Date data;

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
     * @return the Nome_Produto
     */
    public String getNome_Produto() {
        return Nome_Produto;
    }

    /**
     * @param Nome_Produto the Nome_Produto to set
     */
    public void setNome_Produto(String Nome_Produto) {
        this.Nome_Produto = Nome_Produto;
    }

    /**
     * @return the Codigo_de_Barras
     */
    public String getCodigo_de_Barras() {
        return Codigo_de_Barras;
    }

    /**
     * @param Codigo_de_Barras the Codigo_de_Barras to set
     */
    public void setCodigo_de_Barras(String Codigo_de_Barras) {
        this.Codigo_de_Barras = Codigo_de_Barras;
    }

    /**
     * @return the Imagem
     */
    public String getImagem() {
        return Imagem;
    }

    /**
     * @param Imagem the Imagem to set
     */
    public void setImagem(String Imagem) {
        this.Imagem = Imagem;
    }

    /**
     * @return the Observacoes
     */
    public String getObservacoes() {
        return Observacoes;
    }

    /**
     * @param Observacoes the Observacoes to set
     */
    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }

    /**
     * @return the Preco
     */
    public BigDecimal getPreco() {
        return Preco;
    }

    /**
     * @param Preco the Preco to set
     */
    public void setPreco(BigDecimal Preco) {
        this.Preco = Preco;
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

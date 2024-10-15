package Sistema.BackEnd.TelasPrincipais.Cadastro;

import DAO.Cadastro.CadastroEstoqueDAO;
import DTO.Cadastro.CadastroEstoqueDTO;
import java.math.BigDecimal;

public class CadastroEstoque {

    private CadastroEstoqueDAO cadastroEstoqueDAO;
    private CadastroEstoqueDTO cadastroEstoqueDTO;
    private int idProduto, idCategoria, quantidade;
    private String descricao;
    private BigDecimal precoUnitario;

    public CadastroEstoque() {
        this.cadastroEstoqueDAO = new CadastroEstoqueDAO();
        this.cadastroEstoqueDTO = new CadastroEstoqueDTO();
    }

    public CadastroEstoque(int idProduto, int idCategoria, int quantidade, String descricao, BigDecimal precoUnitario) {
        this();
        this.idProduto = idProduto;
        this.idCategoria = idCategoria;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
    }

    public void cadastrar() {
        
        cadastroEstoqueDTO.setIdProduto(idProduto);
        cadastroEstoqueDTO.setIdCategoria(idCategoria);
        cadastroEstoqueDTO.setDescricao(descricao);
        cadastroEstoqueDTO.setQuantidade(quantidade);
        cadastroEstoqueDTO.setPrecoUnitario(precoUnitario);
        
        cadastroEstoqueDAO.cadastrarEstoque(cadastroEstoqueDTO);
        
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
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the precoUnitario
     */
    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    /**
     * @param precoUnitario the precoUnitario to set
     */
    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

}

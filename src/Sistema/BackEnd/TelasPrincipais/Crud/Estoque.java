package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.EstoqueDAO;
import DTO.Crud.EstoqueDTO;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Estoque {

    private EstoqueDAO cadastroEstoqueDAO;
    private EstoqueDTO cadastroEstoqueDTO;
    private int idProduto, idCategoria, quantidade;
    private String descricao;
    private BigDecimal precoUnitario;

    public Estoque() {
        this.cadastroEstoqueDAO = new EstoqueDAO();
        this.cadastroEstoqueDTO = new EstoqueDTO();
    }

    public Estoque(int idProduto, int idCategoria, int quantidade, String descricao, BigDecimal precoUnitario) {
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

    public ArrayList<EstoqueDTO> listar() {
        return cadastroEstoqueDAO.listarEstoque();
    }

    public void atualizar() {
        cadastroEstoqueDTO.setIdProduto(idProduto);
        cadastroEstoqueDTO.setIdCategoria(idCategoria);
        cadastroEstoqueDTO.setDescricao(descricao);
        cadastroEstoqueDTO.setQuantidade(quantidade);
        cadastroEstoqueDTO.setPrecoUnitario(precoUnitario);

        cadastroEstoqueDAO.atualizarEstoque(cadastroEstoqueDTO);
    }

    public void excluir() {
        cadastroEstoqueDAO.excluirEstoque(idProduto);
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

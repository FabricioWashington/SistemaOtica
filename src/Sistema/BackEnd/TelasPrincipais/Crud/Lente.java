package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.LentesDAO;
import DTO.Crud.LentesDTO;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Lente {

    private int idLente;
    private int idProduto;
    private int idTipoLente;
    private int idMaterial;
    private int idTratamento;
    private BigDecimal indiceRefracao;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private BigDecimal grau;
    private BigDecimal diametro;
    private BigDecimal curvaBase;
    private int quantidade;
    private int eixo;
    private LentesDTO cadastroLenteDTO;
    private LentesDAO cadastroLenteDAO;

    public Lente() {
        this.cadastroLenteDAO = new LentesDAO();
        this.cadastroLenteDTO = new LentesDTO();
    }

    //Lente de Contato
    public Lente(int idProduto, int idTipoLente, int idMaterial, int idTratamento, BigDecimal precoCusto, BigDecimal precoVenda, BigDecimal grau, BigDecimal diametro, BigDecimal curvaBase, int quantidade) {
        this();
        this.idProduto = idProduto;
        this.idTipoLente = idTipoLente;
        this.idMaterial = idMaterial;
        this.idTratamento = idTratamento;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.grau = grau;
        this.diametro = diametro;
        this.curvaBase = curvaBase;
        this.quantidade = quantidade;
    }

    //Lente
    public Lente(int idProduto, int idTipoLente, int idMaterial, int idTratamento, BigDecimal indiceRefracao, BigDecimal precoCusto, BigDecimal precoVenda, BigDecimal grau, int quantidade, int eixo) {
        this();
        this.idProduto = idProduto;
        this.idTipoLente = idTipoLente;
        this.idMaterial = idMaterial;
        this.idTratamento = idTratamento;
        this.indiceRefracao = indiceRefracao;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.grau = grau;
        this.quantidade = quantidade;
        this.eixo = eixo;
    }

    public void cadastrarLenteContato() {
        cadastroLenteDTO.setIdProduto(idProduto);
        cadastroLenteDTO.setIdTipoLente(idTipoLente);
        cadastroLenteDTO.setIdMaterial(idMaterial);
        cadastroLenteDTO.setIdTratamento(idTratamento);
        cadastroLenteDTO.setCurvaBase(curvaBase);
        cadastroLenteDTO.setDiametro(diametro);
        cadastroLenteDTO.setPrecoCusto(precoCusto);
        cadastroLenteDTO.setPrecoVenda(precoVenda);
        cadastroLenteDTO.setQuantidade(quantidade);
        cadastroLenteDTO.setGrau(grau);

        cadastroLenteDAO.cadastrarLenteContato(cadastroLenteDTO);
    }

    public void cadastrarLente() {
        cadastroLenteDTO.setIdProduto(idProduto);
        cadastroLenteDTO.setIdTipoLente(idTipoLente);
        cadastroLenteDTO.setIdMaterial(idMaterial);
        cadastroLenteDTO.setIdTratamento(idTratamento);
        cadastroLenteDTO.setIndiceRefracao(indiceRefracao);
        cadastroLenteDTO.setPrecoCusto(precoCusto);
        cadastroLenteDTO.setPrecoVenda(precoVenda);
        cadastroLenteDTO.setQuantidade(quantidade);
        cadastroLenteDTO.setGrau(grau);
        cadastroLenteDTO.setEixo(eixo);

        cadastroLenteDAO.cadastrarLente(cadastroLenteDTO);
    }

    public ArrayList<LentesDTO> listarLentes() {
        return cadastroLenteDAO.listarLentes();
    }

    public ArrayList<LentesDTO> listarLentesContato() {
        return cadastroLenteDAO.listarLentesContato();
    }

    public void atualizarLente() {
        cadastroLenteDTO.setIdProduto(idProduto);
        cadastroLenteDTO.setIdTipoLente(idTipoLente);
        cadastroLenteDTO.setIdMaterial(idMaterial);
        cadastroLenteDTO.setIdTratamento(idTratamento);
        cadastroLenteDTO.setIndiceRefracao(indiceRefracao);
        cadastroLenteDTO.setPrecoCusto(precoCusto);
        cadastroLenteDTO.setPrecoVenda(precoVenda);
        cadastroLenteDTO.setQuantidade(quantidade);
        cadastroLenteDTO.setGrau(grau);
        cadastroLenteDTO.setEixo(eixo);

        cadastroLenteDAO.atualizarLente(cadastroLenteDTO);
    }

    public void atualizarLenteContato() {
        cadastroLenteDTO.setIdProduto(idProduto);
        cadastroLenteDTO.setIdTipoLente(idTipoLente);
        cadastroLenteDTO.setIdMaterial(idMaterial);
        cadastroLenteDTO.setIdTratamento(idTratamento);
        cadastroLenteDTO.setCurvaBase(curvaBase);
        cadastroLenteDTO.setDiametro(diametro);
        cadastroLenteDTO.setPrecoCusto(precoCusto);
        cadastroLenteDTO.setPrecoVenda(precoVenda);
        cadastroLenteDTO.setQuantidade(quantidade);
        cadastroLenteDTO.setGrau(grau);

        cadastroLenteDAO.atualizarLenteContato(cadastroLenteDTO);
    }

    public void excluirLente() {
        cadastroLenteDAO.excluirLente(idProduto);
    }

    public void excluirLenteContato() {
        cadastroLenteDAO.excluirLenteContato(idProduto);
    }

    /**
     * @return the idLente
     */
    public int getIdLente() {
        return idLente;
    }

    /**
     * @param idLente the idLente to set
     */
    public void setIdLente(int idLente) {
        this.idLente = idLente;
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
     * @return the idTipoLente
     */
    public int getIdTipoLente() {
        return idTipoLente;
    }

    /**
     * @param idTipoLente the idTipoLente to set
     */
    public void setIdTipoLente(int idTipoLente) {
        this.idTipoLente = idTipoLente;
    }

    /**
     * @return the idMaterial
     */
    public int getIdMaterial() {
        return idMaterial;
    }

    /**
     * @param idMaterial the idMaterial to set
     */
    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    /**
     * @return the idTratamento
     */
    public int getIdTratamento() {
        return idTratamento;
    }

    /**
     * @param idTratamento the idTratamento to set
     */
    public void setIdTratamento(int idTratamento) {
        this.idTratamento = idTratamento;
    }

    /**
     * @return the indiceRefracao
     */
    public BigDecimal getIndiceRefracao() {
        return indiceRefracao;
    }

    /**
     * @param indiceRefracao the indiceRefracao to set
     */
    public void setIndiceRefracao(BigDecimal indiceRefracao) {
        this.indiceRefracao = indiceRefracao;
    }

    /**
     * @return the precoCusto
     */
    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    /**
     * @param precoCusto the precoCusto to set
     */
    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    /**
     * @return the precoVenda
     */
    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    /**
     * @param precoVenda the precoVenda to set
     */
    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    /**
     * @return the grau
     */
    public BigDecimal getGrau() {
        return grau;
    }

    /**
     * @param grau the grau to set
     */
    public void setGrau(BigDecimal grau) {
        this.grau = grau;
    }

    /**
     * @return the diametro
     */
    public BigDecimal getDiametro() {
        return diametro;
    }

    /**
     * @param diametro the diametro to set
     */
    public void setDiametro(BigDecimal diametro) {
        this.diametro = diametro;
    }

    /**
     * @return the curvaBase
     */
    public BigDecimal getCurvaBase() {
        return curvaBase;
    }

    /**
     * @param curvaBase the curvaBase to set
     */
    public void setCurvaBase(BigDecimal curvaBase) {
        this.curvaBase = curvaBase;
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
     * @return the eixo
     */
    public int getEixo() {
        return eixo;
    }

    /**
     * @param eixo the eixo to set
     */
    public void setEixo(int eixo) {
        this.eixo = eixo;
    }

}

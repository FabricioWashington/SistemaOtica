package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.VendaDAO;
import DTO.Crud.VendaDTO;
import java.math.BigDecimal;
import java.util.Date;

public class Venda {
    
    private VendaDTO vendaDTO;
    private VendaDAO vendaDAO;
    private int idVenda, idFuncionario, idCliente, idPagamento;
    private Date data, dataVencimento;
    private BigDecimal vlrSugerido, vlrFinal, desconto, vlrRecebido, vlrRestante, totalVenda;
    private String parcela, status;
    
    public Venda() {
        this.vendaDAO = new VendaDAO();
        this.vendaDTO = new VendaDTO();
    }
    
    public Venda(int idFuncionario, int idCliente, int idPagamento, Date data, Date dataVencimento, BigDecimal vlrSugerido, BigDecimal vlrFinal, BigDecimal desconto,
            BigDecimal vlrRecebido, BigDecimal vlrRestante, BigDecimal totalVenda, String parcela, String status) {
        this();
        this.idFuncionario = idFuncionario;
        this.idCliente = idCliente;
        this.idPagamento = idPagamento;
        this.data = data;
        this.dataVencimento = dataVencimento;
        this.vlrSugerido = vlrSugerido;
        this.vlrFinal = vlrFinal;
        this.desconto = desconto;
        this.vlrRecebido = vlrRecebido;
        this.vlrRestante = vlrRestante;
        this.totalVenda = totalVenda;
        this.parcela = parcela;
        this.status = status;
    }
    
    public void cadastrar() {
        vendaDTO.setIdFuncionario(idFuncionario);
        vendaDTO.setIdCliente(idCliente);
        vendaDTO.setIdPagamento(idPagamento);
        vendaDTO.setData(data);
        vendaDTO.setDataVencimento(dataVencimento);
        vendaDTO.setVlrSugerido(vlrSugerido);
        vendaDTO.setVlrFinal(vlrFinal);
        vendaDTO.setDesconto(desconto);
        vendaDTO.setVlrRecebido(vlrRecebido);
        vendaDTO.setVlrRestante(vlrRestante);
        vendaDTO.setTotalVenda(totalVenda);
        vendaDTO.setParcela(parcela);
        vendaDTO.setStatus(status);
        
        vendaDAO.cadastrarVenda(vendaDTO);
    }

    /**
     * @return the vendaDTO
     */
    public VendaDTO getVendaDTO() {
        return vendaDTO;
    }

    /**
     * @param vendaDTO the vendaDTO to set
     */
    public void setVendaDTO(VendaDTO vendaDTO) {
        this.vendaDTO = vendaDTO;
    }

    /**
     * @return the vendaDAO
     */
    public VendaDAO getVendaDAO() {
        return vendaDAO;
    }

    /**
     * @param vendaDAO the vendaDAO to set
     */
    public void setVendaDAO(VendaDAO vendaDAO) {
        this.vendaDAO = vendaDAO;
    }

    /**
     * @return the idVenda
     */
    public int getIdVenda() {
        return idVenda;
    }

    /**
     * @param idVenda the idVenda to set
     */
    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    /**
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idPagamento
     */
    public int getIdPagamento() {
        return idPagamento;
    }

    /**
     * @param idPagamento the idPagamento to set
     */
    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
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
     * @return the dataVencimento
     */
    public Date getDataVencimento() {
        return dataVencimento;
    }

    /**
     * @param dataVencimento the dataVencimento to set
     */
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    /**
     * @return the vlrSugerido
     */
    public BigDecimal getVlrSugerido() {
        return vlrSugerido;
    }

    /**
     * @param vlrSugerido the vlrSugerido to set
     */
    public void setVlrSugerido(BigDecimal vlrSugerido) {
        this.vlrSugerido = vlrSugerido;
    }

    /**
     * @return the vlrFinal
     */
    public BigDecimal getVlrFinal() {
        return vlrFinal;
    }

    /**
     * @param vlrFinal the vlrFinal to set
     */
    public void setVlrFinal(BigDecimal vlrFinal) {
        this.vlrFinal = vlrFinal;
    }

    /**
     * @return the desconto
     */
    public BigDecimal getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the vlrRecebido
     */
    public BigDecimal getVlrRecebido() {
        return vlrRecebido;
    }

    /**
     * @param vlrRecebido the vlrRecebido to set
     */
    public void setVlrRecebido(BigDecimal vlrRecebido) {
        this.vlrRecebido = vlrRecebido;
    }

    /**
     * @return the vlrRestante
     */
    public BigDecimal getVlrRestante() {
        return vlrRestante;
    }

    /**
     * @param vlrRestante the vlrRestante to set
     */
    public void setVlrRestante(BigDecimal vlrRestante) {
        this.vlrRestante = vlrRestante;
    }

    /**
     * @return the totalVenda
     */
    public BigDecimal getTotalVenda() {
        return totalVenda;
    }

    /**
     * @param totalVenda the totalVenda to set
     */
    public void setTotalVenda(BigDecimal totalVenda) {
        this.totalVenda = totalVenda;
    }

    /**
     * @return the parcela
     */
    public String getParcela() {
        return parcela;
    }

    /**
     * @param parcela the parcela to set
     */
    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}

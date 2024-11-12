package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.PagamentoDAO;
import DTO.Crud.PagamentoDTO;

public class Pagamento {

    private PagamentoDAO pagamentoDAO;
    private PagamentoDTO pagamentoDTO;
    private String tipoPagamento;

    public Pagamento() {
        this.pagamentoDAO = new PagamentoDAO();
        this.pagamentoDTO = new PagamentoDTO();
    }

    public Pagamento(String tipoPagamento) {
        this();
        this.tipoPagamento = tipoPagamento;
    }

    public void cadastrar() {
        pagamentoDTO.setTipoPagamento(getTipoPagamento());

        pagamentoDAO.cadastrarPagamento(pagamentoDTO);
    }

    public void limparCampos() {

    }

    /**
     * @return the tipoPagamento
     */
    public String getTipoPagamento() {
        return tipoPagamento;
    }

    /**
     * @param tipoPagamento the tipoPagamento to set
     */
    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

}

package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.AgendamentoExameDAO;
import DTO.Crud.AgendamentoExameDTO;
import java.util.Calendar;
import java.util.Date;


public class Agendamento {
    
    private int idAgendamento, idCliente;
    private Date dataExame, dataAgendamento;
    private AgendamentoExameDTO agendamentoDTO;
    private AgendamentoExameDAO agendamentoDAO;
    
    public Agendamento(){
        this.agendamentoDAO = new AgendamentoExameDAO();
        this.agendamentoDTO = new AgendamentoExameDTO();
    }

    public Agendamento(int idAgendamento, int idCliente, Date dataExame, Date dataAgendamento) {
        this.idAgendamento = idAgendamento;
        this.idCliente = idCliente;
        this.dataExame = dataExame;
        this.dataAgendamento = dataAgendamento;
    }
    
    public void cadastrar(){
        agendamentoDTO.setIdCliente(idCliente);
        agendamentoDTO.setDataExame(dataExame);
        agendamentoDTO.setDataAgendamento(dataAgendamento);
        
        agendamentoDAO.cadastrarAgendamento(agendamentoDTO);
    }
    
     public void obterDataAtual() {
        Calendar cal = Calendar.getInstance();
       //this.dataCadastro = cal.getTime();
        //this.dataModificacao = cal.getTime();
    }

    /**
     * @return the idAgendamento
     */
    public int getIdAgendamento() {
        return idAgendamento;
    }

    /**
     * @param idAgendamento the idAgendamento to set
     */
    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
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
     * @return the dataExame
     */
    public Date getDataExame() {
        return dataExame;
    }

    /**
     * @param dataExame the dataExame to set
     */
    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    /**
     * @return the dataAgendamento
     */
    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    /**
     * @param dataAgendamento the dataAgendamento to set
     */
    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
    
    
    
}

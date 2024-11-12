package DTO.Crud;

import java.util.Date;


public class AgendamentoExameDTO {
    private int idAgendamento, idCliente;
    private Date dataExame, dataAgendamento;

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

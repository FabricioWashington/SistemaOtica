package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.ExameDAO;
import DTO.Crud.ExameDTO;
import java.util.ArrayList;
import java.util.Date;

public class Exame {

    private ExameDAO exameDAO;
    private ExameDTO exameDTO;
    private int idCliente, idMedico;
    private Date dataExame;
    private String tipoExame, resultados, observacoes;

    public Exame() {
        this.exameDAO = new ExameDAO();
        this.exameDTO = new ExameDTO();
    }

    public Exame(int idCliente, int idMedico, Date dataExame, String tipoExame, String resultados, String observacoes) {
        this();
        this.idCliente = idCliente;
        this.idMedico = idMedico;
        this.dataExame = dataExame;
        this.tipoExame = tipoExame;
        this.resultados = resultados;
        this.observacoes = observacoes;
    }

    public void cadastrar() {
        exameDTO.setIdCliente(idCliente);
        exameDTO.setIdMedico(idMedico);
        exameDTO.setDataExame(dataExame);
        exameDTO.setTipoExame(tipoExame);
        exameDTO.setResultados(resultados);
        exameDTO.setObservacoes(observacoes);

        exameDAO.cadastrarExame(exameDTO);
    }

    public ArrayList<ExameDTO> listar() {
        return exameDAO.listarExames();
    }

    public void atualizar() {
        exameDTO.setIdCliente(idCliente);
        exameDTO.setIdMedico(idMedico);
        exameDTO.setDataExame(dataExame);
        exameDTO.setTipoExame(tipoExame);
        exameDTO.setResultados(resultados);
        exameDTO.setObservacoes(observacoes);

        exameDAO.atualizarExame(exameDTO);
    }

    public void excluir(int idExame) {
        exameDAO.excluirExame(idExame);
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
     * @return the idMedico
     */
    public int getIdMedico() {
        return idMedico;
    }

    /**
     * @param idMedico the idMedico to set
     */
    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
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
     * @return the tipoExame
     */
    public String getTipoExame() {
        return tipoExame;
    }

    /**
     * @param tipoExame the tipoExame to set
     */
    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    /**
     * @return the resultados
     */
    public String getResultados() {
        return resultados;
    }

    /**
     * @param resultados the resultados to set
     */
    public void setResultados(String resultados) {
        this.resultados = resultados;
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

}

package DTO.Cadastro;

import java.math.BigDecimal;

public class CadastroCargoFuncionarioDTO {

    private int idCargo_Funcionario;
    private String cargo;
    private BigDecimal salario;

    /**
     * @return the idCargo_Funcionario
     */
    public int getIdCargo_Funcionario() {
        return idCargo_Funcionario;
    }

    /**
     * @param idCargo_Funcionario the idCargo_Funcionario to set
     */
    public void setIdCargo_Funcionario(int idCargo_Funcionario) {
        this.idCargo_Funcionario = idCargo_Funcionario;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the salario
     */
    public BigDecimal getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

}

package DTO.Crud;

import java.math.BigDecimal;

public class CargoFuncionarioDTO {

    private int idCargo_Funcionario;
    private String Cargo;
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
     * @return the Cargo
     */
    public String getCargo() {
        return Cargo;
    }

    /**
     * @param Cargo the Cargo to set
     */
    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
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

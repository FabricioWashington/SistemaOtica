package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.CargoFuncionarioDAO;
import DTO.Crud.CargoFuncionarioDTO;
import java.math.BigDecimal;

public class CargoFuncionario {

    private CargoFuncionarioDTO cadastroCargoFuncionarioDTO;
    private CargoFuncionarioDAO cadastroCargoFuncionarioDAO;
    private String cargo;
    private BigDecimal salario;

    public CargoFuncionario() {
        this.cadastroCargoFuncionarioDAO = new CargoFuncionarioDAO();
        this.cadastroCargoFuncionarioDTO = new CargoFuncionarioDTO();
    }

    public CargoFuncionario(String cargo, BigDecimal salario) {
        this();
        this.cargo = cargo;
        this.salario = salario;
    }

    public void cadastrar() {

        cadastroCargoFuncionarioDTO.setCargo(cargo);
        cadastroCargoFuncionarioDTO.setSalario(salario);

        cadastroCargoFuncionarioDAO.cadastrarCargo(cadastroCargoFuncionarioDTO);
    }

    public void limparCampos() {
        //adicionar logica de limpar os campos
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

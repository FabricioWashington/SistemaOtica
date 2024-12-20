package Sistema.BackEnd.TelasPrincipais.Crud;

import DAO.Crud.CargoFuncionarioDAO;
import DTO.Crud.CargoFuncionarioDTO;
import java.math.BigDecimal;
import java.util.ArrayList;

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

    // Método para cadastrar usando atributos internos
    public void cadastrar() {
        if (cargo == null || salario == null) {
            throw new IllegalStateException("Cargo e salário devem ser definidos antes de cadastrar.");
        }
        cadastroCargoFuncionarioDTO.setCargo(cargo);
        cadastroCargoFuncionarioDTO.setSalario(salario);
        cadastroCargoFuncionarioDAO.cadastrarCargo(cadastroCargoFuncionarioDTO);
    }

//    // Método para cadastrar usando parâmetros
//    public void cadastrar(String cargo, BigDecimal salario) {
//        cadastroCargoFuncionarioDTO.setCargo(cargo);
//        cadastroCargoFuncionarioDTO.setSalario(salario);
//        cadastroCargoFuncionarioDAO.cadastrarCargo(cadastroCargoFuncionarioDTO);
//    }

    public ArrayList<CargoFuncionarioDTO> listar() {
        return cadastroCargoFuncionarioDAO.listarCargos();
    }

    public void atualizar(int idCargo, String novoCargo, BigDecimal novoSalario) {
        cadastroCargoFuncionarioDTO.setIdCargo_Funcionario(idCargo);
        cadastroCargoFuncionarioDTO.setCargo(novoCargo);
        cadastroCargoFuncionarioDTO.setSalario(novoSalario);
        cadastroCargoFuncionarioDAO.atualizarCargo(cadastroCargoFuncionarioDTO);
    }

    public void excluir(int idCargo) {
        cadastroCargoFuncionarioDAO.excluirCargo(idCargo);
    }

    public void limparCampos() {
        this.cargo = null;
        this.salario = null;
    }

    // Getters e Setters
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}

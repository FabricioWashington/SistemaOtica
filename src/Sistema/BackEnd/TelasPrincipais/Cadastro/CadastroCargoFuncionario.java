package Sistema.BackEnd.TelasPrincipais.Cadastro;

import DAO.Cadastro.CadastroCargoFuncionarioDAO;
import DTO.Cadastro.CadastroCargoFuncionarioDTO;
import java.math.BigDecimal;

public class CadastroCargoFuncionario {

    private CadastroCargoFuncionarioDTO cadastroCargoFuncionarioDTO;
    private CadastroCargoFuncionarioDAO cadastroCargoFuncionarioDAO;
    private String cargo;
    private BigDecimal salario;

    public CadastroCargoFuncionario() {
        this.cadastroCargoFuncionarioDAO = new CadastroCargoFuncionarioDAO();
        this.cadastroCargoFuncionarioDTO = new CadastroCargoFuncionarioDTO();
    }

    public CadastroCargoFuncionario(String cargo, BigDecimal salario) {
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

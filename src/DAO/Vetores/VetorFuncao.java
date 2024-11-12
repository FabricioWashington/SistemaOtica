package DAO.Vetores;

import DAO.Crud.FuncionarioDAO;
import DTO.Crud.CargoFuncionarioDTO;
import javax.swing.JComboBox;
import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VetorFuncao {

    private ArrayList<Integer> idCargo_Funcionario = new ArrayList<>();
    private JComboBox<String> cbxFuncao;

    // Construtor que recebe o JComboBox Função funcionario
    public VetorFuncao(JComboBox<String> cbxFuncao) {
        this.cbxFuncao = cbxFuncao;
    }

    public void restaurarDadosCbxIdFuncao() {

        try {
            CargoFuncionarioDTO objCargoFuncionarioDto = new CargoFuncionarioDTO();
            FuncionarioDAO objCadastroFuncionarioDao = new FuncionarioDAO();
            ResultSet rs = objCadastroFuncionarioDao.listarIdFuncao(objCargoFuncionarioDto);

            //Limpa os itens anteriores
            idCargo_Funcionario.clear();
            cbxFuncao.removeAllItems();

            //Adiciona a opção "Selecione"
            cbxFuncao.addItem("Selecione");

            // Adiciona novos dados no VetoresTipoLogin e no ComboBox
            while (rs.next()) {
                idCargo_Funcionario.add(rs.getInt(1));   // Adiciona o ID no VetoresTipoLogin
                cbxFuncao.addItem(rs.getString(2));   // Adiciona o nome no ComboBox

            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro em Class Vector no metodo restaurarDadosCbxIdFuncao: " + erro);
        }
    }

    // Método para obter o VetoresTipoLogin de IDs
    public ArrayList<Integer> getIdFuncao() {
        return idCargo_Funcionario;
    }
}

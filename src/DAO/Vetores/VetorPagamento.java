package DAO.Vetores;

import DAO.Crud.PagamentoDAO;
import DTO.Crud.PagamentoDTO;
import javax.swing.JComboBox;
import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VetorPagamento {

    private ArrayList<Integer> idPagamento = new ArrayList<>();
    private JComboBox<String> cbxPagamento;

    public VetorPagamento(JComboBox<String> cbxPagamento) {
        this.cbxPagamento = cbxPagamento;
    }

    public void restaurarDadosCbxIdPagamento() {

        try {
            PagamentoDTO pagamentoDTO = new PagamentoDTO();
            PagamentoDAO pagamentoDAO = new PagamentoDAO();
            ResultSet rs = pagamentoDAO.listarIdPagamento(pagamentoDTO);

            //Limpa os itens anteriores
            idPagamento.clear();
            cbxPagamento.removeAllItems();

            //Adiciona a opção "Selecione"
            cbxPagamento.addItem("Selecione");

            // Adiciona novos dados no VetoresTipoLogin e no ComboBox
            while (rs.next()) {
                idPagamento.add(rs.getInt(1));   // Adiciona o ID no VetoresTipoLogin
                cbxPagamento.addItem(rs.getString(2));   // Adiciona o nome no ComboBox

            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro em Class Vector no metodo restaurarDadosCbxIdPagamento: " + erro);
        }
    }
    
    public ArrayList<Integer> getIdPagamento(){
        return idPagamento;
    }
}

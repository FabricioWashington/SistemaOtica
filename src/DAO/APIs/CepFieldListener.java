package DAO.APIs;
import DTO.Contato_Endereco.EnderecoDTO;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.IOException;

public class CepFieldListener implements DocumentListener {
    private CepAPI cepAPI;
    private JFormattedTextField txtCep;
    private JTextField txtLogradouro;
    private JTextField txtBairro;
    private JTextField txtMunicipio;

    public CepFieldListener(JFormattedTextField txtCep, JTextField txtLogradouro, JTextField txtBairro, JTextField txtMunicipio) {
        this.cepAPI = new CepAPI();
        this.txtCep = txtCep;
        this.txtLogradouro = txtLogradouro;
        this.txtBairro = txtBairro;
        this.txtMunicipio = txtMunicipio;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        verificarCep();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        verificarCep();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        verificarCep();
    }

    private void verificarCep() {
        String cep = txtCep.getText().replaceAll("[^\\d]", "");

        if (cep.length() == 8) {
            try {
                EnderecoDTO enderecoDTO = cepAPI.getEndereco(cep);
                txtLogradouro.setText(enderecoDTO.getLogradouro());
                txtBairro.setText(enderecoDTO.getBairro());
                txtMunicipio.setText(enderecoDTO.getLocalidade());
            } catch (IOException e) {
                throw new RuntimeException("Erro ao consultar o CEP", e);
            } catch (InterruptedException e) {
                throw new RuntimeException("Operação interrompida", e);
            }
        }
    }
}

package Sistema.BackEnd.TelasPrincipais.Telas;

import DAO.Crud.EmpresaDAO;
import DAO.Vetores.CnaeDAO;
import DTO.Crud.EmpresaDTO;
import DTO.Vetores.CnaeDTO;
import DTO.Contato_Endereco.ContatoDTO;
import DTO.Vetores.DDD_DTO;
import DTO.Contato_Endereco.EnderecoDTO;
import DAO.Login.LoginDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CadastroEmpresa {
    // Componentes de interface

    private JTextField txtCNPJ, txtRazao_Social, txtNome_Fantasia, txtInscricao_Estadual, txtLogradouro, txtBairro, txtNumero, txtComplemento, txtCEP, txtMunicipio, txtTelefone, txtTelefone2, txtEmail;
    private JComboBox<String> cbxRegime_Tributario, cbxIndicador_IE, cbxCNAE_Principal, cbxDDD, cbxUF;

    // Vetores para armazenar IDs
    private Vector<Integer> idCNAE = new Vector<>();
    private Vector<Integer> idCNAE_Secundario = new Vector<>();
    private Vector<Integer> idContato = new Vector<>();
    private Vector<Integer> idDDD = new Vector<>();

    public CadastroEmpresa(JTextField txtCNPJ, JTextField txtRazao_Social, JTextField txtNome_Fantasia, JTextField txtInscricao_Estadual,
            JTextField txtLogradouro, JTextField txtBairro, JTextField txtNumero, JTextField txtComplemento, JTextField txtCEP,
            JTextField txtMunicipio, JTextField txtTelefone, JTextField txtTelefone2, JTextField txtEmail, JComboBox<String> cbxRegime_Tributario,
            JComboBox<String> cbxIndicador_IE, JComboBox<String> cbxCNAE_Principal, JComboBox<String> cbxDDD, JComboBox<String> cbxUF) {
        this.txtCNPJ = txtCNPJ;
        this.txtRazao_Social = txtRazao_Social;
        this.txtNome_Fantasia = txtNome_Fantasia;
        this.txtInscricao_Estadual = txtInscricao_Estadual;
        this.txtLogradouro = txtLogradouro;
        this.txtBairro = txtBairro;
        this.txtNumero = txtNumero;
        this.txtComplemento = txtComplemento;
        this.txtCEP = txtCEP;
        this.txtMunicipio = txtMunicipio;
        this.txtTelefone = txtTelefone;
        this.txtTelefone2 = txtTelefone2;
        this.txtEmail = txtEmail;
        this.cbxRegime_Tributario = cbxRegime_Tributario;
        this.cbxIndicador_IE = cbxIndicador_IE;
        this.cbxCNAE_Principal = cbxCNAE_Principal;
        this.cbxDDD = cbxDDD;
        this.cbxUF = cbxUF;
    }

    public void CadastrarLogin_Dados() {
        String CNPJ = txtCNPJ.getText();
        String Razao_Social = txtRazao_Social.getText();
        String Nome_Fantasia = txtNome_Fantasia.getText();
        String Regime_Tributario = (String) cbxRegime_Tributario.getSelectedItem();
        String Inscricao_Estadual = txtInscricao_Estadual.getText();
        String Indicador_IE = (String) cbxIndicador_IE.getSelectedItem();
        Calendar cal = Calendar.getInstance(); // Gerar data atual cadastro
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.get(Calendar.SECOND));
        Date Data_Cadastro = cal.getTime();
        Date Data_Modificacao = cal.getTime();

        int selectedDDD = cbxDDD.getSelectedIndex();
        int selectedCNAE = cbxCNAE_Principal.getSelectedIndex();
        if (selectedDDD <= 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma opção de DDD válida", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (selectedCNAE <= 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma opção de CNAE PRINCIPAL válida", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idDDD = this.idDDD.get(cbxDDD.getSelectedIndex() - 1);
        int idCNAE = this.idCNAE.get(cbxCNAE_Principal.getSelectedIndex() - 1);

        // Obter os dados de Endereço
        String Logradouro = txtLogradouro.getText();
        String Bairro = txtBairro.getText();
        String Numero = txtNumero.getText();
        String Complemento = txtComplemento.getText();
        String CEP = txtCEP.getText();
        String UF = (String) cbxUF.getSelectedItem();
        String Municipio = txtMunicipio.getText();
        // Obter os dados de Contato
        String Telefone = txtTelefone.getText();
        String Telefone2 = txtTelefone2.getText();
        String Email = txtEmail.getText();

        // Verificar se algum campo obrigatório está vazio
        if (CNPJ.isEmpty() || Razao_Social.isEmpty() || Nome_Fantasia.isEmpty() || Regime_Tributario.isEmpty() || Inscricao_Estadual.isEmpty()
                || Indicador_IE.isEmpty() || Logradouro.isEmpty() || Bairro.isEmpty() || Numero.isEmpty() || Complemento.isEmpty()
                || UF.isEmpty() || Municipio.isEmpty() || Telefone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Retorna sem executar o cadastro
        }
        // Verificar se todas as cbx foram selecionadas
        if (cbxCNAE_Principal.getSelectedIndex() == -1 || cbxDDD.getSelectedIndex() == -1
                || cbxIndicador_IE.getSelectedIndex() == -1 || cbxRegime_Tributario.getSelectedIndex() == -1
                || cbxUF.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Retorna sem executar o cadastro
        }

        // Validar o CNPJ
        if (!validarCNPJ(CNPJ)) {
            JOptionPane.showMessageDialog(null, "CNPJ inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Retorna sem executar o cadastro
        }

        // Formatar o CNPJ 
        CNPJ = formatarCNPJ(CNPJ);

        // Formatar o telefone
        String telefoneFormatado = formatarTelefone(txtTelefone.getText());
        String telefoneFormatado2 = formatarTelefone(txtTelefone2.getText());
        if (telefoneFormatado == null || telefoneFormatado2 == null) {
            JOptionPane.showMessageDialog(null, "Número de telefone inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Retorna sem executar o cadastro
        }
        // Validar o CEP
        if (!validarCEP(CEP)) {
            JOptionPane.showMessageDialog(null, "CEP inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Retorna sem executar o cadastro
        }
        // Formatar o CEP
        CEP = formatarCEP(CEP);

        // Criar e registrar o contato
        ContatoDTO objcontato = new ContatoDTO();
        objcontato.setIdDDD(idDDD);
        objcontato.setTelefone(telefoneFormatado);
        objcontato.setTelefone2(telefoneFormatado2);
        objcontato.setEmail(txtEmail.getText());

        // Criar e registrar o cadastro
        EmpresaDTO objcadastroEmpresa = new EmpresaDTO();
        objcadastroEmpresa.setCNPJ(CNPJ);
        objcadastroEmpresa.setRazao_Social(Razao_Social);
        objcadastroEmpresa.setNome_Fantasia(Nome_Fantasia);
        objcadastroEmpresa.setRegime_Tributario(Regime_Tributario);
        objcadastroEmpresa.setInscricao_Estadual(Inscricao_Estadual);
        objcadastroEmpresa.setIndicador_IE(Indicador_IE);
        objcadastroEmpresa.setIdCNAE(idCNAE);
        objcadastroEmpresa.setData_Cadastro(Data_Cadastro);
        objcadastroEmpresa.setData_Modificacao(Data_Modificacao);

        // Criar e registrar o Endereço
        EnderecoDTO objenderecodto = new EnderecoDTO();
        objenderecodto.setBairro(Bairro);
        objenderecodto.setCEP(CEP);
        objenderecodto.setComplemento(Complemento);
        objenderecodto.setLogradouro(Logradouro);
        objenderecodto.setMunicipio(Municipio);
        objenderecodto.setNumero(Numero);
        objenderecodto.setUF(UF);

        // Chamar o método para cadastrar todos os dados
        EmpresaDAO objcadastroEmpresaDAO = new EmpresaDAO();
        objcadastroEmpresaDAO.cadastrarUsuarioCompleto(objenderecodto, objcadastroEmpresa, objcontato);
    }

    public void restaurardadosComboBoxCNAE() {
        try {
            CnaeDTO objcnaedto = new CnaeDTO();
            CnaeDAO objcnaedao = new CnaeDAO();
            ResultSet rs = objcnaedao.ListarCNAE(objcnaedto);
            while (rs.next()) {
                idCNAE.addElement(rs.getInt(1));
                cbxCNAE_Principal.addItem(rs.getString(2));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "erro em restaurardadosComboBoxCNAE" + erro);
        }
    }

    public void restaurardadosComboBoxDDD() {
        try {
            DDD_DTO objddd_dto = new DDD_DTO();
            LoginDAO objddd_dao = new LoginDAO();
            ResultSet rs = objddd_dao.ListarDDD(objddd_dto);
            while (rs.next()) {
                idDDD.addElement(rs.getInt(1));
                cbxDDD.addItem(rs.getString(2));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "erro em restaurardadosComboBoxDDD" + erro);
        }
    }

// (VERIFICAR SE VOU COLOCAR ISSO OU NÃO)
//        public void restaurardadosComboBoxUF() { 
//            try {
//                EnderecoDTO objendereco = new EnderecoDTO();
//                EmpresaDAO objcadastro = new EmpresaDAO();
//                ResultSet rs = objcadastro.listarUF(objendereco);
//                while (rs.next()) {
//                    cbxUF.addItem(rs.getString(1));
//                }
//            } catch (SQLException erro) {
//                JOptionPane.showMessageDialog(null, "erro em restaurardadosComboBoxUF" + erro);
//            }
//        }
    public void restaurardadosComboBoxRegime_Tributario() {
        cbxRegime_Tributario.addItem("Simples Nacional");
        cbxRegime_Tributario.addItem("Simples Nacional - excesso de sublimite de receita bruta");
        cbxRegime_Tributario.addItem("Regime Normal");
    }

    public void restaurardadosComboBoxIndicador_IE() {
        cbxIndicador_IE.addItem("Contribuinte ICMS");
        cbxIndicador_IE.addItem("Contribuinte isento de Inscrição no cadastro de Contribuintes");
        cbxIndicador_IE.addItem("Não contribuinte");
    }

    private boolean validarCNPJ(String cnpj) {
        // Remove caracteres não numéricos
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // Verifica se o CNPJ possui 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }

        // Calcula e compara os dígitos verificadores
        int[] numerosCNPJ = new int[14];
        for (int i = 0; i < 14; i++) {
            numerosCNPJ[i] = Character.getNumericValue(cnpj.charAt(i));
        }

        int soma = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            soma += numerosCNPJ[i] * peso;
            peso++;
            if (peso == 10) {
                peso = 2;
            }
        }

        int digito1 = soma % 11;
        if (digito1 < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - digito1;
        }

        soma = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            soma += numerosCNPJ[i] * peso;
            peso++;
            if (peso == 10) {
                peso = 2;
            }
        }

        int digito2 = soma % 11;
        if (digito2 < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - digito2;
        }

        return (numerosCNPJ[12] == digito1 && numerosCNPJ[13] == digito2);
    }

    private String formatarCNPJ(String cnpj) {
        // Remove todos os caracteres não numéricos
        String apenasDigitos = cnpj.replaceAll("[^\\d]", "");

        // Verifica se o CNPJ possui 14 dígitos
        if (apenasDigitos.length() != 14) {
            return null; // Retorna null se o CNPJ não tiver 14 dígitos
        }

        // Formata o CNPJ no padrão desejado
        StringBuilder cnpjFormatado = new StringBuilder();
        cnpjFormatado.append(apenasDigitos.substring(0, 2)); // Primeiros 2 dígitos
        cnpjFormatado.append(".");
        cnpjFormatado.append(apenasDigitos.substring(2, 5)); // Próximos 3 dígitos
        cnpjFormatado.append(".");
        cnpjFormatado.append(apenasDigitos.substring(5, 8)); // Próximos 3 dígitos
        cnpjFormatado.append("/");
        cnpjFormatado.append(apenasDigitos.substring(8, 12)); // Próximos 4 dígitos
        cnpjFormatado.append("-");
        cnpjFormatado.append(apenasDigitos.substring(12)); // Últimos 2 dígitos

        return cnpjFormatado.toString();
    }

    private boolean validarCEP(String cep) {
        // Remove caracteres não numéricos
        cep = cep.replaceAll("[^0-9]", "");

        // Verifica se o CEP possui 8 dígitos
        return cep.length() == 8;
    }

    private String formatarCEP(String cep) {
        // Remove todos os caracteres não numéricos
        String apenasDigitos = cep.replaceAll("[^\\d]", "");

        // Verifica se o CEP possui 8 dígitos
        if (apenasDigitos.length() != 8) {
            return null; // Retorna null se o CEP não tiver 8 dígitos
        }

        // Formata o CEP no padrão desejado
        StringBuilder cepFormatado = new StringBuilder();
        cepFormatado.append(apenasDigitos.substring(0, 5)); // Primeiros 5 dígitos
        cepFormatado.append("-");
        cepFormatado.append(apenasDigitos.substring(5)); // Últimos 3 dígitos

        return cepFormatado.toString();
    }

    private String formatarTelefone(String telefone) {
        // Remove todos os caracteres não numéricos
        String apenasDigitos = telefone.replaceAll("[^\\d]", "");

        // Verifica se o telefone tem pelo menos 8 ou 9 dígitos
        if (apenasDigitos.length() < 8 || apenasDigitos.length() > 9) {
            return null; // retorna null se o número não for válido
        }

        // Formata o telefone no padrão desejado
        StringBuilder formatoTelefone = new StringBuilder();
        if (apenasDigitos.length() == 8) { // Número fixo
            formatoTelefone.append(apenasDigitos.substring(0, 4)); // Primeira parte do número
            formatoTelefone.append("-");
            formatoTelefone.append(apenasDigitos.substring(4)); // Segunda parte do número
        } else { // Número celular
            formatoTelefone.append(apenasDigitos.substring(0, 5)); // Primeira parte do número
            formatoTelefone.append("-");
            formatoTelefone.append(apenasDigitos.substring(5)); // Segunda parte do número
        }

        return formatoTelefone.toString();
    }
}

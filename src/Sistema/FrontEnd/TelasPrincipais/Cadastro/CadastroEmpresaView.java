package Sistema.FrontEnd.TelasPrincipais.Cadastro;

import DAO.APIs.CepFieldListener;
import DAO.Crud.EmpresaDAO;
import DAO.Vetores.CnaeDAO;
import DAO.Vetores.CnaeSecundarioDAO;
import DTO.Crud.EmpresaDTO;
import DTO.Vetores.CnaeDTO;
import DTO.Vetores.CnaeSecundarioDTO;
import DTO.Contato_Endereco.ContatoDTO;
import DTO.Vetores.DDD_DTO;
import DTO.Contato_Endereco.EnderecoDTO;
import DAO.Login.LoginDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class CadastroEmpresaView extends JDialog {
    
    private CepFieldListener cepListener;

    public CadastroEmpresaView(JFrame parent, String title, boolean modal) {
        super(parent, title, modal);
        initComponents();
        restaurarDadosComboBoxDDD();
        restaurardadosComboBoxCNAE();
        cepListener = new CepFieldListener(txtCep, txtLogradouro, txtBairro, txtMunicipio);
        txtCep.getDocument().addDocumentListener(cepListener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TeladeFundo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Contato = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblContato = new javax.swing.JLabel();
        cbxDDD = new javax.swing.JComboBox<>();
        lblDDD = new javax.swing.JLabel();
        txtTelefone2 = new javax.swing.JFormattedTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        Dados_da_Empresa = new javax.swing.JPanel();
        txtInscricao_Estadual = new javax.swing.JTextField();
        lbl_Inscricao_Estadual = new javax.swing.JLabel();
        lbl_Indicador_IE = new javax.swing.JLabel();
        cbxIndicador_IE = new javax.swing.JComboBox<>();
        cbxRegime_Tributario = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        lblCnpj = new javax.swing.JLabel();
        lblRazao_Social = new javax.swing.JLabel();
        txtRazao_Social = new javax.swing.JTextField();
        txtNome_Fantasia = new javax.swing.JTextField();
        lblNome_Fantasia = new javax.swing.JLabel();
        lblCnae_Principal = new javax.swing.JLabel();
        cbxCNAE_Principal = new javax.swing.JComboBox<>();
        txtCNPJ = new javax.swing.JFormattedTextField();
        Endereco = new javax.swing.JPanel();
        txtComplemento = new javax.swing.JTextField();
        lblComplemento = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        lblUF = new javax.swing.JLabel();
        lblMunicipio = new javax.swing.JLabel();
        cbxUF = new javax.swing.JComboBox<>();
        txtMunicipio = new javax.swing.JTextField();
        lblLogradouro = new javax.swing.JLabel();
        txtLogradouro = new javax.swing.JTextField();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtCep = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnCadastrar_Login = new javax.swing.JButton();
        btnLimpar_Campos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("WASHINGTON TECHNOLOGY - SISTEMA ÓTICA - VERSION 1.01.1");
        setUndecorated(true);

        TeladeFundo.setBackground(new java.awt.Color(255, 255, 255));
        TeladeFundo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        TeladeFundo.setForeground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, java.awt.Color.black, new java.awt.Color(0, 0, 0), null));

        Contato.setBackground(new java.awt.Color(255, 255, 255));
        Contato.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTATO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        lblEmail.setBackground(new java.awt.Color(255, 255, 255));
        lblEmail.setForeground(new java.awt.Color(0, 0, 0));
        lblEmail.setText("Email");

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));

        lblContato.setBackground(new java.awt.Color(255, 255, 255));
        lblContato.setForeground(new java.awt.Color(0, 0, 0));
        lblContato.setText("Contato");

        cbxDDD.setBackground(new java.awt.Color(255, 255, 255));
        cbxDDD.setForeground(new java.awt.Color(0, 0, 0));
        cbxDDD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbxDDD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblDDD.setBackground(new java.awt.Color(255, 255, 255));
        lblDDD.setForeground(new java.awt.Color(0, 0, 0));
        lblDDD.setText("DDD");

        txtTelefone2.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefone2.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtTelefone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTelefone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefone2ActionPerformed(evt);
            }
        });

        lblTelefone.setBackground(new java.awt.Color(255, 255, 255));
        lblTelefone.setForeground(new java.awt.Color(0, 0, 0));
        lblTelefone.setText("Telefone");

        txtTelefone.setBackground(new java.awt.Color(255, 255, 255));
        txtTelefone.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContatoLayout = new javax.swing.GroupLayout(Contato);
        Contato.setLayout(ContatoLayout);
        ContatoLayout.setHorizontalGroup(
            ContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContatoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(ContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ContatoLayout.createSequentialGroup()
                        .addGroup(ContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addGroup(ContatoLayout.createSequentialGroup()
                                .addGroup(ContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDDD)
                                    .addComponent(cbxDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(ContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblContato)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(ContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefone)))
                    .addComponent(txtEmail))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        ContatoLayout.setVerticalGroup(
            ContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContatoLayout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(ContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContato)
                    .addComponent(lblDDD)
                    .addComponent(lblTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        Dados_da_Empresa.setBackground(new java.awt.Color(255, 255, 255));
        Dados_da_Empresa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DADOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        txtInscricao_Estadual.setBackground(new java.awt.Color(255, 255, 255));
        txtInscricao_Estadual.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtInscricao_Estadual.setForeground(new java.awt.Color(0, 0, 0));

        lbl_Inscricao_Estadual.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Inscricao_Estadual.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Inscricao_Estadual.setText("Inscrição Estadual");

        lbl_Indicador_IE.setBackground(new java.awt.Color(255, 255, 255));
        lbl_Indicador_IE.setForeground(new java.awt.Color(0, 0, 0));
        lbl_Indicador_IE.setText("Indicador IE");

        cbxIndicador_IE.setBackground(new java.awt.Color(255, 255, 255));
        cbxIndicador_IE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxIndicador_IE.setForeground(new java.awt.Color(0, 0, 0));
        cbxIndicador_IE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Normal", "Produtor Rural", "Microempreendedor Individual (MEI)", "Substituto Tributário", "Isento" }));
        cbxIndicador_IE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxIndicador_IE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxIndicador_IEActionPerformed(evt);
            }
        });

        cbxRegime_Tributario.setBackground(new java.awt.Color(255, 255, 255));
        cbxRegime_Tributario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxRegime_Tributario.setForeground(new java.awt.Color(0, 0, 0));
        cbxRegime_Tributario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Simples Nacional", "Simples Nacional - Excesso de Sublimite de Receita", "Regime Normal" }));
        cbxRegime_Tributario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Regime Tributario");

        lblCnpj.setBackground(new java.awt.Color(255, 255, 255));
        lblCnpj.setForeground(new java.awt.Color(0, 0, 0));
        lblCnpj.setText("CNPJ");

        lblRazao_Social.setBackground(new java.awt.Color(255, 255, 255));
        lblRazao_Social.setForeground(new java.awt.Color(0, 0, 0));
        lblRazao_Social.setText("Razão Social");

        txtRazao_Social.setBackground(new java.awt.Color(255, 255, 255));
        txtRazao_Social.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtRazao_Social.setForeground(new java.awt.Color(0, 0, 0));
        txtRazao_Social.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazao_SocialActionPerformed(evt);
            }
        });

        txtNome_Fantasia.setBackground(new java.awt.Color(255, 255, 255));
        txtNome_Fantasia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNome_Fantasia.setForeground(new java.awt.Color(0, 0, 0));

        lblNome_Fantasia.setBackground(new java.awt.Color(255, 255, 255));
        lblNome_Fantasia.setForeground(new java.awt.Color(0, 0, 0));
        lblNome_Fantasia.setText("Nome Fantasia");

        lblCnae_Principal.setForeground(new java.awt.Color(0, 0, 0));
        lblCnae_Principal.setText("CNAE Principal");

        cbxCNAE_Principal.setBackground(new java.awt.Color(255, 255, 255));
        cbxCNAE_Principal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxCNAE_Principal.setForeground(new java.awt.Color(0, 0, 0));
        cbxCNAE_Principal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbxCNAE_Principal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtCNPJ.setBackground(new java.awt.Color(255, 255, 255));
        txtCNPJ.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCNPJ.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout Dados_da_EmpresaLayout = new javax.swing.GroupLayout(Dados_da_Empresa);
        Dados_da_Empresa.setLayout(Dados_da_EmpresaLayout);
        Dados_da_EmpresaLayout.setHorizontalGroup(
            Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dados_da_EmpresaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Dados_da_EmpresaLayout.createSequentialGroup()
                        .addGroup(Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxIndicador_IE, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Dados_da_EmpresaLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lbl_Indicador_IE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxRegime_Tributario, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Dados_da_EmpresaLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Inscricao_Estadual)
                            .addComponent(txtInscricao_Estadual)))
                    .addComponent(lblCnae_Principal)
                    .addComponent(cbxCNAE_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Dados_da_EmpresaLayout.createSequentialGroup()
                        .addGroup(Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCnpj)
                            .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Dados_da_EmpresaLayout.createSequentialGroup()
                                .addComponent(txtRazao_Social)
                                .addGap(12, 12, 12))
                            .addGroup(Dados_da_EmpresaLayout.createSequentialGroup()
                                .addComponent(lblRazao_Social)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome_Fantasia)
                            .addComponent(txtNome_Fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        Dados_da_EmpresaLayout.setVerticalGroup(
            Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Dados_da_EmpresaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRazao_Social)
                    .addComponent(lblNome_Fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCnpj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRazao_Social, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome_Fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbl_Indicador_IE)
                    .addComponent(lbl_Inscricao_Estadual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtInscricao_Estadual, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxRegime_Tributario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxIndicador_IE, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCnae_Principal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCNAE_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        Endereco.setBackground(new java.awt.Color(255, 255, 255));
        Endereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ENDEREÇO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        txtComplemento.setBackground(new java.awt.Color(255, 255, 255));
        txtComplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtComplemento.setForeground(new java.awt.Color(0, 0, 0));

        lblComplemento.setBackground(new java.awt.Color(255, 255, 255));
        lblComplemento.setForeground(new java.awt.Color(0, 0, 0));
        lblComplemento.setText("Complemento");

        lblCep.setBackground(new java.awt.Color(255, 255, 255));
        lblCep.setForeground(new java.awt.Color(0, 0, 0));
        lblCep.setText("CEP");

        lblUF.setBackground(new java.awt.Color(255, 255, 255));
        lblUF.setForeground(new java.awt.Color(0, 0, 0));
        lblUF.setText("UF");

        lblMunicipio.setBackground(new java.awt.Color(255, 255, 255));
        lblMunicipio.setForeground(new java.awt.Color(0, 0, 0));
        lblMunicipio.setText("MUNICIPIO");

        cbxUF.setBackground(new java.awt.Color(255, 255, 255));
        cbxUF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxUF.setForeground(new java.awt.Color(0, 0, 0));
        cbxUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "RO", "AC", "AM", "RR", "PA", "AP", "TO", "MA", "PI", "CE", "RN", "PB", "PE", "AL", "SE", "BA", "MG", "ES", "RJ", "SP", "PR", "SC", "RS", "MS", "MT", "GO", "DF" }));
        cbxUF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtMunicipio.setBackground(new java.awt.Color(255, 255, 255));
        txtMunicipio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtMunicipio.setForeground(new java.awt.Color(0, 0, 0));

        lblLogradouro.setBackground(new java.awt.Color(255, 255, 255));
        lblLogradouro.setForeground(new java.awt.Color(0, 0, 0));
        lblLogradouro.setText("Logradouro");

        txtLogradouro.setBackground(new java.awt.Color(255, 255, 255));
        txtLogradouro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtLogradouro.setForeground(new java.awt.Color(0, 0, 0));

        lblBairro.setBackground(new java.awt.Color(255, 255, 255));
        lblBairro.setForeground(new java.awt.Color(0, 0, 0));
        lblBairro.setText("Bairro");

        txtBairro.setBackground(new java.awt.Color(255, 255, 255));
        txtBairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBairro.setForeground(new java.awt.Color(0, 0, 0));

        lblNumero.setBackground(new java.awt.Color(255, 255, 255));
        lblNumero.setForeground(new java.awt.Color(0, 0, 0));
        lblNumero.setText("Numero");

        txtNumero.setBackground(new java.awt.Color(255, 255, 255));
        txtNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNumero.setForeground(new java.awt.Color(0, 0, 0));

        txtCep.setBackground(new java.awt.Color(255, 255, 255));
        txtCep.setForeground(new java.awt.Color(0, 0, 0));
        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout EnderecoLayout = new javax.swing.GroupLayout(Endereco);
        Endereco.setLayout(EnderecoLayout);
        EnderecoLayout.setHorizontalGroup(
            EnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLogradouro)
                    .addComponent(txtBairro)
                    .addGroup(EnderecoLayout.createSequentialGroup()
                        .addGroup(EnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogradouro)
                            .addComponent(lblBairro))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6)
                .addGroup(EnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EnderecoLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblUF)
                        .addGap(129, 129, 129)
                        .addComponent(lblMunicipio))
                    .addGroup(EnderecoLayout.createSequentialGroup()
                        .addGroup(EnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EnderecoLayout.createSequentialGroup()
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EnderecoLayout.createSequentialGroup()
                                .addComponent(lblNumero)
                                .addGap(79, 79, 79)
                                .addComponent(lblComplemento)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCep)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(EnderecoLayout.createSequentialGroup()
                        .addComponent(cbxUF, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        EnderecoLayout.setVerticalGroup(
            EnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumero)
                    .addGroup(EnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLogradouro)
                        .addComponent(lblCep)
                        .addComponent(lblComplemento)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(EnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBairro)
                    .addComponent(lblUF)
                    .addComponent(lblMunicipio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxUF, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Dados_da_Empresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Endereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Dados_da_Empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lblTitulo.setBackground(new java.awt.Color(51, 153, 255));
        lblTitulo.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("CADASTRO EMPRESA");

        btnExit.setBackground(new java.awt.Color(153, 0, 0));
        btnExit.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("X");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(322, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(293, 293, 293)
                .addComponent(btnExit))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCadastrar_Login.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastrar_Login.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCadastrar_Login.setForeground(new java.awt.Color(0, 0, 0));
        btnCadastrar_Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/registro.png"))); // NOI18N
        btnCadastrar_Login.setToolTipText("");
        btnCadastrar_Login.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        btnCadastrar_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrar_LoginActionPerformed(evt);
            }
        });

        btnLimpar_Campos.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpar_Campos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLimpar_Campos.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpar_Campos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/limpar-limpo.png"))); // NOI18N
        btnLimpar_Campos.setToolTipText("");
        btnLimpar_Campos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Limpar campos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        btnLimpar_Campos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar_Campos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar_CamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TeladeFundoLayout = new javax.swing.GroupLayout(TeladeFundo);
        TeladeFundo.setLayout(TeladeFundoLayout);
        TeladeFundoLayout.setHorizontalGroup(
            TeladeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TeladeFundoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(TeladeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TeladeFundoLayout.createSequentialGroup()
                        .addComponent(btnCadastrar_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnLimpar_Campos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        TeladeFundoLayout.setVerticalGroup(
            TeladeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeladeFundoLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TeladeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCadastrar_Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpar_Campos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TeladeFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TeladeFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1068, 900));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpar_CamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar_CamposActionPerformed
        // Limpar todos os campos
        LimparCampos();
    }//GEN-LAST:event_btnLimpar_CamposActionPerformed

    private void btnCadastrar_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrar_LoginActionPerformed
        // chamar tela cadastro
        CadastrarLogin_Dados();
    }//GEN-LAST:event_btnCadastrar_LoginActionPerformed

    private void cbxIndicador_IEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxIndicador_IEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxIndicador_IEActionPerformed

    private void txtRazao_SocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazao_SocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazao_SocialActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // fechar tela
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtTelefone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefone2ActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroEmpresaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroEmpresaView(null, "CadastroEmpresaView", true).setVisible(true);
            }
        });
    }

    public void ExibirSenha(JPasswordField txtSenha, JCheckBox chkVisualizarSenha) {
        // Adiciona a ação ao checkbox de visualização
        chkVisualizarSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSenha.setEchoChar(chkVisualizarSenha.isSelected() ? '\u0000' : '*');

            }
        });
    }

    private void CadastrarLogin_Dados() {
        String CNPJ, Razao_Social, Nome_Fantasia, Regime_Tributario, Inscricao_Estadual, Indicador_IE, Logradouro, Bairro, Numero, Complemento, CEP, UF, Municipio, Telefone, Email, Telefone2;
        Date Data_Cadastro, Data_Modificacao;
        int idDDD,idCNAE;

        // Obter os dados da empresa
        CNPJ = txtCNPJ.getText();
        Razao_Social = txtRazao_Social.getText();
        Nome_Fantasia = txtNome_Fantasia.getText();
        Regime_Tributario = (String) cbxRegime_Tributario.getSelectedItem();
        Inscricao_Estadual = txtInscricao_Estadual.getText();
        Indicador_IE = (String) cbxIndicador_IE.getSelectedItem();
        Calendar cal = Calendar.getInstance(); // gerar data atual cadastro
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.get(Calendar.SECOND));
        Data_Cadastro = cal.getTime();
        Data_Modificacao = cal.getTime();
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

        idDDD = this.idDDD.get(cbxDDD.getSelectedIndex() - 1);
        idCNAE = this.idCNAE.get(cbxCNAE_Principal.getSelectedIndex() - 1);

        // Obter os dados de Endereço
        Logradouro = txtLogradouro.getText();
        Bairro = txtBairro.getText();
        Numero = txtNumero.getText();
        Complemento = txtComplemento.getText();
        CEP = txtCep.getText();
        UF = (String) cbxUF.getSelectedItem();
        Municipio = txtMunicipio.getText();
        // Obter os dados de Contato
        Telefone = txtTelefone.getText();
        Telefone2 = txtTelefone2.getText();
        Email = txtEmail.getText();

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

        }

        // Validar o CPF
        if (!validarCNPJ(CNPJ)) {
            JOptionPane.showMessageDialog(null, "CNPJ inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return; // Retorna sem executar o cadastro
        }

        // Formatar o CPF 
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
            return;

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

    Vector<Integer> idCNAE = new Vector<Integer>();

    private void restaurardadosComboBoxCNAE() {
        try {
            CnaeDTO objcnaedto = new CnaeDTO();
            CnaeDAO objcnaedao = new CnaeDAO();
            ResultSet rs = objcnaedao.ListarCNAE(objcnaedto);
            while (rs.next()) {
                idCNAE.addElement(rs.getInt(1));
                cbxCNAE_Principal.addItem(rs.getString(2));

            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "erro em restaurar dados da cbx CNAE" + erro);
        }
    }
    Vector<Integer> idCNAE_Secundario = new Vector<Integer>();

    private void restaurardadosComboBoxCNAESecundario() {
        try {
            CnaeSecundarioDTO objCnaeSecundarioDTO = new CnaeSecundarioDTO();
            CnaeSecundarioDAO objCnaeSecundarioDAO = new CnaeSecundarioDAO();
            ResultSet rs = objCnaeSecundarioDAO.ListarCNAEsecundario(objCnaeSecundarioDTO);
            while (rs.next()) {
                idCNAE_Secundario.addElement(rs.getInt(1));
//                cbxCNAE_Secundario.addItem(rs.getString(2));

            }
            idCNAE_Secundario.addElement(-1);

        } catch (Exception e) {
        }
    }

    Vector<Integer> idContato = new Vector<Integer>();

    private void restaurarDadosdatabelaContatos() {
        try {
            ContatoDTO objcontatodto = new ContatoDTO();
            LoginDAO objlogindao = new LoginDAO();
            ResultSet rs = objlogindao.ListarContatos(objcontatodto);
            while (rs.next()) {
                idContato.addElement(rs.getInt(1));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "erro em restaurar dados da tabela contato" + erro);
        }
    }
    Vector<Integer> idDDD = new Vector<Integer>();

    private void restaurarDadosComboBoxDDD() {

        try {
            DDD_DTO objddddto = new DDD_DTO();
            LoginDAO objlogindao = new LoginDAO();
            ResultSet rs = objlogindao.ListarDDD(objddddto);
            while (rs.next()) {

                idDDD.addElement(rs.getInt(1));
                cbxDDD.addItem(rs.getString(2));

            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro em restaurarcbxDDD " + erro);
        }
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

    public void LimparCampos() {
        txtRazao_Social.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtCNPJ.setText("");
        txtBairro.setText("");
        txtCep.setText("");
        txtLogradouro.setText("");
        txtNumero.setText("");
        txtInscricao_Estadual.setText("");
        txtComplemento.setText("");
        txtNome_Fantasia.setText("");
        cbxCNAE_Principal.setSelectedIndex(0);
        cbxDDD.setSelectedIndex(0);
        cbxIndicador_IE.setSelectedIndex(0);
        cbxRegime_Tributario.setSelectedIndex(0);
        cbxUF.setSelectedIndex(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contato;
    private javax.swing.JPanel Dados_da_Empresa;
    private javax.swing.JPanel Endereco;
    private javax.swing.JPanel TeladeFundo;
    private javax.swing.JButton btnCadastrar_Login;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLimpar_Campos;
    private javax.swing.JComboBox<String> cbxCNAE_Principal;
    private javax.swing.JComboBox<String> cbxDDD;
    private javax.swing.JComboBox<String> cbxIndicador_IE;
    private javax.swing.JComboBox<String> cbxRegime_Tributario;
    private javax.swing.JComboBox<String> cbxUF;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCnae_Principal;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblComplemento;
    private javax.swing.JLabel lblContato;
    private javax.swing.JLabel lblDDD;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLogradouro;
    private javax.swing.JLabel lblMunicipio;
    private javax.swing.JLabel lblNome_Fantasia;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblRazao_Social;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUF;
    private javax.swing.JLabel lbl_Indicador_IE;
    private javax.swing.JLabel lbl_Inscricao_Estadual;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtInscricao_Estadual;
    private javax.swing.JTextField txtLogradouro;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNome_Fantasia;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRazao_Social;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JFormattedTextField txtTelefone2;
    // End of variables declaration//GEN-END:variables
}

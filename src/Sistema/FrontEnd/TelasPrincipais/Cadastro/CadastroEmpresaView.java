package Sistema.FrontEnd.TelasPrincipais.Cadastro;

import DAO.APIs.CepFieldListener;
import DAO.Vetores.VetorCnae;
import DAO.Vetores.VetorDdd;
import DTO.Crud.EmpresaDTO;
import Sistema.BackEnd.NotaFiscal.Config;
import Sistema.BackEnd.NotaFiscal.ConsultaCadastro;
import Sistema.BackEnd.TelasPrincipais.Crud.ConfiguracaoService;
import Sistema.BackEnd.TelasPrincipais.Crud.Empresa;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import java.io.File;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CadastroEmpresaView extends JDialog {

    private CepFieldListener cepListener;
    private Empresa empresa;
    private String caminhoCertificado;
    private char[] senhaCertificado = "suaSenhaDoCertificado".toCharArray(); // Defina a senha do certificado
    private ConfiguracoesNfe configuracoesNfe;
    private Config Config;
    private ConfiguracaoService configuracaoService;
    private VetorCnae vetorCnae;
    private VetorDdd vetorDDD;

    public CadastroEmpresaView(JFrame parent, String title, boolean modal) {
        super(parent, title, modal);
        initComponents();
        vetorCnae = new VetorCnae(cbxCnaePrincipal);
        vetorCnae.restaurardadosComboBoxCNAE();
        vetorDDD = new VetorDdd(cbxDDD);
        vetorDDD.restaurarDadosCbxDDD();
        cepListener = new CepFieldListener(txtCep, txtLogradouro, txtBairro, txtMunicipio);
        txtCep.getDocument().addDocumentListener(cepListener);
        configurarComboBoxes();

    }

    private void configurarComboBoxes() {
        // Configura o JComboBox cbxEstado com os valores de EstadosEnum
        cbxEstado.removeAllItems();
        for (EstadosEnum estado : EstadosEnum.values()) {
            cbxEstado.addItem(estado);
        }

        // Configura o JComboBox cbxAmbiente com os valores de AmbienteEnum (Produção e Homologação)
        cbxAmbiente.removeAllItems();
        cbxAmbiente.addItem(AmbienteEnum.PRODUCAO);
        cbxAmbiente.addItem(AmbienteEnum.HOMOLOGACAO);
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
        cbxCnaePrincipal = new javax.swing.JComboBox<>();
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
        Certificado = new javax.swing.JPanel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbxAmbiente = new javax.swing.JComboBox<>();
        btnCertificado = new javax.swing.JButton();
        lblUrlCertificado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();

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
                .addContainerGap(52, Short.MAX_VALUE))
        );
        ContatoLayout.setVerticalGroup(
            ContatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContatoLayout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
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

        cbxCnaePrincipal.setBackground(new java.awt.Color(255, 255, 255));
        cbxCnaePrincipal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxCnaePrincipal.setForeground(new java.awt.Color(0, 0, 0));
        cbxCnaePrincipal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbxCnaePrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
                            .addComponent(lbl_Indicador_IE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxRegime_Tributario, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Dados_da_EmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Inscricao_Estadual)
                            .addComponent(txtInscricao_Estadual)))
                    .addComponent(lblCnae_Principal)
                    .addComponent(cbxCnaePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(cbxCnaePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        Certificado.setBackground(new java.awt.Color(255, 255, 255));
        Certificado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CERTIFICADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        txtSenha.setBackground(new java.awt.Color(255, 255, 255));
        txtSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Senha");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Estado");

        cbxEstado.setBackground(new java.awt.Color(255, 255, 255));
        cbxEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxEstado.setForeground(new java.awt.Color(0, 0, 0));
        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Ambiente");

        cbxAmbiente.setBackground(new java.awt.Color(255, 255, 255));
        cbxAmbiente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxAmbiente.setForeground(new java.awt.Color(0, 0, 0));
        cbxAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAmbienteActionPerformed(evt);
            }
        });

        btnCertificado.setBackground(new java.awt.Color(255, 255, 255));
        btnCertificado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCertificado.setForeground(new java.awt.Color(0, 0, 0));
        btnCertificado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/update.png"))); // NOI18N
        btnCertificado.setToolTipText("");
        btnCertificado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carregar Certificado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        btnCertificado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCertificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCertificadoActionPerformed(evt);
            }
        });

        lblUrlCertificado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblUrlCertificado.setForeground(new java.awt.Color(0, 0, 0));
        lblUrlCertificado.setText("<html>URL <br> CERTIFICADO.<br></html>");

        javax.swing.GroupLayout CertificadoLayout = new javax.swing.GroupLayout(Certificado);
        Certificado.setLayout(CertificadoLayout);
        CertificadoLayout.setHorizontalGroup(
            CertificadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CertificadoLayout.createSequentialGroup()
                .addGroup(CertificadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CertificadoLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE))
                    .addGroup(CertificadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblUrlCertificado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(CertificadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CertificadoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(jLabel5))
                .addGap(38, 38, 38))
            .addGroup(CertificadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CertificadoLayout.createSequentialGroup()
                    .addGap(237, 237, 237)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );
        CertificadoLayout.setVerticalGroup(
            CertificadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CertificadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CertificadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CertificadoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CertificadoLayout.createSequentialGroup()
                        .addComponent(btnCertificado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUrlCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(CertificadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CertificadoLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(216, 216, 216)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Dados_da_Empresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Certificado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Contato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Certificado, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
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

        btnCadastrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(0, 0, 0));
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/registro.png"))); // NOI18N
        btnCadastrar.setToolTipText("");
        btnCadastrar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        btnCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimparCampos.setBackground(new java.awt.Color(255, 255, 255));
        btnLimparCampos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLimparCampos.setForeground(new java.awt.Color(0, 0, 0));
        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/limpar-limpo.png"))); // NOI18N
        btnLimparCampos.setToolTipText("");
        btnLimparCampos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Limpar campos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        btnLimparCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
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
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimparCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(1068, 1019));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        // Limpar todos os campos
        LimparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // chamar tela cadastro
        cadastrarEmpresa();
    }//GEN-LAST:event_btnCadastrarActionPerformed

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

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void cbxAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAmbienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAmbienteActionPerformed

    private void btnCertificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificadoActionPerformed
        // carregar certificado
        carregarCertificado();
    }//GEN-LAST:event_btnCertificadoActionPerformed

    public static void main(String args[]) {
        mostrarDadosEmpresas();
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroEmpresaView(null, "CadastroEmpresaView", true).setVisible(true);
            }
        });
    }

    public void carregarCertificado() {
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Selecionar arquivo de certificado");
        jfc.setFileFilter(new FileNameExtensionFilter("Certificado (*.PFX)", "pfx"));
        int resultado = jfc.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = jfc.getSelectedFile();
            caminhoCertificado = arquivoSelecionado.getAbsolutePath();

            String senhaCertificado = new String(txtSenha.getPassword());
            EstadosEnum estadoSelecionado = (EstadosEnum) cbxEstado.getSelectedItem();
            AmbienteEnum ambienteSelecionado = (AmbienteEnum) cbxAmbiente.getSelectedItem();

            try {
                ConfiguracoesNfe configuracoes = Config.configurarCertificado(caminhoCertificado, senhaCertificado, estadoSelecionado, ambienteSelecionado);

                // Passa as configurações para o objeto de consulta
                ConsultaCadastro consultaCadastro = new ConsultaCadastro();
                consultaCadastro.setConfiguracoes(configuracoes);

                JOptionPane.showMessageDialog(this, "Configuração concluída com sucesso.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao configurar: " + ex.getMessage());
            }
        }
    }

    public static void mostrarDadosEmpresas() {
        ConsultaCadastro consultaCadastro = new ConsultaCadastro();
        List<EmpresaDTO> empresas = consultaCadastro.getEmpresasConsultadas();

        empresas.forEach(empresa -> {
            System.out.println("Razão Social: " + empresa.getRazaoSocial());
            System.out.println("CNPJ: " + empresa.getCnpj());
            System.out.println("Inscrição Estadual: " + empresa.getInscricaoEstadual());
            System.out.println("------------------------------");
        });
    }

    private void cadastrarEmpresa() {

        // Obter os dados da empresa
        String cnpj = txtCNPJ.getText();
        String razaoSocial = txtRazao_Social.getText();
        String nomeFantasia = txtNome_Fantasia.getText();
        String regimeTributario = (String) cbxRegime_Tributario.getSelectedItem();
        String inscricaoEstadual = txtInscricao_Estadual.getText();
        String indicadorIE = (String) cbxIndicador_IE.getSelectedItem();
        int idCNAE = cbxCnaePrincipal.getSelectedIndex();
        int idDDD = cbxDDD.getSelectedIndex();

        // Obter os dados de Endereço
        String logradouro = txtLogradouro.getText();
        String bairro = txtBairro.getText();
        String numero = txtNumero.getText();
        String complemento = txtComplemento.getText();
        String cep = txtCep.getText();
        String uf = (String) cbxUF.getSelectedItem();
        String municipio = txtMunicipio.getText();

        // Obter os dados de Contato
        String telefone = txtTelefone.getText();
        String telefone2 = txtTelefone2.getText();
        String email = txtEmail.getText();

        String certificado = caminhoCertificado;
        String senha = txtSenha.getText();
        String estado = cbxEstado.getSelectedItem().toString();
        String ambiente = cbxAmbiente.getSelectedItem().toString();

        empresa = new Empresa(idCNAE, cnpj, razaoSocial, nomeFantasia, regimeTributario, inscricaoEstadual, indicadorIE, idDDD, logradouro, bairro, numero, complemento, cep, uf, municipio, telefone, telefone2, email, certificado, senha, estado, ambiente);
        empresa.cadastrar();
    }

    private void cadastrarCertificado() {
        String certificado = caminhoCertificado;
        String senha = txtSenha.getText();
        String estado = cbxEstado.getSelectedItem().toString();
        String ambiente = cbxAmbiente.getSelectedItem().toString();

        configuracaoService = new ConfiguracaoService(certificado, senha, estado, ambiente);
        configuracaoService.cadastrarConfiguracao();
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
        cbxCnaePrincipal.setSelectedIndex(0);
        cbxDDD.setSelectedIndex(0);
        cbxIndicador_IE.setSelectedIndex(0);
        cbxRegime_Tributario.setSelectedIndex(0);
        cbxUF.setSelectedIndex(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Certificado;
    private javax.swing.JPanel Contato;
    private javax.swing.JPanel Dados_da_Empresa;
    private javax.swing.JPanel Endereco;
    private javax.swing.JPanel TeladeFundo;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCertificado;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JComboBox<AmbienteEnum> cbxAmbiente;
    private javax.swing.JComboBox<String> cbxCnaePrincipal;
    private javax.swing.JComboBox<String> cbxDDD;
    private javax.swing.JComboBox<EstadosEnum> cbxEstado;
    private javax.swing.JComboBox<String> cbxIndicador_IE;
    private javax.swing.JComboBox<String> cbxRegime_Tributario;
    private javax.swing.JComboBox<String> cbxUF;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JLabel lblUrlCertificado;
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
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JFormattedTextField txtTelefone2;
    // End of variables declaration//GEN-END:variables
}

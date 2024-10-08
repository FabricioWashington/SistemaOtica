package Sistema.FrontEnd.TelasPrincipais.Telas;

import Sistema.BackEnd.TelasInicio.Login.UsuarioLogado;
import Sistema.FrontEnd.TelasInicio.LoginView;
import static Sistema.FrontEnd.TelasPrincipais.Estoque.ControleDeEstoqueView.btnECF;
import static Sistema.FrontEnd.TelasPrincipais.Estoque.ControleDeEstoqueView.btnFinanceiro_Auditoria;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class OrdemServicoView extends javax.swing.JFrame {

    private UsuarioLogado usuarioLogado;
    private Timer timer;

    public OrdemServicoView() {

    }

    public OrdemServicoView(UsuarioLogado usuarioLogado) {
        initComponents();
        updateDateTime(); //atualiza data e hora
        setExtendedState(MAXIMIZED_BOTH);

        // mostra o nome e o tipo de acesso do usuario
        this.usuarioLogado = usuarioLogado;
        lblUsuario.setText(usuarioLogado.getNomeUsuario());
        lblAcesso.setText(usuarioLogado.getTipoAcesso());
        verificarRestricoes(usuarioLogado);

        List<JButton> botoes = Arrays.asList(btnCadastro, btnCaixa, btnCaixa, btnECF, btnEntradas_Saidas, btnEstoque,
                btnFinanceiro_Auditoria, btnHome, btnNFC, btnOS, btnRelatorio_Gerencial, btnVendas, btnLogout);

        for (JButton btn : botoes) {
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(new Color(0, 51, 153));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(null);
                }

            });

            timer = new Timer(1000, e -> updateDateTime());
            timer.start();
        }
    }

    public void verificarRestricoes(UsuarioLogado usuarioLogado) {
        // Componentes a serem escondidos para funcionários na tela de Cadastro
        List<Component> componentesParaEsconder = Arrays.asList(btnECF, btnFinanceiro_Auditoria);

        // Aplica as restrições
        usuarioLogado.aplicarRestricoesFuncionarios(componentesParaEsconder, null, null, null, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        painelPrincipal = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnCaixa = new javax.swing.JButton();
        btnCadastro = new javax.swing.JButton();
        btnNFC = new javax.swing.JButton();
        btnEstoque = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblAcesso = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnOS = new javax.swing.JButton();
        btnRelatorio_Gerencial = new javax.swing.JButton();
        btnVendas = new javax.swing.JButton();
        btnECF = new javax.swing.JButton();
        btnFinanceiro_Auditoria = new javax.swing.JButton();
        btnEntradas_Saidas = new javax.swing.JButton();
        lblHora = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        painelMenu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cabecalho1 = new Sistema.FrontEnd.Componentes.Swing.Cabecalho();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jButton5.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WASHINGTON TECHNOLOGY - SISTEMA ÓTICA - VERSION 1.01.1");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        painelPrincipal.setBackground(new java.awt.Color(0, 102, 204));
        painelPrincipal.setForeground(new java.awt.Color(0, 102, 204));

        btnHome.setBackground(new java.awt.Color(0, 102, 204));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/botao-de-inicio.png"))); // NOI18N
        btnHome.setText("HOME");
        btnHome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnCaixa.setBackground(new java.awt.Color(0, 102, 204));
        btnCaixa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCaixa.setForeground(new java.awt.Color(255, 255, 255));
        btnCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/caixa-eletronico.png"))); // NOI18N
        btnCaixa.setText("CAIXA");
        btnCaixa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnCaixa.setHideActionText(true);
        btnCaixa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCaixa.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaixaActionPerformed(evt);
            }
        });

        btnCadastro.setBackground(new java.awt.Color(0, 102, 204));
        btnCadastro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastro.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/notes_768818.png"))); // NOI18N
        btnCadastro.setText("CADASTRO");
        btnCadastro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnCadastro.setHideActionText(true);
        btnCadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCadastro.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        btnNFC.setBackground(new java.awt.Color(0, 102, 204));
        btnNFC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNFC.setForeground(new java.awt.Color(255, 255, 255));
        btnNFC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/dollar_407133.png"))); // NOI18N
        btnNFC.setText("NFCe/NFe");
        btnNFC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnNFC.setHideActionText(true);
        btnNFC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNFC.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNFCActionPerformed(evt);
            }
        });

        btnEstoque.setBackground(new java.awt.Color(0, 102, 204));
        btnEstoque.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEstoque.setForeground(new java.awt.Color(255, 255, 255));
        btnEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/ready-stock_4947506.png"))); // NOI18N
        btnEstoque.setText("ESTOQUE");
        btnEstoque.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnEstoque.setHideActionText(true);
        btnEstoque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEstoque.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstoqueActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));

        lblUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lblUsuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Fabrício");

        lblAcesso.setBackground(new java.awt.Color(255, 255, 255));
        lblAcesso.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblAcesso.setForeground(new java.awt.Color(255, 255, 255));
        lblAcesso.setText("ADMIN");

        btnLogout.setBackground(new java.awt.Color(0, 102, 204));
        btnLogout.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/password_12795740.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/user_1144709.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblAcesso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblUsuario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAcesso))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnOS.setBackground(new java.awt.Color(0, 102, 204));
        btnOS.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOS.setForeground(new java.awt.Color(255, 255, 255));
        btnOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/servico-de-gestao.png"))); // NOI18N
        btnOS.setText("ORDEM SERVIÇO");
        btnOS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnOS.setHideActionText(true);
        btnOS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOS.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOSActionPerformed(evt);
            }
        });

        btnRelatorio_Gerencial.setBackground(new java.awt.Color(0, 102, 204));
        btnRelatorio_Gerencial.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRelatorio_Gerencial.setForeground(new java.awt.Color(255, 255, 255));
        btnRelatorio_Gerencial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/grafico-preditivo.png"))); // NOI18N
        btnRelatorio_Gerencial.setText("RELATORIO GERENCIAL");
        btnRelatorio_Gerencial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnRelatorio_Gerencial.setHideActionText(true);
        btnRelatorio_Gerencial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRelatorio_Gerencial.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRelatorio_Gerencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorio_GerencialActionPerformed(evt);
            }
        });

        btnVendas.setBackground(new java.awt.Color(0, 102, 204));
        btnVendas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVendas.setForeground(new java.awt.Color(255, 255, 255));
        btnVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/vendedor.png"))); // NOI18N
        btnVendas.setText("VENDAS");
        btnVendas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnVendas.setHideActionText(true);
        btnVendas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVendas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasActionPerformed(evt);
            }
        });

        btnECF.setBackground(new java.awt.Color(0, 102, 204));
        btnECF.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnECF.setForeground(new java.awt.Color(255, 255, 255));
        btnECF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/business-graphic_4008604.png"))); // NOI18N
        btnECF.setText("ECF");
        btnECF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnECF.setHideActionText(true);
        btnECF.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnECF.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnECF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnECFActionPerformed(evt);
            }
        });

        btnFinanceiro_Auditoria.setBackground(new java.awt.Color(0, 102, 204));
        btnFinanceiro_Auditoria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnFinanceiro_Auditoria.setForeground(new java.awt.Color(255, 255, 255));
        btnFinanceiro_Auditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/fluxo-de-caixa.png"))); // NOI18N
        btnFinanceiro_Auditoria.setText("FINANCEIRO");
        btnFinanceiro_Auditoria.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnFinanceiro_Auditoria.setHideActionText(true);
        btnFinanceiro_Auditoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFinanceiro_Auditoria.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFinanceiro_Auditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinanceiro_AuditoriaActionPerformed(evt);
            }
        });

        btnEntradas_Saidas.setBackground(new java.awt.Color(0, 102, 204));
        btnEntradas_Saidas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEntradas_Saidas.setForeground(new java.awt.Color(255, 255, 255));
        btnEntradas_Saidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/produtos.png"))); // NOI18N
        btnEntradas_Saidas.setText("MOVIMENTAÇÃO");
        btnEntradas_Saidas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnEntradas_Saidas.setHideActionText(true);
        btnEntradas_Saidas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEntradas_Saidas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEntradas_Saidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradas_SaidasActionPerformed(evt);
            }
        });

        lblHora.setBackground(new java.awt.Color(255, 255, 255));
        lblHora.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));

        lblData.setBackground(new java.awt.Color(255, 255, 255));
        lblData.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DATA");

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNFC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRelatorio_Gerencial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnECF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFinanceiro_Auditoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEntradas_Saidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelPrincipalLayout.createSequentialGroup()
                        .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNFC, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOS, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRelatorio_Gerencial, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnECF, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinanceiro_Auditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntradas_Saidas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setToolTipText("");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setToolTipText("");

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setForeground(new java.awt.Color(0, 0, 0));
        jButton10.setToolTipText("");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cadastrar O.S");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("<html> <center> Cadastrar <br/> Receita Medica </html>\n");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText(" O.S");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Receita Medica");

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setToolTipText("");

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));

        painelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/menu.png"))); // NOI18N
        painelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        painelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelMenuMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("> O.S");

        cabecalho1.setBackground(new java.awt.Color(153, 153, 153));
        cabecalho1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cabecalho1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/engrenagem.png"))); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/notificacao.png"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelMenu)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cabecalho1, javax.swing.GroupLayout.PREFERRED_SIZE, 1037, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(cabecalho1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(painelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel5)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addContainerGap())
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1515, 827));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // substitui a label por uma data atual
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));

    }//GEN-LAST:event_formWindowActivated

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // chamar tela Inicial
        HomeView homeView = new HomeView(usuarioLogado);
        homeView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed
        // chamar tela caixa
        CaixaView caixaView = new CaixaView(usuarioLogado);
        caixaView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCaixaActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        // chamar tela cadastro
        CadastroView cadastroView = new CadastroView(usuarioLogado);
        cadastroView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnNFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNFCActionPerformed
        // chamar tela nota fiscal
        NotaFiscalView notaFiscalView = new NotaFiscalView(usuarioLogado);
        notaFiscalView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnNFCActionPerformed

    private void btnEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstoqueActionPerformed
        // chamar tela estoque
        EstoqueView estoqueView = new EstoqueView(usuarioLogado);
        estoqueView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEstoqueActionPerformed

    private void btnOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOSActionPerformed
        // tela ordem serviço
        OrdemServicoView ordemServicoView = new OrdemServicoView(usuarioLogado);
        ordemServicoView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnOSActionPerformed

    private void btnRelatorio_GerencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorio_GerencialActionPerformed
        // chamar tela relatorio gerencial
        RelatorioGerencialView relatorioGerencialView = new RelatorioGerencialView(usuarioLogado);
        relatorioGerencialView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRelatorio_GerencialActionPerformed

    private void btnVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasActionPerformed
        // chamar tela vendas
        VendasView vendasView = new VendasView(usuarioLogado);
        vendasView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVendasActionPerformed

    private void btnECFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnECFActionPerformed
        // chamar tela ECF
        ECFView ecfView = new ECFView(usuarioLogado);
        ecfView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnECFActionPerformed

    private void btnFinanceiro_AuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinanceiro_AuditoriaActionPerformed
        // chamar tela financeiro auditoria
        FinanceiroAuditoriaView financerioAuditoriaView = new FinanceiroAuditoriaView(usuarioLogado);
        financerioAuditoriaView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnFinanceiro_AuditoriaActionPerformed

    private void btnEntradas_SaidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradas_SaidasActionPerformed
        // chamar tela entradas e saidas de produtos
        MovimentacaoView movimentacao = new MovimentacaoView(usuarioLogado);
        movimentacao.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEntradas_SaidasActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // Chamar tela LoginView (logout) deslogar
        String[] options = {"Sim", "Não"};
        int response = JOptionPane.showOptionDialog(this,
                "Realmente deseja deslogar da sua conta?",
                "Confirmação de Logout",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (response == 0) { // Se o usuário clicar em "Sim"
            LoginView objloginview = new LoginView();
            objloginview.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void painelMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelMenuMouseClicked
        // Verifica o tamanho atual do painelPrincipal
        boolean Visible = painelPrincipal.isVisible();

        // Define o novo tamanho dependendo do tamanho atual
        if (Visible) {
            painelPrincipal.setVisible(false);
        } else {
            painelPrincipal.setVisible(true);
        }

        // Atualiza o layout do painel para aplicar a mudança de tamanho
        painelPrincipal.revalidate();
        painelPrincipal.repaint();
    }//GEN-LAST:event_painelMenuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrdemServicoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrdemServicoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrdemServicoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrdemServicoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrdemServicoView().setVisible(true);
            }
        });
    }

    private void updateDateTime() {
        // Atualiza a label com a data e hora atuais
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");
        lblHora.setText(formatador.format(data));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCadastro;
    public static javax.swing.JButton btnCaixa;
    public static javax.swing.JButton btnECF;
    public static javax.swing.JButton btnEntradas_Saidas;
    public static javax.swing.JButton btnEstoque;
    public static javax.swing.JButton btnFinanceiro_Auditoria;
    public static javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    public static javax.swing.JButton btnNFC;
    public static javax.swing.JButton btnOS;
    public static javax.swing.JButton btnRelatorio_Gerencial;
    public static javax.swing.JButton btnVendas;
    private Sistema.FrontEnd.Componentes.Swing.Cabecalho cabecalho1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public static javax.swing.JLabel lblAcesso;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel painelMenu;
    private javax.swing.JPanel painelPrincipal;
    // End of variables declaration//GEN-END:variables
}

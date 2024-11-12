package Sistema.FrontEnd.Componentes.Swing;

import Sistema.FrontEnd.TelasPrincipais.Telas.CadastroView;
import Sistema.FrontEnd.TelasPrincipais.Telas.CaixaView;
import Sistema.FrontEnd.TelasPrincipais.Telas.ECFView;
import Sistema.FrontEnd.TelasPrincipais.Telas.MovimentacaoView;
import Sistema.FrontEnd.TelasPrincipais.Telas.EstoqueView;
import Sistema.FrontEnd.TelasPrincipais.Telas.FinanceiroAuditoriaView;
import Sistema.FrontEnd.TelasPrincipais.Telas.HomeView;
import static Sistema.FrontEnd.TelasPrincipais.Telas.HomeView.btnLogout;
import Sistema.FrontEnd.TelasPrincipais.Telas.NotaFiscalView;
import Sistema.FrontEnd.TelasPrincipais.Telas.OrdemServicoView;
import Sistema.FrontEnd.TelasPrincipais.Telas.RelatorioGerencialView;
import Sistema.FrontEnd.TelasPrincipais.Telas.VendasView;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

public class PainelPrincipal extends javax.swing.JPanel {

    public static String usuarioLogado;
    public static String tipoAcesso;
    private Timer timer;
    private JButton btnLogout;
    private JLabel lblUsuario;
    private JLabel lblAcesso;

    public PainelPrincipal() {
        initComponents();
        updateDateTime();
        lblUsuario = new JLabel("Usuario");
        lblAcesso = new JLabel("Acesso");
        btnLogout = new JButton("Logout");
        setUsuarioLabel();
        
        this.add(lblUsuario);
        this.add(lblAcesso);
        this.add(btnLogout);

        updateDate();
        aplicarRestricoesParaFuncionario();

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnCaixa = new javax.swing.JButton();
        btnCadastro = new javax.swing.JButton();
        btnNFC = new javax.swing.JButton();
        btnEstoque = new javax.swing.JButton();
        btnOS = new javax.swing.JButton();
        btnRelatorio_Gerencial = new javax.swing.JButton();
        btnVendas = new javax.swing.JButton();
        btnECF = new javax.swing.JButton();
        btnFinanceiro_Auditoria = new javax.swing.JButton();
        btnEntradas_Saidas = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        profilePrincipal1 = new Sistema.FrontEnd.Componentes.Swing.ProfilePrincipal();

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        btnHome.setBackground(new java.awt.Color(0, 102, 204));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/botao-de-inicio.png"))); // NOI18N
        btnHome.setText("HOME");
        btnHome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
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
        btnCaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btnCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btnNFC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btnEstoque.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstoque.setHideActionText(true);
        btnEstoque.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEstoque.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstoqueActionPerformed(evt);
            }
        });

        btnOS.setBackground(new java.awt.Color(0, 102, 204));
        btnOS.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOS.setForeground(new java.awt.Color(255, 255, 255));
        btnOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/servico-de-gestao.png"))); // NOI18N
        btnOS.setText("ORDEM SERVIÇO");
        btnOS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btnRelatorio_Gerencial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btnVendas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btnECF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btnFinanceiro_Auditoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btnEntradas_Saidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntradas_Saidas.setHideActionText(true);
        btnEntradas_Saidas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEntradas_Saidas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEntradas_Saidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradas_SaidasActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("DATA");

        lblData.setBackground(new java.awt.Color(0, 0, 0));
        lblData.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(0, 0, 0));

        lblHora.setBackground(new java.awt.Color(0, 0, 0));
        lblHora.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEntradas_Saidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnFinanceiro_Auditoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnECF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVendas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRelatorio_Gerencial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNFC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEstoque, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCaixa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(profilePrincipal1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(profilePrincipal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
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
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // chamar tela home
        HomeView homeview = new HomeView();
        homeview.setVisible(true);
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed
        // chamar tela caixa
        CaixaView caixaview = new CaixaView();
        caixaview.setVisible(true);
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnCaixaActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        // chamar tela cadastro
        CadastroView cadastroview = new CadastroView();
        cadastroview.setVisible(true);
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnNFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNFCActionPerformed
        // chamar tela nota fiscal
        NotaFiscalView notafiscalview = new NotaFiscalView();
        notafiscalview.setVisible(true);
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnNFCActionPerformed

    private void btnEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstoqueActionPerformed
        // chamar tela estoque
        EstoqueView estoqueview = new EstoqueView();
        estoqueview.setVisible(true);
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnEstoqueActionPerformed

    private void btnOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOSActionPerformed
        // chamar tela ordem serviço
        OrdemServicoView ordemservicoview = new OrdemServicoView();
        ordemservicoview.setVisible(true);
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnOSActionPerformed

    private void btnRelatorio_GerencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorio_GerencialActionPerformed
        // chamar tela relatorio gerencial
        RelatorioGerencialView relatoriogerencialview = new RelatorioGerencialView();
        relatoriogerencialview.setVisible(true);
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnRelatorio_GerencialActionPerformed

    private void btnVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasActionPerformed
        // chamar tela vendas
        VendasView vendasview = new VendasView();
        vendasview.setVisible(true);
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnVendasActionPerformed

    private void btnECFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnECFActionPerformed
        // chamar tela ECF
        ECFView ecfview = new ECFView();
        ecfview.setVisible(true);
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnECFActionPerformed

    private void btnFinanceiro_AuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinanceiro_AuditoriaActionPerformed
        // chamar tela financeiro auditoria
        FinanceiroAuditoriaView financerioauditoriaview = new FinanceiroAuditoriaView();
        financerioauditoriaview.setVisible(true);
    }//GEN-LAST:event_btnFinanceiro_AuditoriaActionPerformed

    private void btnEntradas_SaidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradas_SaidasActionPerformed
        // chamar tela entradas e saidas de produtos
        MovimentacaoView EntradaeSaida = new MovimentacaoView();
        EntradaeSaida.setVisible(true);
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
    }//GEN-LAST:event_btnEntradas_SaidasActionPerformed

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        btnHome.setBackground(new Color(0, 102, 204));
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        btnHome.setBackground(null);

    }//GEN-LAST:event_btnHomeMouseExited
    private void updateDateTime() {
        // Atualiza a label com a data e hora atuais
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");
        lblHora.setText(formatador.format(data));
    }

    private void updateDate() {
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));
    }

    public static void aplicarRestricoesParaFuncionario() {
        if ("Funcionario".equals(tipoAcesso)) {
            btnFinanceiro_Auditoria.setVisible(false);
            btnECF.setVisible(false);

        }
    }
    public void setUsuarioLabel() {
        // Verifica se lblUsuario não é nulo antes de usá-lo
        if (lblUsuario != null && lblAcesso != null) {
            lblUsuario.setText(usuarioLogado);
            lblAcesso.setText(tipoAcesso);
        } else {
            System.out.println("lblUsuario não foi inicializado corretamente.");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnCadastro;
    public static javax.swing.JButton btnCaixa;
    public static javax.swing.JButton btnECF;
    public static javax.swing.JButton btnEntradas_Saidas;
    public static javax.swing.JButton btnEstoque;
    public static javax.swing.JButton btnFinanceiro_Auditoria;
    public static javax.swing.JButton btnHome;
    public static javax.swing.JButton btnNFC;
    public static javax.swing.JButton btnOS;
    public static javax.swing.JButton btnRelatorio_Gerencial;
    public static javax.swing.JButton btnVendas;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    private Sistema.FrontEnd.Componentes.Swing.ProfilePrincipal profilePrincipal1;
    // End of variables declaration//GEN-END:variables

}

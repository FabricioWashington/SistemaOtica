package Sistema.FrontEnd.TelasPrincipais.Telas;

import Sistema.BackEnd.TelasInicio.Login.UsuarioLogado;
import Sistema.BackEnd.TelasPrincipais.Crud.Cliente;
import Sistema.FrontEnd.Componentes.ScrollBarCustom;
import Sistema.FrontEnd.TelasInicio.LoginView;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Arrays;
import javax.swing.Timer;

public class HomeView extends javax.swing.JFrame {

    private Timer timer;
    private UsuarioLogado usuarioLogado;
    private Cliente cliente;

    public HomeView() {

    }

    public HomeView(UsuarioLogado usuarioLogado) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        updateDateTime(); // atualiza a data e hora
        verificarRestricoes(usuarioLogado);

        // mostra o nome e o tipo de acesso do usuario
        this.usuarioLogado = usuarioLogado;
        lblAcesso.setText(usuarioLogado.getTipoAcesso());
        lblUsuario.setText(usuarioLogado.getNomeUsuario());
        SwingUtilities.invokeLater(() -> verificarRestricoes(usuarioLogado));

        // tabelas so aparecem quando o botão é clicado
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        graficoPanel.setPreferredSize(new Dimension(1580, 600)); // inicia com esse dimensao
        cabecalho1.setPreferredSize(new Dimension(1580, 37));
        graficoPanel.setPreferredSize(new Dimension(1580, 240));

        // Listener para monitorar as mudanças no JPanel
        PainelMen.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                checkScrollPane(PainelMen);
            }
        });

        // Lista de cartões
        List<JPanel> cartoes = Arrays.asList(cartao1, cartao2, cartao3, cartao4, cartao5);

        // Muda o cursor do mouse quando passa por cima dos cartões
        for (JPanel cartao : cartoes) {
            cartao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            // Adiciona MouseListener aos cartões
            cartao.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ajustarDimensaoDoGraficoPanel();
                }
            });
        }
        graficoPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (graficoPanel.getPreferredSize().height == 600) {
                    ajustarDimensaoDoGraficoPanel();
                    lblHistorico.setVisible(true);
                    jScrollPane1.setVisible(true);
                } else {
                    graficoPanel.setPreferredSize(new Dimension(1580, 600));
                    lblHistorico.setVisible(false);
                    jScrollPane1.setVisible(false);
                }
                revalidate();
                repaint();
            }
        });
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
        // Componentes a serem escondidos para funcionários
        List<Component> componentesParaEsconder = Arrays.asList(btnFinanceiro_Auditoria, btnECF, graficoPanel);

        // Define nova dimensão da tabela
        Dimension novaDimensaoTabela = new Dimension(1580, 600);

        // Aplica as restrições
        usuarioLogado.aplicarRestricoesFuncionarios(componentesParaEsconder, novaDimensaoTabela, tabela1, jScrollPane1, lblHistorico);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PainelMen = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        painelMenu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cabecalho1 = new Sistema.FrontEnd.Componentes.Swing.Cabecalho();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        jLabel6 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblHistorico = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela1 = new Sistema.FrontEnd.Componentes.Tabela();
        graficoPanel = new Sistema.FrontEnd.Componentes.graficoPanel();
        cartao2 = new Sistema.FrontEnd.Componentes.Swing.Cartao();
        cartao1 = new Sistema.FrontEnd.Componentes.Swing.Cartao();
        cartao4 = new Sistema.FrontEnd.Componentes.Swing.Cartao();
        cartao_BemVindo1 = new Sistema.FrontEnd.Componentes.Swing.Cartao_BemVindo();
        cartao5 = new Sistema.FrontEnd.Componentes.Swing.Cartao();
        cartao3 = new Sistema.FrontEnd.Componentes.Swing.Cartao();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WASHINGTON TECHNOLOGY - SISTEMA ÓTICA - VERSION 1.01.1");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        PainelMen.setBackground(new java.awt.Color(255, 255, 255));
        PainelMen.setPreferredSize(new java.awt.Dimension(1600, 900));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        painelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/menu.png"))); // NOI18N
        painelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        painelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelMenuMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("> Dashboard");

        cabecalho1.setBackground(new java.awt.Color(153, 153, 153));
        cabecalho1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        cabecalho1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/notificacao.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/engrenagem.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelMenu)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(cabecalho1, javax.swing.GroupLayout.PREFERRED_SIZE, 1037, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(cabecalho1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(painelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
        );

        painelPrincipal.setBackground(new java.awt.Color(0, 102, 204));

        btnHome.setBackground(new java.awt.Color(0, 102, 204));
        btnHome.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/botao-de-inicio.png"))); // NOI18N
        btnHome.setText("HOME");
        btnHome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnCaixa.setBackground(new java.awt.Color(0, 102, 204));
        btnCaixa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCaixa.setForeground(new java.awt.Color(255, 255, 255));
        btnCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/caixa-eletronico.png"))); // NOI18N
        btnCaixa.setText("CAIXA");
        btnCaixa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnCaixa.setHideActionText(true);
        btnCaixa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCaixa.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaixaActionPerformed(evt);
            }
        });

        btnCadastro.setBackground(new java.awt.Color(0, 102, 204));
        btnCadastro.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCadastro.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/notes_768818.png"))); // NOI18N
        btnCadastro.setText("CADASTRO");
        btnCadastro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnCadastro.setHideActionText(true);
        btnCadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCadastro.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        btnNFC.setBackground(new java.awt.Color(0, 102, 204));
        btnNFC.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnNFC.setForeground(new java.awt.Color(255, 255, 255));
        btnNFC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/business-graphic_4008604.png"))); // NOI18N
        btnNFC.setText("NFCe/NFe");
        btnNFC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnNFC.setHideActionText(true);
        btnNFC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNFC.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNFC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNFCActionPerformed(evt);
            }
        });

        btnEstoque.setBackground(new java.awt.Color(0, 102, 204));
        btnEstoque.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnEstoque.setForeground(new java.awt.Color(255, 255, 255));
        btnEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/ready-stock_4947506.png"))); // NOI18N
        btnEstoque.setText("ESTOQUE");
        btnEstoque.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
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
        btnOS.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnOS.setForeground(new java.awt.Color(255, 255, 255));
        btnOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/servico-de-gestao.png"))); // NOI18N
        btnOS.setText("ORDEM SERVIÇO");
        btnOS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnOS.setHideActionText(true);
        btnOS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOS.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOSActionPerformed(evt);
            }
        });

        btnRelatorio_Gerencial.setBackground(new java.awt.Color(0, 102, 204));
        btnRelatorio_Gerencial.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnRelatorio_Gerencial.setForeground(new java.awt.Color(255, 255, 255));
        btnRelatorio_Gerencial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/grafico-preditivo.png"))); // NOI18N
        btnRelatorio_Gerencial.setText("RELATORIO GERENCIAL");
        btnRelatorio_Gerencial.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnRelatorio_Gerencial.setHideActionText(true);
        btnRelatorio_Gerencial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRelatorio_Gerencial.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRelatorio_Gerencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorio_GerencialActionPerformed(evt);
            }
        });

        btnVendas.setBackground(new java.awt.Color(0, 102, 204));
        btnVendas.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnVendas.setForeground(new java.awt.Color(255, 255, 255));
        btnVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/vendedor.png"))); // NOI18N
        btnVendas.setText("VENDAS");
        btnVendas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnVendas.setHideActionText(true);
        btnVendas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVendas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendasActionPerformed(evt);
            }
        });

        btnECF.setBackground(new java.awt.Color(0, 102, 204));
        btnECF.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnECF.setForeground(new java.awt.Color(255, 255, 255));
        btnECF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/business-graphic_4008604.png"))); // NOI18N
        btnECF.setText("ECF");
        btnECF.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnECF.setHideActionText(true);
        btnECF.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnECF.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnECF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnECFActionPerformed(evt);
            }
        });

        btnFinanceiro_Auditoria.setBackground(new java.awt.Color(0, 102, 204));
        btnFinanceiro_Auditoria.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnFinanceiro_Auditoria.setForeground(new java.awt.Color(255, 255, 255));
        btnFinanceiro_Auditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/fluxo-de-caixa.png"))); // NOI18N
        btnFinanceiro_Auditoria.setText("FINANCEIRO");
        btnFinanceiro_Auditoria.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnFinanceiro_Auditoria.setHideActionText(true);
        btnFinanceiro_Auditoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFinanceiro_Auditoria.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFinanceiro_Auditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinanceiro_AuditoriaActionPerformed(evt);
            }
        });

        btnEntradas_Saidas.setBackground(new java.awt.Color(0, 102, 204));
        btnEntradas_Saidas.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnEntradas_Saidas.setForeground(new java.awt.Color(255, 255, 255));
        btnEntradas_Saidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/produtos.png"))); // NOI18N
        btnEntradas_Saidas.setText("MOVIMENTAÇÃO");
        btnEntradas_Saidas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btnEntradas_Saidas.setHideActionText(true);
        btnEntradas_Saidas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEntradas_Saidas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEntradas_Saidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradas_SaidasActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("DATA");

        lblData.setBackground(new java.awt.Color(0, 0, 0));
        lblData.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));

        lblHora.setBackground(new java.awt.Color(0, 0, 0));
        lblHora.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntradas_Saidas, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinanceiro_Auditoria, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnECF, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRelatorio_Gerencial)
                    .addComponent(btnOS, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNFC, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        painelPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastro, btnCaixa, btnECF, btnEntradas_Saidas, btnEstoque, btnFinanceiro_Auditoria, btnHome, btnNFC, btnOS, btnRelatorio_Gerencial, btnVendas});

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
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelPrincipalLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCadastro, btnCaixa, btnECF, btnEntradas_Saidas, btnEstoque, btnFinanceiro_Auditoria, btnHome, btnNFC, btnOS, btnRelatorio_Gerencial, btnVendas});

        lblHistorico.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblHistorico.setForeground(new java.awt.Color(102, 102, 102));
        lblHistorico.setText("HISTORICO DOS CLIENTES");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setColumnHeaderView(null);
        jScrollPane1.setViewportView(null);

        tabela1.setBackground(new java.awt.Color(255, 255, 255));
        tabela1.setForeground(new java.awt.Color(255, 255, 255));
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Tipo", "CPF/CNPJ", "Endereço", "Contato", "Data Cadastro"
            }
        ));
        tabela1.setShowGrid(false);
        tabela1.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(tabela1);

        graficoPanel.setBackground(new java.awt.Color(0, 0, 0));
        graficoPanel.setForeground(new java.awt.Color(102, 102, 102));
        graficoPanel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        cartao2.setCor2(new java.awt.Color(102, 255, 255));
        cartao2.setTitulo("Produtos");
        cartao2.setValor("Total: 0");
        cartao2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartao2MouseClicked(evt);
            }
        });

        cartao1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cartao1.setImagem("/Resources/icons/user (2).png");
        cartao1.setTitulo("Clientes");
        cartao1.setValor("Total: 0");
        cartao1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartao1MouseClicked(evt);
            }
        });

        cartao4.setCor2(new java.awt.Color(255, 51, 51));
        cartao4.setImagem("/Resources/icons/money.png");
        cartao4.setTitulo("<html> Notas <br/> Canceladas <html/>");
        cartao4.setValor("R$ 00,00");
        cartao4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartao4MouseClicked(evt);
            }
        });

        cartao5.setCor2(new java.awt.Color(204, 102, 0));
        cartao5.setImagem("/Resources/icons/money.png");
        cartao5.setTitulo("<html> Notas <br/>  Denegadas <html/>");
        cartao5.setValor("R$ 00,00");
        cartao5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartao5MouseClicked(evt);
            }
        });

        cartao3.setCor2(new java.awt.Color(153, 255, 102));
        cartao3.setImagem("/Resources/icons/money.png");
        cartao3.setTitulo("<html> Notas <br/>\n Autorizadas <html/>");
        cartao3.setValor("R$ 00,00");
        cartao3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartao3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PainelMenLayout = new javax.swing.GroupLayout(PainelMen);
        PainelMen.setLayout(PainelMenLayout);
        PainelMenLayout.setHorizontalGroup(
            PainelMenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelMenLayout.createSequentialGroup()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PainelMenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PainelMenLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(PainelMenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(lblHistorico)
                            .addComponent(graficoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1296, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelMenLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartao_BemVindo1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cartao1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cartao2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cartao3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cartao4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cartao5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        PainelMenLayout.setVerticalGroup(
            PainelMenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PainelMenLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(PainelMenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cartao_BemVindo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cartao1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cartao2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cartao3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cartao4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cartao5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(lblHistorico)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(graficoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 66, Short.MAX_VALUE))
        );

        PainelMenLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cartao1, cartao2, cartao3, cartao4, cartao5, cartao_BemVindo1});

        getContentPane().add(PainelMen, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // substitui a label por uma data atual
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));

//        lblUsuario.setText(usuarioLogado.getNomeUsuario());
//        lblAcesso.setText(usuarioLogado.getTipoAcesso());

    }//GEN-LAST:event_formWindowActivated

    private void cartao4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartao4MouseClicked
        // Notas canceladas
        jScrollPane1.setVisible(true);
        lblHistorico.setVisible(true);
        lblHistorico.setText("Historico de notas canceladas");
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null}
                },
                new String[]{
                    "ID", "Nome", "Descrição", "Preço", "Quantidade"
                }
        ));
    }//GEN-LAST:event_cartao4MouseClicked

    private void cartao5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartao5MouseClicked
        // Notas denegadas
        jScrollPane1.setVisible(true);
        lblHistorico.setVisible(true);
        lblHistorico.setText("Historico de notas denegadas");
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null}
                },
                new String[]{
                    "ID", "Nome", "Descrição", "Preço", "Quantidade"
                }
        ));
    }//GEN-LAST:event_cartao5MouseClicked

    private void cartao2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartao2MouseClicked
        // Produtos
        jScrollPane1.setVisible(true);
        lblHistorico.setVisible(true);
        lblHistorico.setText("Historico de produtos");
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null}
                },
                new String[]{
                    "ID", "Nome", "Descrição", "Preço", "Quantidade"
                }
        ));
    }//GEN-LAST:event_cartao2MouseClicked

    // AÇÃO DOS CARTOES
    private void cartao1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartao1MouseClicked
        // Clientes
        jScrollPane1.setVisible(true);
        lblHistorico.setVisible(true);
        lblHistorico.setText("Historico dos clientes");
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null}
                },
                new String[]{
                    "ID", "Nome", "Tipo", "CPF/CNPJ", "Endereço", "Contato", "Data Cadastro"
                }
        ));
        cliente = new Cliente();
        cliente.carregarTabelaClientes(tabela1);
    }//GEN-LAST:event_cartao1MouseClicked

    private void cartao3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartao3MouseClicked
        // Notas autorizadas
        jScrollPane1.setVisible(true);
        lblHistorico.setVisible(true);
        lblHistorico.setText("Historico de notas autorizadas");
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null}
                },
                new String[]{
                    "ID", "Nome", "Descrição", "Preço", "Quantidade"
                }
        ));
    }//GEN-LAST:event_cartao3MouseClicked

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

    private void btnEntradas_SaidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradas_SaidasActionPerformed
        // chamar tela entradas e saidas de produtos
        MovimentacaoView movimentacao = new MovimentacaoView(usuarioLogado);
        movimentacao.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEntradas_SaidasActionPerformed

    private void btnFinanceiro_AuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinanceiro_AuditoriaActionPerformed
        // chamar tela financeiro auditoria
        FinanceiroAuditoriaView financerioAuditoriaView = new FinanceiroAuditoriaView(usuarioLogado);
        financerioAuditoriaView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnFinanceiro_AuditoriaActionPerformed

    private void btnECFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnECFActionPerformed
        // chamar tela ECF
        ECFView ecfView = new ECFView(usuarioLogado);
        ecfView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnECFActionPerformed

    private void btnVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendasActionPerformed
        // chamar tela vendas
        VendasView vendasView = new VendasView(usuarioLogado);
        vendasView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVendasActionPerformed

    private void btnRelatorio_GerencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorio_GerencialActionPerformed
        // chamar tela relatorio gerencial
        RelatorioGerencialView relatorioGerencialView = new RelatorioGerencialView(usuarioLogado);
        relatorioGerencialView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRelatorio_GerencialActionPerformed

    private void btnOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOSActionPerformed
        // chamar tela ordem serviço
        OrdemServicoView ordemServicoView = new OrdemServicoView(usuarioLogado);
        ordemServicoView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnOSActionPerformed

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

    // ação dos botoes
    private void btnEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstoqueActionPerformed
        // chamar tela estoque
        EstoqueView estoqueView = new EstoqueView(usuarioLogado);
        estoqueView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEstoqueActionPerformed

    private void btnNFCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNFCActionPerformed
        // chamar tela nota fiscal
        NotaFiscalView notaFiscalView = new NotaFiscalView(usuarioLogado);
        notaFiscalView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnNFCActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        // chamar tela cadastro
        CadastroView cadastroView = new CadastroView(usuarioLogado);
        cadastroView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaixaActionPerformed
        // chamar tela caixa
        CaixaView caixaView = new CaixaView(usuarioLogado);
        caixaView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCaixaActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // chamar tela home
        HomeView homeView = new HomeView(usuarioLogado);
        homeView.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

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
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UsuarioLogado usuarioLogado = new UsuarioLogado("Nome do Usuário", "Tipo de Acesso");

                new HomeView(usuarioLogado).setVisible(true);
            }
        });
    }

    private void updateDateTime() {
        // Atualiza a label com a data e hora atuais
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");
        lblHora.setText(formatador.format(data));
    }

    private void ajustarDimensaoDoGraficoPanel() {
        // Altera a dimensão do graficoPanel
        graficoPanel.setPreferredSize(new Dimension(1580, 240));
        graficoPanel.revalidate();
        graficoPanel.repaint();
    }

    private void checkScrollPane(JPanel PainelMen) {
        Container parent = PainelMen.getParent();
        if (parent == null) {
            System.err.println("Erro: JPanel não possui contêiner pai.");
            return;
        }

        Dimension panelSize = PainelMen.getSize();
        Dimension contentSize = PainelMen.getPreferredSize();

        // Verifica se o JPanel é menor que seu conteúdo
        if (panelSize.width < contentSize.width || panelSize.height < contentSize.height) {
            // Adiciona um JScrollPane ao JPanel
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setViewportView(PainelMen);
            scrollPane.setVerticalScrollBar(new ScrollBarCustom(JScrollBar.VERTICAL));
            scrollPane.setHorizontalScrollBar(new ScrollBarCustom(JScrollBar.HORIZONTAL));
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            // Remove o JPanel do layout atual e adiciona o JScrollPane ao contêiner pai
            parent.remove(PainelMen);
            parent.add(scrollPane);
            parent.revalidate();
            parent.repaint();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelMen;
    public static javax.swing.JButton btnCadastro;
    public static javax.swing.JButton btnCaixa;
    public static javax.swing.JButton btnECF;
    public static javax.swing.JButton btnEntradas_Saidas;
    public static javax.swing.JButton btnEstoque;
    public static javax.swing.JButton btnFinanceiro_Auditoria;
    public static javax.swing.JButton btnHome;
    public static javax.swing.JButton btnLogout;
    public static javax.swing.JButton btnNFC;
    public static javax.swing.JButton btnOS;
    public static javax.swing.JButton btnRelatorio_Gerencial;
    public static javax.swing.JButton btnVendas;
    private Sistema.FrontEnd.Componentes.Swing.Cabecalho cabecalho1;
    private Sistema.FrontEnd.Componentes.Swing.Cartao cartao1;
    private Sistema.FrontEnd.Componentes.Swing.Cartao cartao2;
    private Sistema.FrontEnd.Componentes.Swing.Cartao cartao3;
    private Sistema.FrontEnd.Componentes.Swing.Cartao cartao4;
    private Sistema.FrontEnd.Componentes.Swing.Cartao cartao5;
    private Sistema.FrontEnd.Componentes.Swing.Cartao_BemVindo cartao_BemVindo1;
    public static Sistema.FrontEnd.Componentes.graficoPanel graficoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblAcesso;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblHistorico;
    private javax.swing.JLabel lblHora;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel painelMenu;
    private javax.swing.JPanel painelPrincipal;
    public static Sistema.FrontEnd.Componentes.Tabela tabela1;
    // End of variables declaration//GEN-END:variables
}

package Sistema.FrontEnd.TelasInicio;

import DAO.Conexao.ConexaoDAO;
import DAO.Vetores.VetorTipoLogin;
import Sistema.BackEnd.NotaFiscal.Config;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import Sistema.BackEnd.TelasInicio.Login.Login;
import Sistema.FrontEnd.TelasPrincipais.Cadastro.CadastroEmpresaView;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import java.io.IOException;
import java.net.HttpURLConnection;
import javax.swing.Timer;

public class LoginView extends javax.swing.JFrame {

    Connection conectaBD = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    private VetorTipoLogin vectorIdTipoLogin;
    private Login login;
    private Connection conn;
    private CadastroEmpresaView cadastroEmpresaView;

    public LoginView() {
        initComponents();
        this.login = new Login();
        vectorIdTipoLogin = new DAO.Vetores.VetorTipoLogin(cbxTipoLogin);
        vectorIdTipoLogin.restaurarDadosCbxTiposLogin();
        getRootPane().setDefaultButton(btnLoginEntrar); // Define o botão "Entrar" como padrão

        // Adiciona um KeyListener à tela para capturar a tecla Enter
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    enterPressed = true; // Marca que a tecla Enter foi pressionada
                    btnLoginEntrar.doClick(); // Simula um clique no botão "Entrar"
                }
            }
        });

        // Adiciona um ActionListener ao botão "Entrar"
        btnLoginEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (enterPressed) { // Verifica se a tecla Enter foi pressionada
                    login.realizarLogin(); // Executa o método de login
                    enterPressed = false; // Reseta a variável para evitar execução dupla
                }
            }
        });
        ExibirSenha(txtLoginSenha, checkBoxVisualizarSenha);
        //restaurarDadosComboBoxTipos_Login();
        conectaBD = ConexaoDAO.conectaBD();
        System.out.println(conectaBD);

        // Verifica a conexão e define o ícone corretamente
        URL okIconUrl = getClass().getResource("/Resources/dbok.png");
        URL errorIconUrl = getClass().getResource("/Resources/derror.png");

        if (conectaBD != null) {
            if (okIconUrl != null) {
                lblStatusBD.setIcon(new javax.swing.ImageIcon(okIconUrl));
            } else {
                System.out.println("Imagem não encontrada: /Resources/dbok.png");
            }
        } else {
            if (errorIconUrl != null) {
                lblStatusBD.setIcon(new javax.swing.ImageIcon(errorIconUrl));
            } else {
                System.out.println("Imagem não encontrada: /Resources/derror.png");
            }
        }
        Timer timer = new Timer(5000, e -> atualizarIconesStatus()); // Atualiza a cada 5 segundos
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtLoginSenha = new javax.swing.JPasswordField();
        btnLoginEntrar = new javax.swing.JButton();
        lblStatusWifi = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtLoginUsuario = new javax.swing.JTextField();
        cbxTipoLogin = new javax.swing.JComboBox<>();
        lblUsuario = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        checkBoxVisualizarSenha = new javax.swing.JCheckBox();
        btnPrimeiroAcesso = new javax.swing.JButton();
        lblStatusBD = new javax.swing.JLabel();
        lblStatusCertificado = new javax.swing.JLabel();
        lblResource = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WASHINGTON TECHNOLOGY - SISTEMA ÓTICA - VERSION 1.01.1");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(245, 245, 245));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        txtLoginSenha.setBackground(new java.awt.Color(255, 255, 255));
        txtLoginSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtLoginSenha.setForeground(new java.awt.Color(0, 0, 0));
        txtLoginSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginSenhaActionPerformed(evt);
            }
        });

        btnLoginEntrar.setBackground(new java.awt.Color(255, 255, 255));
        btnLoginEntrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLoginEntrar.setForeground(new java.awt.Color(0, 0, 0));
        btnLoginEntrar.setText("ENTRAR");
        btnLoginEntrar.setToolTipText("");
        btnLoginEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLoginEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginEntrarActionPerformed(evt);
            }
        });
        btnLoginEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnLoginEntrarKeyPressed(evt);
            }
        });

        lblStatusWifi.setForeground(java.awt.Color.black);
        lblStatusWifi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/semsinal.png"))); // NOI18N

        lblSenha.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblSenha.setForeground(java.awt.Color.black);
        lblSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/password_12795740.png"))); // NOI18N
        lblSenha.setText("Senha");

        txtLoginUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtLoginUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtLoginUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtLoginUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginUsuarioActionPerformed(evt);
            }
        });

        cbxTipoLogin.setBackground(new java.awt.Color(255, 255, 255));
        cbxTipoLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbxTipoLogin.setForeground(new java.awt.Color(0, 0, 0));
        cbxTipoLogin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cbxTipoLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblUsuario.setBackground(new java.awt.Color(0, 0, 0));
        lblUsuario.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblUsuario.setForeground(java.awt.Color.black);
        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/user_1077012_1.png"))); // NOI18N
        lblUsuario.setText("Usuario");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setForeground(java.awt.Color.black);
        jLabel10.setText("Opções de Acesso");

        checkBoxVisualizarSenha.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        checkBoxVisualizarSenha.setForeground(java.awt.Color.black);
        checkBoxVisualizarSenha.setText("Visualizar Senha");
        checkBoxVisualizarSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkBoxVisualizarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxVisualizarSenhaActionPerformed(evt);
            }
        });

        btnPrimeiroAcesso.setBackground(new java.awt.Color(255, 255, 255));
        btnPrimeiroAcesso.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnPrimeiroAcesso.setForeground(new java.awt.Color(0, 0, 0));
        btnPrimeiroAcesso.setText("PRIMEIRO ACESSO");
        btnPrimeiroAcesso.setToolTipText("");
        btnPrimeiroAcesso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrimeiroAcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroAcessoActionPerformed(evt);
            }
        });
        btnPrimeiroAcesso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPrimeiroAcessoKeyPressed(evt);
            }
        });

        lblStatusBD.setForeground(java.awt.Color.black);
        lblStatusBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/dberror.png"))); // NOI18N

        lblStatusCertificado.setForeground(java.awt.Color.black);
        lblStatusCertificado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/paginaerro.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(checkBoxVisualizarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(120, 120, 120))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(98, 98, 98))
                            .addComponent(txtLoginUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(151, 151, 151))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(155, 155, 155))
                            .addComponent(txtLoginSenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxTipoLogin, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(71, 71, 71))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnLoginEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(93, 93, 93)
                        .addComponent(lblStatusWifi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStatusCertificado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStatusBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrimeiroAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLoginSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxTipoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkBoxVisualizarSenha)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLoginEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatusWifi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatusCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatusBD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btnPrimeiroAcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, 0, 350, 450));

        lblResource.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/fw.png"))); // NOI18N
        jPanel3.add(lblResource, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 460, 320));

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
        jPanel3.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 50, 33));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 10, 470));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 450));

        getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(829, 450));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginEntrarActionPerformed
        // logar
        String usuario = txtLoginUsuario.getText();
        String senha = txtLoginSenha.getText();
        int tipoLogin = cbxTipoLogin.getSelectedIndex();

        login = new Login(usuario, senha, tipoLogin, cbxTipoLogin);
        login.realizarLogin();
        if (login.isLoginBemSucedido()) {
            dispose(); // Fecha a janela se o login for bem-sucedido
        }

        enterPressed = false;
    }//GEN-LAST:event_btnLoginEntrarActionPerformed

    private void txtLoginUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginUsuarioActionPerformed

    private void txtLoginSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginSenhaActionPerformed

    private void checkBoxVisualizarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxVisualizarSenhaActionPerformed
        // Ver senha
        ExibirSenha(txtLoginSenha, checkBoxVisualizarSenha);
    }//GEN-LAST:event_checkBoxVisualizarSenhaActionPerformed

    private void btnLoginEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginEntrarKeyPressed
        // Atalho Enter
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !enterPressed) {
            enterPressed = true;
            btnLoginEntrarActionPerformed(null); // Chama o método de login 
        }

    }//GEN-LAST:event_btnLoginEntrarKeyPressed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // fechar tela
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnPrimeiroAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroAcessoActionPerformed
        // Chamar tela cadastro de empresa
        cadastroEmpresaView = new CadastroEmpresaView(null, "CadastroEmpresaView", true);
        cadastroEmpresaView.setVisible(true);
    }//GEN-LAST:event_btnPrimeiroAcessoActionPerformed

    private void btnPrimeiroAcessoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPrimeiroAcessoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrimeiroAcessoKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView loginView = new LoginView();
                loginView.setVisible(true);
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
    private boolean enterPressed = false;

    public boolean verificarConexaoInternet() {
        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(3000); // Timeout de 3 segundos
            connection.connect();
            return connection.getResponseCode() == 200;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean verificarCertificado() {
        try {
            ConfiguracoesNfe configuracoes = Config.testeConfiguracoes();
            return configuracoes != null; // Se conseguiu carregar, está ok
        } catch (Exception e) {
            return false; // Certificado não configurado corretamente
        }
    }

    private void atualizarIconesStatus() {
        // Caminhos para os ícones
        URL okIconWifi = getClass().getResource("/Resources/sinal.png");
        URL errorIconWifi = getClass().getResource("/Resources/semsinal.png");
        URL okIconCertificado = getClass().getResource("/Resources/certificadogarantia.png");
        URL errorIconCertificado = getClass().getResource("/Resources/paginaerro.png");

        // Verifica a conexão com a internet
        if (verificarConexaoInternet()) {
            if (okIconWifi != null) {
                lblStatusWifi.setIcon(new javax.swing.ImageIcon(okIconWifi));
            } else {
                System.out.println("Imagem não encontrada: /Resources/sinal.png");
            }
        } else {
            if (errorIconWifi != null) {
                lblStatusWifi.setIcon(new javax.swing.ImageIcon(errorIconWifi));
            } else {
                System.out.println("Imagem não encontrada: /Resources/semsinal.png");
            }
        }

        // Verifica a configuração do certificado
        if (verificarCertificado()) {
            if (okIconCertificado != null) {
                lblStatusCertificado.setIcon(new javax.swing.ImageIcon(okIconCertificado));
            } else {
                System.out.println("Imagem não encontrada: /Resources/certificadogarantia.png");
            }
        } else {
            if (errorIconCertificado != null) {
                lblStatusCertificado.setIcon(new javax.swing.ImageIcon(errorIconCertificado));
            } else {
                System.out.println("Imagem não encontrada: /Resources/paginaerro.png");
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoginEntrar;
    private javax.swing.JButton btnPrimeiroAcesso;
    private javax.swing.JComboBox<String> cbxTipoLogin;
    private javax.swing.JCheckBox checkBoxVisualizarSenha;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblResource;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblStatusBD;
    private javax.swing.JLabel lblStatusCertificado;
    private javax.swing.JLabel lblStatusWifi;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtLoginSenha;
    private javax.swing.JTextField txtLoginUsuario;
    // End of variables declaration//GEN-END:variables
}

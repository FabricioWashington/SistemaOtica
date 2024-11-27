package Sistema.FrontEnd.TelasInicio;

import Sistema.FrontEnd.TelasPrincipais.Cadastro.*;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileInputStream;
import java.security.KeyStore;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import Sistema.BackEnd.NotaFiscal.Config;
import Sistema.BackEnd.TelasPrincipais.Crud.ConfiguracaoService;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpresaCertificadoView extends JDialog {

    private String caminhoCertificado;
    private char[] senhaCertificado = "suaSenhaDoCertificado".toCharArray(); // Defina a senha do certificado
    private ConfiguracoesNfe configuracoesNfe;
    private Config Config;
    private ConfiguracaoService configuracaoService;
    EstadosEnum estadoSelecionado;
    AmbienteEnum ambienteSelecionado;

    private CadastroEmpresaView cadastroEmpresaView;

    public EmpresaCertificadoView(JFrame parent, String title, boolean modal) {
        super(parent, title, modal);
        initComponents();
        
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

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxEmpresa = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCertificado = new javax.swing.JButton();
        lblUrlCertificado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        cbxEstado = new javax.swing.JComboBox<>();
        cbxAmbiente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCadastrarCertificado = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("WASHINGTON TECHNOLOGY - SISTEMA ÓTICA - VERSION 1.01.1");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.black, java.awt.Color.black, null));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Empresa");

        cbxEmpresa.setBackground(new java.awt.Color(255, 255, 255));
        cbxEmpresa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxEmpresa.setForeground(new java.awt.Color(0, 0, 0));
        cbxEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEmpresaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Selecione uma empresa desejada,");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Carregue o certificado digital.");

        btnCertificado.setBackground(new java.awt.Color(255, 255, 255));
        btnCertificado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCertificado.setForeground(new java.awt.Color(0, 0, 0));
        btnCertificado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/update.png"))); // NOI18N
        btnCertificado.setToolTipText("");
        btnCertificado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Certificado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        btnCertificado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCertificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCertificadoActionPerformed(evt);
            }
        });

        lblUrlCertificado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblUrlCertificado.setForeground(new java.awt.Color(0, 0, 0));
        lblUrlCertificado.setText("<html>URL <br> CERTIFICADO.<br></html>");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Já Possui uma empresa cadastrada?");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Senha");

        txtSenha.setBackground(new java.awt.Color(255, 255, 255));
        txtSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSenha.setForeground(new java.awt.Color(0, 0, 0));

        cbxEstado.setBackground(new java.awt.Color(255, 255, 255));
        cbxEstado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxEstado.setForeground(new java.awt.Color(0, 0, 0));
        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });

        cbxAmbiente.setBackground(new java.awt.Color(255, 255, 255));
        cbxAmbiente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbxAmbiente.setForeground(new java.awt.Color(0, 0, 0));
        cbxAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAmbienteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Estado");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Ambiente");

        btnCadastrarCertificado.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastrarCertificado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCadastrarCertificado.setForeground(new java.awt.Color(0, 0, 0));
        btnCadastrarCertificado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/registro.png"))); // NOI18N
        btnCadastrarCertificado.setToolTipText("");
        btnCadastrarCertificado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar Certificado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        btnCadastrarCertificado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadastrarCertificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarCertificadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 412, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addComponent(btnCadastrarCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(btnCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblUrlCertificado))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCertificado)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5)
                        .addGap(2, 2, 2)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(1, 1, 1)
                        .addComponent(cbxAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUrlCertificado, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnCadastrarCertificado)))
                .addContainerGap())
        );

        btnExit.setBackground(new java.awt.Color(153, 0, 0));
        btnExit.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("X");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 510));

        setSize(new java.awt.Dimension(511, 512));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // fechar tela
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void cbxEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEmpresaActionPerformed

    private void btnCertificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCertificadoActionPerformed
        // carregar certificado
        carregarCertificado();
    }//GEN-LAST:event_btnCertificadoActionPerformed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void cbxAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAmbienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAmbienteActionPerformed

    private void btnCadastrarCertificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarCertificadoActionPerformed
        cadastrarConfiguracoes();

        //        try {
//            // cadastra certificado no sgbd
//            salvarConfiguracoes();
//        } catch (SQLException ex) {
//            Logger.getLogger(EmpresaCertificadoView.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnCadastrarCertificadoActionPerformed
    public void carregarConfiguracoes() {
        lblUrlCertificado.setText(configuracaoService.getCaminhoCertificado());
        txtSenha.setText(new String(configuracaoService.getSenhaCertificado()));
        cbxEstado.setSelectedItem(configuracaoService.getEstado());
        cbxAmbiente.setSelectedItem(configuracaoService.getAmbiente());
    }

    private void salvarConfiguracoes() throws SQLException {
        configuracaoService.atualizarConfiguracao("empresa.caminhoCertificado", lblUrlCertificado.getText());
        configuracaoService.atualizarConfiguracao("empresa.senhaCertificado", new String(txtSenha.getPassword()));
        configuracaoService.atualizarConfiguracao("empresa.estado", cbxEstado.getSelectedItem().toString());
        configuracaoService.atualizarConfiguracao("empresa.ambiente", cbxAmbiente.getSelectedItem().toString());
    }

    public void cadastrarConfiguracoes() {
        String certificado = caminhoCertificado;
        String senha = txtSenha.getText();
        String estado = cbxEstado.getSelectedItem().toString();
        String ambiente = cbxAmbiente.getSelectedItem().toString();

        configuracaoService = new ConfiguracaoService(certificado, senha, estado, ambiente);
        configuracaoService.cadastrarConfiguracao();

    }

    public void carregarCertificado() {
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Selecionar arquivo de certificado");
        jfc.setFileFilter(new FileNameExtensionFilter("Certificado (*.PFX)", "pfx"));
        int resultado = jfc.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = jfc.getSelectedFile();
            caminhoCertificado = arquivoSelecionado.getAbsolutePath();

            // Atualiza o lblUrlCertificado com o caminho do certificado com quebras de linha
            String caminhoFormatado = "<html>" + caminhoCertificado.replace("\\", "\\<br>") + "</html>";
            lblUrlCertificado.setText(caminhoFormatado);


            // Obtém a senha inserida
            String senhaCertificado = new String(txtSenha.getPassword());

            // Obtém o estado selecionado
            estadoSelecionado = (EstadosEnum) cbxEstado.getSelectedItem();

            // Obtém o ambiente selecionado
            ambienteSelecionado = (AmbienteEnum) cbxAmbiente.getSelectedItem();

            // Chama o método de configuração com esses dados
            try {
                ConfiguracoesNfe configuracoes = Config.configurarCertificado(caminhoCertificado, senhaCertificado, estadoSelecionado, ambienteSelecionado);
                JOptionPane.showMessageDialog(this, "Configuração concluída com sucesso.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao configurar: " + ex.getMessage());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(EmpresaCertificadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpresaCertificadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpresaCertificadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpresaCertificadoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpresaCertificadoView(null, "CadastroArmacoesView", true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarCertificado;
    private javax.swing.JButton btnCertificado;
    private javax.swing.JButton btnExit;
    private javax.swing.JComboBox<AmbienteEnum> cbxAmbiente;
    private javax.swing.JComboBox<String> cbxEmpresa;
    private javax.swing.JComboBox<EstadosEnum> cbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblUrlCertificado;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}

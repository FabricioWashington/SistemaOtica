package Sistema.FrontEnd.Componentes.Swing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.time.LocalTime;
import java.time.ZoneId;
import javax.swing.JLabel;

public class Cartao_BemVindo extends javax.swing.JPanel {

    private Color cor1;
    private Color cor2;

    public Cartao_BemVindo() {
        initComponents();
        setOpaque(false);
        cor1 = Color.BLACK;
        cor2 = Color.GRAY;
        updateMessage(lblhorariododia);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint gradientPaint = new GradientPaint(0, 0, cor1, 0, getHeight(), cor2);
        graphics2D.setPaint(gradientPaint);

        graphics2D.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

        graphics2D.setColor(new Color(255, 255, 255, 50));
        graphics2D.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        graphics2D.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());

        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public Color getCor1() {
        return cor1;
    }

    public Color getCor2() {
        return cor2;
    }

    public void setCor1(Color cor1) {
        this.cor1 = cor1;
    }

    public void setCor2(Color cor2) {
        this.cor2 = cor2;
    }

    private static void updateMessage(JLabel lblhorariododia) {
        LocalTime now = LocalTime.now();

        if (now.isBefore(LocalTime.of(4, 0))) {
            lblhorariododia.setText("<html>Tenha uma<br>Boa madrugada.</html>");
        } else if (now.isBefore(LocalTime.of(12, 0))) {
            lblhorariododia.setText("<html>Tenha um<br>Bom dia.</html>");
        } else if (now.isBefore(LocalTime.of(18, 0))) {
            lblhorariododia.setText("<html>Tenha uma<br>Boa tarde.</html>");
        } else {
            lblhorariododia.setText("<html>Tenha uma<br>Boa noite.</html>");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCartaoIcon = new javax.swing.JLabel();
        lblOla = new javax.swing.JLabel();
        lblhorariododia = new javax.swing.JLabel();

        lblOla.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblOla.setForeground(new java.awt.Color(255, 255, 255));
        lblOla.setText("Olá,");

        lblhorariododia.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblhorariododia.setForeground(new java.awt.Color(255, 255, 255));
        lblhorariododia.setText("Boa tarde");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOla)
                    .addComponent(lblhorariododia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCartaoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(labelCartaoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOla)
                        .addGap(26, 26, 26)))
                .addComponent(lblhorariododia)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelCartaoIcon;
    private javax.swing.JLabel lblOla;
    private javax.swing.JLabel lblhorariododia;
    // End of variables declaration//GEN-END:variables
}

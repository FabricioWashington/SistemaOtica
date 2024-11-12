package Sistema.FrontEnd.Componentes.Swing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Cartao extends javax.swing.JPanel {

    private Color cor1;
    private Color cor2;
    private String caminhoImagem;

    public Cartao() {
        initComponents();
        setOpaque(false);
        cor1 = Color.BLACK;
        cor2 = Color.BLUE;
        lblTitulo.setText("");
        lblValor.setText("");
        caminhoImagem = "/Resources/icons/stock.png";
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

    public String getTitulo() {
        return lblTitulo.getText();
    }

    public void setTitulo(String titulo) {
        lblTitulo.setText(titulo);
    }

    public String getValor() {
        return lblValor.getText();
    }

    public void setValor(String valor) {
        lblValor.setText(valor);
    }
    public String getImagem(){
        return caminhoImagem;
    }
    public void setImagem(String caminho){
        this.caminhoImagem = caminho;
        lbl_img.setIcon(new javax.swing.ImageIcon(getClass().getResource(caminho)));
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCartaoIcon = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        lbl_img = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Vendas");

        lblValor.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblValor.setForeground(new java.awt.Color(255, 255, 255));
        lblValor.setText("Total: 0");

        lbl_img.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_img.setForeground(new java.awt.Color(255, 255, 255));
        lbl_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/stock.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValor)
                    .addComponent(lblTitulo)
                    .addComponent(lbl_img))
                .addGap(18, 18, 18)
                .addComponent(labelCartaoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCartaoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_img))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblValor)
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelCartaoIcon;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lbl_img;
    // End of variables declaration//GEN-END:variables

}

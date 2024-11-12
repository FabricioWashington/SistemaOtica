package Sistema.FrontEnd.Componentes;

import javax.swing.*;
import java.awt.*;

public class graficoPanel extends javax.swing.JPanel {

    /**
     * Creates new form graficoPanel
     */
    public graficoPanel() {
        initComponents();
        setLayout(new BorderLayout());

        Grafico grafico = new Grafico();
        grafico.setPreferredSize(new Dimension(1580, 240));
        add(grafico, BorderLayout.CENTER);

        revalidate();
        repaint();
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 829, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 164, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Exemplo de JPanelForm com Gráfico");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1580, 240);
            frame.setLocationRelativeTo(null);

            // Adiciona o MeuJPanelForm ao JFrame
            graficoPanel meuJPanelForm = new graficoPanel();
            frame.setContentPane(meuJPanelForm);

            frame.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

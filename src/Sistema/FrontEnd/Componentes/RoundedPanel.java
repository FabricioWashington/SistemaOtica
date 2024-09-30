package Sistema.FrontEnd.Componentes;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {

    private int radius; // Raio das bordas arredondadas

    // Construtor padrão
    public RoundedPanel() {
        this(30); // Raio padrão de 30
    }

    // Construtor com parâmetro para definir o raio
    public RoundedPanel(int radius) {
        super();
        this.radius = radius;
        setOpaque(false); // Fundo transparente
    }

    // Sobrescrevendo o método paintComponent para desenhar o painel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground()); // Usa a cor de fundo do painel
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius); // Desenha bordas arredondadas
    }


    // Getter para o raio
    public int getRadius() {
        return radius;
    }

    // Setter para o raio
    public void setRadius(int radius) {
        this.radius = radius;
        repaint(); // Redesenha o painel com o novo raio
    }

    // Getter para a cor de fundo
    public Color getPanelColor() {
        return getBackground();
    }

    // Setter para a cor de fundo
    public void setPanelColor(Color color) {
        setBackground(color);
        repaint(); // Redesenha o painel com a nova cor
    }
}

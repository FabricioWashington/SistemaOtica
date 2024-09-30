package Sistema.FrontEnd.Componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;

public class Pesquisar extends JTextField {

    public Pesquisar() {
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setSelectionColor(new Color(51,153,255));
        setForeground(new Color(0, 0, 0));
        setPreferredSize(new Dimension(1580, 37));
    }

    private final String hint = "Pesquise aqui...";

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getText().length() == 0) {
            int h = getHeight();
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            g.setColor(new Color(0,0,0)); // Define a cor da fonte do placeholder
            g.drawString(hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
    }
}

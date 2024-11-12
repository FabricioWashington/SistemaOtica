package Sistema.FrontEnd.Componentes;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    private final int THUMB_SIZE = 80;

    public ScrollBarCustom(int orientation) {
        super(orientation);
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(15, 15));
        setForeground(new Color(94, 139, 231));
        setUnitIncrement(20);
        setOpaque(false);
    }
}

package Sistema.FrontEnd.Componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Tabela extends JTable {

    public Tabela() {
        setShowHorizontalLines(true);
        setRowHeight(30);
        setGridColor(new Color(230, 230, 230));
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TabelaCabelho cabelho = new TabelaCabelho(value + "");
                return cabelho;
            }

        });

        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (isSelected) {
                    component.setForeground(new Color(13, 113, 182));
                } else {
                    component.setForeground(new Color(102, 102, 102));
                }

                component.setBackground(Color.WHITE);
                return component;
            }

        });
    }

    public void setPreferredSize(int width, int height) {
        setPreferredScrollableViewportSize(new Dimension(width, height));
    }

}

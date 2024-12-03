package Sistema.FrontEnd.TelasPrincipais.Vendas;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class CustomTableCellEditor extends AbstractCellEditor implements TableCellEditor {
    private JSpinner spinner;

    public CustomTableCellEditor() {
        // Cria um JSpinner com um modelo de número inteiro
        spinner = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
    }

    @Override
    public Object getCellEditorValue() {
        return spinner.getValue(); // Retorna o valor do JSpinner
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // Define o valor do JSpinner com o valor da célula
        spinner.setValue(value != null ? value : 1); // Se o valor for nulo, define como 1
        return spinner; // Retorna o JSpinner como componente de edição
    }
}

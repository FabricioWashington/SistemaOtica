package Sistema.FrontEnd.Componentes;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.CategoryDataset;

import javax.swing.*;
import javax.swing.plaf.ToolTipUI;
import java.awt.*;

/**
 *
 * @author FaFa
 */
public class Grafico extends JPanel {

    JLabel lblProdutividade;
    ImageIcon icon = new ImageIcon("src/Resources/icons/grafico-preditivo.png");

    public Grafico() {
        super(new BorderLayout());

        JPanel panelTitulo = new JPanel(new BorderLayout());
        lblProdutividade = new JLabel();
        lblProdutividade.setText("Produtividade");
        lblProdutividade.setForeground(Color.LIGHT_GRAY);
        lblProdutividade.setBackground(Color.LIGHT_GRAY);
        lblProdutividade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblProdutividade.setFont(new Font("Arial", Font.BOLD, 18));
        lblProdutividade.setIcon(icon);
        lblProdutividade.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        panelTitulo.add(lblProdutividade, BorderLayout.WEST);
        panelTitulo.setBackground(Color.WHITE);
        add(panelTitulo, BorderLayout.NORTH);

        // Cria o dataset
        DefaultCategoryDataset dataset = criarDataset();

        // Cria o gráfico
        JFreeChart grafico = ChartFactory.createLineChart(
                "", // Título do gráfico
                "Meses", // Eixo X
                "", // Eixo Y
                dataset, // Dados
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true, // Legenda
                true, // Tooltips
                false // URLs
        );

        // Customiza o gráfico
        CategoryPlot plot = grafico.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE); // Define o fundo do gráfico como branco
        plot.setDomainGridlinePaint(Color.BLACK); // Define a cor da grade vertical
        plot.setRangeGridlinePaint(Color.BLACK); // Define a cor da grade horizontal

        // Adiciona linhas de grade horizontais
        plot.setDomainGridlinesVisible(true);
        plot.setRangeMinorGridlinePaint(Color.BLACK);

        // Customiza o renderer para as séries
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.GREEN); // Cor para "Autorizadas"
        renderer.setSeriesPaint(1, Color.RED); // Cor para "Canceladas"
        renderer.setSeriesPaint(2, Color.ORANGE); // Cor para "Denegadas"

        // Configura tooltips para o renderer
        renderer.setDefaultToolTipGenerator(new CustomCategoryToolTipGenerator());
        plot.setRenderer(renderer);

        // Configura o eixo X para mostrar os nomes dos meses
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
                org.jfree.chart.axis.CategoryLabelPositions.UP_45
        );
        // Ajusta a posição inicial do eixo X
        domainAxis.setLowerMargin(-0.03); // Define a margem inferior do eixo X
        domainAxis.setUpperMargin(-0.01); // Define a margem superior do eixo X

        // Cria o painel do gráfico
        CustomChartPanel painelDoGrafico = new CustomChartPanel(grafico);
        painelDoGrafico.setPreferredSize(new Dimension(1580, 240));
        add(painelDoGrafico, BorderLayout.CENTER);

    }

    private DefaultCategoryDataset criarDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(50000, "Autorizadas", "Jan");
        dataset.addValue(50000, "Autorizadas", "Fev");
        dataset.addValue(50000, "Autorizadas", "Mar");
        dataset.addValue(50000, "Autorizadas", "Abr");
        dataset.addValue(40000, "Autorizadas", "Mai");
        dataset.addValue(40000, "Autorizadas", "Jun");
        dataset.addValue(55000, "Autorizadas", "Jul");
        dataset.addValue(56000, "Autorizadas", "Ago");
        dataset.addValue(57000, "Autorizadas", "Set");
        dataset.addValue(58000, "Autorizadas", "Out");
        dataset.addValue(50000, "Autorizadas", "Nov");
        dataset.addValue(50000, "Autorizadas", "Dez");

        dataset.addValue(0, "Canceladas", "Jan");
        dataset.addValue(0, "Canceladas", "Fev");
        dataset.addValue(0, "Canceladas", "Mar");
        dataset.addValue(0, "Canceladas", "Abr");
        dataset.addValue(0, "Canceladas", "Mai");
        dataset.addValue(0, "Canceladas", "Jun");
        dataset.addValue(0, "Canceladas", "Jul");
        dataset.addValue(0, "Canceladas", "Ago");
        dataset.addValue(0, "Canceladas", "Set");
        dataset.addValue(0, "Canceladas", "Out");
        dataset.addValue(0, "Canceladas", "Nov");
        dataset.addValue(0, "Canceladas", "Dez");

        dataset.addValue(0, "Denegadas", "Jan");
        dataset.addValue(0, "Denegadas", "Fev");
        dataset.addValue(0, "Denegadas", "Mar");
        dataset.addValue(0, "Denegadas", "Abr");
        dataset.addValue(0, "Denegadas", "Mai");
        dataset.addValue(0, "Denegadas", "Jun");
        dataset.addValue(0, "Denegadas", "Jul");
        dataset.addValue(0, "Denegadas", "Ago");
        dataset.addValue(0, "Denegadas", "Set");
        dataset.addValue(0, "Denegadas", "Out");
        dataset.addValue(0, "Denegadas", "Nov");
        dataset.addValue(0, "Denegadas", "Dez");

        return dataset;
    }
    // Classe personalizada para os tooltips

    class CustomCategoryToolTipGenerator extends StandardCategoryToolTipGenerator {

        @Override
        public String generateToolTip(CategoryDataset dataset, int row, int column) {
            String seriesName = (String) dataset.getRowKey(row);
            String category = (String) dataset.getColumnKey(column);
            Number value = dataset.getValue(row, column);
            return String.format("%s\n%s: %,.0f", category, seriesName, value.doubleValue());
        }
    }

    // Classe personalizada para a aparência do tooltip
    static class CustomToolTipUI extends ToolTipUI {

        @Override
        public void paint(Graphics g, JComponent c) {
            FontMetrics metrics = g.getFontMetrics(g.getFont());
            Dimension size = c.getSize();
            g.setColor(new Color(0, 0, 0, 170)); // Preto com transparência
            g.fillRect(0, 0, size.width, size.height);
            g.setColor(Color.WHITE);
            g.drawRect(0, 0, size.width - 1, size.height - 1);
            String tipText = ((JToolTip) c).getTipText();
            if (tipText != null) {
                String[] lines = tipText.split("\n");
                int y = metrics.getHeight();
                for (String line : lines) {
                    g.drawString(line, 5, y);
                    y += metrics.getHeight();
                }
            }
        }

        @Override
        public Dimension getPreferredSize(JComponent c) {
            FontMetrics metrics = c.getFontMetrics(c.getFont());
            String tipText = ((JToolTip) c).getTipText();
            if (tipText != null) {
                String[] lines = tipText.split("\n");
                int width = 0;
                for (String line : lines) {
                    int lineWidth = metrics.stringWidth(line);
                    if (lineWidth > width) {
                        width = lineWidth;
                    }
                }
                int height = metrics.getHeight() * lines.length;
                return new Dimension(width + 10, height + 4);
            }
            return super.getPreferredSize(c);
        }
    }

    // Classe personalizada para o JToolTip
    static class CustomToolTip extends JToolTip {

        public CustomToolTip() {
            setUI(new CustomToolTipUI());
        }
    }

    // Classe personalizada para o painel de gráficos
    static class CustomChartPanel extends ChartPanel {

        public CustomChartPanel(JFreeChart chart) {
            super(chart);
        }

        @Override
        public JToolTip createToolTip() {
            return new CustomToolTip();
        }
    }
}

package plugin;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import tubes2.BasePlugin;
import javax.swing.*;
import java.awt.*;

public class PluginChart1 extends BasePlugin {
    @Override
    public JPanel createPluginPanel() {
        // Label
        JLabel graphLabel = new JLabel("Bar Chart");
        graphLabel.setForeground(Color.WHITE);
        graphLabel.setFont(new Font(graphLabel.getFont().getName(), graphLabel.getFont().getStyle(), 15));
        graphLabel.setPreferredSize(new Dimension(500,20));
        // Bar Chart
        JPanel barChart = createBarChart();
        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setBounds(100, 50, 500, 65);
        panel1.setBackground(Color.gray);
        panel1.setLayout(new BorderLayout(0,10));
        panel1.add(graphLabel, BorderLayout.NORTH);
        panel1.add(barChart);


        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(100,100));
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 75));
        centerPanel.setBackground(Color.GRAY);
        centerPanel.add(panel1);


        mainPanel = createBlankPage("Plugin 1");
        mainPanel.add(centerPanel);
        return this.mainPanel;
    }

    private JPanel createBarChart() {
        DefaultCategoryDataset dataset;
        JFreeChart chart;
        ChartPanel chartPanel;

        dataset = new DefaultCategoryDataset();

        dataset.addValue(20, "Barang 1", "2022");
        dataset.addValue(21, "Barang 2", "2022");
        dataset.addValue(19, "Barang 3", "2022");

        chart = ChartFactory.createBarChart("Top 3 Barang 2022", "", "Buah", dataset, PlotOrientation.VERTICAL, true, true, false);

        chartPanel = new ChartPanel(chart);
        return chartPanel;
    }
}

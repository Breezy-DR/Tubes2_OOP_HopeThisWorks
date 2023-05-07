package plugin;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.data.statistics.StatisticalCategoryDataset;
import tubes2.BasePlugin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Map;

public class PluginChart1 extends BasePlugin implements ActionListener {
    private JButton lineChartButton;
    private JButton barChartButton;
    private JPanel chartPanel;
    private CardLayout cardLayout;

    private static CategoryDataset createCategoryDataset(Map<String, Integer> dataSource) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Map.Entry<String, Integer> entry: dataSource.entrySet()){
            dataset.addValue(entry.getValue(), entry.getKey(), "");
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return dataset;
    }

    private static StatisticalCategoryDataset createStatisticalCategoryDataset(Map<String, Integer> dataSource) {
        DefaultStatisticalCategoryDataset dataset = new DefaultStatisticalCategoryDataset();
        for(Map.Entry<String, Integer> entry: dataSource.entrySet()){
            dataset.add((int)entry.getValue(), 0.2, "serie", entry.getKey());
        }
        return dataset;
    }

    @Override
    public JPanel createPluginPanel() {
        // Bagian Line Chart
        // Label
        JLabel lineChartLabel = new JLabel("Line Chart");
        lineChartLabel.setForeground(Color.WHITE);
        lineChartLabel.setFont(new Font(lineChartLabel.getFont().getName(), lineChartLabel.getFont().getStyle(), 15));
        lineChartLabel.setPreferredSize(new Dimension(500,20));
        // Line Chart
        JFreeChart lineChart = createLineChart("Chart", null, null, createStatisticalCategoryDataset(soldItems()), PlotOrientation.VERTICAL, false, true, true);
        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setBounds(100, 50, 500, 65);
        panel1.setBackground(Color.gray);
        panel1.setLayout(new BorderLayout(0,10));
        panel1.add(lineChartLabel, BorderLayout.NORTH);
        panel1.add(new ChartPanel(lineChart));


        // Bagian Bar Chart
        // Label
        JLabel barChartLabel = new JLabel("Bar Chart");
        barChartLabel.setForeground(Color.WHITE);
        barChartLabel.setFont(new Font(barChartLabel.getFont().getName(), barChartLabel.getFont().getStyle(), 15));
        barChartLabel.setPreferredSize(new Dimension(500,20));
        // Bar Chart
        JFreeChart barChart = createBarChart("Jumlah Barang Terjual", "", "Jumlah", createCategoryDataset(soldItems()), PlotOrientation.VERTICAL, true, true, false);
        // Panel 2
        JPanel panel2 = new JPanel();
        panel2.setBounds(100, 50, 500, 65);
        panel2.setBackground(Color.gray);
        panel2.setLayout(new BorderLayout(0,10));
        panel2.add(barChartLabel, BorderLayout.NORTH);
        panel2.add(new ChartPanel( barChart ));

        // Chart Container
        cardLayout = new CardLayout();
        chartPanel = new JPanel();
        chartPanel.setLayout(cardLayout);
        chartPanel.add(panel1, "1");
        chartPanel.add(panel2, "2");
        cardLayout.show(chartPanel, "1");


        // Bagian Aktivasi/Deaktivasi
        // Tombol Line Chart
        lineChartButton = new JButton("Line Chart");
        lineChartButton.setFocusable(false);
        lineChartButton.addActionListener(this);
        lineChartButton.setPreferredSize(new Dimension(100, 35));
        lineChartButton.setEnabled(false);
        // Tombol Bar Chart
        barChartButton = new JButton("Bar Chart");
        barChartButton.setFocusable(false);
        barChartButton.addActionListener(this);
        barChartButton.setPreferredSize(new Dimension(100, 35));
        barChartButton.setEnabled(true);
        // Sub-Panel 3
        JPanel subPanel3 = new JPanel();
        subPanel3.setOpaque(false);
        subPanel3.setPreferredSize(new Dimension(300,30));
        subPanel3.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
        subPanel3.add(lineChartButton);
        subPanel3.add(barChartButton);
        // Panel 3
        JPanel panel3 = new JPanel();
        panel3.setOpaque(false);
        panel3.setLayout(new BorderLayout(0,10));
        panel3.add(subPanel3, BorderLayout.SOUTH);


        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(100,100));
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 35));
        centerPanel.setBackground(Color.GRAY);
        centerPanel.add(chartPanel);
        centerPanel.add(panel3);


        mainPanel = createBlankPage("Plugin 1");
        mainPanel.add(centerPanel);
        return this.mainPanel;
    }

    private static JFreeChart createBarChart(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
        JFreeChart chart = ChartFactory.createBarChart(title, categoryAxisLabel, valueAxisLabel, dataset, orientation, legend, tooltips, urls);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return chart;
    }

    private JFreeChart createLineChart(String title, String categoryAxisLabel, String valueAxisLabel, CategoryDataset dataset, PlotOrientation orientation, boolean legend, boolean tooltips, boolean urls) {
        JFreeChart chart;
        ChartPanel chartPanel;

//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        dataset.setValue(150, "Item 1", "2022");
//        dataset.setValue(30, "Item 2", "2022");
//        dataset.setValue(400, "Item 3", "2022");
//
//        chart = ChartFactory.createLineChart("Top 3 Barang 2022", "Item", "Buah", dataset, PlotOrientation.VERTICAL, false, true, false);
//        chart.setBorderPaint(Color.YELLOW);
//        chart.getTitle().setPaint(Color.red);
//        CategoryPlot p = chart.getCategoryPlot();
//        p.setRangeGridlinePaint(Color.blue);
//        p.setRangeGridlinesVisible(true);

        chart = ChartFactory.createLineChart(title, categoryAxisLabel, valueAxisLabel, dataset, orientation, legend, tooltips, urls);
        LineAndShapeRenderer renderer = new LineAndShapeRenderer(true, false);
        chart.getCategoryPlot().setRenderer(renderer);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getNumberInstance()));
        renderer.setBaseItemLabelsVisible(true);
        return chart;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lineChartButton) {
            lineChartButton.setEnabled(false);
            barChartButton.setEnabled(true);
            this.cardLayout.show(chartPanel, "1");
        }
        else if (e.getSource() == barChartButton) {
            lineChartButton.setEnabled(true);
            barChartButton.setEnabled(false);
            this.cardLayout.show(chartPanel, "2");
        }
    }
}

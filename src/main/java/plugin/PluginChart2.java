package plugin;

import org.jfree.chart.labels.PieSectionLabelGenerator;
import tubes2.*;
import tubes2.Barang;
import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.ChartFactory;

public class PluginChart2 extends BasePlugin implements Runnable{
    private JFreeChart chart;
    private ChartPanel chartPanel;
    private JPanel centerPanel;
    private static PieDataset createDataset( Map<String, Integer> dataSource) {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        for(Map.Entry<String, Integer> entry: dataSource.entrySet()){
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        return dataset;
    }

    private static JFreeChart createChart( String titles, PieDataset dataset, boolean legend, boolean tooltips, boolean urls ) {
        JFreeChart chart = ChartFactory.createPieChart(titles, dataset, legend, tooltips, urls);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSimpleLabels(true);

        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);
        return chart;
    }
    public JPanel createPluginPanel(){
            // Bagian Test Text
            // Label
            JLabel pathLabel=new JLabel("Plugin Panel");
            pathLabel.setForeground(Color.WHITE);
            pathLabel.setFont(new Font(pathLabel.getFont().getName(),pathLabel.getFont().getStyle(),15));
            pathLabel.setPreferredSize(new Dimension(500,20));
            // Text
            JTextArea pathText=new JTextArea("Hiyaaaa jadi");
            pathText.setBorder(BorderFactory.createLoweredBevelBorder());
            pathText.setEditable(false);
            // Sub-Panel 1
            JPanel subPanel1=new JPanel();
            subPanel1.setPreferredSize(new Dimension(500,30));
            subPanel1.setBackground(Color.gray);
            subPanel1.setLayout(new BorderLayout());
//            subPanel1.add(pathText,BorderLayout.CENTER);
            // Panel 1
            JPanel panel1=new JPanel();
            panel1.setBounds(100,50,500,65);
            panel1.setBackground(Color.gray);
            panel1.setLayout(new BorderLayout(0,10));
//            panel1.add(pathLabel,BorderLayout.NORTH);
//            panel1.add(subPanel1,BorderLayout.SOUTH);


            // Label
            JLabel graphLabel=new JLabel("Graf");
            graphLabel.setForeground(Color.WHITE);
            graphLabel.setFont(new Font(graphLabel.getFont().getName(),graphLabel.getFont().getStyle(),15));
            graphLabel.setPreferredSize(new Dimension(500,20));
            // Panel 2
            JPanel panel2=new JPanel();
            panel2.setBounds(100,50,500,65);
            panel2.setBackground(Color.gray);
            panel2.setLayout(new BorderLayout(0,10));
            panel2.add(graphLabel,BorderLayout.NORTH);

            Map<String, Integer> dataSource = soldItems();
            chart = createChart("Jumlah Barang Terjual", createDataset(dataSource), true, true, false );
            chartPanel = new ChartPanel( chart );
            //return new ChartPanel( chart );


            // Center panel
            centerPanel=new JPanel();
            centerPanel.setPreferredSize(new Dimension(100,100));
            centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER,1000,35));
            centerPanel.setBackground(Color.GRAY);
            centerPanel.add(panel1);
            centerPanel.add(panel2);
            centerPanel.add(chartPanel);


            mainPanel=createBlankPage("Plugin 2");
            mainPanel.add(centerPanel);
            setPieChart();
            return this.mainPanel;
    }

    public void setPieChart() {
        Thread pie = new Thread(this);
        pie.start();
    }

    @Override
    public void run() {
        while (true) {
            datastore = new DataStoreHub();
            centerPanel.remove(chartPanel);
            chart = createChart("Jumlah Barang Terjual", createDataset(soldItems()), true, true, false );
            chartPanel = new ChartPanel( chart );
            centerPanel.add(chartPanel);
            mainPanel.revalidate();

            //System.out.println("OVERRIDE");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

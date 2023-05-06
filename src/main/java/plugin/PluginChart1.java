package plugin;

import tubes2.BasePlugin;
import javax.swing.*;
import java.awt.*;

public class PluginChart1 extends BasePlugin {
    @Override
    public JPanel createPluginPanel() {
        // Bagian Test Text
        // Label
        JLabel pathLabel = new JLabel("Test Text");
        pathLabel.setForeground(Color.WHITE);
        pathLabel.setFont(new Font(pathLabel.getFont().getName(), pathLabel.getFont().getStyle(), 15));
        pathLabel.setPreferredSize(new Dimension(500,20));
        // Text
        JTextArea pathText = new JTextArea("Hiyaaaa jadi");
        pathText.setBorder(BorderFactory.createLoweredBevelBorder());
        pathText.setEditable(false);
        // Sub-Panel 1
        JPanel subPanel1 = new JPanel();
        subPanel1.setPreferredSize(new Dimension(500,30));
        subPanel1.setBackground(Color.gray);
        subPanel1.setLayout(new BorderLayout());
        subPanel1.add(pathText, BorderLayout.CENTER);
        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setBounds(100, 50, 500, 65);
        panel1.setBackground(Color.gray);
        panel1.setLayout(new BorderLayout(0,10));
        panel1.add(pathLabel, BorderLayout.NORTH);
        panel1.add(subPanel1, BorderLayout.SOUTH);


        // Label
        JLabel graphLabel = new JLabel("Graf");
        graphLabel.setForeground(Color.WHITE);
        graphLabel.setFont(new Font(graphLabel.getFont().getName(), graphLabel.getFont().getStyle(), 15));
        graphLabel.setPreferredSize(new Dimension(500,20));
        // Panel 2
        JPanel panel2 = new JPanel();
        panel2.setBounds(100, 50, 500, 65);
        panel2.setBackground(Color.gray);
        panel2.setLayout(new BorderLayout(0,10));
        panel2.add(graphLabel, BorderLayout.NORTH);


        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(100,100));
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 75));
        centerPanel.setBackground(Color.GRAY);
        centerPanel.add(panel1);
        centerPanel.add(panel2);


        mainPanel = createBlankPage();
        mainPanel.add(centerPanel);
        return this.mainPanel;
    }
}

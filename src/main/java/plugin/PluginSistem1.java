package plugin;

import tubes2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PluginSistem1 extends SystemPlugin implements ActionListener {
    private JRadioButton optionRupiah;
    private JRadioButton optionDolar;
    private JRadioButton optionDirham;

    @Override
    public JPanel createPluginPanel() {
        // Bagian Mata Uang
        // Label
        JLabel formatLabel = new JLabel("Mata Uang");
        formatLabel.setForeground(Color.WHITE);
        formatLabel.setFont(new Font(formatLabel.getFont().getName(), formatLabel.getFont().getStyle(), 15));
        formatLabel.setPreferredSize(new Dimension(500,20));
        // Tombol
        optionRupiah = new JRadioButton("Rupiah");
        optionDolar = new JRadioButton("Dolar");
        optionDirham = new JRadioButton("Dirham");
        optionRupiah.setOpaque(false);
        optionDolar.setOpaque(false);
        optionDirham.setOpaque(false);
        optionRupiah.setFocusable(false);
        optionDolar.setFocusable(false);
        optionDirham.setFocusable(false);
        optionRupiah.addActionListener(this);
        optionDolar.addActionListener(this);
        optionDirham.addActionListener(this);
        optionRupiah.setSelected(true);
        ButtonGroup optionGroup = new ButtonGroup();
        optionGroup.add(optionRupiah);
        optionGroup.add(optionDolar);
        optionGroup.add(optionDirham);
        // Sub-panel 1
        JPanel subPanel1 = new JPanel();
        subPanel1.setPreferredSize(new Dimension(100,30));
        subPanel1.setBackground(Color.lightGray);
        subPanel1.setLayout(new FlowLayout());
        subPanel1.add(optionRupiah);
        subPanel1.add(optionDolar);
        subPanel1.add(optionDirham);
        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setBounds(100, 190, 500, 65);
        panel1.setBackground(Color.gray);
        panel1.setLayout(new BorderLayout(0,10));
        panel1.add(formatLabel, BorderLayout.NORTH);
        panel1.add(subPanel1, BorderLayout.SOUTH);

        return panel1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == optionRupiah) {
            System.out.println("Rupiah");
        }
        else if (e.getSource() == optionDolar) {
            System.out.println("Dolar");
        }
        else if (e.getSource() == optionDirham) {
            System.out.println("Dirham");
        }
    }
}
